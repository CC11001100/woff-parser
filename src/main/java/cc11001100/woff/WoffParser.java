package cc11001100.woff;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPOutputStream;

/**
 * woff 字体解析器
 *
 * @author CC11001100
 */
public class WoffParser {

	private InputStream woffInputStream;
	private Integer woffInputStreamPointer;
	private Woff woff;

	/**
	 * 是否严格模式，严格模式下解析时会对数据进行校验，不合法则抛出异常
	 * 非严格模式只按照结构解析，不关心数据是否有效
	 */
	private Boolean strictMode = false;

	public WoffParser(String woffFilePath) throws FileNotFoundException {
		this(new FileInputStream(woffFilePath));
	}

	public WoffParser(InputStream woffInputStream) {
		this.woffInputStream = woffInputStream;
	}

	public Woff get() throws IOException {
		if (this.woff != null) {
			return this.woff;
		}

		this.woff = new Woff();
		parseHeader();
		parseTableDirectoryList();
		return woff;
	}

	/**
	 * 解析woff文件头
	 *
	 * @return
	 * @throws IOException
	 */
	private void parseHeader() throws IOException {
		Woff.Header header = new Woff.Header();
		header.setSignature(readUInt32ToString());
		header.setFlavor(readUInt32ToInt());

		header.setLength(readUInt32ToInt());
		header.setNumTables(readUInt16ToInt());
		header.setReserved(readUInt16ToInt());
		header.setTotalSfntSize(readUInt32ToInt());

		header.setMajorVersion(readUInt16ToInt());
		header.setMinorVersion(readUInt16ToInt());

		header.setMetaOffset(readUInt32ToInt());
		header.setMetaLength(readUInt32ToInt());
		header.setMetaOrigLength(readUInt32ToInt());

		header.setPrivOffset(readUInt32ToInt());
		header.setPrivLength(readUInt32ToInt());
		woff.setHeader(header);
	}

	/**
	 * 解析表的目录
	 *
	 * @return
	 * @throws IOException
	 */
	private void parseTableDirectoryList() throws IOException {
		List<Woff.TableDirectory> tableDirectoryList = new ArrayList<>();
		int tableDirectoryNum = woff.getHeader().getNumTables();
		for (int i = 0; i < tableDirectoryNum; i++) {
			Woff.TableDirectory tableDirectory = new Woff.TableDirectory();
			tableDirectory.setTag(readUInt32ToString());
			tableDirectory.setOffset(readUInt32ToInt());
			tableDirectory.setCompLength(readUInt32ToInt());
			tableDirectory.setOrigLength(readUInt32ToInt());
			tableDirectory.setOrigChecksum(readUInt32ToInt());
			tableDirectoryList.add(tableDirectory);
		}
		woff.setTableDirectoryList(tableDirectoryList);
	}

	/**
	 * 根据TableDirectory解析字体数据
	 */
	private void parseFontTables() throws IOException {
		List<Woff.TableDirectory> tableDirectoryList = woff.getTableDirectoryList();
		for (Woff.TableDirectory tableDirectory : tableDirectoryList) {
			// 如果不到offset的话就空读一些字节
			int offset = tableDirectory.getOffset();
			int needNullReadBytes = offset - woffInputStreamPointer;
			readBytes(needNullReadBytes);

			byte[] data = readBytes(tableDirectory.getCompLength());


		}


	}

	private String readUInt32ToString() throws IOException {
		return new String(readBytes(4), "UTF-8");
	}

	private String readUInt16ToString() throws IOException {
		return new String(readBytes(2), "UTF-8");
	}

	private int readUInt32ToInt() throws IOException {
		return convertByteToInt(readBytes(4));
	}

	private int readUInt16ToInt() throws IOException {
		return convertByteToInt(readBytes(2));
	}

	private byte[] readBytes(int n) throws IOException {
		woffInputStreamPointer += n;
		byte[] unitN = new byte[n];
		woffInputStream.read(unitN);
		return unitN;
	}

	/**
	 * 数值类型大端存储
	 *
	 * @param bytes
	 * @return
	 */
	private int convertByteToInt(byte[] bytes) {
		int result = 0;
		for (int i = bytes.length - 1; i >= 0; i--) {
			int weight = 8 * (bytes.length - i - 1);
			result = result + (bytes[i] << weight);
		}
		return result;
	}

}

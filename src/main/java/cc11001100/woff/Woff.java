package cc11001100.woff;

import java.util.List;

/**
 * @author CC11001100
 */
public class Woff {

	private Header header;
	private List<TableDirectory> tableDirectoryList;

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public List<TableDirectory> getTableDirectoryList() {
		return tableDirectoryList;
	}

	public void setTableDirectoryList(List<TableDirectory> tableDirectoryList) {
		this.tableDirectoryList = tableDirectoryList;
	}

	/**
	 * 文件头
	 */
	public static class Header {

		/**
		 * version 1 wOFF
		 * version 2 wOF2
		 */
		private String signature;

		/**
		 * The "sfnt version" of the input font.
		 */
		private Integer flavor;

		private Integer length;

		private Integer numTables;

		private Integer reserved;

		private Integer totalSfntSize;

		private Integer majorVersion;

		private Integer minorVersion;

		private Integer metaOffset;

		private Integer metaLength;
		private Integer metaOrigLength;
		private Integer privOffset;
		private Integer privLength;

		public String getSignature() {
			return signature;
		}

		public void setSignature(String signature) {
			this.signature = signature;
		}

		public Integer getFlavor() {
			return flavor;
		}

		public void setFlavor(Integer flavor) {
			this.flavor = flavor;
		}

		public Integer getLength() {
			return length;
		}

		public void setLength(Integer length) {
			this.length = length;
		}

		public Integer getNumTables() {
			return numTables;
		}

		public void setNumTables(Integer numTables) {
			this.numTables = numTables;
		}

		public Integer getReserved() {
			return reserved;
		}

		public void setReserved(Integer reserved) {
			this.reserved = reserved;
		}

		public Integer getTotalSfntSize() {
			return totalSfntSize;
		}

		public void setTotalSfntSize(Integer totalSfntSize) {
			this.totalSfntSize = totalSfntSize;
		}

		public Integer getMajorVersion() {
			return majorVersion;
		}

		public void setMajorVersion(Integer majorVersion) {
			this.majorVersion = majorVersion;
		}

		public Integer getMinorVersion() {
			return minorVersion;
		}

		public void setMinorVersion(Integer minorVersion) {
			this.minorVersion = minorVersion;
		}

		public Integer getMetaOffset() {
			return metaOffset;
		}

		public void setMetaOffset(Integer metaOffset) {
			this.metaOffset = metaOffset;
		}

		public Integer getMetaLength() {
			return metaLength;
		}

		public void setMetaLength(Integer metaLength) {
			this.metaLength = metaLength;
		}

		public Integer getMetaOrigLength() {
			return metaOrigLength;
		}

		public void setMetaOrigLength(Integer metaOrigLength) {
			this.metaOrigLength = metaOrigLength;
		}

		public Integer getPrivOffset() {
			return privOffset;
		}

		public void setPrivOffset(Integer privOffset) {
			this.privOffset = privOffset;
		}

		public Integer getPrivLength() {
			return privLength;
		}

		public void setPrivLength(Integer privLength) {
			this.privLength = privLength;
		}
	}

	public static class TableDirectory {
		private String tag;
		private Integer offset;
		private Integer compLength;
		private Integer origLength;
		private Integer origChecksum;
		private byte[] compData;
		private byte[] origData;

		public String getTag() {
			return tag;
		}

		public void setTag(String tag) {
			this.tag = tag;
		}

		public Integer getOffset() {
			return offset;
		}

		public void setOffset(Integer offset) {
			this.offset = offset;
		}

		public Integer getCompLength() {
			return compLength;
		}

		public void setCompLength(Integer compLength) {
			this.compLength = compLength;
		}

		public Integer getOrigLength() {
			return origLength;
		}

		public void setOrigLength(Integer origLength) {
			this.origLength = origLength;
		}

		public Integer getOrigChecksum() {
			return origChecksum;
		}

		public void setOrigChecksum(Integer origChecksum) {
			this.origChecksum = origChecksum;
		}

		public byte[] getCompData() {
			return compData;
		}

		public void setCompData(byte[] compData) {
			this.compData = compData;
		}

		public byte[] getOrigData() {
			return origData;
		}

		public void setOrigData(byte[] origData) {
			this.origData = origData;
		}
	}

	public static class ExtendedMetadata {

	}

	public static class PrivateData {

	}

}

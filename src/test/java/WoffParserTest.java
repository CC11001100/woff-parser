import cc11001100.woff.Woff;
import cc11001100.woff.WoffParser;
import org.junit.Test;

import java.io.IOException;

/**
 * @author CC11001100
 */
public class WoffParserTest {

	@Test
	public void test_001() throws IOException {

		String woffFilePath = "D:\\test\\crawler\\58TongCheng\\20180418_215810.woff";
		WoffParser woffParser = new WoffParser(woffFilePath);
		Woff woff = woffParser.get();
		System.out.println(woff.getHeader());



	}

}

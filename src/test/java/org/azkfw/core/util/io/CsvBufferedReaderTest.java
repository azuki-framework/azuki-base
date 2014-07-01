package org.azkfw.core.util.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.List;

import org.azkfw.core.AbstractTestCase;
import org.azkfw.core.io.CsvBufferedReader;
import org.azkfw.core.util.PathUtility;
import org.junit.Test;

/**
 * このクラスは、{@link CsvBufferedReader}クラスのユニットテストを行うクラスです。
 * 
 * @since 1.2.0
 * @version 1.2.0 2014/07/01
 * @author Kawakicchi
 */
public class CsvBufferedReaderTest extends AbstractTestCase {

	@Test
	public void test() {
		CsvBufferedReader reader = null;
		try {
			reader = new CsvBufferedReader(getResourceAsFile(PathUtility.replaseEnvSeparator("csv/sjis.csv")), "SJIS");

			List<String> data;

			data = reader.readCsvLine();

			assertNotNull(data);
			assertEquals("列数", 4, data.size());
			assertEquals("No.", data.get(0));
			assertEquals("名前", data.get(1));
			assertEquals("年齢", data.get(2));
			assertEquals("性別", data.get(3));

			data = reader.readCsvLine();

			assertNotNull(data);
			assertEquals("列数", 4, data.size());
			assertEquals("1", data.get(0));
			assertEquals("佐藤", data.get(1));
			assertEquals("20歳", data.get(2));
			assertEquals("男性", data.get(3));

			data = reader.readCsvLine();

			assertNotNull(data);
			assertEquals("列数", 4, data.size());
			assertEquals("2", data.get(0));
			assertEquals("田中", data.get(1));
			assertEquals("40歳", data.get(2));
			assertEquals("女性", data.get(3));

			data = reader.readCsvLine();

			assertNotNull(data);
			assertEquals("列数", 4, data.size());
			assertEquals("3", data.get(0));
			assertEquals("吉田", data.get(1));
			assertEquals("32歳", data.get(2));
			assertEquals("男性", data.get(3));

			data = reader.readCsvLine();
			assertNull(data);

		} catch (FileNotFoundException ex) {
			fail(ex.getLocalizedMessage());
		} catch (UnsupportedEncodingException ex) {
			fail(ex.getLocalizedMessage());
		} catch (IOException ex) {
			fail(ex.getLocalizedMessage());
		} finally {
			if (null != reader) {
				try {
					reader.close();
				} catch (IOException ex) {
					fail(ex.getLocalizedMessage());
				}
			}
		}

		try {
			reader = new CsvBufferedReader(getResourceAsPath(PathUtility.replaseEnvSeparator("csv/utf8.csv")), "UTF-8");

			List<String> data;

			data = reader.readCsvLine();

			assertNotNull(data);
			assertEquals("列数", 4, data.size());
			assertEquals("No.", data.get(0));
			assertEquals("名前", data.get(1));
			assertEquals("年齢", data.get(2));
			assertEquals("性別", data.get(3));

			data = reader.readCsvLine();

			assertNotNull(data);
			assertEquals("列数", 4, data.size());
			assertEquals("1", data.get(0));
			assertEquals("佐藤", data.get(1));
			assertEquals("20歳", data.get(2));
			assertEquals("男性", data.get(3));

			data = reader.readCsvLine();

			assertNotNull(data);
			assertEquals("列数", 4, data.size());
			assertEquals("2", data.get(0));
			assertEquals("田中", data.get(1));
			assertEquals("40歳", data.get(2));
			assertEquals("女性", data.get(3));

			data = reader.readCsvLine();

			assertNotNull(data);
			assertEquals("列数", 4, data.size());
			assertEquals("3", data.get(0));
			assertEquals("吉田", data.get(1));
			assertEquals("32歳", data.get(2));
			assertEquals("男性", data.get(3));

			data = reader.readCsvLine();
			assertNull(data);

		} catch (FileNotFoundException ex) {
			fail(ex.getLocalizedMessage());
		} catch (UnsupportedEncodingException ex) {
			fail(ex.getLocalizedMessage());
		} catch (IOException ex) {
			fail(ex.getLocalizedMessage());
		} finally {
			if (null != reader) {
				try {
					reader.close();
				} catch (IOException ex) {
					fail(ex.getLocalizedMessage());
				}
			}
		}
	}

	@Test
	public void testFileNotFound() {

		try {
			CsvBufferedReader reader = new CsvBufferedReader(getResourceAsFile("????????????????????"));
			reader.close();
			fail();
		} catch (FileNotFoundException ex) {

		} catch (UnsupportedEncodingException ex) {
			fail(ex.getLocalizedMessage());
		} catch (IOException ex) {
			fail(ex.getLocalizedMessage());
		}

		try {
			CsvBufferedReader reader = new CsvBufferedReader(getResourceAsPath("????????????????????"));
			reader.close();
			fail();
		} catch (FileNotFoundException ex) {

		} catch (UnsupportedEncodingException ex) {
			fail(ex.getLocalizedMessage());
		} catch (IOException ex) {
			fail(ex.getLocalizedMessage());
		}

		try {
			CsvBufferedReader reader = new CsvBufferedReader(getResourceAsFile("????????????????????"), Charset.defaultCharset());
			reader.close();
			fail();
		} catch (FileNotFoundException ex) {

		} catch (UnsupportedEncodingException ex) {
			fail(ex.getLocalizedMessage());
		} catch (IOException ex) {
			fail(ex.getLocalizedMessage());
		}

		try {
			CsvBufferedReader reader = new CsvBufferedReader(getResourceAsFile("????????????????????"), "UTF-8");
			reader.close();
			fail();
		} catch (FileNotFoundException ex) {

		} catch (UnsupportedEncodingException ex) {
			fail(ex.getLocalizedMessage());
		} catch (IOException ex) {
			fail(ex.getLocalizedMessage());
		}

		try {
			CsvBufferedReader reader = new CsvBufferedReader(getResourceAsPath("????????????????????"), Charset.defaultCharset());
			reader.close();
			fail();
		} catch (FileNotFoundException ex) {

		} catch (UnsupportedEncodingException ex) {
			fail(ex.getLocalizedMessage());
		} catch (IOException ex) {
			fail(ex.getLocalizedMessage());
		}

		try {
			CsvBufferedReader reader = new CsvBufferedReader(getResourceAsPath("????????????????????"), "UTF-8");
			reader.close();
			fail();
		} catch (FileNotFoundException ex) {

		} catch (UnsupportedEncodingException ex) {
			fail(ex.getLocalizedMessage());
		} catch (IOException ex) {
			fail(ex.getLocalizedMessage());
		}

	}

	@Test
	public void testUnsupportedEncoding() {
		try {
			CsvBufferedReader reader = new CsvBufferedReader(getResourceAsFile(PathUtility.replaseEnvSeparator("csv/sjis.csv")), "????");
			reader.close();
			fail();
		} catch (FileNotFoundException ex) {
			fail(ex.getLocalizedMessage());
		} catch (UnsupportedEncodingException ex) {

		} catch (IOException ex) {
			fail(ex.getLocalizedMessage());
		}

		try {
			CsvBufferedReader reader = new CsvBufferedReader(getResourceAsPath(PathUtility.replaseEnvSeparator("csv/sjis.csv")), "????");
			reader.close();
			fail();
		} catch (FileNotFoundException ex) {
			fail(ex.getLocalizedMessage());
		} catch (UnsupportedEncodingException ex) {

		} catch (IOException ex) {
			fail(ex.getLocalizedMessage());
		}
	}
}

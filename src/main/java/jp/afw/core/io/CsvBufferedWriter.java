/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jp.afw.core.io;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.List;

/**
 * このクラスは、CSVファイルを書き出すライタークラスです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2013/07/02
 * @author Kawakicchi
 * 
 */
public class CsvBufferedWriter extends BufferedWriter {

	/**
	 * コンストラクタ
	 * 
	 * @param aWriter ライター
	 */
	public CsvBufferedWriter(final Writer aWriter) {
		super(aWriter);
	}

	/**
	 * コンストラクタ
	 * 
	 * @param aFile ファイル
	 * @param aCharset 文字エンコーディング
	 * @throws FileNotFoundException {@link FileNotFoundException}
	 * @throws UnsupportedEncodingException {@link UnsupportedEncodingException}
	 */
	public CsvBufferedWriter(final String aFile, final String aCharset) throws FileNotFoundException, UnsupportedEncodingException {
		super(new OutputStreamWriter(new FileOutputStream(aFile), aCharset));
	}

	/**
	 * CSVとして１行書き出す。
	 * 
	 * @param strs CSV１行データ
	 * @throws IOException IO操作時に問題が発生した場合
	 */
	public void writeCsvLine(final String... strs) throws IOException {
		for (int i = 0; i < strs.length; i++) {
			if (0 != i) {
				write(",");
			}
			write(toCsvString(strs[i]));
		}
		write("\r\n");
	}

	/**
	 * CSVとして１行書き出す。
	 * 
	 * @param strs CSV１行データ
	 * @throws IOException IO操作時に問題が発生した場合
	 */
	public void writeCsvLine(final List<String> strs) throws IOException {
		for (int i = 0; i < strs.size(); i++) {
			if (0 != i) {
				write(",");
			}
			write(toCsvString(strs.get(i)));
		}
		write("\r\n");
	}

	/**
	 * 文字列をＣＳＶ用の文字列にする。
	 * 
	 * @param aString 文字列
	 * @return CSV文字列
	 */
	private String toCsvString(final String aString) {
		String result = "";
		if (null != aString) {
			result = aString;
		}
		boolean dblFlg = false;
		if (-1 != result.indexOf(",")) {
			dblFlg = true;
		}
		if (-1 != result.indexOf("\"")) {
			dblFlg = true;
			result = result.replace("\"", "\"\"");
		}
		if (dblFlg) {
			result = "\"" + result + "\"";
		}
		return result;
	}
}

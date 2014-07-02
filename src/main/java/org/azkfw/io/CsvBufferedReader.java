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
package org.azkfw.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.azkfw.util.StringUtility;

/**
 * このクラスは、CSVファイルを読み込むリーダークラスです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2013/07/02
 * @author Kawakicchi
 */
public class CsvBufferedReader extends BufferedReader {

	/**
	 * コンストラクタ
	 * 
	 * @param aReader リーダー
	 */
	public CsvBufferedReader(final Reader aReader) {
		super(aReader);
	}

	/**
	 * コンストラクタ
	 * <p>
	 * システムデフォルトの文字コードで読み込む。
	 * </p>
	 * 
	 * @param aFile ファイル
	 * @throws FileNotFoundException {@link FileNotFoundException}
	 * @throws UnsupportedEncodingException {@link UnsupportedEncodingException}
	 */
	public CsvBufferedReader(final String aFile) throws FileNotFoundException, UnsupportedEncodingException {
		super(new InputStreamReader(new FileInputStream(aFile), System.getProperty("file.encoding")));
	}

	/**
	 * コンストラクタ
	 * 
	 * @param aFile ファイル
	 * @param aCharset 文字エンコーディング
	 * @throws FileNotFoundException {@link FileNotFoundException}
	 * @throws UnsupportedEncodingException {@link UnsupportedEncodingException}
	 */
	public CsvBufferedReader(final String aFile, final String aCharset) throws FileNotFoundException, UnsupportedEncodingException {
		super(new InputStreamReader(new FileInputStream(aFile), aCharset));
	}

	/**
	 * コンストラクタ
	 * 
	 * @param aFile ファイル
	 * @param aCharset 文字エンコーディング
	 * @throws FileNotFoundException {@link FileNotFoundException}
	 * @throws UnsupportedEncodingException {@link UnsupportedEncodingException}
	 */
	public CsvBufferedReader(final String aFile, final Charset aCharset) throws FileNotFoundException, UnsupportedEncodingException {
		super(new InputStreamReader(new FileInputStream(aFile), aCharset));
	}

	/**
	 * コンストラクタ
	 * <p>
	 * システムデフォルトの文字コードで読み込む。
	 * </p>
	 * 
	 * @param aFile ファイル
	 * @throws FileNotFoundException {@link FileNotFoundException}
	 * @throws UnsupportedEncodingException {@link UnsupportedEncodingException}
	 */
	public CsvBufferedReader(final File aFile) throws FileNotFoundException, UnsupportedEncodingException {
		super(new InputStreamReader(new FileInputStream(aFile), System.getProperty("file.encoding")));
	}

	/**
	 * コンストラクタ
	 * 
	 * @param aFile ファイル
	 * @param aCharset 文字エンコーディング
	 * @throws FileNotFoundException {@link FileNotFoundException}
	 * @throws UnsupportedEncodingException {@link UnsupportedEncodingException}
	 */
	public CsvBufferedReader(final File aFile, final String aCharset) throws FileNotFoundException, UnsupportedEncodingException {
		super(new InputStreamReader(new FileInputStream(aFile), aCharset));
	}

	/**
	 * コンストラクタ
	 * 
	 * @param aFile ファイル
	 * @param aCharset 文字エンコーディング
	 * @throws FileNotFoundException {@link FileNotFoundException}
	 * @throws UnsupportedEncodingException {@link UnsupportedEncodingException}
	 */
	public CsvBufferedReader(final File aFile, final Charset aCharset) throws FileNotFoundException, UnsupportedEncodingException {
		super(new InputStreamReader(new FileInputStream(aFile), aCharset));
	}

	/**
	 * CSVとして１行読み取る。
	 * 
	 * @return CSV１行データ
	 * @throws IOException IO操作時に問題が発生した場合
	 */
	public List<String> readCsvLine() throws IOException {
		List<String> result = null;
		String line = readLine();
		if (null != line) {
			result = purseLine(line);
		}
		return result;
	}

	/**
	 * CSV行を解析しデータ単位にする。
	 * 
	 * @param aLine CSV行文字列
	 * @return データ
	 */
	private List<String> purseLine(final String aLine) {
		List<String> result = new ArrayList<String>();
		if (StringUtility.isNotEmpty(aLine)) {
			StringBuilder sb = new StringBuilder();
			boolean dblFlg = false;
			for (int i = 0; i < aLine.length(); i++) {
				char c = aLine.charAt(i);
				if (dblFlg) {
					if ('"' == c) {
						if (aLine.length() > i + 1) {
							if ('"' == aLine.charAt(i + 1)) {
								sb.append('"');
								i++;
							} else {
								dblFlg = false;
							}
						} else {
							// end
						}
					} else {
						sb.append(c);
					}
				} else {
					if ('"' == c) {
						dblFlg = true;
					} else if (',' == c) {
						result.add(sb.toString());
						sb = new StringBuilder();
					} else {
						sb.append(c);
					}
				}
			}
			result.add(sb.toString());
		}
		return result;
	}
}

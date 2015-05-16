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

	/** 区切り文字 */
	private Character separateCharacter = ',';

	/**
	 * コンストラクタ
	 * 
	 * @param reader リーダー
	 */
	public CsvBufferedReader(final Reader reader) {
		super(reader);
	}

	/**
	 * コンストラクタ
	 * <p>
	 * システムデフォルトの文字コードで読み込む。
	 * </p>
	 * 
	 * @param file ファイル
	 * @throws FileNotFoundException {@link FileNotFoundException}
	 * @throws UnsupportedEncodingException {@link UnsupportedEncodingException}
	 */
	public CsvBufferedReader(final String file) throws FileNotFoundException, UnsupportedEncodingException {
		super(new InputStreamReader(new FileInputStream(file), System.getProperty("file.encoding")));
	}

	/**
	 * コンストラクタ
	 * 
	 * @param file ファイル
	 * @param charset 文字エンコーディング
	 * @throws FileNotFoundException {@link FileNotFoundException}
	 * @throws UnsupportedEncodingException {@link UnsupportedEncodingException}
	 */
	public CsvBufferedReader(final String file, final String charset) throws FileNotFoundException, UnsupportedEncodingException {
		super(new InputStreamReader(new FileInputStream(file), charset));
	}

	/**
	 * コンストラクタ
	 * 
	 * @param file ファイル
	 * @param charset 文字エンコーディング
	 * @throws FileNotFoundException {@link FileNotFoundException}
	 * @throws UnsupportedEncodingException {@link UnsupportedEncodingException}
	 */
	public CsvBufferedReader(final String file, final Charset charset) throws FileNotFoundException, UnsupportedEncodingException {
		super(new InputStreamReader(new FileInputStream(file), charset));
	}

	/**
	 * コンストラクタ
	 * <p>
	 * システムデフォルトの文字コードで読み込む。
	 * </p>
	 * 
	 * @param file ファイル
	 * @throws FileNotFoundException {@link FileNotFoundException}
	 * @throws UnsupportedEncodingException {@link UnsupportedEncodingException}
	 */
	public CsvBufferedReader(final File file) throws FileNotFoundException, UnsupportedEncodingException {
		super(new InputStreamReader(new FileInputStream(file), System.getProperty("file.encoding")));
	}

	/**
	 * コンストラクタ
	 * 
	 * @param file ファイル
	 * @param charset 文字エンコーディング
	 * @throws FileNotFoundException {@link FileNotFoundException}
	 * @throws UnsupportedEncodingException {@link UnsupportedEncodingException}
	 */
	public CsvBufferedReader(final File file, final String charset) throws FileNotFoundException, UnsupportedEncodingException {
		super(new InputStreamReader(new FileInputStream(file), charset));
	}

	/**
	 * コンストラクタ
	 * 
	 * @param file ファイル
	 * @param charset 文字エンコーディング
	 * @throws FileNotFoundException {@link FileNotFoundException}
	 * @throws UnsupportedEncodingException {@link UnsupportedEncodingException}
	 */
	public CsvBufferedReader(final File file, final Charset charset) throws FileNotFoundException, UnsupportedEncodingException {
		super(new InputStreamReader(new FileInputStream(file), charset));
	}

	/**
	 * 区切り文字を設定する。
	 * 
	 * @param character 区切り文字
	 */
	public void setSeparateCharacter(final Character character) {
		separateCharacter = character;
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
	 * @param line CSV行文字列
	 * @return データ
	 */
	private List<String> purseLine(final String line) {
		List<String> result = new ArrayList<String>();
		if (StringUtility.isNotEmpty(line)) {
			StringBuilder sb = new StringBuilder();
			boolean dblFlg = false;
			for (int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);
				if (dblFlg) {
					if ('"' == c) {
						if (line.length() > i + 1) {
							if ('"' == line.charAt(i + 1)) {
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
					} else if (separateCharacter == c) {
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

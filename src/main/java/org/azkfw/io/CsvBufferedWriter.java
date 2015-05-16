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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.List;

/**
 * このクラスは、CSVファイルを書き出すライタークラスです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2013/07/02
 * @author Kawakicchi
 */
public class CsvBufferedWriter extends BufferedWriter {

	/** 区切り文字 */
	private Character separateCharacter = ',';

	/** 改行コード */
	private String lineSeparator;

	/**
	 * コンストラクタ
	 * 
	 * @param writer ライター
	 */
	public CsvBufferedWriter(final Writer writer) {
		super(writer);
		setup();
	}

	/**
	 * コンストラクタ
	 * <p>
	 * システムデフォルトの文字コードで書き出す。
	 * </p>
	 * 
	 * @param file ファイル
	 * @throws FileNotFoundException {@link FileNotFoundException}
	 * @throws UnsupportedEncodingException {@link UnsupportedEncodingException}
	 */
	public CsvBufferedWriter(final String file) throws FileNotFoundException, UnsupportedEncodingException {
		super(new OutputStreamWriter(new FileOutputStream(file), System.getProperty("file.encoding")));
		setup();
	}

	/**
	 * コンストラクタ
	 * 
	 * @param file ファイル
	 * @param charset 文字エンコーディング
	 * @throws FileNotFoundException {@link FileNotFoundException}
	 * @throws UnsupportedEncodingException {@link UnsupportedEncodingException}
	 */
	public CsvBufferedWriter(final File file, final String charset) throws FileNotFoundException, UnsupportedEncodingException {
		super(new OutputStreamWriter(new FileOutputStream(file), charset));
		setup();
	}

	/**
	 * コンストラクタ
	 * 
	 * @param file ファイル
	 * @param charset 文字エンコーディング
	 * @throws FileNotFoundException {@link FileNotFoundException}
	 * @throws UnsupportedEncodingException {@link UnsupportedEncodingException}
	 */
	public CsvBufferedWriter(final File file, final Charset charset) throws FileNotFoundException, UnsupportedEncodingException {
		super(new OutputStreamWriter(new FileOutputStream(file), charset));
		setup();
	}

	/**
	 * コンストラクタ
	 * <p>
	 * システムデフォルトの文字コードで書き出す。
	 * </p>
	 * 
	 * @param file ファイル
	 * @throws FileNotFoundException {@link FileNotFoundException}
	 * @throws UnsupportedEncodingException {@link UnsupportedEncodingException}
	 */
	public CsvBufferedWriter(final File file) throws FileNotFoundException, UnsupportedEncodingException {
		super(new OutputStreamWriter(new FileOutputStream(file), System.getProperty("file.encoding")));
		setup();
	}

	/**
	 * コンストラクタ
	 * 
	 * @param file ファイル
	 * @param charset 文字エンコーディング
	 * @throws FileNotFoundException {@link FileNotFoundException}
	 * @throws UnsupportedEncodingException {@link UnsupportedEncodingException}
	 */
	public CsvBufferedWriter(final String file, final String charset) throws FileNotFoundException, UnsupportedEncodingException {
		super(new OutputStreamWriter(new FileOutputStream(file), charset));
		setup();
	}

	/**
	 * コンストラクタ
	 * 
	 * @param file ファイル
	 * @param charset 文字エンコーディング
	 * @throws FileNotFoundException {@link FileNotFoundException}
	 * @throws UnsupportedEncodingException {@link UnsupportedEncodingException}
	 */
	public CsvBufferedWriter(final String file, final Charset charset) throws FileNotFoundException, UnsupportedEncodingException {
		super(new OutputStreamWriter(new FileOutputStream(file), charset));
		setup();
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
	 * 改行コードを設定する。
	 * 
	 * @param lineSeparator 改行コード、<code>null</code>を指定した場合、システムデフォルト改行コードを設定する。
	 */
	public void setLineSeparator(final String lineSeparator) {
		if (null != lineSeparator) {
			this.lineSeparator = lineSeparator;
		} else {
			this.lineSeparator = getSystemLineSeparator();
		}
	}

	/**
	 * CSVとして１行書き出す。
	 * 
	 * @param strs CSV１行データ
	 * @throws IOException IO操作時に問題が発生した場合
	 */
	public void writeCsvLine(final String... strs) throws IOException {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < strs.length; i++) {
			if (0 != i) {
				s.append(separateCharacter);
			}
			s.append(toCsvString(strs[i]));
		}
		s.append(lineSeparator);

		write(s.toString());
	}

	/**
	 * CSVとして１行書き出す。
	 * 
	 * @param strs CSV１行データ
	 * @throws IOException IO操作時に問題が発生した場合
	 */
	public void writeCsvLine(final List<String> strs) throws IOException {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < strs.size(); i++) {
			if (0 != i) {
				s.append(separateCharacter);
			}
			s.append(toCsvString(strs.get(i)));
		}
		s.append(lineSeparator);

		write(s.toString());
	}

	/**
	 * システムの改行コードを取得する。
	 * 
	 * @return 改行コード
	 */
	private static String getSystemLineSeparator() {
		String str = "\n";
		try {
			str = System.getProperty("line.separator");
		} catch (SecurityException ex) {
		}
		return str;
	}

	private void setup() {
		lineSeparator = getSystemLineSeparator();
	}

	/**
	 * 文字列をＣＳＶ用の文字列にする。
	 * 
	 * @param aString 文字列
	 * @return CSV文字列
	 */
	private String toCsvString(final String string) {
		String result = "";
		if (null != string) {
			result = string;
		}
		boolean dblFlg = false;
		if (-1 != result.indexOf(separateCharacter)) {
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

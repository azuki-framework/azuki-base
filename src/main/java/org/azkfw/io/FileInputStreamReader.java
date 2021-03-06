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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

/**
 * このクラスは、ファイルを読み込むリーダークラスです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2014/10/17
 * @author Kawakicchi
 */
public class FileInputStreamReader extends InputStreamReader {

	/** 読み込みサイズ */
	private long readSize;

	/**
	 * コンストラクタ
	 * 
	 * @param file ファイル
	 * @param charset 文字コード
	 * @throws FileNotFoundException {@link FileNotFoundException}
	 * @throws UnsupportedEncodingException {@link UnsupportedEncodingException}
	 */
	public FileInputStreamReader(final File file, final Charset charset) throws FileNotFoundException, UnsupportedEncodingException {
		super(new FileInputStream(file), charset);
		readSize = 0;
	}

	public FileInputStreamReader(final File file) throws FileNotFoundException, UnsupportedEncodingException {
		super(new FileInputStream(file), System.getProperty("file.encoding"));
		readSize = 0;
	}

	/**
	 * トータル読み込みサイズを取得する。
	 * 
	 * @return サイズ
	 */
	public long getTotalReadSize() {
		return readSize;
	}

	@Override
	public int read() throws IOException {
		int ch = super.read();
		if (-1 != ch) {
			readSize++;
		}
		return ch;
	}

	@Override
	public int read(char[] cbuf) throws IOException {
		int size = super.read(cbuf);
		readSize += size;
		return size;
	}

	@Override
	public int read(char[] cbuf, int offset, int length) throws IOException {
		int size = super.read(cbuf, offset, length);
		readSize += size;
		return size;
	}

	@Override
	public int read(CharBuffer target) throws IOException {
		int size = super.read(target);
		readSize += size;

		return size;
	}

	@Override
	public long skip(long n) throws IOException {
		long size = super.skip(n);
		readSize += size;
		return size;
	}
}

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
package org.azkfw.util;

import java.io.File;
import java.nio.file.Paths;

/**
 * このクラスは、パス操作をまとめたユーティリティクラスです。
 * 
 * @since 1.0.0
 * @version 1.0.1 2014/06/06
 * @author Kawakicchi
 */
public final class PathUtility {

	/**
	 * コンストラクタ
	 * <p>
	 * インスタンス生成を禁止する。
	 * </p>
	 */
	private PathUtility() {

	}

	public static File get(final File aDirectory, final String... more) {
		return Paths.get(aDirectory.getAbsolutePath(), more).toFile();
	}

	/**
	 * 文字配列を結合してパスを作成する。
	 * 
	 * @param strs 文字配列
	 * @return パス
	 */
	public static String cat(final String... strs) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < strs.length; i++) {
			String str = replaseEnvSeparator(strs[i]);
			if (0 == i) {
				str = trimR(str, File.separator);
			} else {
				s.append(File.separator);
				str = trim(str, File.separator);
			}
			s.append(str);
		}
		return s.toString();
	}

	/**
	 * パスの接尾に区切り文字を追加する。
	 * 
	 * @param aPath パス
	 * @return パス
	 */
	public static String addSeparatorSuffix(final String aPath) {
		String path = replaseEnvSeparator(aPath);
		if (!path.endsWith(File.separator)) {
			path += File.separator;
		}
		return path;
	}

	/**
	 * パスを環境に合わせた区切り文字に置き換える。
	 * 
	 * @param aPath パス
	 * @return パス
	 */
	public static String replaseEnvSeparator(final String aPath) {
		String path = aPath;
		if (null != path) {
			path = path.replace("/", File.separator);
			path = path.replace("\\", File.separator);
		} else {
			path = StringUtility.EMPTY;
		}
		return path;
	}

	/**
	 * 文字列の前後から指定の文字列を除去する。
	 * 
	 * @param aString 対象文字列
	 * @param aTrimword 除去文字列
	 * @return 除去結果文字列
	 */
	private static String trim(final String aString, final String aTrimword) {
		String buf = trimL(aString, aTrimword);
		buf = trimR(buf, aTrimword);
		return buf;
	}

	/**
	 * 文字列の接頭から指定の文字列を除去する。
	 * 
	 * @param aString 対象文字列
	 * @param aTrimword 除去文字列
	 * @return 除去結果文字列
	 */
	private static String trimL(final String aString, final String aTrimword) {
		String buf = aString;
		if (null != buf) {
			buf = buf.trim();
			while (buf.startsWith(aTrimword)) {
				buf = buf.substring(aTrimword.length());
			}
		} else {
			buf = StringUtility.EMPTY;
		}
		return buf;
	}

	/**
	 * 文字列の接尾から指定の文字列を除去する。
	 * 
	 * @param aString 対象文字列
	 * @param aTrimword 除去文字列
	 * @return 除去結果文字列
	 */
	private static String trimR(final String aString, final String aTrimword) {
		String buf = aString;
		if (null != buf) {
			buf = aString.trim();
			while (buf.endsWith(aTrimword)) {
				buf = buf.substring(0, buf.length() - aTrimword.length());
			}
		} else {
			buf = StringUtility.EMPTY;
		}
		return buf;
	}
}

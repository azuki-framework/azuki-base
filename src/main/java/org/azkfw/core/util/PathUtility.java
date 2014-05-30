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
package org.azkfw.core.util;

import java.io.File;

/**
 * このクラスは、パス操作をまとめたユーティリティクラスです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2013/06/26
 * @author Kawakicchi
 */
public class PathUtility {

	/**
	 * コンストラクタ
	 * <p>
	 * インスタンス生成を禁止する。
	 * </p>
	 */
	private PathUtility() {

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
			if (0 < i) {
				s.append(File.separator);
			}

			String str = strs[i];
			str = str.replaceAll("/", File.separator);
			str = str.replaceAll("\\\\", File.separator);
			if (0 == i) {
				str = trimR(str, File.separator);
			} else {
				str = trim(str, File.separator);
			}
			s.append(str);
		}
		return s.toString();
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
		while (buf.startsWith(aTrimword)) {
			buf = buf.substring(aTrimword.length());
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
		while (buf.endsWith(aTrimword)) {
			buf = buf.substring(0, buf.length() - aTrimword.length());
		}
		return buf;
	}
}

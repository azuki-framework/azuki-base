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

/**
 * このクラスは、文字列操作を行うユーティリティクラスです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2013/01/04
 * @author Kawakicchi
 */
public final class StringUtility {

	/** Empty */
	public static final String EMPTY = "";

	/**
	 * コンストラクタ
	 * <p>
	 * インスタンス生成を禁止する。
	 * </p>
	 */
	private StringUtility() {

	}

	/**
	 * 文字列が、エンプティーでないか判断する。
	 * 
	 * @param string 文字列
	 * @return 文字列が<code>null</code>かブランク以外の場合、<code>true</code>を返す。
	 */
	public static boolean isNotEmpty(final String string) {
		if (null != string) {
			if (!EMPTY.equals(string)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 文字列が、エンプティーか判断する。
	 * 
	 * @param string 文字列
	 * @return 文字列が<code>null</code>かブランクの場合、<code>true</code>を返す。
	 */
	public static boolean isEmpty(final String string) {
		return !(isNotEmpty(string));
	}

	/**
	 * 全ての文字列が、エンプティーでないか判断する。
	 * 
	 * @param strings 文字列群
	 * @return 全ての文字列が<code>null</code>かブランク以外の場合、<code>true</code>を返す。
	 */
	public static boolean isNotEmptyAll(final String... strings) {
		for (String str : strings) {
			if (isEmpty(str)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * どれか１つでも文字列が、エンプティーでないか文字列があるか判断する。
	 * 
	 * @param strings 文字列群
	 * @return どれか１つでも文字列が<code>null</code>かブランク以外の場合、<code>true</code>を返す。
	 */
	public static boolean isNotEmptyAny(final String... strings) {
		for (String str : strings) {
			if (isNotEmpty(str)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * オブジェクトを文字列として取得する。 オブジェクトが<code>null</code>の場合、空文字を返す。
	 * 
	 * @param object オブジェクト
	 * @return 文字列
	 */
	public static String toStringEmpty(final Object object) {
		String string = EMPTY;
		if (null != object) {
			string = object.toString();
		}
		return string;
	}

	/**
	 * オブジェクトを文字列として取得する。 オブジェクトが<code>null</code>の場合、<code>null</code>を返す。
	 * 
	 * @param object オブジェクト
	 * @return 空文字
	 */
	public static String toStringNull(final Object object) {
		String string = null;
		if (null != object) {
			string = object.toString();
		}
		return string;
	}

	/**
	 * 文字列をトリムする。
	 * 
	 * @param string 文字列
	 * @return 文字列
	 */
	public static String trim(final String string) {
		String str = string;
		if (StringUtility.isNotEmpty(str)) {
			str = str.trim();
		}
		return str;
	}

	/**
	 * 文字列をキャメル表記で取得する。
	 * 
	 * @param string 文字列
	 * @return キャメル表記文字列
	 */
	public static String toCamelcase(final String string) {
		StringBuilder s = new StringBuilder();
		boolean big = false;
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			if ('_' == c) {
				big = true;
			} else {
				if (big) {
					big = false;
					s.append(Character.toUpperCase(c));
				} else {
					s.append(c);
				}
			}
		}
		return s.toString();
	}
}

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
package jp.afw.core.util;

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
	 * 文字列が、エンプティーか判断する。
	 * 
	 * @param aString 文字列
	 * @return 文字列が<code>null</code>かブランク以外の場合、<code>true</code>を返す。
	 */
	public static boolean isNotEmpty(final String aString) {
		if (null != aString) {
			if (!EMPTY.equals(aString)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 文字列が、エンプティーか判断する。
	 * 
	 * @param aString 文字列
	 * @return 文字列が<code>null</code>かブランクの場合、<code>true</code>を返す。
	 */
	public static boolean isEmpty(final String aString) {
		return !(isNotEmpty(aString));
	}

	/**
	 * オブジェクトを文字列として取得する。
	 * オブジェクトが<code>null</code>の場合、空文字を返す。
	 * 
	 * @param aObject オブジェクト
	 * @return 文字列
	 */
	public static String toStringEmpty(final Object aObject) {
		String string = EMPTY;
		if (null != aObject) {
			string = aObject.toString();
		}
		return string;
	}

	/**
	 * オブジェクトを文字列として取得する。
	 * オブジェクトが<code>null</code>の場合、<code>null</code>を返す。
	 * 
	 * @param aObject オブジェクト
	 * @return 空文字
	 */
	public static String toStringNull(final Object aObject) {
		String string = null;
		if (null != aObject) {
			string = aObject.toString();
		}
		return string;
	}

	/**
	 * 文字列をキャメル表記で取得する。
	 * 
	 * @param aString 文字列
	 * @return キャメル表記文字列
	 */
	public static String toCamel(final String aString) {
		StringBuilder s = new StringBuilder();
		boolean big = false;
		for (int i = 0; i < aString.length(); i++) {
			char c = aString.charAt(i);
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

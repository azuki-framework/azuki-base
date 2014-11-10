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
 * このクラスは、オブジェクト操作を行うユーティリティクラスです。
 * 
 * @since 1.2.0
 * @version 1.2.0 2014/07/02
 * @author Kawakicchi
 */
public final class ObjectUtility {

	/**
	 * コンストラクタ
	 * <p>
	 * インスタンス生成を禁止する。
	 * </p>
	 */
	private ObjectUtility() {

	}

	/**
	 * オブジェクトが、<code>null</code>か判断する。
	 * 
	 * @param aObject オブジェクト
	 * @return オブジェクトが<code>null</code>以外の場合、<code>true</code>を返す。
	 */
	public static boolean isNotNull(final Object aObject) {
		return (null != aObject);
	}

	/**
	 * オブジェクトが、<code>null</code>か判断する。
	 * 
	 * @param aObject オブジェクト
	 * @return オブジェクトが<code>null</code>の場合、<code>true</code>を返す。
	 */
	public static boolean isNull(final Object aObject) {
		return !(isNotNull(aObject));
	}

	/**
	 * 全てのオブジェクトが、<code>null</code>でないか判断する。
	 * 
	 * @param aObject オブジェクト
	 * @return 全てのオブジェクトが<code>null</code>以外の場合、<code>true</code>を返す。
	 */
	public static boolean isAllNotNull(final Object... objects) {
		for (Object object : objects) {
			if (null == object) {
				return false;
			}
		}
		return true;
	}

	/**
	 * オブジェクト配列の最初に見つかった<code>null</code>以外のオブジェクトを返す。
	 * 
	 * @param objs オブジェクト配列
	 * @return 最初に見つかった<code>null</code>以外のオブジェクト
	 */
	@SafeVarargs
	public static <TYPE> TYPE getNotNullObject(final TYPE... objs) {
		for (TYPE obj : objs) {
			if (null != obj) {
				return obj;
			}
		}
		return null;
	}
}

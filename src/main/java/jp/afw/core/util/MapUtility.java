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

import java.util.Map;

/**
 * このクラスは、マップ操作を行うユーティリティクラスです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2013/01/01
 * @author Kawakicchi
 */
public final class MapUtility {

	/**
	 * コンストラクタ
	 * <p>
	 * インスタンス生成を禁止する。
	 * </p>
	 */
	private MapUtility() {

	}

	/**
	 * マップが、エンプティーか判断する。
	 * 
	 * @param aMap マップ
	 * @return マップが<code>null</code>かエンプティーの場合、<code>true</code>を返す。
	 */
	public static boolean isEmpty(final Map<?, ?> aMap) {
		return !(isNotEmpty(aMap));
	}

	/**
	 * マップが、エンプティーか判断する。
	 * 
	 * @param aMap マップ
	 * @return マップが<code>null</code>かエンプテー以外の場合、<code>true</code>を返す。
	 */
	public static boolean isNotEmpty(final Map<?, ?> aMap) {
		if (null != aMap) {
			if (!aMap.isEmpty()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * マップの値を取得する。
	 * 
	 * @param map マップ
	 * @param key キー
	 * @param def デフォルト値
	 * @return 値
	 */
	public static Object getObject(final Map<?, ?> map, final Object key, final Object def) {
		Object result = def;
		if (map.containsKey(key)) {
			Object o = map.get(key);
			if (null != o) {
				result = o;
			}
		}
		return result;
	}

	/**
	 * マップの値を取得する。
	 * 
	 * @param map マップ
	 * @param key キー
	 * @return 値
	 */
	public static String getString(final Map<?, ?> map, final Object key) {
		return getString(map, key, null);
	}

	/**
	 * マップの値を取得する。
	 * 
	 * @param map マップ
	 * @param key キー
	 * @param def デフォルト値
	 * @return 値
	 */
	public static String getString(final Map<?, ?> map, final Object key, final String def) {
		Object result = getObject(map, key, def);
		if (null != result) {
			return result.toString();
		} else {
			return null;
		}
	}

	/**
	 * マップの値を取得する。
	 * 
	 * @param map マップ
	 * @param key キー
	 * @return 値
	 */
	public static Integer getInteger(final Map<?, ?> map, final Object key) {
		return getInteger(map, key, null);
	}

	/**
	 * マップの値を取得する。
	 * 
	 * @param map マップ
	 * @param key キー
	 * @param def デフォルト値
	 * @return 値
	 */
	public static Integer getInteger(final Map<?, ?> map, final Object key, final Integer def) {
		Integer result = def;
		if (map.containsKey(key)) {
			Object obj = map.get(key);
			if (null != obj) {
				if (obj instanceof Integer) {
					result = (Integer) obj;
				} else if (obj instanceof Long) {
					result = Integer.valueOf(((Long) obj).intValue());
				} else if (obj instanceof String) {
					result = Integer.parseInt((String) obj);
				}
			}
		}
		return result;
	}

	/**
	 * マップの値を取得する。
	 * 
	 * @param map マップ
	 * @param key キー
	 * @return 値
	 */
	public static Long getLong(final Map<?, ?> map, final Object key) {
		return getLong(map, key, null);
	}

	/**
	 * マップの値を取得する。
	 * 
	 * @param map マップ
	 * @param key キー
	 * @param def デフォルト値
	 * @return 値
	 */
	public static Long getLong(final Map<?, ?> map, final Object key, final Long def) {
		Long result = def;
		if (map.containsKey(key)) {
			Object obj = map.get(key);
			if (null != obj) {
				if (obj instanceof Long) {
					result = (Long) obj;
				} else if (obj instanceof Integer) {
					result = Long.valueOf(((Integer) obj).longValue());
				} else if (obj instanceof String) {
					result = Long.parseLong((String) obj);
				}
			}
		}
		return result;
	}
}

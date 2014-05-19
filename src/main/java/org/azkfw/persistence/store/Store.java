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
package org.azkfw.persistence.store;

import java.util.Map;

/**
 * このクラスは、ストア機能を表現するインターフェースです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2013/01/01
 * @author Kawakicchi
 */
public interface Store<K, V> {

	/**
	 * 値を格納する。
	 * 
	 * @param aKey キー
	 * @param aValue 値
	 */
	public void put(final K aKey, final V aValue);

	/**
	 * 値をすべて格納する。
	 * 
	 * @param aMap マップ
	 */
	public void putAll(final Map<K, V> aMap);

	/**
	 * 値を取得する。
	 * 
	 * @param aKey キー
	 * @return 値
	 */
	public V get(final K aKey);

	/**
	 * 値を取得する。
	 * 
	 * @param aKey キー
	 * @param aDefault デフォルト値
	 * @return 値
	 */
	public V get(final K aKey, final V aDefault);

	/**
	 * キーに値が存在するか判断する。
	 * 
	 * @param aKey キー
	 * @return 判断結果
	 */
	public boolean has(final K aKey);

	/**
	 * 値を削除する。
	 * 
	 * @param aKey キー
	 */
	public void remove(final K aKey);
}

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

import java.util.UUID;

/**
 * このクラスは、UUID操作を行うユーティリティクラスです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2013/06/14
 * @author Kawakicchi
 */
public class UUIDUtility {

	/**
	 * コンストラクタ
	 * <p>
	 * インスタンス生成を禁止する。
	 * </p>
	 */
	private UUIDUtility() {

	}

	/**
	 * UUIDを生成する。
	 * 
	 * @return UUID
	 */
	public static String generateToString() {
		String s = UUID.randomUUID().toString();
		return s;
	}

	/**
	 * UUIDを生成する。
	 * 
	 * @return UUID
	 */
	public static String generateToShortString() {
		String s = UUID.randomUUID().toString();
		return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24, 36);
	}
}

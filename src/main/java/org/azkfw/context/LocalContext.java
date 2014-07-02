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
package org.azkfw.context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.azkfw.util.PathUtility;
import org.azkfw.util.StringUtility;

/**
 * このクラスは、ローカル用のコンテキスト機能を実装するクラスです。
 * 
 * @since 1.0.0
 * @version 1.0.0 12/06/07
 * @author Kawakicchi
 */
public class LocalContext extends AbstractContext {

	/**
	 * ベースディレクトリ
	 */
	private String baseDir;

	/**
	 * コンストラクタ
	 */
	public LocalContext() {
		baseDir = PathUtility.addSeparatorSuffix(".");
	}

	/**
	 * コンストラクタ
	 * 
	 * @param aBaseDir ベースディレクトリ
	 */
	public LocalContext(final String aBaseDir) {
		if (StringUtility.isEmpty(aBaseDir)) {
			baseDir = StringUtility.EMPTY;
		} else {
			baseDir = PathUtility.addSeparatorSuffix(aBaseDir);
		}
	}

	@Override
	public String getAbstractPath(final String aName) {
		return getFullPath(aName);
	}

	@Override
	@SuppressWarnings("resource")
	public InputStream getResourceAsStream(final String name) {
		InputStream stream = null;
		try {
			stream = new FileInputStream(getFullPath(name));
		} catch (FileNotFoundException ex) {
			;
		}
		if (null == stream) {
			stream = this.getClass().getResourceAsStream(name);
		}
		if (null == stream) {
			stream = Class.class.getResourceAsStream(name);
		}
		return stream;
	}

	/**
	 * ベースディレクトリを取得する。
	 * 
	 * @return ベースディレクトリ
	 */
	protected final String getBaseDir() {
		return baseDir;
	}

	/**
	 * フルパスを取得する。
	 * 
	 * @param aName 名前
	 * @return パス
	 */
	private String getFullPath(final String aName) {
		StringBuilder path = new StringBuilder();
		String name = PathUtility.replaseEnvSeparator(aName);
		if (name.startsWith("/") || -1 != name.indexOf(":\\") || StringUtility.isEmpty(baseDir)) {
			path.append(aName);
		} else {
			path.append(PathUtility.cat(baseDir, aName));
		}
		return path.toString();
	}
}

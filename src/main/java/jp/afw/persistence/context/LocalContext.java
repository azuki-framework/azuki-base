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
package jp.afw.persistence.context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import jp.afw.core.util.StringUtility;

/**
 * このクラスは、ローカル用のコンテキスト機能を実装するクラスです。
 * 
 * @since 1.0.0
 * @version 1.0.0 12/06/07
 * @author Kawakicchi
 * 
 */
public final class LocalContext extends AbstractContext {

	/**
	 * ベースディレクトリ
	 */
	private String baseDir;

	/**
	 * コンストラクタ
	 */
	public LocalContext() {
		baseDir = ".";
	}

	/**
	 * コンストラクタ
	 * 
	 * @param dir ベースディレクトリ
	 */
	public LocalContext(final String dir) {
		baseDir = dir;
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
	 * フルパスを取得する。
	 * 
	 * @param name 名前
	 * @return パス
	 */
	private String getFullPath(final String name) {
		StringBuilder path = new StringBuilder();
		if (StringUtility.isNotEmpty(baseDir)) {
			path.append(baseDir);
		}
		if (!name.startsWith("/")) {
			path.append("/");
		}
		path.append(name);
		return path.toString();
	}
}

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
package jp.afw.core.log;

import jp.afw.persistence.context.Context;

/**
 * このクラスは、ログを生成するファクトリークラスです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2012/08/12
 * @author Kawakicchi
 */
public abstract class LoggerFactory {

	private static LoggerFactory FACTORY = new StdoutLoggerFactory();

	protected abstract void doLoad(final String aName, final Context aContext);

	protected abstract Logger doCreate();

	protected abstract Logger doCreate(final String aName);

	protected abstract Logger doCreate(final Class<?> aClass);

	protected LoggerFactory() {

	}

	public static final void load(final String aFactoryClass, final String aName, final Context aContext) {
		try {
			Class<?> clazz = Class.forName(aFactoryClass);
			Object obj = clazz.newInstance();
			if (obj instanceof LoggerFactory) {
				FACTORY = (LoggerFactory) obj;
				FACTORY.doLoad(aName, aContext);
			}
		} catch (ClassNotFoundException ex) {

		} catch (IllegalAccessException ex) {

		} catch (InstantiationException ex) {

		}
	}

	/**
	 * ログインスタンスを生成します。
	 * 
	 * @return ログインスタンス
	 */
	public static final Logger create() {
		return FACTORY.doCreate();
	}

	/**
	 * ログインスタンスを生成します。
	 * 
	 * @param aName 名前
	 * @return ログインスタンス
	 */
	public static final Logger create(final String aName) {
		return FACTORY.doCreate(aName);
	}

	/**
	 * ログインスタンスを生成します。
	 * 
	 * @param aClass クラス
	 * @return ログインスタンス
	 */
	public static final Logger create(final Class<?> aClass) {
		return FACTORY.doCreate(aClass);
	}
}

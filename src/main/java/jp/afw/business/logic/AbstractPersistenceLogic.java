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
package jp.afw.business.logic;

import jp.afw.persistence.context.Context;
import jp.afw.persistence.context.ContextSupport;
import jp.afw.persistence.proterty.Property;
import jp.afw.persistence.proterty.PropertySupport;

/**
 * このクラスは、ロジック機能を実装する基底クラスです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2012/12/30
 * @author Kawakicchi
 */
public abstract class AbstractPersistenceLogic extends AbstractLogic implements ContextSupport, PropertySupport {

	/**
	 * コンテキスト
	 */
	private Context context;

	/**
	 * プロパティ
	 */
	private Property property;

	/**
	 * コンストラクタ
	 */
	public AbstractPersistenceLogic() {
		super();
		property = new Property();
	}

	/**
	 * コンストラクタ
	 * 
	 * @param aName 名前
	 */
	public AbstractPersistenceLogic(final String aName) {
		super(aName);
		property = new Property();
	}

	/**
	 * コンストラクタ
	 * 
	 * @param aClass クラス
	 */
	public AbstractPersistenceLogic(final Class<?> aClass) {
		super(aClass);
		property = new Property();
	}

	@Override
	public final void setContext(final Context aContext) {
		context = aContext;
	}

	/**
	 * コンテキストを取得する。
	 * 
	 * @return コンテキスト
	 */
	protected final Context getContext() {
		return context;
	}

	@Override
	public final void setProperty(final Property aProperty) {
		property = aProperty;
	}

	/**
	 * プロパティ情報を取得する。
	 * 
	 * @return プロパティ情報
	 */
	protected final Property getProperty() {
		return property;
	}
}
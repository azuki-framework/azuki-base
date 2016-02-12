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
package org.azkfw.plugin;

import java.io.IOException;

import org.azkfw.configuration.ConfigurationFormatException;
import org.azkfw.configuration.Configuration;
import org.azkfw.configuration.ConfigurationSupport;
import org.azkfw.context.Context;
import org.azkfw.context.ContextSupport;
import org.azkfw.log.LoggingObject;

/**
 * このクラスは、プラグイン機能の実装を行うための基底クラスです。
 * 
 * @since 1.0.0
 * @version 1.0.0 12/06/07
 * @author Kawakicchi
 */
public abstract class AbstractPlugin extends LoggingObject implements Plugin, ContextSupport, ConfigurationSupport {

	/**
	 * コンテキスト情報
	 */
	private Context context;

	/**
	 * コンフィグレーション情報
	 */
	private Configuration configuration;

	/**
	 * コンストラクタ
	 */
	public AbstractPlugin() {
		super(Plugin.class);
	}

	/**
	 * コンストラクタ
	 * 
	 * @param aName 名前
	 */
	public AbstractPlugin(final String aName) {
		super(aName);
	}

	/**
	 * コンストラクタ
	 * 
	 * @param clazz クラス
	 */
	public AbstractPlugin(final Class<?> aClass) {
		super(aClass);
	}

	@Override
	public final void setContext(final Context aContext) {
		context = aContext;
	}

	/**
	 * コンテキスト情報を取得する。
	 * 
	 * @return コンテキスト情報
	 */
	protected final Context getContext() {
		return context;
	}

	@Override
	public final void setConfiguration(final Configuration aConfiguration) {
		configuration = aConfiguration;
	}

	/**
	 * コンフィグレーション情報を取得する。
	 * 
	 * @return コンフィグレーション情報
	 */
	protected final Configuration getConfiguration() {
		return configuration;
	}

	@Override
	public final void initialize() throws PluginServiceException {
		debug(this.getClass().getSimpleName() + ".initialize()");
		doInitialize();
	}

	@Override
	public final void load() throws PluginServiceException, ConfigurationFormatException, IOException {
		debug(this.getClass().getSimpleName() + ".load()");
		doLoad();
	}

	@Override
	public final void destroy() throws PluginServiceException {
		debug(this.getClass().getSimpleName() + ".destroy()");
		doDestroy();
	}
	
	@Override
	public final void support(final Object obj) throws PluginServiceException {
		doSupport(obj);
	}

	/**
	 * 初期化処理を行う。
	 * 
	 * @throws PluginServiceException プラグイン機能に起因する問題が発生した場合
	 */
	protected abstract void doInitialize() throws PluginServiceException;

	/**
	 * 設定情報をロードする。
	 * 
	 * @throws PluginServiceException プラグイン機能に起因する問題が発生した場合
	 * @throws ConfigurationFormatException 設定ファイルに問題がある場合
	 * @throws IOException IO操作時に問題が発生した場合
	 */
	protected abstract void doLoad() throws PluginServiceException, ConfigurationFormatException, IOException;

	/**
	 * 解放処理を行う。
	 * 
	 * @throws PluginServiceException プラグイン機能に起因する問題が発生した場合
	 */
	protected abstract void doDestroy() throws PluginServiceException;

	/**
	 * オプジェクトにサポート機能を付与する。
	 * 
	 * @param obj オプジェクト
	 * @throws PluginServiceException プラグイン機能に起因する問題が発生した場合
	 */
	protected void doSupport(final Object obj) throws PluginServiceException {
		
	}

}

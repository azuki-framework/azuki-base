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
package jp.afw.plugin;

import java.io.IOException;

import jp.afw.persistence.ConfigurationFormatException;

/**
 * このインターフェースは、プラグイン機能を表現するインターフェースです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2012/06/07
 * @author Kawakicchi
 */
public interface Plugin {

	/**
	 * 初期化処理を行う。
	 * 
	 * @throws PluginServiceException プラグイン機能に起因する問題が発生した場合
	 */
	public void initialize() throws PluginServiceException;

	/**
	 * 解放処理を行う。
	 * 
	 * @throws PluginServiceException プラグイン機能に起因する問題が発生した場合
	 */
	public void destroy() throws PluginServiceException;

	/**
	 * 設定情報をロードする。
	 * 
	 * @throws PluginServiceException プラグイン機能に起因する問題が発生した場合
	 * @throws ConfigurationFormatException 設定ファイルに問題がある場合
	 * @throws IOException IO操作時に問題が発生した場合
	 */
	public void load() throws PluginServiceException, ConfigurationFormatException, IOException;
}

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
package org.azkfw.core.console;

/**
 * このインターフェースは、コンソール機能のサポートを行うためのインターフェースです。
 * 
 * @since 1.0.1
 * @version 1.0.1 2014/06/10
 * @author Kawakicchi
 */
public interface Console {

	/**
	 * 行の最大文字数を取得する。
	 * 
	 * @return 文字数
	 */
	public int getCharacterMaxSizeOfLine();

	/**
	 * メッセージを出力する。
	 * 
	 * @param message メッセージ
	 */
	public void print(final String message);

	/**
	 * フォーマットにしたがってメッセージを出力する。
	 * 
	 * @param format フォーマット
	 * @param args 引数
	 */
	public void print(final String format, final Object... args);

	/**
	 * メッセージを出力する。
	 * 
	 * @param message メッセージ
	 */
	public void println(final String message);

	/**
	 * フォーマットにしたがってメッセージを出力する。
	 * 
	 * @param format フォーマット
	 * @param args 引数
	 */
	public void println(final String format, final Object... args);

}

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
package org.azkfw.core.log;

/**
 * このインターフェースは、ログ機能を表現するインターフェースです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2012/08/12
 * @author Kawakicchi
 */
public interface Logger {

	/**
	 * ログ(DEBUG)を出力します。
	 * 
	 * @param message Message
	 */
	public void debug(final String message);

	/**
	 * ログ(DEBUG)を出力します。
	 * 
	 * @param throwable Throwable
	 */
	public void debug(final Throwable throwable);

	/**
	 * ログ(DEBUG)を出力します。
	 * 
	 * @param message Message
	 * @param throwable Throwable
	 */
	public void debug(final String message, final Throwable throwable);

	/**
	 * ログ(INFO)を出力します。
	 * 
	 * @param message Message
	 */
	public void info(final String message);

	/**
	 * ログ(INFO)を出力します。
	 * 
	 * @param throwable Throwable
	 */
	public void info(final Throwable throwable);

	/**
	 * ログ(INFO)を出力します。
	 * 
	 * @param message Message
	 * @param throwable Throwable
	 */
	public void info(final String message, final Throwable throwable);

	/**
	 * ログ(WARN)を出力します。
	 * 
	 * @param message Message
	 */
	public void warn(final String message);

	/**
	 * ログ(WARN)を出力します。
	 * 
	 * @param throwable Throwable
	 */
	public void warn(final Throwable throwable);

	/**
	 * ログ(WARN)を出力します。
	 * 
	 * @param message Message
	 * @param throwable Throwable
	 */
	public void warn(final String message, final Throwable throwable);

	/**
	 * ログ(ERROR)を出力します。
	 * 
	 * @param message Message
	 */
	public void error(final String message);

	/**
	 * ログ(ERROR)を出力します。
	 * 
	 * @param throwable Throwable
	 */
	public void error(final Throwable throwable);

	/**
	 * ログ(ERROR)を出力します。
	 * 
	 * @param message Message
	 * @param throwable Throwable
	 */
	public void error(final String message, final Throwable throwable);

	/**
	 * ログ(FATAL)を出力します。
	 * 
	 * @param message Message
	 */
	public void fatal(final String message);

	/**
	 * ログ(FATAL)を出力します。
	 * 
	 * @param throwable Throwable
	 */
	public void fatal(final Throwable throwable);

	/**
	 * ログ(FATAL)を出力します。
	 * 
	 * @param message Message
	 * @param throwable Throwable
	 */
	public void fatal(final String message, final Throwable throwable);
}

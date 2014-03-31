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

/**
 * このクラスは、Log4j機能で出力を行うロガークラスです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2013/02/09
 * @author Kawakicchi
 */
public class Log4jLogger implements Logger {

	/**
	 * Log4j logger
	 */
	private org.apache.log4j.Logger logger;

	/**
	 * コンストラクタ
	 * 
	 * @param aName 名前
	 */
	public Log4jLogger(final String aName) {
		logger = org.apache.log4j.Logger.getLogger(aName);
	}

	/**
	 * コンストラクタ
	 * 
	 * @param aClazz
	 */
	public Log4jLogger(final Class<?> aClazz) {
		logger = org.apache.log4j.Logger.getLogger(aClazz);
	}

	@Override
	public void debug(final String aMessage) {
		logger.debug(aMessage);
	}

	@Override
	public void debug(final Throwable aThrowable) {
		logger.debug(aThrowable.getMessage(), aThrowable);
	}

	@Override
	public void debug(final String aMessage, final Throwable aThrowable) {
		logger.debug(aMessage, aThrowable);
	}

	@Override
	public void info(final String aMessage) {
		logger.info(aMessage);
	}

	@Override
	public void info(final Throwable aThrowable) {
		logger.info(aThrowable.getMessage(), aThrowable);
	}

	@Override
	public void info(final String aMessage, final Throwable aThrowable) {
		logger.info(aMessage, aThrowable);
	}

	@Override
	public void warn(final String aMessage) {
		logger.warn(aMessage);
	}

	@Override
	public void warn(final Throwable aThrowable) {
		logger.warn(aThrowable.getMessage(), aThrowable);
	}

	@Override
	public void warn(final String aMessage, final Throwable aThrowable) {
		logger.warn(aMessage, aThrowable);
	}

	@Override
	public void error(final String aMessage) {
		logger.error(aMessage);
	}

	@Override
	public void error(final Throwable aThrowable) {
		logger.error(aThrowable.getMessage(), aThrowable);
	}

	@Override
	public void error(final String aMessage, final Throwable aThrowable) {
		logger.error(aMessage, aThrowable);
	}

	@Override
	public void fatal(final String aMessage) {
		logger.fatal(aMessage);
	}

	@Override
	public void fatal(final Throwable aThrowable) {
		logger.fatal(aThrowable.getMessage(), aThrowable);
	}

	@Override
	public void fatal(final String aMessage, final Throwable aThrowable) {
		logger.fatal(aMessage, aThrowable);
	}

}

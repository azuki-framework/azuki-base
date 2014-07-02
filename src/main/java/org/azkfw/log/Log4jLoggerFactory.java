/** * Licensed to the Apache Software Foundation (ASF) under one * or more contributor license agreements.  See the NOTICE file * distributed with this work for additional information * regarding copyright ownership.  The ASF licenses this file * to you under the Apache License, Version 2.0 (the * "License"); you may not use this file except in compliance * with the License.  You may obtain a copy of the License at * *     http://www.apache.org/licenses/LICENSE-2.0 * * Unless required by applicable law or agreed to in writing, software * distributed under the License is distributed on an "AS IS" BASIS, * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. * See the License for the specific language governing permissions and * limitations under the License. */package org.azkfw.log;import org.apache.log4j.xml.DOMConfigurator;import org.azkfw.context.Context;/** * このクラスは、Log4jロガーのインスタンス生成を行うファクトリクラスです。 *  * @since 1.0.0 * @version 1.0.0 2013/02/09 * @author Kawakicchi */public final class Log4jLoggerFactory extends LoggerFactory {	/**	 * コンストラクタ	 */	public Log4jLoggerFactory() {	}	@Override	protected void doLoad(String aName, Context aContext) {		DOMConfigurator.configure(aContext.getAbstractPath(aName));	}	@Override	protected Logger doCreate() {		return new Log4jLogger(LoggerFactory.class);	}	@Override	protected Logger doCreate(final String aName) {		return new Log4jLogger(aName);	}	@Override	protected Logger doCreate(final Class<?> aClass) {		return new Log4jLogger(aClass);	}}
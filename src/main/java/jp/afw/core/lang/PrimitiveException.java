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
package jp.afw.core.lang;

/**
 * このクラスは、例外の基底となるクラスです。
 * 
 * @since 1.0.0
 * @version 1.0.0 12/06/07
 * @author Kawakicchi
 */
public abstract class PrimitiveException extends Exception {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2889735279991264706L;

	/**
	 * コンストラクタ
	 */
	public PrimitiveException() {
		super();
	}

	/**
	 * コンストラクタ
	 * 
	 * @param message Message
	 */
	public PrimitiveException(final String message) {
		super(message);
	}

	/**
	 * コンストラクタ
	 * 
	 * @param throwable Throwable
	 */
	public PrimitiveException(final Throwable throwable) {
		super(throwable);
	}

	/**
	 * コンストラクタ
	 * 
	 * @param message Message
	 * @param throwable Throwable
	 */
	public PrimitiveException(final String message, final Throwable throwable) {
		super(message, throwable);
	}
}

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
 * このクラスは、コンソール機能の実装を行うための基底クラスです。
 * 
 * @since 1.0.1
 * @version 1.0.1 2014/06/10
 * @author Kawakicchi
 */
public abstract class AbstractConsole implements Console {

	public void print(final String message) {
		System.out.print(message);
	}

	public void print(final String format, final Object... args) {
		String message = String.format(format, args);
		print(message);
	}

	public void println(final String message) {
		System.out.println(message);
	}

	public void println(final String format, final Object... args) {
		String message = String.format(format, args);
		println(message);
	}

	public int getCharacterMaxSizeOfLine() {
		return 80;
	}
}

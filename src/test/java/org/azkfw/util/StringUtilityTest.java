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
package org.azkfw.util;

import junit.framework.TestCase;

import org.azkfw.util.StringUtility;
import org.junit.Test;

/**
 * このクラスは、{@link StringUtility}クラスのユニットテストを行うクラスです。
 * 
 * @since 1.0.0
 * @version 1.0.1 2014/06/06
 * @author Kawakicchi
 */
public class StringUtilityTest extends TestCase {

	@Test
	public void testTrim() {
		String src;
		String dst;

		src = null;
		dst = StringUtility.trim(src);
		assertNull(dst);

		src = "";
		dst = StringUtility.trim(src);
		assertEquals("", dst);

		src = " ";
		dst = StringUtility.trim(src);
		assertEquals("", dst);

		src = "  ";
		dst = StringUtility.trim(src);
		assertEquals("", dst);

		src = "AA ";
		dst = StringUtility.trim(src);
		assertEquals("AA", dst);

		src = "AA ";
		dst = StringUtility.trim(src);
		assertEquals("AA", dst);

		src = " AA ";
		dst = StringUtility.trim(src);
		assertEquals("AA", dst);

		src = "   AA   ";
		dst = StringUtility.trim(src);
		assertEquals("AA", dst);

		src = "  [ AA ]  ";
		dst = StringUtility.trim(src);
		assertEquals("[ AA ]", dst);

		src = "\tAA\t";
		dst = StringUtility.trim(src);
		assertEquals("AA", dst);
	}
}

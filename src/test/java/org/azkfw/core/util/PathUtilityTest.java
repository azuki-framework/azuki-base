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
package org.azkfw.core.util;

import java.io.File;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * このクラスは、{@link PathUtility}クラスのユニットテストを行うクラスです。
 * 
 * @since 1.0.0
 * @version 1.0.1 2014/06/06
 * @author Kawakicchi
 */
public class PathUtilityTest extends TestCase {

	@Test
	public void testCat() {

		assertEquals("", PathUtility.cat());
		assertEquals("", PathUtility.cat(""));

		assertEquals(File.separator, PathUtility.cat("", ""));
		assertEquals("aaa" + File.separator + "bbb", PathUtility.cat("aaa", "bbb"));
	}

	@Test
	public void testAddSeparatorSuffix() {

		assertEquals(File.separator, PathUtility.addSeparatorSuffix(null));
		assertEquals(File.separator, PathUtility.addSeparatorSuffix(""));

	}
}

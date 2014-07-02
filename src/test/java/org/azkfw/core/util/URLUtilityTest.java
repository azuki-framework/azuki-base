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

import junit.framework.TestCase;

import org.azkfw.util.URLUtility;
import org.junit.Test;

/**
 * このクラスは、{@link URLUtility}クラスのユニットテストを行うクラスです。
 * 
 * @since 1.0.0
 * @version 1.0.1 2014/06/06
 * @author Kawakicchi
 */
public class URLUtilityTest extends TestCase {

	@Test
	public void testA() {

		try {
			assertEquals("https://127.0.0.1", URLUtility.get("http://localhost", "https://127.0.0.1"));
			assertEquals("https://127.0.0.1/", URLUtility.get("http://localhost", "https://127.0.0.1/"));
			assertEquals("https://127.0.0.1/test.do", URLUtility.get("http://localhost", "https://127.0.0.1/test.do"));
			assertEquals("https://127.0.0.1/test.do?aaa=BBB", URLUtility.get("http://localhost", "https://127.0.0.1/test.do?aaa=BBB"));
			assertEquals("https://127.0.0.1/test.do#top", URLUtility.get("http://localhost", "https://127.0.0.1/test.do#top"));

			assertEquals("http://localhost/test.do", URLUtility.get("http://localhost", "/test.do"));
			assertEquals("http://localhost/test.do", URLUtility.get("http://localhost/", "/test.do"));
			assertEquals("http://localhost/test.do", URLUtility.get("http://localhost/index.do", "/test.do"));
			assertEquals("http://localhost/test.do", URLUtility.get("http://localhost/aaaa", "/test.do"));
			assertEquals("http://localhost/test.do", URLUtility.get("http://localhost/aaaa/", "/test.do"));
			assertEquals("http://localhost/test.do", URLUtility.get("http://localhost/aaaa/index.do", "/test.do"));
			assertEquals("http://localhost/test.do?aaa=BBB", URLUtility.get("http://localhost/aaaa/index.do", "/test.do?aaa=BBB"));
			assertEquals("http://localhost/test.do#bottom", URLUtility.get("http://localhost/aaaa/index.do", "/test.do#bottom"));

			assertEquals("http://localhost", URLUtility.get("http://localhost", ""));
			assertEquals("http://localhost/", URLUtility.get("http://localhost/", ""));
			assertEquals("http://localhost/index.do", URLUtility.get("http://localhost/index.do", ""));
			assertEquals("http://localhost/aaaa", URLUtility.get("http://localhost/aaaa", ""));
			assertEquals("http://localhost/aaaa/", URLUtility.get("http://localhost/aaaa/", ""));
			assertEquals("http://localhost/aaaa/index.do", URLUtility.get("http://localhost/aaaa/index.do", ""));
			assertEquals("http://localhost/aaaa/index.do?aaa=bbb", URLUtility.get("http://localhost/aaaa/index.do?aaa=bbb", ""));
			assertEquals("http://localhost/aaaa/index.do", URLUtility.get("http://localhost/aaaa/index.do#top", ""));

			assertEquals("http://localhost/#bottom", URLUtility.get("http://localhost", "#bottom"));
			assertEquals("http://localhost/#bottom", URLUtility.get("http://localhost/", "#bottom"));
			assertEquals("http://localhost/index.do#bottom", URLUtility.get("http://localhost/index.do", "#bottom"));
			assertEquals("http://localhost/aaaa/#bottom", URLUtility.get("http://localhost/aaaa", "#bottom"));
			assertEquals("http://localhost/aaaa?aaa=bbb#bottom", URLUtility.get("http://localhost/aaaa?aaa=bbb", "#bottom"));
			assertEquals("http://localhost/aaaa/#bottom", URLUtility.get("http://localhost/aaaa/", "#bottom"));
			assertEquals("http://localhost/aaaa/index.do#bottom", URLUtility.get("http://localhost/aaaa/index.do", "#bottom"));
			assertEquals("http://localhost/aaaa/index.do?aaa=bbb#bottom", URLUtility.get("http://localhost/aaaa/index.do?aaa=bbb", "#bottom"));
			assertEquals("http://localhost/aaaa/index.do#bottom", URLUtility.get("http://localhost/aaaa/index.do#top", "#bottom"));

			assertEquals("http://localhost/test.do", URLUtility.get("http://localhost", "test.do"));
			assertEquals("http://localhost/test.do", URLUtility.get("http://localhost/", "test.do"));
			assertEquals("http://localhost/test.do", URLUtility.get("http://localhost/index.do", "test.do"));
			assertEquals("http://localhost/aaaa/test.do", URLUtility.get("http://localhost/aaaa", "test.do"));
			assertEquals("http://localhost/aaaa/test.do", URLUtility.get("http://localhost/aaaa/", "test.do"));
			assertEquals("http://localhost/aaaa/test.do", URLUtility.get("http://localhost/aaaa/index.do", "test.do"));
			assertEquals("http://localhost/aaaa/test.do", URLUtility.get("http://localhost/aaaa/index.do?aaa=bbb", "test.do"));
			assertEquals("http://localhost/aaaa/test.do", URLUtility.get("http://localhost/aaaa/index.do#top", "test.do"));

			assertNull(URLUtility.get("http://localhost", "./"));
			assertNull(URLUtility.get("http://localhost", "../"));
			assertNull(URLUtility.get("http://localhost", "./aaa"));
			assertNull(URLUtility.get("http://localhost", "../bbb"));

		} catch (Exception ex) {
			fail();
		}
	}
}

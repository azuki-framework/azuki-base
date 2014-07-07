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

import java.util.Calendar;

import junit.framework.TestCase;

import org.azkfw.util.DateUtility;
import org.junit.Test;

/**
 * このクラスは、{@link DateUtility}クラスのユニットテストを行うクラスです。
 * 
 * @since 1.0.0
 * @version 1.0.1 2014/06/06
 * @author Kawakicchi
 */
public class DateUtilityTest extends TestCase {

	@Test
	public void testGetDayOfAddDay() {
		Calendar dst = null;
		Calendar src = null;

		src = DateUtility.createCalendar(2007, 1, 1, 0, 0, 0);
		dst = DateUtility.getDayOfAddDay(src, 1);
		assertEquals(2007, dst.get(Calendar.YEAR));
		assertEquals(0, dst.get(Calendar.MONTH));
		assertEquals(2, dst.get(Calendar.DAY_OF_MONTH));

		dst = DateUtility.getDayOfAddDay(src, 10);
		assertEquals(2007, dst.get(Calendar.YEAR));
		assertEquals(0, dst.get(Calendar.MONTH));
		assertEquals(11, dst.get(Calendar.DAY_OF_MONTH));

		dst = DateUtility.getDayOfAddDay(src, -1);
		assertEquals(2006, dst.get(Calendar.YEAR));
		assertEquals(11, dst.get(Calendar.MONTH));
		assertEquals(31, dst.get(Calendar.DAY_OF_MONTH));

		src = DateUtility.createCalendar(2007, 2, 28, 0, 0, 0);
		dst = DateUtility.getDayOfAddDay(src, 1);
		assertEquals(2007, dst.get(Calendar.YEAR));
		assertEquals(2, dst.get(Calendar.MONTH));
		assertEquals(1, dst.get(Calendar.DAY_OF_MONTH));
	}

	@Test
	public void testGetLastDayOfMonth() {
		Calendar dst = null;
		Calendar src = null;

		src = DateUtility.createCalendar(2007, 1, 1, 0, 0, 0);
		dst = DateUtility.getLastDayOfMonth(src);
		assertEquals(2007, dst.get(Calendar.YEAR));
		assertEquals(0, dst.get(Calendar.MONTH));
		assertEquals(31, dst.get(Calendar.DAY_OF_MONTH));

		src = DateUtility.createCalendar(2007, 2, 1, 0, 0, 0);
		dst = DateUtility.getLastDayOfMonth(src);
		assertEquals(2007, dst.get(Calendar.YEAR));
		assertEquals(1, dst.get(Calendar.MONTH));
		assertEquals(28, dst.get(Calendar.DAY_OF_MONTH));

		src = DateUtility.createCalendar(2008, 2, 1, 0, 0, 0);
		dst = DateUtility.getLastDayOfMonth(src);
		assertEquals(2008, dst.get(Calendar.YEAR));
		assertEquals(1, dst.get(Calendar.MONTH));
		assertEquals(29, dst.get(Calendar.DAY_OF_MONTH));
	}

	@Test
	public void testGetDayOfPreviousMonth() {
		Calendar dst = null;
		Calendar src = null;

		src = DateUtility.createCalendar(2007, 1, 1, 0, 0, 0);
		dst = DateUtility.getDayOfPreviousMonth(src);
		assertEquals(2006, dst.get(Calendar.YEAR));
		assertEquals(11, dst.get(Calendar.MONTH));
		assertEquals(1, dst.get(Calendar.DAY_OF_MONTH));

		src = DateUtility.createCalendar(2007, 1, 31, 0, 0, 0);
		dst = DateUtility.getDayOfPreviousMonth(src);
		assertEquals(2006, dst.get(Calendar.YEAR));
		assertEquals(11, dst.get(Calendar.MONTH));
		assertEquals(1, dst.get(Calendar.DAY_OF_MONTH));

		src = DateUtility.createCalendar(2007, 2, 1, 0, 0, 0);
		dst = DateUtility.getDayOfPreviousMonth(src);
		assertEquals(2007, dst.get(Calendar.YEAR));
		assertEquals(0, dst.get(Calendar.MONTH));
		assertEquals(1, dst.get(Calendar.DAY_OF_MONTH));

		src = DateUtility.createCalendar(2007, 2, 28, 0, 0, 0);
		dst = DateUtility.getDayOfPreviousMonth(src);
		assertEquals(2007, dst.get(Calendar.YEAR));
		assertEquals(0, dst.get(Calendar.MONTH));
		assertEquals(1, dst.get(Calendar.DAY_OF_MONTH));
	}

	@Test
	public void testGetDayOfNextMonth() {
		Calendar dst = null;
		Calendar src = null;

		src = DateUtility.createCalendar(2007, 12, 1, 0, 0, 0);
		dst = DateUtility.getDayOfNextMonth(src);
		assertEquals(2008, dst.get(Calendar.YEAR));
		assertEquals(0, dst.get(Calendar.MONTH));
		assertEquals(1, dst.get(Calendar.DAY_OF_MONTH));

		src = DateUtility.createCalendar(2007, 12, 31, 0, 0, 0);
		dst = DateUtility.getDayOfNextMonth(src);
		assertEquals(2008, dst.get(Calendar.YEAR));
		assertEquals(0, dst.get(Calendar.MONTH));
		assertEquals(1, dst.get(Calendar.DAY_OF_MONTH));

		src = DateUtility.createCalendar(2007, 2, 1, 0, 0, 0);
		dst = DateUtility.getDayOfNextMonth(src);
		assertEquals(2007, dst.get(Calendar.YEAR));
		assertEquals(2, dst.get(Calendar.MONTH));
		assertEquals(1, dst.get(Calendar.DAY_OF_MONTH));

		src = DateUtility.createCalendar(2007, 2, 28, 0, 0, 0);
		dst = DateUtility.getDayOfNextMonth(src);
		assertEquals(2007, dst.get(Calendar.YEAR));
		assertEquals(2, dst.get(Calendar.MONTH));
		assertEquals(1, dst.get(Calendar.DAY_OF_MONTH));
	}
}

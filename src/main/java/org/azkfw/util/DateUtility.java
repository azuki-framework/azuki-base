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

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

/**
 * このクラスは、日付操作を行うユーティリティクラスです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2013/02/04
 * @author Kawakicchi
 */
public final class DateUtility {

	/**
	 * コンストラクタ
	 * <p>
	 * インスタンス生成を禁止する。
	 * </p>
	 */
	private DateUtility() {

	}

	/**
	 * 日付を作成する。
	 * 
	 * @param aYear 年
	 * @param aMonth 月(1-12)
	 * @param aDate 日
	 * @param aHour 時
	 * @param aMinute 分
	 * @param aSecond 秒
	 * @return 日付
	 */
	public static Date createDate(final int aYear, final int aMonth, final int aDate, final int aHour, final int aMinute, final int aSecond) {
		Calendar c = Calendar.getInstance();
		c.set(aYear, aMonth - 1, aDate, aHour, aMinute, aSecond);
		return c.getTime();
	}

	/**
	 * 日付を作成する。
	 * 
	 * @param aYear 年
	 * @param aMonth 月(1-12)
	 * @param aDate 日
	 * @param aHour 時
	 * @param aMinute 分
	 * @param aSecond 秒
	 * @return 日付
	 */
	public static Calendar createCalendar(final int aYear, final int aMonth, final int aDate, final int aHour, final int aMinute, final int aSecond) {
		Calendar c = Calendar.getInstance();
		c.set(aYear, aMonth - 1, aDate, aHour, aMinute, aSecond);
		return c;
	}

	/**
	 * 日付を作成する。
	 * 
	 * @param aYear 年
	 * @param aMonth 月(1-12)
	 * @param aDate 日
	 * @param aHour 時
	 * @param aMinute 分
	 * @param aSecond 秒
	 * @return 日付
	 */
	public static Timestamp createTimestamp(final int aYear, final int aMonth, final int aDate, final int aHour, final int aMinute, final int aSecond) {
		Calendar c = Calendar.getInstance();
		c.set(aYear, aMonth - 1, aDate, aHour, aMinute, aSecond);
		return new Timestamp(c.getTimeInMillis());
	}

	/**
	 * カレンダー型として取得する。
	 * 
	 * @param aDate 日付
	 * @return カレンダー型
	 */
	public static Calendar toCalender(final Date aDate) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(aDate.getTime());
		return c;
	}

	/**
	 * カレンダー型として取得する。
	 * 
	 * @param aDate 日付
	 * @return カレンダー型
	 */
	public static Calendar toCalender(final java.sql.Date aDate) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(aDate.getTime());
		return c;
	}

	/**
	 * タイムスタンプ型として取得する。
	 * 
	 * @param aDate 日付
	 * @return タイムスタンプ型
	 */
	public static Timestamp toTimestamp(final Date aDate) {
		Timestamp ts = new Timestamp(aDate.getTime());
		return ts;
	}

	/**
	 * タイムスタンプ型として取得する。
	 * 
	 * @param aDate 日付
	 * @return タイムスタンプ型
	 */
	public static Timestamp toTimestamp(final java.sql.Date aDate) {
		Timestamp ts = new Timestamp(aDate.getTime());
		return ts;
	}

	/**
	 * カレンダー型として取得する。
	 * 
	 * @param aTimestamp 日付
	 * @return カレンダー型
	 */
	public static Calendar toCalender(final Timestamp aTimestamp) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(aTimestamp.getTime());
		return c;
	}

	/**
	 * 対象日に日数を加算した日付を取得する。
	 * 
	 * @param aDate 対象日
	 * @param aDay 日数
	 * @return 日付
	 */
	public static Date getDayOfAddDay(final Date aDate, final int aDay) {
		Calendar src = Calendar.getInstance();
		src.setTime(aDate);
		Calendar dst = getDayOfAddDay(src, aDay);
		return dst.getTime();
	}

	/**
	 * 対象日に日数を加算した日付を取得する。
	 * 
	 * @param aCalendar 対象日
	 * @param aDay 日数
	 * @return 日付
	 */
	public static Calendar getDayOfAddDay(final Calendar aCalendar, final int aDay) {
		Calendar cln = Calendar.getInstance();
		cln.set(aCalendar.get(Calendar.YEAR), aCalendar.get(Calendar.MONTH), aCalendar.get(Calendar.DAY_OF_MONTH) + aDay,
				aCalendar.get(Calendar.HOUR_OF_DAY), aCalendar.get(Calendar.MINUTE), aCalendar.get(Calendar.SECOND));
		return cln;
	}

	/**
	 * 対象日の前月1日を取得する。
	 * 
	 * @param aDate 対象日
	 * @return 前月1日
	 */
	public static Date getDayOfPreviousMonth(final Date aDate) {
		Calendar src = Calendar.getInstance();
		src.setTime(aDate);
		Calendar dst = getDayOfPreviousMonth(src);
		return dst.getTime();
	}

	/**
	 * 対象日の前月1日を取得する。
	 * 
	 * @param aCalendar 対象日
	 * @return 前月1日
	 */
	public static Calendar getDayOfPreviousMonth(final Calendar aCalendar) {
		Calendar cln = Calendar.getInstance();
		cln.set(aCalendar.get(Calendar.YEAR), aCalendar.get(Calendar.MONTH) - 1, 1, 0, 0, 0);
		return cln;
	}

	/**
	 * 対象日の翌月１日を取得する。
	 * 
	 * @param aDate 対象日
	 * @return 翌月1日
	 */
	public static Date getDayOfNextMonth(final Date aDate) {
		Calendar src = Calendar.getInstance();
		src.setTime(aDate);
		Calendar dst = getDayOfNextMonth(src);
		return dst.getTime();
	}

	/**
	 * 対象日の翌月１日を取得する。
	 * 
	 * @param aCalendar 対象日
	 * @return 翌月1日
	 */
	public static Calendar getDayOfNextMonth(final Calendar aCalendar) {
		Calendar cln = Calendar.getInstance();
		cln.set(aCalendar.get(Calendar.YEAR), aCalendar.get(Calendar.MONTH) + 1, 1, 0, 0, 0);
		return cln;
	}

	/**
	 * 対象日の月の最終日を取得する。
	 * 
	 * @param aDate 対象日
	 * @return 最終日
	 */
	public static Date getLastDayOfMonth(final Date aDate) {
		Calendar src = Calendar.getInstance();
		src.setTime(aDate);
		Calendar dst = getLastDayOfMonth(src);
		return dst.getTime();
	}

	/**
	 * 対象日の月の最終日を取得する。
	 * 
	 * @param aCalendar 対象日
	 * @return 最終日
	 */
	public static Calendar getLastDayOfMonth(final Calendar aCalendar) {
		int lastDay = aCalendar.getActualMaximum(Calendar.DATE);
		Calendar cln = Calendar.getInstance();
		cln.set(aCalendar.get(Calendar.YEAR), aCalendar.get(Calendar.MONTH), lastDay, 0, 0, 0);
		return cln;
	}
}

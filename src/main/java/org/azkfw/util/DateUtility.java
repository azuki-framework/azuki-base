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
	 * @param year 年
	 * @param month 月(1-12)
	 * @param day 日
	 * @param hour 時
	 * @param minute 分
	 * @param second 秒
	 * @return 日付
	 */
	public static Date createDate(final int year, final int month, final int day, final int hour, final int minute, final int second) {
		return createCalendar(year, month, day, hour, minute, second).getTime();
	}

	/**
	 * 日付を作成する。
	 * 
	 * @param year 年
	 * @param month 月(1-12)
	 * @param day 日
	 * @param hour 時
	 * @param minute 分
	 * @param second 秒
	 * @return 日付
	 */
	public static Calendar createCalendar(final int year, final int month, final int day, final int hour, final int minute, final int second) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month - 1);
		c.set(Calendar.DAY_OF_MONTH, day);
		c.set(Calendar.HOUR_OF_DAY, hour);
		c.set(Calendar.MINUTE, minute);
		c.set(Calendar.SECOND, second);
		c.set(Calendar.MILLISECOND, 0);
		return c;
	}

	/**
	 * 日付を作成する。
	 * 
	 * @param year 年
	 * @param month 月(1-12)
	 * @param day 日
	 * @param hour 時
	 * @param minute 分
	 * @param second 秒
	 * @return 日付
	 */
	public static Timestamp createTimestamp(final int year, final int month, final int day, final int hour, final int minute, final int second) {
		return new Timestamp(createCalendar(year, month, day, hour, minute, second).getTimeInMillis());
	}

	/**
	 * カレンダー型として取得する。
	 * 
	 * @param date 日付
	 * @return カレンダー型
	 */
	public static Calendar toCalender(final Date date) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(date.getTime());
		return c;
	}

	/**
	 * カレンダー型として取得する。
	 * 
	 * @param date 日付
	 * @return カレンダー型
	 */
	public static Calendar toCalender(final java.sql.Date date) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(date.getTime());
		return c;
	}

	/**
	 * タイムスタンプ型として取得する。
	 * 
	 * @param date 日付
	 * @return タイムスタンプ型
	 */
	public static Timestamp toTimestamp(final Date date) {
		Timestamp ts = new Timestamp(date.getTime());
		return ts;
	}

	/**
	 * タイムスタンプ型として取得する。
	 * 
	 * @param date 日付
	 * @return タイムスタンプ型
	 */
	public static Timestamp toTimestamp(final java.sql.Date date) {
		Timestamp ts = new Timestamp(date.getTime());
		return ts;
	}

	/**
	 * カレンダー型として取得する。
	 * 
	 * @param timestamp 日付
	 * @return カレンダー型
	 */
	public static Calendar toCalender(final Timestamp timestamp) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(timestamp.getTime());
		return c;
	}

	/**
	 * 対象日に日数を加算した日付を取得する。
	 * 
	 * @param date 対象日
	 * @param day 日数
	 * @return 日付
	 */
	public static Date getDayOfAddDay(final Date date, final int day) {
		Calendar src = Calendar.getInstance();
		src.setTime(date);
		Calendar dst = getDayOfAddDay(src, day);
		return dst.getTime();
	}

	/**
	 * 対象日に日数を加算した日付を取得する。
	 * 
	 * @param calendar 対象日
	 * @param day 日数
	 * @return 日付
	 */
	public static Calendar getDayOfAddDay(final Calendar calendar, final int day) {
		Calendar cln = Calendar.getInstance();
		cln.setTimeInMillis(calendar.getTimeInMillis());
		cln.add(Calendar.DAY_OF_MONTH, day);
		return cln;
	}

	/**
	 * 対象日の前月1日を取得する。
	 * 
	 * @param date 対象日
	 * @return 前月1日
	 */
	public static Date getDayOfPreviousMonth(final Date date) {
		Calendar src = Calendar.getInstance();
		src.setTime(date);
		Calendar dst = getDayOfPreviousMonth(src);
		return dst.getTime();
	}

	/**
	 * 対象日の前月1日を取得する。
	 * 
	 * @param calendar 対象日
	 * @return 前月1日
	 */
	public static Calendar getDayOfPreviousMonth(final Calendar calendar) {
		Calendar cln = Calendar.getInstance();
		cln.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) - 1, 1, 0, 0, 0);
		return cln;
	}

	/**
	 * 対象日の翌月１日を取得する。
	 * 
	 * @param date 対象日
	 * @return 翌月1日
	 */
	public static Date getDayOfNextMonth(final Date date) {
		Calendar src = Calendar.getInstance();
		src.setTime(date);
		Calendar dst = getDayOfNextMonth(src);
		return dst.getTime();
	}

	/**
	 * 対象日の翌月１日を取得する。
	 * 
	 * @param calendar 対象日
	 * @return 翌月1日
	 */
	public static Calendar getDayOfNextMonth(final Calendar calendar) {
		Calendar cln = Calendar.getInstance();
		cln.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, 1, 0, 0, 0);
		return cln;
	}

	/**
	 * 対象日の月の最終日を取得する。
	 * 
	 * @param date 対象日
	 * @return 最終日
	 */
	public static Date getLastDayOfMonth(final Date date) {
		Calendar src = Calendar.getInstance();
		src.setTime(date);
		Calendar dst = getLastDayOfMonth(src);
		return dst.getTime();
	}

	/**
	 * 対象日の月の最終日を取得する。
	 * 
	 * @param calendar 対象日
	 * @return 最終日
	 */
	public static Calendar getLastDayOfMonth(final Calendar calendar) {
		int lastDay = calendar.getActualMaximum(Calendar.DATE);
		Calendar cln = Calendar.getInstance();
		cln.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), lastDay, 0, 0, 0);
		return cln;
	}
}

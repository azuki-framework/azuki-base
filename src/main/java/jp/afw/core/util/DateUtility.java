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
package jp.afw.core.util;

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
	 * @param aMonth 月
	 * @param aDate 日
	 * @param aHour 時
	 * @param aMinute 分
	 * @param aSecond 秒
	 * @return 日付
	 */
	public static Date createDate(final int aYear, final int aMonth, final int aDate, final int aHour, final int aMinute, final int aSecond) {
		Calendar c = Calendar.getInstance();
		c.set(aYear, aMonth, aDate, aHour, aMinute, aSecond);
		return c.getTime();
	}

	/**
	 * 日付を作成する。
	 * 
	 * @param aYear 年
	 * @param aMonth 月
	 * @param aDate 日
	 * @param aHour 時
	 * @param aMinute 分
	 * @param aSecond 秒
	 * @return 日付
	 */
	public static Timestamp createTimestamp(final int aYear, final int aMonth, final int aDate, final int aHour, final int aMinute, final int aSecond) {
		Calendar c = Calendar.getInstance();
		c.set(aYear, aMonth, aDate, aHour, aMinute, aSecond);
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
}

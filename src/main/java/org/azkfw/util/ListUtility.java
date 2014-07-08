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

import java.util.List;

/**
 * このクラスは、リスト操作を行うユーティリティクラスです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2013/03/01
 * @author Kawakicchi
 */
public final class ListUtility {

	/**
	 * コンストラクタ
	 * <p>
	 * インスタンス生成を禁止する。
	 * </p>
	 */
	private ListUtility() {

	}

	/**
	 * リストが、エンプティーか判断する。
	 * 
	 * @param aList リスト
	 * @return リストが<code>null</code>かエンプティの場合、<code>true</code>を返す。
	 */
	public static boolean isEmpty(final List<?> aList) {
		return !(isNotEmpty(aList));
	}

	/**
	 * リストが、エンプティーか判断する。
	 * 
	 * @param aList リスト
	 * @return リストが<code>null</code>かエンプティ以外の場合、<code>true</code>を返す。
	 */
	public static boolean isNotEmpty(final List<?> aList) {
		if (null != aList) {
			if (!aList.isEmpty()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * リスト内で最大の値を取得する。
	 * 
	 * @param aList リスト
	 * @param aDefalut リストが<code>null</code>かエンプティの場合に返却する。
	 * @return 最大値
	 */
	public static Double max(final List<Double> aList, final Double aDefalut) {
		Double max = aDefalut;
		if (null != aList) {
			for (Double value : aList) {
				if (null != value) {
					if (null == max) {
						max = value;
					} else {
						max = Math.max(max, value);
					}
				}
			}
		}
		return max;
	}

	/**
	 * リスト内で最大の値を取得する。
	 * 
	 * @param aList リスト
	 * @param aDefalut リストが<code>null</code>かエンプティの場合に返却する。
	 * @return 最大値
	 */
	public static Float max(final List<Float> aList, final Float aDefault) {
		Float max = aDefault;
		if (null != aList) {
			for (Float value : aList) {
				if (null != value) {
					if (null == max) {
						max = value;
					} else {
						max = Math.max(max, value);
					}
				}
			}
		}
		return max;
	}

	/**
	 * リスト内で最大の値を取得する。
	 * 
	 * @param aList リスト
	 * @param aDefalut リストが<code>null</code>かエンプティの場合に返却する。
	 * @return 最大値
	 */
	public static Integer max(final List<Integer> aList, final Integer aDefalut) {
		Integer max = aDefalut;
		if (null != aList) {
			for (Integer value : aList) {
				if (null != value) {
					if (null == max) {
						max = value;
					} else {
						max = Math.max(max, value);
					}
				}
			}
		}
		return max;
	}

	/**
	 * リスト内で最大の値を取得する。
	 * 
	 * @param aList リスト
	 * @param aDefalut リストが<code>null</code>かエンプティの場合に返却する。
	 * @return 最大値
	 */
	public static Long max(final List<Long> aList, final Long aDefault) {
		Long max = aDefault;
		if (null != aList) {
			for (Long value : aList) {
				if (null != value) {
					if (null == max) {
						max = value;
					} else {
						max = Math.max(max, value);
					}
				}
			}
		}
		return max;
	}

	/**
	 * リスト内で最小の値を取得する。
	 * 
	 * @param aList リスト
	 * @param aDefalut リストが<code>null</code>かエンプティの場合に返却する。
	 * @return 最小値
	 */
	public static Double min(final List<Double> aList, final Double aDefalut) {
		Double min = aDefalut;
		if (null != aList) {
			for (Double value : aList) {
				if (null != value) {
					if (null == min) {
						min = value;
					} else {
						min = Math.min(min, value);
					}
				}
			}
		}
		return min;
	}

	/**
	 * リスト内で最小の値を取得する。
	 * 
	 * @param aList リスト
	 * @param aDefalut リストが<code>null</code>かエンプティの場合に返却する。
	 * @return 最小値
	 */
	public static Float min(final List<Float> aList, final Float aDefault) {
		Float min = aDefault;
		if (null != aList) {
			for (Float value : aList) {
				if (null != value) {
					if (null == min) {
						min = value;
					} else {
						min = Math.min(min, value);
					}
				}
			}
		}
		return min;
	}

	/**
	 * リスト内で最小の値を取得する。
	 * 
	 * @param aList リスト
	 * @param aDefalut リストが<code>null</code>かエンプティの場合に返却する。
	 * @return 最小値
	 */
	public static Integer min(final List<Integer> aList, final Integer aDefalut) {
		Integer min = aDefalut;
		if (null != aList) {
			for (Integer value : aList) {
				if (null != value) {
					if (null == min) {
						min = value;
					} else {
						min = Math.min(min, value);
					}
				}
			}
		}
		return min;
	}

	/**
	 * リスト内で最小の値を取得する。
	 * 
	 * @param aList リスト
	 * @param aDefalut リストが<code>null</code>かエンプティの場合に返却する。
	 * @return 最小値
	 */
	public static Long min(final List<Long> aList, final Long aDefault) {
		Long min = aDefault;
		if (null != aList) {
			for (Long value : aList) {
				if (null != value) {
					if (null == min) {
						min = value;
					} else {
						min = Math.max(min, value);
					}
				}
			}
		}
		return min;
	}
}

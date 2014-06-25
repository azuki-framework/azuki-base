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
package org.azkfw.persistence.parameter;

import java.util.HashMap;
import java.util.Map;

/**
 * このインターフェースは、パラメータ情報を保持する機能を定義したインターフェースです。
 * 
 * @since 1.0.1
 * @version 1.0.1 2014/06/05
 * @author Kawakicchi
 */
public interface Parameter {

	/**
	 * このクラスは、パラメータ情報の作成を行うクラスです。
	 * 
	 * @since 1.0.1
	 * @version 1.0.1 2014/06/05
	 * @author Kawakicchi
	 */
	public static class Builder {

		/**
		 * コンストラクタ
		 * <p>
		 * インスタンス化を禁止する。
		 * </p>
		 */
		private Builder() {

		}

		/**
		 * パラメータ情報を作成する。
		 * 
		 * @return パラメータ情報
		 */
		public static Parameter build() {
			Parameter p;
			p = new MapParameter();
			return p;
		}

		/**
		 * パラメータ情報を作成する。
		 * 
		 * @param aMap マップ情報
		 * @return パラメータ情報
		 */
		public static Parameter build(final Map<String, Object> aMap) {
			Parameter p;
			p = new MapParameter(aMap);
			return p;
		}
	}

	/**
	 * パラメータを取得する。
	 * <p>
	 * 値が存在しない場合、<code>null</code>を返す。
	 * </p>
	 * 
	 * @param aKey キー
	 * @return 値
	 */
	public Object get(final String aKey);

	/**
	 * パラメータを取得する。
	 * <p>
	 * 値が存在しない、または<code>null</code>の場合、デフォルト値を返す。
	 * </p>
	 * 
	 * @param aKey キー
	 * @param aDefault デフォルト値
	 * @return 値
	 */
	public Object get(final String aKey, final Object aDefault);

	/**
	 * パラメータを取得する。
	 * <p>
	 * 値が存在しない場合、<code>null</code>を返す。
	 * </p>
	 * 
	 * @param aKey キー
	 * @return 値
	 */
	public String getString(final String aKey);

	/**
	 * パラメータを取得する。
	 * <p>
	 * 値が存在しない、または<code>null</code>の場合、デフォルト値を返す。
	 * </p>
	 * 
	 * @param aKey キー
	 * @param aDefault デフォルト値
	 * @return 値
	 */
	public String getString(final String aKey, final String aDefault);

	/**
	 * パラメータを取得する。
	 * <p>
	 * 値が存在しない場合、<code>null</code>を返す。
	 * </p>
	 * 
	 * @param aKey キー
	 * @return 値
	 */
	public Integer getInteger(final String aKey);

	/**
	 * パラメータを取得する。
	 * <p>
	 * 値が存在しない、または<code>null</code>の場合、デフォルト値を返す。
	 * </p>
	 * 
	 * @param aKey キー
	 * @param aDefault デフォルト値
	 * @return 値
	 */
	public Integer getInteger(final String aKey, final Integer aDefault);

	/**
	 * パラメータを取得する。
	 * <p>
	 * 値が存在しない場合、<code>null</code>を返す。
	 * </p>
	 * 
	 * @param aKey キー
	 * @return 値
	 */
	public Long getLong(final String aKey);

	/**
	 * パラメータを取得する。
	 * <p>
	 * 値が存在しない、または<code>null</code>の場合、デフォルト値を返す。
	 * </p>
	 * 
	 * @param aKey キー
	 * @param aDefault デフォルト値
	 * @return 値
	 */
	public Long getLong(final String aKey, final Long aDefault);

	/**
	 * パラメータを取得する。
	 * <p>
	 * 値が存在しない場合、<code>null</code>を返す。
	 * </p>
	 * 
	 * @param aKey キー
	 * @return 値
	 */
	public Double getDouble(final String aKey);

	/**
	 * パラメータを取得する。
	 * <p>
	 * 値が存在しない、または<code>null</code>の場合、デフォルト値を返す。
	 * </p>
	 * 
	 * @param aKey キー
	 * @param aDefault デフォルト値
	 * @return 値
	 */
	public Double getDouble(final String aKey, final Double aDefault);

	/**
	 * パラメータを取得する。
	 * <p>
	 * 値が存在しない場合、<code>null</code>を返す。
	 * </p>
	 * 
	 * @param aKey キー
	 * @return 値
	 */
	public Boolean getBoolean(final String aKey);

	/**
	 * パラメータを取得する。
	 * <p>
	 * 値が存在しない、または<code>null</code>の場合、デフォルト値を返す。
	 * </p>
	 * 
	 * @param aKey キー
	 * @param aDefault デフォルト値
	 * @return 値
	 */
	public Boolean getBoolean(final String aKey, final Boolean aDefault);

	/**
	 * このクラスは、マップ形式のパラメータ情報を保持するクラスです。
	 * 
	 * @since 1.0.1
	 * @version 1.0.1 2014/06/05
	 * @author Kawakicchi
	 */
	public final static class MapParameter implements Parameter {

		/**
		 * parameter
		 */
		private Map<String, Object> parameter;

		/**
		 * コンストラクタ
		 */
		private MapParameter() {
			parameter = new HashMap<String, Object>();
		}

		/**
		 * コンストラクタ
		 * 
		 * @param aMap マップ情報
		 */
		private MapParameter(final Map<String, Object> aMap) {
			parameter = new HashMap<String, Object>(aMap);
		}

		@Override
		public Object get(final String aKey) {
			return get(aKey, null);
		}

		@Override
		public Object get(final String aKey, final Object aDefault) {
			Object value = aDefault;
			if (parameter.containsKey(aKey)) {
				if (null != parameter.get(aKey)) {
					value = parameter.get(aKey);
				}
			}
			return value;
		}

		@Override
		public String getString(final String aKey) {
			return getString(aKey, null);
		}

		@Override
		public String getString(final String aKey, final String aDefault) {
			String value = aDefault;
			if (parameter.containsKey(aKey)) {
				if (null != parameter.get(aKey)) {
					value = parameter.get(aKey).toString();
				}
			}
			return value;
		}

		@Override
		public Integer getInteger(final String aKey) {
			return getInteger(aKey, null);
		}

		@Override
		public Integer getInteger(final String aKey, final Integer aDefault) {
			Integer value = aDefault;
			if (parameter.containsKey(aKey)) {
				Object o = parameter.get(aKey);
				if (null != o) {
					if (o instanceof Integer) {
						value = (Integer) o;
					} else if (o instanceof String) {
						value = Integer.parseInt((String) o);
					}
				}
			}
			return value;
		}

		@Override
		public Long getLong(final String aKey) {
			return getLong(aKey, null);
		}

		@Override
		public Long getLong(final String aKey, final Long aDefault) {
			Long value = aDefault;
			if (parameter.containsKey(aKey)) {
				Object o = parameter.get(aKey);
				if (null != o) {
					if (o instanceof Long) {
						value = (Long) o;
					} else if (o instanceof String) {
						value = Long.parseLong((String) o);
					}
				}
			}
			return value;
		}

		@Override
		public Double getDouble(final String aKey) {
			return getDouble(aKey, null);
		}

		@Override
		public Double getDouble(final String aKey, final Double aDefault) {
			Double value = aDefault;
			if (parameter.containsKey(aKey)) {
				Object o = parameter.get(aKey);
				if (null != o) {
					if (o instanceof Double) {
						value = (Double) o;
					} else if (o instanceof Float) {
						value = ((Float) o).doubleValue();
					} else if (o instanceof String) {
						value = Double.parseDouble((String) o);
					}
				}
			}
			return value;
		}

		@Override
		public Boolean getBoolean(final String aKey) {
			return getBoolean(aKey, null);
		}

		@Override
		public Boolean getBoolean(final String aKey, final Boolean aDefault) {
			Boolean value = aDefault;
			if (parameter.containsKey(aKey)) {
				Object o = parameter.get(aKey);
				if (null != o) {
					if (o instanceof Boolean) {
						value = (Boolean) o;
					} else if (o instanceof String) {
						if ("on".equals(((String) o).toLowerCase())) {
							value = Boolean.TRUE;
						} else {
							value = Boolean.parseBoolean((String) o);
						}
					}
				}
			}
			return value;
		}
	}
}

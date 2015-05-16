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
package org.azkfw.parameter;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

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
			Parameter p = new MapParameter();
			return p;
		}

		/**
		 * パラメータ情報を作成する。
		 * 
		 * @param map マップ情報
		 * @return パラメータ情報
		 */
		public static Parameter build(final Map<String, Object> map) {
			Parameter p = new MapParameter(map);
			return p;
		}

		/**
		 * パラメータ情報を作成する。
		 * 
		 * @param properties プロパティ情報
		 * @return パラメータ情報
		 */
		public static Parameter build(final Properties properties) {
			Map<String, Object> map = new HashMap<String, Object>();
			for (Object key : properties.keySet()) {
				String name = key.toString();
				map.put(name, properties.getProperty(name));
			}
			return build(map);
		}
	}

	/**
	 * パラメータを取得する。
	 * <p>
	 * 値が存在しない場合、<code>null</code>を返す。
	 * </p>
	 * 
	 * @param key キー
	 * @return 値
	 */
	public Object get(final String key);

	/**
	 * パラメータを取得する。
	 * <p>
	 * 値が存在しない、または<code>null</code>の場合、デフォルト値を返す。
	 * </p>
	 * 
	 * @param key キー
	 * @param def デフォルト値
	 * @return 値
	 */
	public Object get(final String key, final Object def);

	/**
	 * パラメータを取得する。
	 * <p>
	 * 値が存在しない場合、<code>null</code>を返す。
	 * </p>
	 * 
	 * @param key キー
	 * @return 値
	 */
	public String getString(final String key);

	/**
	 * パラメータを取得する。
	 * <p>
	 * 値が存在しない、または<code>null</code>の場合、デフォルト値を返す。
	 * </p>
	 * 
	 * @param key キー
	 * @param def デフォルト値
	 * @return 値
	 */
	public String getString(final String key, final String def);

	/**
	 * パラメータを取得する。
	 * <p>
	 * 値が存在しない場合、<code>null</code>を返す。
	 * </p>
	 * 
	 * @param key キー
	 * @return 値
	 */
	public Integer getInteger(final String key);

	/**
	 * パラメータを取得する。
	 * <p>
	 * 値が存在しない、または<code>null</code>の場合、デフォルト値を返す。
	 * </p>
	 * 
	 * @param key キー
	 * @param def デフォルト値
	 * @return 値
	 */
	public Integer getInteger(final String key, final Integer def);

	/**
	 * パラメータを取得する。
	 * <p>
	 * 値が存在しない場合、<code>null</code>を返す。
	 * </p>
	 * 
	 * @param key キー
	 * @return 値
	 */
	public Long getLong(final String key);

	/**
	 * パラメータを取得する。
	 * <p>
	 * 値が存在しない、または<code>null</code>の場合、デフォルト値を返す。
	 * </p>
	 * 
	 * @param key キー
	 * @param def デフォルト値
	 * @return 値
	 */
	public Long getLong(final String key, final Long def);

	/**
	 * プロパティを取得する。
	 * <p>
	 * 値が存在しない場合、<code>null</code>を返す。
	 * </p>
	 * 
	 * @param key キー
	 * @return 値
	 */
	public Float getFloat(final String key);

	/**
	 * プロパティを取得する。
	 * <p>
	 * 値が存在しない、または<code>null</code>の場合、デフォルト値を返す。
	 * </p>
	 * 
	 * @param key キー
	 * @param def デフォルト値
	 * @return 値
	 */
	public Float getFloat(final String key, final Float def);

	/**
	 * パラメータを取得する。
	 * <p>
	 * 値が存在しない場合、<code>null</code>を返す。
	 * </p>
	 * 
	 * @param key キー
	 * @return 値
	 */
	public Double getDouble(final String key);

	/**
	 * パラメータを取得する。
	 * <p>
	 * 値が存在しない、または<code>null</code>の場合、デフォルト値を返す。
	 * </p>
	 * 
	 * @param key キー
	 * @param def デフォルト値
	 * @return 値
	 */
	public Double getDouble(final String key, final Double def);

	/**
	 * パラメータを取得する。
	 * <p>
	 * 値が存在しない場合、<code>null</code>を返す。
	 * </p>
	 * 
	 * @param key キー
	 * @return 値
	 */
	public Boolean getBoolean(final String key);

	/**
	 * パラメータを取得する。
	 * <p>
	 * 値が存在しない、または<code>null</code>の場合、デフォルト値を返す。
	 * </p>
	 * 
	 * @param key キー
	 * @param def デフォルト値
	 * @return 値
	 */
	public Boolean getBoolean(final String key, final Boolean def);

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
		 * @param map マップ情報
		 */
		private MapParameter(final Map<String, Object> map) {
			parameter = new HashMap<String, Object>(map);
		}

		@Override
		public Object get(final String key) {
			return get(key, null);
		}

		@Override
		public Object get(final String key, final Object def) {
			Object value = def;
			if (parameter.containsKey(key)) {
				if (null != parameter.get(key)) {
					value = parameter.get(key);
				}
			}
			return value;
		}

		@Override
		public String getString(final String key) {
			return getString(key, null);
		}

		@Override
		public String getString(final String key, final String def) {
			String value = def;
			if (parameter.containsKey(key)) {
				if (null != parameter.get(key)) {
					value = parameter.get(key).toString();
				}
			}
			return value;
		}

		@Override
		public Integer getInteger(final String key) {
			return getInteger(key, null);
		}

		@Override
		public Integer getInteger(final String key, final Integer def) {
			Integer value = def;
			if (parameter.containsKey(key)) {
				Object o = parameter.get(key);
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
		public Long getLong(final String key) {
			return getLong(key, null);
		}

		@Override
		public Long getLong(final String key, final Long def) {
			Long value = def;
			if (parameter.containsKey(key)) {
				Object o = parameter.get(key);
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
		public Float getFloat(final String key) {
			return getFloat(key, null);
		}

		@Override
		public Float getFloat(final String key, final Float def) {
			Float value = def;
			if (parameter.containsKey(key)) {
				Object o = parameter.get(key);
				if (null != o) {
					if (o instanceof Float) {
						value = (Float) o;
					} else if (o instanceof Double) {
						value = ((Double) o).floatValue();
					} else if (o instanceof String) {
						value = Float.parseFloat((String) o);
					}
				}
			}
			return value;
		}

		@Override
		public Double getDouble(final String key) {
			return getDouble(key, null);
		}

		@Override
		public Double getDouble(final String key, final Double def) {
			Double value = def;
			if (parameter.containsKey(key)) {
				Object o = parameter.get(key);
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
		public Boolean getBoolean(final String key) {
			return getBoolean(key, null);
		}

		@Override
		public Boolean getBoolean(final String key, final Boolean def) {
			Boolean value = def;
			if (parameter.containsKey(key)) {
				Object o = parameter.get(key);
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

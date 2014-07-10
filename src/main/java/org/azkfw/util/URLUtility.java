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

import java.net.MalformedURLException;
import java.net.URL;

/**
 * このクラスは、URL操作を行うユーティリティクラスです。
 * 
 * @since 1.0.1
 * @version 1.0.1 2014/06/05
 * @author Kawakicchi
 */
public class URLUtility {

	/**
	 * コンストラクタ
	 * <p>
	 * インスタンス生成を禁止する。
	 * </p>
	 */
	private URLUtility() {

	}

	public static URL toURL(final String aProtocol, final String aHost, final String aAreas) throws MalformedURLException {
		return toURL(aProtocol, aHost, null, aAreas);
	}

	public static URL toURL(final String aProtocol, final String aHost, final Integer aPort, final String aAreas) throws MalformedURLException {
		StringBuilder s = new StringBuilder();
		s.append(aProtocol);
		s.append("://");
		s.append(aHost);
		if (null != aPort) {
			if ("http".equals(aProtocol) && 80 == aPort) {
				// 省略
			} else {
				s.append(":");
				s.append(aPort);
			}
		}
		if (StringUtility.isNotEmpty(aAreas)) {
			if (!aAreas.startsWith("/")) {
				s.append("/");
			}
			s.append(aAreas);
		} else {
			s.append("/");
		}
		return new URL(s.toString());
	}

	public static String get(final String aBaseURL, final String aTargetURL) throws MalformedURLException {
		URL base = new URL(aBaseURL);
		URL url = get(base, aTargetURL);
		if (null != url) {
			return url.toExternalForm();
		} else {
			return null;
		}
	}

	public static URL get(final URL aBaseURL, final String aTargetURL) throws MalformedURLException {
		URL url = null;

		String host = aBaseURL.getProtocol() + "://" + aBaseURL.getHost() + ((-1 != aBaseURL.getPort()) ? ":" + aBaseURL.getPort() : "");
		String file = aBaseURL.getFile();
		String path = aBaseURL.getPath();
		String query = aBaseURL.getQuery();

		if (-1 != aTargetURL.indexOf("./")) { // 
			// TODO: 未対応		

		} else if (-1 != aTargetURL.indexOf("://")) { // 別ホストへ移動
			url = new URL(aTargetURL);

		} else if (0 == aTargetURL.length()) { // 同じ場所 -> #があればどける
			url = new URL(host + file);

		} else if (aTargetURL.startsWith("#")) { // 表示位置移動 -> #があれば切り替え
			if (-1 == path.indexOf(".")) { // directory
				if (file.endsWith("/") || StringUtility.isNotEmpty(query)) {
					url = new URL(host + file + aTargetURL);
				} else {
					url = new URL(host + file + "/" + aTargetURL);
				}
			} else { // file
				url = new URL(host + file + aTargetURL);
			}

		} else if (aTargetURL.startsWith("/")) { // ホストまで戻る
			url = new URL(host + aTargetURL);

		} else {
			if (0 == file.length()) {
				url = new URL(host + "/" + aTargetURL);

			} else if (file.endsWith("/")) {
				url = new URL(host + file + aTargetURL);

			} else if (-1 == path.indexOf(".")) {
				url = new URL(host + path + "/" + aTargetURL);

			} else {
				int index = path.lastIndexOf("/");
				if (-1 == index) {
					url = new URL(host + "/" + aTargetURL);

				} else {
					url = new URL(host + path.substring(0, index + 1) + aTargetURL);

				}
			}
		}

		return url;
	}
}

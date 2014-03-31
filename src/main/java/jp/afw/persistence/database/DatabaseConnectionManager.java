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
package jp.afw.persistence.database;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import jp.afw.business.manager.AbstractManager;
import jp.afw.core.util.StringUtility;
import jp.afw.persistence.PersistenceServiceException;

/**
 * このクラスは、データベースの管理を行うマネージャークラスです。
 * 
 * @since 1.0.0
 * @version 1.0.0 12/06/09
 * @author Kawakicchi
 * 
 */
public final class DatabaseConnectionManager extends AbstractManager {

	/**
	 * Instance
	 */
	private static final DatabaseConnectionManager INSTANCE = new DatabaseConnectionManager();

	/**
	 * Connection map
	 */
	private final Map<String, DatabaseSource> connections = new HashMap<String, DatabaseSource>();

	/**
	 * コンストラクタ
	 */
	private DatabaseConnectionManager() {
		super(DatabaseConnectionManager.class);
	}

	/**
	 * 初期化処理を行う。
	 */
	public static void initialize() {

	}

	/**
	 * 解放処理を行う。
	 */
	public static void destroy() {

	}

	public static void load(final String uri, final String driver, final String user, final String password) throws PersistenceServiceException,
			ClassNotFoundException {
		load(StringUtility.EMPTY, driver, uri, user, password);
	}

	public static void load(final Properties p) throws PersistenceServiceException, ClassNotFoundException {
		load(StringUtility.EMPTY, p);
	}

	public static void load(final String name, final String driver, final String uri, final String user, final String password)
			throws PersistenceServiceException, ClassNotFoundException {
		INSTANCE.doLoad(name, driver, uri, user, password);
	}

	public static void load(final String name, final Properties p) throws PersistenceServiceException, ClassNotFoundException {
		INSTANCE.doLoad(name, p);
	}

	public static DatabaseSource getSource() throws SQLException {
		return getSource(StringUtility.EMPTY);
	}

	public static DatabaseSource getSource(final String name) throws SQLException {
		return INSTANCE.doGetSource(name);
	}

	private void doLoad(final String name, final Properties p) throws PersistenceServiceException, ClassNotFoundException {
		if (connections.containsKey(name)) {
			throw new PersistenceServiceException("Duplicate database connection name.[" + name + "]");
		}

		DatabaseSource connection = new DatabaseSource();
		connection.load(p);

		connections.put(name, connection);
	}

	private void doLoad(final String name, final String driver, final String uri, final String user, final String password)
			throws PersistenceServiceException, ClassNotFoundException {
		if (connections.containsKey(name)) {
			throw new PersistenceServiceException("Duplicate database connection name.[" + name + "]");
		}

		DatabaseSource connection = new DatabaseSource();
		connection.load(driver, uri, user, password);

		connections.put(name, connection);
	}

	private DatabaseSource doGetSource(final String name) throws SQLException {
		DatabaseSource connection = null;
		if (connections.containsKey(name)) {
			connection = connections.get(name);
		}
		return connection;
	}

}

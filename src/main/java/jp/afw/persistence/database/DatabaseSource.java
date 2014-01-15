package jp.afw.persistence.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import jp.afw.persistence.database.entity.DatabaseConnectionEntity;

import org.apache.commons.pool.BasePoolableObjectFactory;
import org.apache.commons.pool.ObjectPool;
import org.apache.commons.pool.PoolableObjectFactory;
import org.apache.commons.pool.impl.StackObjectPool;

/**
 * このクラスは、データベース接続機能を実装するクラスです。
 * 
 * @since 1.0.0
 * @version 1.0.0 12/06/09
 * @author Kawakicchi
 * 
 */
public final class DatabaseSource {

	public class SimpleConnectionFactory extends BasePoolableObjectFactory<Connection> {
		private String url;
		private String user;
		private String password;

		/**
		 * このクラスのインスタンスを生成します。
		 * 
		 * @param aUrl データベース接続のためのURL。
		 * @param aUser データベース接続のためのユーザ名。
		 * @param aPassword データベース接続のためのパスワード。
		 */
		public SimpleConnectionFactory(final String aUrl, final String aUser, final String aPassword) {
			url = aUrl;
			user = aUser;
			password = aPassword;
		}

		/**
		 * java.sql.Connectionオブジェクトを生成します。
		 * 
		 * @return 生成したオブジェクト。
		 */
		public Connection makeObject() throws Exception {
			return DriverManager.getConnection(url, user, password);
		}
	}

	/**
	 * Connection entity
	 */
	private DatabaseConnectionEntity entity;

	private ObjectPool<Connection> pool;

	/**
	 * コンストラクタ
	 */
	public DatabaseSource() {
		;
	}

	/**
	 * データベース接続設定をロードします。
	 * 
	 * @param driver ドライバ名
	 * @param uri 接続情報
	 * @param user ユーザ名
	 * @param password パスワード
	 * @throws ClassNotFoundException データベース接続ドライバが見つからない場合
	 */
	public void load(final String driver, final String uri, final String user, final String password) throws ClassNotFoundException {
		DatabaseConnectionEntity e = new DatabaseConnectionEntity();
		e.setDriver(driver);
		e.setUri(uri);
		e.setUser(user);
		e.setPassword(password);
		load(e);
	}

	/**
	 * データベース接続設定をロードします。
	 * 
	 * @param p 接続設定プロパティ
	 * @throws ClassNotFoundException データベース接続ドライバが見つからない場合
	 */
	public void load(final Properties p) throws ClassNotFoundException {
		DatabaseConnectionEntity e = new DatabaseConnectionEntity();
		e.setDriver(p.getProperty("database.dirver"));
		e.setUri(p.getProperty("database.uri"));
		e.setUser(p.getProperty("database.user"));
		e.setPassword(p.getProperty("database.password"));
		load(e);
	}

	/**
	 * データベース接続設定をロードします。
	 * 
	 * @param aEntity 接続設定
	 * @throws ClassNotFoundException データベース接続ドライバが見つからない場合
	 */
	private void load(final DatabaseConnectionEntity aEntity) throws ClassNotFoundException {
		entity = aEntity;
		pooling();
	}

	/**
	 * データベース接続をプールします。
	 * 
	 * @throws ClassNotFoundException データベース接続ドライバが見つからない場合
	 */
	private void pooling() throws ClassNotFoundException {
		Class.forName(entity.getDriver());

		PoolableObjectFactory<Connection> factory = new SimpleConnectionFactory(entity.getUri(), entity.getUser(), entity.getPassword());
		pool = new StackObjectPool<Connection>(factory);
	}

	/**
	 * コネクションを取得します。
	 * 
	 * @return コネクション
	 * @throws SQLException SQL例外が発生した場合
	 */
	public DatabaseConnection getConnection() throws SQLException {
		return getConnection(true);
	}

	/**
	 * コネクションを取得します。
	 * 
	 * @param aPool プールフラグ
	 * @return コネクション
	 * @throws SQLException SQL例外が発生した場合
	 */
	public DatabaseConnection getConnection(final boolean aPool) throws SQLException {
		Connection con = null;
		try {
			if (aPool) {
				con = pool.borrowObject();
			} else {
				con = DriverManager.getConnection(entity.getUri(), entity.getUser(), entity.getPassword());
			}
		} catch (Exception ex) {
			throw new SQLException(ex);
		}
		return new DatabaseConnection(con);
	}

	/**
	 * コネクションを返却します。
	 * 
	 * @param connection コネクション
	 * @throws SQLException SQL例外が発生した場合
	 */
	public void returnConnection(final DatabaseConnection connection) throws SQLException {
		returnConnection(connection, true);
	}

	/**
	 * コネクションを返却します。
	 * 
	 * @param connection コネクション
	 * @param pool プールフラグ
	 * @throws SQLException SQL例外が発生した場合
	 */
	public void returnConnection(final DatabaseConnection connection, final boolean aPool) throws SQLException {
		Connection con = connection.getConnection();
		try {
			if (null != con) {
				if (aPool) {
					pool.returnObject(con);
				} else {
					con.close();
				}
			}
		} catch (Exception ex) {
			throw new SQLException(ex);
		}
	}
}

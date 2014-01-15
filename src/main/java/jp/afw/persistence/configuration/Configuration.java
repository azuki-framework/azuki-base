package jp.afw.persistence.configuration;import java.io.InputStream;/** * このインターフェースは、コンフィグレーション機能を表現するインターフェースです。 *  * @since 1.0.0 * @version 1.0.0 2013/07/19 * @author Kawakicchi */public interface Configuration {	/**	 * 入力ストリームを取得する。	 * 	 * @return 入力ストリーム	 */	public InputStream getResourceAsStream();}
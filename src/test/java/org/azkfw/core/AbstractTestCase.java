package org.azkfw.core;

import java.io.File;
import java.io.InputStream;

import junit.framework.TestCase;

import org.azkfw.util.PathUtility;

public abstract class AbstractTestCase extends TestCase {

	/** リソースディレクトリ */
	private File resourcesDirectory;

	/**
	 * コンストラクタ
	 */
	public AbstractTestCase() {
		resourcesDirectory = new File(PathUtility.replaseEnvSeparator("./src/test/resources"));
	}

	/**
	 * コンストラクタ
	 * 
	 * @param aResourcesDirectory リソースディレクトリ
	 */
	public AbstractTestCase(final File aResourcesDirectory) {
		resourcesDirectory = aResourcesDirectory;
	}

	/**
	 * コンストラクタ
	 * 
	 * @param aResourcesDirectory リソースディレクトリ
	 */
	public AbstractTestCase(final String aResourcesDirectory) {
		resourcesDirectory = new File(aResourcesDirectory);
	}

	/**
	 * リソース内のパスを取得する。
	 * 
	 * @param aName 名前
	 * @return パス
	 */
	protected final String getResourceAsPath(final String aName) {
		String path = PathUtility.cat(resourcesDirectory.getAbsolutePath(), aName);
		return path;
	}

	/**
	 * リソースのファイルを取得する。
	 * 
	 * @param aName 名前
	 * @return ファイル
	 */
	protected final File getResourceAsFile(final String aName) {
		String path = PathUtility.cat(resourcesDirectory.getAbsolutePath(), aName);
		return new File(path);
	}

	/**
	 * リソースのストリームを取得する。
	 * 
	 * @param aName 名前
	 * @return ストリーム
	 */
	protected final InputStream getResourceAsStream(final String aName) {
		String path = PathUtility.cat(resourcesDirectory.getAbsolutePath(), aName);
		return getClass().getResourceAsStream(path);
	}
}

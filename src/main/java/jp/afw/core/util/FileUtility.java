package jp.afw.core.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * このクラスは、ファイル操作をまとめたユーティリティクラスです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2013/06/26
 * @author Kawakicchi
 */
public final class FileUtility {

	/**
	 * コンストラクタ
	 * <p>
	 * インスタンス生成を禁止する。
	 * </p>
	 */
	private FileUtility() {

	}

	/**
	 * ファイルをコピーする。
	 * <p>
	 * コピー処理には
	 * {@link FileChannel#transferTo(long, long, java.nio.channels.WritableByteChannel)}
	 * メソッドを利用します。
	 * </p>
	 * 
	 * @param aSrcPath コピー元のパス
	 * @param aDestPath コピー先のパス
	 * @throws IOException 何らかの入出力処理例外が発生した場合
	 */
	public static void copy(final String aSrcPath, final String aDestPath) throws IOException {
		copy(new File(aSrcPath), new File(aDestPath));
	}

	/**
	 * ファイルをコピーする。
	 * <p>
	 * コピー処理には
	 * {@link FileChannel#transferTo(long, long, java.nio.channels.WritableByteChannel)}
	 * メソッドを利用します。
	 * </p>
	 * 
	 * @param aSrcFile コピー元のファイル
	 * @param aDestFile コピー先のファイル
	 * @throws IOException 何らかの入出力処理例外が発生した場合
	 */
	public static void copy(final File aSrcFile, final File aDestFile) throws IOException {
		if (aSrcFile.isDirectory()) {
			aDestFile.mkdirs();
			File[] files = aSrcFile.listFiles();
			for (File file : files) {
				String srcFile = aSrcFile.getAbsolutePath() + "\\" + file.getName();
				String destFile = aDestFile.getAbsolutePath() + "\\" + file.getName();
				copy(new File(srcFile), new File(destFile));
			}
		} else if (aSrcFile.isFile()) {
			FileChannel srcChannel = null;
			FileChannel destChannel = null;
			try {
				srcChannel = new FileInputStream(aSrcFile).getChannel();
				destChannel = new FileOutputStream(aDestFile).getChannel();
				srcChannel.transferTo(0, srcChannel.size(), destChannel);
			} finally {
				if (null != srcChannel) {
					srcChannel.close();
				}
				if (null != destChannel) {
					destChannel.close();
				}
			}
		}
	}

	/**
	 * ファイル/ディレクトリを削除する。
	 * <p>
	 * このメソッドは、対象配下を再帰的に削除します。
	 * </p>
	 * 
	 * @param aRoot 削除対象
	 */
	public static void remove(final String aRoot) {
		remove(new File(aRoot));
	}

	/**
	 * ファイル/ディレクトリを削除する。
	 * <p>
	 * このメソッドは、対象配下を再帰的に削除します。
	 * </p>
	 * 
	 * @param aRoot 削除対象
	 */
	public static void remove(final File aRoot) {
		if (aRoot == null || !aRoot.exists()) {
			return;
		}
		if (aRoot.isFile()) {
			if (aRoot.exists() && !aRoot.delete()) {
				aRoot.deleteOnExit();
			}
		} else {
			File[] list = aRoot.listFiles();
			for (int i = 0; i < list.length; i++) {
				remove(list[i]);
			}
			if (aRoot.exists() && !aRoot.delete()) {
				aRoot.deleteOnExit();
			}
		}
	}

	/**
	 * 指定されたディレクトリ配下のファイルを再帰的に取得する。
	 * 
	 * @param aDirectory ディレクトリ
	 * @return ファイル群
	 */
	public static final List<File> listFiles(final String aDirectory) {
		return listFiles(aDirectory, (Pattern) null);
	}

	/**
	 * 指定されたディレクトリ配下のファイルを再帰的にパターンにマッチするもののみ取得する。
	 * 
	 * @param aDirectory ディレクトリ
	 * @param aPattern パターン
	 * @return ファイル群
	 */
	public static final List<File> listFiles(final String aDirectory, final String aPattern) {
		return listFiles(aDirectory, Pattern.compile(aPattern));
	}

	/**
	 * 指定されたディレクトリ配下のファイルを再帰的にパターンにマッチするもののみ取得する。
	 * 
	 * @param aDirectory ディレクトリ
	 * @param aPattern パターン
	 * @return ファイル群
	 */
	public static final List<File> listFiles(final String aDirectory, final Pattern aPattern) {
		List<File> files = new ArrayList<File>();
		File dir = new File(aDirectory);
		readDir(aDirectory, dir, aPattern, files);
		return files;
	}

	private static void readDir(final String aTargetBaseDir, final File aDir, final Pattern aPattern, final List<File> aFiles) {
		File[] files = aDir.listFiles();
		if (files == null) {
			return;
		}
		for (File file : files) {
			if (!file.exists()) {
				continue;
			} else if (file.isDirectory()) {
				readDir(aTargetBaseDir, file, aPattern, aFiles);
			} else if (file.isFile())
				readFile(aTargetBaseDir, file, aPattern, aFiles);
		}
	}

	private static void readFile(final String aTargetBaseDir, final File aFile, final Pattern aPattern, final List<File> aFiles) {
		String path = aFile.getAbsolutePath();
		path = path.substring(aTargetBaseDir.length());
		if (null == aPattern || aPattern.matcher(path).matches()) {
			aFiles.add(aFile);
		}
	}
}

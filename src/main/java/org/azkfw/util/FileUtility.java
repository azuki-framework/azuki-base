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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * このクラスは、ファイル操作をまとめたユーティリティクラスです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2013/06/26
 * @author Kawakicchi
 */
public final class FileUtility {

	public enum SortMode {
		// 列挙子の定義は、コンストラクターに合わせた引数を持たせる。
		String(0), Integer(1);

		private int value;

		private SortMode(int n) {
			this.value = n;
		}

		public int getValue() {
			return this.value;
		}
	}

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
	 * ファイルリストをファイルパスがパターンで同一のものでグルーピングする。
	 * <p>
	 * <ul>
	 * <li>同一ディレクトリ - "^(.*)[0-9]{3}\.csv$"</li>
	 * </ul>
	 * </p>
	 * 
	 * @param aFiles ファイル一覧
	 * @param aPattern パターン
	 * @return
	 */
	public static final Map<String, List<File>> groupFiles(final List<File> aFiles, final Pattern aPattern) {
		Map<String, List<File>> groups = new HashMap<String, List<File>>();
		for (File file : aFiles) {
			String path = file.getAbsolutePath();
			String key = extractMatchString(path, aPattern);

			List<File> fs = null;
			if (groups.containsKey(key)) {
				fs = groups.get(key);
			} else {
				fs = new ArrayList<File>();
				groups.put(key, fs);
			}
			fs.add(file);
		}
		return groups;
	}

	/**
	 * ファイルリストをファイルパスがパターンでソートする。
	 * <p>
	 * <ul>
	 * <li>"^.*([0-9]{3})\.csv$"</li>
	 * </ul>
	 * </p>
	 * 
	 * @param aFiles
	 * @param aPattern
	 */
	public static final void sortFiles(final List<File> aFiles, final Pattern aPattern) {
		sortFiles(aFiles, aPattern, SortMode.String);
	}

	/**
	 * ファイルリストをファイルパスがパターンでソートする。
	 * <p>
	 * <ul>
	 * <li>"^.*([0-9]{3})\.csv$"</li>
	 * </ul>
	 * </p>
	 * 
	 * @param aFiles
	 * @param aPattern
	 */
	public static final void sortFiles(final List<File> aFiles, final Pattern aPattern, final SortMode aMode) {
		switch (aMode) {
		case Integer:
			Collections.sort(aFiles, new Comparator<File>() {
				public int compare(File obj1, File obj2) {
					String val1 = extractMatchString(obj1.getAbsolutePath(), aPattern);
					String val2 = extractMatchString(obj2.getAbsolutePath(), aPattern);
					int int1 = Integer.parseInt(val1);
					int int2 = Integer.parseInt(val2);
					return int1 - int2;
				}
			});
			break;
		default:
			Collections.sort(aFiles, new Comparator<File>() {
				public int compare(File obj1, File obj2) {
					String val1 = extractMatchString(obj1.getAbsolutePath(), aPattern);
					String val2 = extractMatchString(obj2.getAbsolutePath(), aPattern);
					return val1.compareTo(val2);
				}
			});
			break;
		}
	}

	private static String extractMatchString(final String aTarget, final Pattern aPattern) {
		Matcher matcher = aPattern.matcher(aTarget);
		if (matcher.find()) {
			return matcher.group(1);
		} else {
			throw new IllegalStateException("No match found.");
		}
	}

	/**
	 * 指定されたディレクトリ配下のファイルを再帰的に全て取得する。
	 * 
	 * @param aDirectory ディレクトリ
	 * @return ファイル群
	 */
	public static final List<File> listFiles(final String aDirectory) {
		return listFiles(aDirectory, (Pattern) null);
	}

	/**
	 * 指定されたディレクトリ配下のファイルを再帰的に全て取得する。
	 * 
	 * @param aDirectory ディレクトリ
	 * @return ファイル群
	 */
	public static final List<File> listFiles(final File aDirectory) {
		return listFiles(aDirectory, (Pattern) null);
	}

	/**
	 * 指定されたディレクトリ配下のファイルを再帰的にファイルパスがパターンにマッチするもののみ取得する。
	 * <p>
	 * パターン例
	 * <ul>
	 * <li>CSVファイル - "^.*\.(csv|CSV)$"</li>
	 * <li>CSVファイルで末3ケタが数値のファイル - "^.*[0-9]{3}\.csv$"</li>
	 * </ul>
	 * </p>
	 * 
	 * @param aDirectory ディレクトリ
	 * @param aPattern パターン
	 * @return ファイル群
	 */
	public static final List<File> listFiles(final String aDirectory, final String aPattern) {
		return listFiles(aDirectory, Pattern.compile(aPattern));
	}

	/**
	 * 指定されたディレクトリ配下のファイルを再帰的にファイルパスがパターンにマッチするもののみ取得する。
	 * <p>
	 * パターン例
	 * <ul>
	 * <li>CSVファイル - "^.*\.(csv|CSV)$"</li>
	 * <li>CSVファイルで末3ケタが数値のファイル - "^.*[0-9]{3}\.csv$"</li>
	 * </ul>
	 * </p>
	 * 
	 * @param aDirectory ディレクトリ
	 * @param aPattern パターン
	 * @return ファイル群
	 */
	public static final List<File> listFiles(final File aDirectory, final String aPattern) {
		return listFiles(aDirectory, Pattern.compile(aPattern));
	}

	/**
	 * 指定されたディレクトリ配下のファイルを再帰的にファイルパスがパターンにマッチするもののみ取得する。
	 * <p>
	 * パターン例
	 * <ul>
	 * <li>CSVファイル - "^.*\.(csv|CSV)$"</li>
	 * </ul>
	 * </p>
	 * 
	 * @param aDirectory ディレクトリ
	 * @param aPattern パターン
	 * @return ファイル群
	 */
	public static final List<File> listFiles(final String aDirectory, final Pattern aPattern) {
		return listFiles(new File(aDirectory), aPattern);
	}

	/**
	 * 指定されたディレクトリ配下のファイルを再帰的にファイルパスがパターンにマッチするもののみ取得する。
	 * <p>
	 * パターン例
	 * <ul>
	 * <li>CSVファイル - "^.*\.(csv|CSV)$"</li>
	 * </ul>
	 * </p>
	 * 
	 * @param aDirectory ディレクトリ
	 * @param aPattern パターン
	 * @return ファイル群
	 */
	public static final List<File> listFiles(final File aDirectory, final Pattern aPattern) {
		List<File> files = new ArrayList<File>();
		readDir(aDirectory, aPattern, files);
		return files;
	}

	private static void readDir(final File aDir, final Pattern aPattern, final List<File> aFiles) {
		File[] files = aDir.listFiles();
		if (files == null) {
			return;
		}
		for (File file : files) {
			if (!file.exists()) {
				continue;
			} else if (file.isDirectory()) {
				readDir(file, aPattern, aFiles);
			} else if (file.isFile())
				readFile(file, aPattern, aFiles);
		}
	}

	private static void readFile(final File aFile, final Pattern aPattern, final List<File> aFiles) {
		String path = aFile.getAbsolutePath();
		if (null == aPattern || aPattern.matcher(path).matches()) {
			aFiles.add(aFile);
		}
	}
}

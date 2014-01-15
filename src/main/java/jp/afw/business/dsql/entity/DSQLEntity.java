package jp.afw.business.dsql.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jp.afw.core.util.StringUtility;
import jp.afw.persistence.entity.Entity;

/**
 * このクラスは、ダイナミックSQL情報を保持するエンティティクラスです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2013/02/14
 * @author Kawakicchi
 */
public final class DSQLEntity implements Entity, Iterable<DSQLLineEntity> {

	/**
	 * 名前
	 */
	private String name;

	/**
	 * 行情報
	 */
	private List<DSQLLineEntity> lines;

	/**
	 * コンストラクタ
	 */
	public DSQLEntity() {
		name = null;
		lines = new ArrayList<DSQLLineEntity>();
	}

	/**
	 * 名前を設定する。
	 * 
	 * @param aName 名前
	 */
	public void setName(final String aName) {
		name = aName;
	}

	/**
	 * 名前を取得する。
	 * 
	 * @return 名前
	 */
	public String getName() {
		return name;
	}

	public void add(final DSQLLineEntity aLine) {
		lines.add(aLine);
	}

	@Override
	public boolean isEmpty() {
		if (StringUtility.isNotEmpty(name)) {
			return false;
		}
		if (0 < lines.size()) {
			return false;
		}
		return true;
	}

	@Override
	public Iterator<DSQLLineEntity> iterator() {
		return lines.iterator();
	}
}

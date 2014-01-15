package jp.afw.business.logic;

import java.io.IOException;

import jp.afw.business.BusinessServiceException;
import jp.afw.plugin.AbstractPlugin;
import jp.afw.plugin.PluginServiceException;

/**
 * このクラスは、ロジック機能をサポートするためのプラグインクラスです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2012/09/21
 * @author Kawakicchi
 */
public final class LogicPlugin extends AbstractPlugin {

	/**
	 * コンストラクタ
	 */
	public LogicPlugin() {

	}

	@Override
	protected void doInitialize() throws PluginServiceException {
		LogicManager.initialize();
	}

	@Override
	protected void doDestroy() throws PluginServiceException {
		LogicManager.destroy();
	}

	@Override
	protected void doLoad() throws PluginServiceException, IOException {
		try {
			LogicManager.load(getConfiguration().getResourceAsStream(), getContext());
		} catch (BusinessServiceException ex) {
			throw new PluginServiceException(ex);
		}
	}
}

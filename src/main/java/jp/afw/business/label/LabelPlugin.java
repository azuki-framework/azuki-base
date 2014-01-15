package jp.afw.business.label;

import java.io.IOException;

import jp.afw.business.BusinessServiceException;
import jp.afw.persistence.ConfigurationFormatException;
import jp.afw.plugin.AbstractPlugin;
import jp.afw.plugin.PluginServiceException;

/**
 * このクラスは、ラベル機能をサポートするためのプラグインクラスです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2013/07/02
 * @author Kawakicchi
 */
public final class LabelPlugin extends AbstractPlugin {

	/**
	 * コンストラクタ
	 */
	public LabelPlugin() {
		super(LabelPlugin.class);
	}

	@Override
	protected void doInitialize() throws PluginServiceException {
		LabelManager.initialize();
	}

	@Override
	protected void doDestroy() throws PluginServiceException {
		LabelManager.destroy();
	}

	@Override
	protected void doLoad() throws PluginServiceException, ConfigurationFormatException, IOException {
		try {
			LabelManager.load(getConfiguration().getResourceAsStream(), getContext());
		} catch (BusinessServiceException ex) {
			throw new PluginServiceException(ex);
		}
	}

}

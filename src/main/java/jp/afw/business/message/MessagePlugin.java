package jp.afw.business.message;

import java.io.IOException;

import jp.afw.business.BusinessServiceException;
import jp.afw.persistence.ConfigurationFormatException;
import jp.afw.plugin.AbstractPlugin;
import jp.afw.plugin.PluginServiceException;

/**
 * このクラスは、メッセージ機能をサポートするためのプラグインクラスです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2013/01/11
 * @author Kawakicchi
 */
public final class MessagePlugin extends AbstractPlugin {

	/**
	 * コンストラクタ
	 */
	public MessagePlugin() {
		super(MessagePlugin.class);
	}

	@Override
	protected void doInitialize() throws PluginServiceException {
		MessageManager.initialize();
	}

	@Override
	protected void doDestroy() throws PluginServiceException {
		MessageManager.destroy();
	}

	@Override
	protected void doLoad() throws PluginServiceException, ConfigurationFormatException, IOException {
		try {
			MessageManager.load(getConfiguration().getResourceAsStream(), getContext());
		} catch (BusinessServiceException ex) {
			throw new PluginServiceException(ex);
		}
	}

}

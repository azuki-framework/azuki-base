package org.azkfw.core;

import java.io.File;
import java.io.InputStream;

import junit.framework.TestCase;

import org.azkfw.core.util.PathUtility;

public abstract class AbstractTestCase extends TestCase {

	private File resourcesDirectory;

	public AbstractTestCase() {
		resourcesDirectory = new File(PathUtility.cat(".", "src", "test", "resources"));
	}

	public AbstractTestCase(final File aResourcesDirectory) {
		resourcesDirectory = aResourcesDirectory;
	}

	public AbstractTestCase(final String aResourcesDirectory) {
		resourcesDirectory = new File(aResourcesDirectory);
	}

	protected final String getResourceAsPath(final String aName) {
		String path = PathUtility.cat(resourcesDirectory.getAbsolutePath(), aName);
		return path;
	}

	protected final File getResourceAsFile(final String aName) {
		String path = PathUtility.cat(resourcesDirectory.getAbsolutePath(), aName);
		return new File(path);
	}

	protected final InputStream getResourceAsStream(final String aName) {
		String path = PathUtility.cat(resourcesDirectory.getAbsolutePath(), aName);
		return getClass().getResourceAsStream(path);
	}
}

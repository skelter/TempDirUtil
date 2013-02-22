package net.skelter.fileutils;

import java.io.File;
import java.io.IOException;

/**
 * Utility methods useful for working with temporary directories.
 */
public class TempDirUtil {
    public static File mkTempDir(String prefix, String suffix) throws IOException {
	// Use what we have to get a decent name and prove we can write there.
	File file = File.createTempFile(prefix, suffix);
	file.delete();
	file.mkdirs();
	return file;
    }
}


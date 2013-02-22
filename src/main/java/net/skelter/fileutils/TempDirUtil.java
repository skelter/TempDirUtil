package net.skelter.fileutils;

import java.io.File;
import java.io.IOException;

/**
 * Utility methods useful for working with temporary directories.
 */
public class TempDirUtil {
  /**
   * Create a scratch directory to do some work, perhaps for a test, in the
   * system temporary dir and randomly named by File.createTempFile (but its a
   * directory).
   * 
   * @param prefix
   *          prefix of dir name
   * @param suffix
   *          suffix of dir name
   * @return a File of the created directory.
   * @throws IOException
   *           if something goes wrong, such as not able to write or create
   *           files in /tmp or %TEMP%.
   */
  public static File mkTempDir(String prefix, String suffix) throws IOException {
    // Use what we have to get a decent name and prove we can write there.
    File file = File.createTempFile(prefix, suffix);
    // ok get rid of that.  
    boolean rc = file.delete();
    if (!rc) throw new IOException("Unable to delete the temp file " + file);
    // now create a folder by the same name.
    rc = file.mkdirs();
    if (!rc) throw new IOException("Unable to create directories to " + file);
    return file;
  }
}

package writers.util;

import java.io.Closeable;
import java.io.IOException;


/**
 * The Class CommonUtils.
 *
 * @author Ahsan Suleman
 * @since Aug 21, 2022
 */
public class CommonUtils {

	/**
	 * Attempts to close a Closable resource and ignores in case of exceptions while closing.
	 *
	 * @param resource the resource
	 */
	public static void closeResource(Closeable resource) {
		try {
			resource.close();
		} catch (IOException e) {
			e.printStackTrace();	
		}
	}
}

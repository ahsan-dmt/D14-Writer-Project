
package writers;

import java.io.IOException;


/**
 * The Interface Writer.
 *
 * @author Ahsan Suleman
 * @since Aug 21, 2022
 */
public interface Writer {
	
	public void write(String input) throws IOException;
	public void close();
	public String readContent() throws IOException;
	
}

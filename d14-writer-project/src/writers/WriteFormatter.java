package writers;

import java.io.IOException;

/**
 * The Class WriteFormatter.
 *
 * @author Ahsan Suleman
 * @since Aug 21, 2022
 */
public abstract class WriteFormatter implements Writer {
	
	protected Writer formattedWriter;

	public WriteFormatter(Writer writer) {
		this.formattedWriter = writer;
	}

	@Override
	public void close() {
		this.formattedWriter.close();
	}
	
	@Override
	public String readContent() throws IOException {
		return this.formattedWriter.readContent();
	}
}

package writers.formatters;

import java.io.IOException;

import writers.WriteFormatter;
import writers.Writer;

/**
 * The Class StupidRemover.
 *
 * @author Ahsan Suleman
 * @since Aug 21, 2022
 */
public class StupidRemover extends WriteFormatter {

	public StupidRemover(Writer writer) {
		super(writer);
	}

	@Override
	public void write(String input) throws IOException {
		formattedWriter.write(format(input));
	}

	private String format(String unFormattedInput) {
		return unFormattedInput.replaceAll("stupid", "s*****");
	}

}

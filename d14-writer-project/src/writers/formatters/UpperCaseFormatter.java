package writers.formatters;

import java.io.IOException;

import writers.WriteFormatter;
import writers.Writer;


/**
 * The Class UpperCaseFormatter.
 *
 * @author Ahsan Suleman
 * @since Aug 21, 2022
 */
public class UpperCaseFormatter extends WriteFormatter  {
	
	public UpperCaseFormatter(Writer writer) {
		super(writer);
	}
	
	@Override
	public void write(String input) throws IOException{
		formattedWriter.write(format(input));
	}
	
	private String format(String unFormattedInput) {
		return unFormattedInput.toUpperCase();
	}
	
	
}

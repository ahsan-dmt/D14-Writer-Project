package writers.formatters;

import java.io.IOException;

import writers.WriteFormatter;
import writers.Writer;


/**
 * The Class LowerCaseFormatter.
 *
 * @author Ahsan Suleman
 * @since Aug 21, 2022
 */
public class LowerCaseFormatter extends WriteFormatter  {
	
	public LowerCaseFormatter(Writer writer) {
		super(writer);
	}
	
	@Override
	public void write(String input) throws IOException{
		formattedWriter.write(format(input));
	}
	
	private String format(String unFormattedInput) {
		return unFormattedInput.toLowerCase();
	}
	
	
}

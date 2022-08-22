package writers.types;

import writers.BasicWriter;


/**
 * The Class StringWriter.
 *
 * @author Ahsan Suleman
 * @since Aug 21, 2022
 */
public class StringWriter extends BasicWriter {
	
	private StringBuilder content = new StringBuilder();

	@Override
	public void write(String input) {
		if(!closed) {
			content.append(input);
		}
	}
	
	@Override
	public String readContent() {
		return content.toString();
	}

}

package writers.formatters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import writers.BasicWriter;
import writers.Writer;
import writers.formatters.UpperCaseFormatter;
import writers.types.FileWriter;
import writers.types.StringWriter;

/**
 * The Class UpperCaseFormattersTest.
 *
 * @author Ahsan Suleman
 * @since Aug 21, 2022
 */
class UpperCaseFormattersTest {

	BasicWriter fileWriter = null;
	BasicWriter stringWriter = null;

	@BeforeEach
	void setup() throws IOException {
		fileWriter = new FileWriter("upper-case-formatter-test.txt");
		stringWriter = new StringWriter();
	}

	
	@Test
	void upperStringWriter() throws IOException {
		Writer upperCaseWriter = new UpperCaseFormatter(stringWriter);
		upperCaseWriter.write("this is important text");
		assertEquals("THIS IS IMPORTANT TEXT", upperCaseWriter.readContent());
	}

	
	@Test
	void multipleUpperCaseFileWrites() throws IOException {
		Writer upperCaseWriter = new UpperCaseFormatter(fileWriter);
		upperCaseWriter.write("CONVERT mE To upper CasE");
		upperCaseWriter.write(" ,Me Too!");
		assertEquals("CONVERT ME TO UPPER CASE ,ME TOO!", upperCaseWriter.readContent());
	}

	@Test
	void ignoreupperCaseWritesAfterClose() throws IOException {
		Writer upperCaseWriter = new UpperCaseFormatter(stringWriter);
		upperCaseWriter.write("this is in lower case");
		upperCaseWriter.write(" THIS IS ALREADY IN UPPER CASE.");
		upperCaseWriter.close();
		upperCaseWriter.write("This will be ignored as the writer is closed");
		upperCaseWriter.write("And this too!");
		assertEquals("THIS IS IN LOWER CASE THIS IS ALREADY IN UPPER CASE.", upperCaseWriter.readContent());
	}
	
	
}

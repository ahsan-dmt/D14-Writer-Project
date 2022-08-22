package writers.formatters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import writers.BasicWriter;
import writers.Writer;
import writers.formatters.LowerCaseFormatter;
import writers.types.FileWriter;
import writers.types.StringWriter;

/**
 * The Class LowerCaseFormattersTest.
 *
 * @author Ahsan Suleman
 * @since Aug 21, 2022
 */
class LowerCaseFormattersTest {

	BasicWriter fileWriter = null;
	BasicWriter stringWriter = null;

	@BeforeEach
	void setup() throws IOException {
		fileWriter = new FileWriter("lower-case-formatter-test.txt");
		stringWriter = new StringWriter();
	}

	
	@Test
	void lowerStringWriter() throws IOException {
		Writer lowerCaseWriter = new LowerCaseFormatter(stringWriter);
		lowerCaseWriter.write("CONVERT mE To LOweR CasE");
		assertEquals("convert me to lower case", lowerCaseWriter.readContent());
	}

	
	@Test
	void multipleLowerCaseFileWrites() throws IOException {
		Writer lowerCaseWriter = new LowerCaseFormatter(fileWriter);
		lowerCaseWriter.write("CONVERT mE To LOweR CasE");
		lowerCaseWriter.write(" ,Me Too!");
		assertEquals("convert me to lower case ,me too!", lowerCaseWriter.readContent());
	}

	@Test
	void ignorelowerCaseWritesAfterClose() throws IOException {
		Writer lowerCaseWriter = new LowerCaseFormatter(fileWriter);
		lowerCaseWriter.write("THIS IS IN UPPER CASE");
		lowerCaseWriter.write(" this is already in lower case.");
		lowerCaseWriter.close();
		lowerCaseWriter.write("This will be ignored as the writer is closed");
		lowerCaseWriter.write("And this too!");
		assertEquals("this is in upper case this is already in lower case.", lowerCaseWriter.readContent());
	}
	
	
}

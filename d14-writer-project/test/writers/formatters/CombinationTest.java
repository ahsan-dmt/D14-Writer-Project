package writers.formatters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import writers.BasicWriter;
import writers.Writer;
import writers.formatters.ConsecutiveDuplicateRemover;
import writers.formatters.LowerCaseFormatter;
import writers.formatters.StupidRemover;
import writers.formatters.UpperCaseFormatter;
import writers.types.FileWriter;
import writers.types.StringWriter;

/**
 * The Class CombinationTest.
 *
 * @author Ahsan Suleman
 * @since Aug 21, 2022
 */
class CombinationTest {

	BasicWriter fileWriter = null;
	BasicWriter stringWriter = null;

	@BeforeEach
	void setup() throws IOException {
		fileWriter = new FileWriter("combination-formatter-test.txt");
		stringWriter = new StringWriter();
	}

	
	@Test
	void lowerCaseStupidRemoverWriter() throws IOException {
		Writer lowerCaseStupidRemover = new LowerCaseFormatter(new StupidRemover(stringWriter));
		lowerCaseStupidRemover.write("This IS Stupid");
		assertEquals("this is s*****", lowerCaseStupidRemover.readContent());
	}
	
	@Test
	void upperCaseDuplicateRemoverWriter() throws IOException {
		Writer upperCaseDuplicateRemover = new UpperCaseFormatter(new ConsecutiveDuplicateRemover(fileWriter));
		upperCaseDuplicateRemover.write("this all all will be corrected in in UPPER case");
		assertEquals("THIS ALL WILL BE CORRECTED IN UPPER CASE", upperCaseDuplicateRemover.readContent());
	}

	@Test
	void duplicateStupidRemoverWriter() throws IOException {
		Writer duplicateStupidRemover = new ConsecutiveDuplicateRemover(new StupidRemover(stringWriter));
		duplicateStupidRemover.write("this is not Really really stupid Stupid");
		assertEquals("this is not Really s*****", duplicateStupidRemover.readContent());
	}
	
	
	@Test
	void stupidDuplicateRemoverWriter() throws IOException {
		Writer stupidDuplicateRemover = new StupidRemover(new ConsecutiveDuplicateRemover(fileWriter));
		stupidDuplicateRemover.write("this is not stupid Stupid");
		assertEquals("this is not s***** Stupid", stupidDuplicateRemover.readContent());
	}
	
	
	@Test
	void lowerCasestupidDuplicateRemoverWriter() throws IOException {
		Writer lowerCasestupidDuplicateRemover = new LowerCaseFormatter(new StupidRemover(new ConsecutiveDuplicateRemover(stringWriter)));
		lowerCasestupidDuplicateRemover.write("this is IS Not not stupid Stupid");
		assertEquals("this is not s*****", lowerCasestupidDuplicateRemover.readContent());
	}
	
}

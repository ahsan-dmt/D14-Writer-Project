package writers.formatters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import writers.BasicWriter;
import writers.Writer;
import writers.formatters.StupidRemover;
import writers.types.FileWriter;
import writers.types.StringWriter;

/**
 * The Class StupidRemoverTest.
 *
 * @author Ahsan Suleman
 * @since Aug 21, 2022
 */
class StupidRemoverTest {

	BasicWriter fileWriter = null;
	BasicWriter stringWriter = null;

	@BeforeEach
	void setup() throws IOException {
		fileWriter = new FileWriter("stupid-remover-test.txt");
		stringWriter = new StringWriter();
	}

	
	@Test
	void stupidRemoverWriter() throws IOException {
		Writer stupidRemoverWriter = new StupidRemover(stringWriter);
		stupidRemoverWriter.write("This is stupid");
		assertEquals("This is s*****", stupidRemoverWriter.readContent());
	}

	
	@Test
	void multipleStupidRemoveWrites() throws IOException {
		Writer stupidRemoverWriter = new StupidRemover(fileWriter);
		stupidRemoverWriter.write("This text contains many stupid");
		stupidRemoverWriter.write(",but this Stupid will not will not be corrected");
		assertEquals("This text contains many s*****,but this Stupid will not will not be corrected", stupidRemoverWriter.readContent());
	}

	@Test
	void ignoreStupidRemoveWritesAfterClose() throws IOException {
		Writer stupidRemoverWriter = new StupidRemover(fileWriter);
		stupidRemoverWriter.write("Stupid stupid stupiD");
		stupidRemoverWriter.write(",This is not so stupid");
		stupidRemoverWriter.close();
		stupidRemoverWriter.write("this is stupid");
		stupidRemoverWriter.write("to write in stupid remover");
		assertEquals("Stupid s***** stupiD,This is not so s*****", stupidRemoverWriter.readContent());
	}
	
	
}

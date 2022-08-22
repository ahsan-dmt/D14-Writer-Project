package writers.formatters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import writers.BasicWriter;
import writers.Writer;
import writers.formatters.ConsecutiveDuplicateRemover;
import writers.types.FileWriter;
import writers.types.StringWriter;

/**
 * The Class ConsecutiveDuplicateRemoverTest.
 *
 * @author Ahsan Suleman
 * @since Aug 21, 2022
 */
class ConsecutiveDuplicateRemoverTest {

	BasicWriter fileWriter = null;
	BasicWriter stringWriter = null;

	@BeforeEach
	void setup() throws IOException {
		fileWriter = new FileWriter("duplicate-remover-test.txt");
		stringWriter = new StringWriter();
	}

	
	@Test
	void duplicateRemoverWriter() throws IOException {
		Writer duplicateRemoverWriter = new ConsecutiveDuplicateRemover(stringWriter);
		duplicateRemoverWriter.write("This is is it");
		assertEquals("This is it", duplicateRemoverWriter.readContent());
	}

	
	@Test
	void multipleDuplicateRemoverFileWrites() throws IOException {
		Writer duplicateRemoverWriter = new ConsecutiveDuplicateRemover(fileWriter);
		duplicateRemoverWriter.write("This this text contains contains many many duplicates");
		duplicateRemoverWriter.write(",but this one will not will not be corrected");
		assertEquals("This text contains many duplicates,but this one will not will not be corrected", duplicateRemoverWriter.readContent());
	}

	@Test
	void ignoreDuplicateRemoverWritesAfterClose() throws IOException {
		Writer duplicateRemoverWriter = new ConsecutiveDuplicateRemover(fileWriter);
		duplicateRemoverWriter.write("Test Test Test");
		duplicateRemoverWriter.write(",Programming is fun fun and fun");
		duplicateRemoverWriter.close();
		duplicateRemoverWriter.write("I am here here here");
		duplicateRemoverWriter.write("Nobody listens listens to me");
		assertEquals("Test,Programming is fun and fun", duplicateRemoverWriter.readContent());
	}
	
	
}

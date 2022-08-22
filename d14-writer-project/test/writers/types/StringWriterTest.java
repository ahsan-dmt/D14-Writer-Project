package writers.types;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import writers.BasicWriter;
import writers.types.StringWriter;

/**
 * The Class StringWriterTest.
 *
 * @author Ahsan Suleman
 * @since Aug 21, 2022
 */
class StringWriterTest {

	BasicWriter stringWriter = null;

	@BeforeEach
	void setup() throws IOException {
		stringWriter = new StringWriter();
	}

	@Test
	void basicWrite() throws IOException {
		stringWriter.write("This is a test string");
		assertEquals("This is a test string", stringWriter.readContent());
	}

	@Test
	void multipleWrites() throws IOException {
		stringWriter.write("I love");
		stringWriter.write(" Programming");
		assertEquals("I love Programming", stringWriter.readContent());
	}

	@Test
	void ignoredWritesAfterClose() throws IOException {
		stringWriter.write("I like JAVA");
		stringWriter.close();
		stringWriter.write("I like Programming");
		stringWriter.write("I like OOP");
		assertEquals("I like JAVA", stringWriter.readContent());
	}

}

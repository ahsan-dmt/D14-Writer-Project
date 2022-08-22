package writers.types;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import writers.BasicWriter;
import writers.types.FileWriter;

/**
 * The Class FileWriterTest.
 *
 * @author Ahsan Suleman
 * @since Aug 21, 2022
 */
class FileWriterTest {

	BasicWriter fileWriter = null;

	@BeforeEach
	void setup() throws IOException {
		fileWriter = new FileWriter("file-writer-test.txt");
	}

	@Test
	void basicWrite() throws IOException {

		fileWriter.write("This is a test string");
		assertEquals("This is a test string", fileWriter.readContent());
	}

	@Test
	void multipleWrites() throws IOException {

		fileWriter.write("I love");
		fileWriter.write(" Programming");
		assertEquals("I love Programming", fileWriter.readContent());
	}

	@Test
	void ignoredWritesAfterClose() throws IOException {

		fileWriter.write("I like JAVA");
		fileWriter.close();
		fileWriter.write("I like Programming");
		fileWriter.write("I like OOP");
		assertEquals("I like JAVA", fileWriter.readContent());
	}

}

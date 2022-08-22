package writers.types;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import writers.BasicWriter;
import writers.util.CommonUtils;


/**
 * The Class FileWriter.
 *
 * @author Ahsan Suleman
 * @since Aug 21, 2022
 */
public class FileWriter extends BasicWriter {
	
	private Path filePath;
	private BufferedWriter fileWriter;
	
	public FileWriter(String filePath) throws IOException {
		this.filePath = Paths.get(filePath);
		fileWriter = Files.newBufferedWriter(this.filePath,StandardOpenOption.CREATE,StandardOpenOption.TRUNCATE_EXISTING);
	}

	@Override
	public void write(String input) throws IOException {
		if(!closed) {
			fileWriter.append(input).flush();
		}
	}
	
	@Override
	public void close() {
		super.close();
		CommonUtils.closeResource(fileWriter);
	}

	
	@Override
	public String readContent() throws IOException {
		try(Stream<String> fileStream =  Files.newBufferedReader(filePath).lines()){
			return fileStream.collect(Collectors.joining(System.lineSeparator()));
		}
	}
	
}

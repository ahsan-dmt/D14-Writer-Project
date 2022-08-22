package writers.formatters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import writers.WriteFormatter;
import writers.Writer;


/**
 * The Class ConsecutiveDuplicateRemover.
 *
 * @author Ahsan Suleman
 * @since Aug 21, 2022
 */
public class ConsecutiveDuplicateRemover extends WriteFormatter  {
	
	
	public ConsecutiveDuplicateRemover(Writer writer) {
		super(writer);
	}
	
	@Override
	public void write(String input) throws IOException{
		formattedWriter.write(format(input));
	}
	
	private String format(String unFormattedInput) {
		String currentWord = "";
		String nextWord = "";

		List<String> words= new ArrayList<>(Arrays.asList(unFormattedInput.split(" ")));
		Iterator<String> wordsIterator= words.iterator();
		
		while(wordsIterator.hasNext()) {
			currentWord = nextWord;
			nextWord = wordsIterator.next();
			if(currentWord.equalsIgnoreCase(nextWord)) {
				wordsIterator.remove();
			}
			
		}
		return String.join(" ",words);
	}

	

}

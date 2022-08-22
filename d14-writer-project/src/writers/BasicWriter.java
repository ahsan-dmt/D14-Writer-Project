package writers;

/**
 * The Class BasicWriter.
 *
 * @author Ahsan Suleman
 * @since Aug 21, 2022
 */
public abstract class BasicWriter implements Writer  {

	protected boolean closed = false;
	
	@Override
	public void close() {
		closed = true;
	}

	
}

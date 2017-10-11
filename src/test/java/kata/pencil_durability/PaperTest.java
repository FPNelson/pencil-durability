package kata.pencil_durability;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PaperTest {
	
	private Paper paper;

	@Before
	public void setup() {
		paper = new Paper();
	}
	
	@Test
	public void whenReadTextFromEmptyPaperThenReturnsEmptyString() {
		assertEquals("", paper.read());
	}
	
	@Test
	public void whenReadTextAfterAppendingOnceFromPaperThenReturnsText() {
		paper.append("Doing stuff");
		assertEquals("Doing stuff", paper.read());
	}
	
	@Test
	public void whenReadTextAfterAppendingMultipleTimesFromPaperThenReturnsText() {
		paper.append("Doing stuff");
		paper.append("? ");
		paper.append("I'm not");
		assertEquals("Doing stuff? I'm not", paper.read());
	}
}

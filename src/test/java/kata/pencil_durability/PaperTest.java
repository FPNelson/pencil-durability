package kata.pencil_durability;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PaperTest {
	@Test
	public void whenReadTextFromEmptyPaperThenReturnsEmptyString() {
		Paper paper = new Paper();
		assertEquals("", paper.read());
	}
	
	@Test
	public void whenReadTextAfterAppendingOnceFromPaperThenReturnsText() {
		Paper paper = new Paper();
		paper.append("Doing stuff");
		assertEquals("Doing stuff", paper.read());
	}
}

package kata.pencil_durability;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class PaperTest {
	@Test
	public void whenReadTextFromPaperThenReturnsWrittenText() {
		Paper paper = new Paper();
		String text = paper.read();
		assertEquals("Some text", text);
	}
}

package kata.pencil_durability;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PencilTest {
	
	private Pencil pencil;

	@Before
	public void setup() {
		pencil = new Pencil();
	}
	
	@Test
	public void whenWriteWithPencilThenWritesTextToPaper() {
		String str = "Testing 1...2...3...";
		Paper paper = new Paper();
		pencil.write(str, paper);
		assertEquals(str, paper.read());
	}
}

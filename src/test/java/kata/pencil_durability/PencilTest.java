package kata.pencil_durability;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PencilTest {
	
	private Pencil pencil;
	private Paper paper;

	@Before
	public void setup() {
		pencil = new Pencil(40);
		paper = new Paper();
	}
	
	@Test
	public void whenWriteWithPencilThenWritesTextToPaper() {
		String str = "Testing 1...2...3...";
		pencil.write(str, paper);
		assertEquals(str, paper.read());
	}
	
	@Test
	public void whenWriteSpaceWithPencilThenDurabilityStaysSame() {
		String str = " ";
		pencil.write(str, paper);
		assertEquals(40, pencil.getPointDurability());
	}
	
	@Test
	public void whenWriteLowercaseLetterWithPencilThenDurabilityDecreasesByOne() {
		String str = "e";
		pencil.write(str, paper);
		assertEquals(39, pencil.getPointDurability());
	}
	
	@Test
	public void whenWriteFiveLowercaseLettersWithPencilThenDurabilityDecreasesByFive() {
		String str = "tasty";
		pencil.write(str, paper);
		assertEquals(35, pencil.getPointDurability());
	}
	
	@Test
	public void whenWriteUppercaseLettersWithPencilThenDurabilityDecreasesByTwo() {
		String str = "E";
		pencil.write(str, paper);
		assertEquals(38, pencil.getPointDurability());
	}
}

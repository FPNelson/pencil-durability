package kata.pencil_durability;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PencilTest {

	private Pencil pencil;
	private Paper paper;

	@Before
	public void setup() {
		pencil = new Pencil(20);
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
		assertDurability(" ", 20);
	}

	@Test
	public void whenWriteLowercaseLetterWithPencilThenDurabilityDecreasesByOne() {
		assertDurability("e", 19);
	}

	@Test
	public void whenWriteFiveLowercaseLettersWithPencilThenDurabilityDecreasesByFive() {
		assertDurability("tasty", 15);
	}

	@Test
	public void whenWriteUppercaseLettersWithPencilThenDurabilityDecreasesByTwo() {
		assertDurability("E", 18);
	}

	@Test
	public void whenWriteFiveUppercaseLettersWithPencilThenDurabilityDecreasesByTen() {
		assertDurability("TASTY", 10);
	}

	@Test
	public void whenWriteOneUppercaseAndFourLowercaseLettersWithPencilThenDurabilityDecreasesBySix() {
		assertDurability("Tasty", 14);
	}

	@Test
	public void whenWriteTextWithInsufficientPointDurabilityThenAppendSpaces() {
		pencil.write("THIS IS TASTY", paper);
		assertEquals("THIS IS TAST ", paper.read());
	}

	private void assertDurability(String str, int expectedPointDurability) {
		pencil.write(str, paper);
		assertEquals(expectedPointDurability, pencil.getPointDurability());
	}
}

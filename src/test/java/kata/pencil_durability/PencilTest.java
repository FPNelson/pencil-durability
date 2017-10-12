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
		assertDurability(" ", 40);
	}
	
	@Test
	public void whenWriteLowercaseLetterWithPencilThenDurabilityDecreasesByOne() {
		assertDurability("e", 39);
	}
	
	@Test
	public void whenWriteFiveLowercaseLettersWithPencilThenDurabilityDecreasesByFive() {
		assertDurability("tasty", 35);
	}
	
	@Test
	public void whenWriteUppercaseLettersWithPencilThenDurabilityDecreasesByTwo() {
		assertDurability("E", 38);
	}
	
	@Test
	public void whenWriteFiveUppercaseLettersWithPencilThenDurabilityDecreasesByTen() {
		assertDurability("TASTY", 30);
	}
	
	@Test
	public void whenWriteOneUppercaseAndFourLowercaseLettersWithPencilThenDurabilityDecreasesBySix() {
		assertDurability("Tasty", 34);
	}
	
	private void assertDurability(String str, int expectedPointDurability) {
		pencil.write(str, paper);
		assertEquals(expectedPointDurability, pencil.getPointDurability());
	}
}

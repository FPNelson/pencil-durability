package kata.pencil_durability;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PencilTest {

	private Pencil pencil;
	private Paper paper;

	@Before
	public void setup() {
		pencil = new Pencil(20, 3, 20);
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

	@Test
	public void whenWriteTextMultipleTimesWithInsufficientPointDurabilityThenAppendSpaces() {
		pencil.write("This is tasty!", paper);
		pencil.write(" Very tasty", paper);
		assertEquals("This is tasty! Very tas  ", paper.read());
	}

	@Test
	public void whenWriteTextWithMorePointDurablePencilThenWritesEntireString() {
		Pencil superPencil = new Pencil(40, 3, 40);
		superPencil.write("THIS IS TASTY", paper);
		assertEquals("THIS IS TASTY", paper.read());
	}

	@Test
	public void whenSharpenPencilThenResetsDurabilityToInitialValue() {
		pencil.write("Test", paper);
		pencil.sharpen();
		assertEquals(20, pencil.getPointDurability());
	}

	@Test
	public void whenSharpenDurablePencilThenResetsDurabilityToInitialValue() {
		Pencil superPencil = new Pencil(40, 3, 40);
		superPencil.write("Test", paper);
		superPencil.sharpen();
		assertEquals(40, superPencil.getPointDurability());
	}

	@Test
	public void whenSharpenPencilThenReducesLengthByOne() {
		pencil.sharpen();
		assertEquals(2, pencil.getLength());
	}

	@Test
	public void whenSharpenLongPencilThenReducesLengthByOne() {
		Pencil longPencil = new Pencil(20, 5, 20);
		longPencil.sharpen();
		assertEquals(4, longPencil.getLength());
	}

	@Test
	public void whenSharpenPencilWithNoLengthThenDoesNothing() {
		pencil.sharpen();
		pencil.sharpen();
		pencil.sharpen();
		pencil.write("e", paper);
		pencil.sharpen();
		assertEquals(0, pencil.getLength());
		assertEquals(19, pencil.getPointDurability());
	}

	@Test
	public void whenEraseWordFromPaperThenReplacesLastInstanceOfWordWithWhitespace() {
		Pencil superPencil = new Pencil(100, 3, 100);
		superPencil.write("Are you doing stuff? Cause I'm not doing anything", paper);
		superPencil.erase("doing", paper);
		assertEquals("Are you doing stuff? Cause I'm not       anything", paper.read());
	}

	@Test
	public void whenEraseWordFromPaperWithNonDurableEraserThenReplacesLastNCharactersOfWordWithWhitespace() {
		Pencil superPencil = new Pencil(100, 3, 4);
		superPencil.write("Are you doing stuff? Cause I'm not doing oing anything", paper);
		superPencil.erase("doing", paper);
		assertEquals("Are you doing stuff? Cause I'm not d     oing anything", paper.read());
	}

	@Test
	public void whenEraseWordFromPaperThenReducesEraserDurabilityByFive() {
		pencil.write("This is tasty!", paper);
		pencil.erase("tasty", paper);
		assertEquals(15, pencil.getEraserDurability());
	}

	private void assertDurability(String str, int expectedPointDurability) {
		pencil.write(str, paper);
		assertEquals(expectedPointDurability, pencil.getPointDurability());
	}
}

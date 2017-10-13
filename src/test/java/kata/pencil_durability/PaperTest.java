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
	public void whenAppendSingleTimeFromPaperThenConcatenatesToString() {
		paper.append("Doing stuff");
		assertEquals("Doing stuff", paper.read());
	}

	@Test
	public void whenAppendMultipleTimesFromPaperThenConcatenatesAllToSingleString() {
		paper.append("Doing stuff");
		paper.append("? ");
		paper.append("I'm not");
		assertEquals("Doing stuff? I'm not", paper.read());
	}

	@Test
	public void whenErasingWordFromPaperThenErasesLastInstanceOfWord() {
		paper.append("Are you doing stuff? Cause I'm not doing anything");
		paper.erase("doing", 5);
		assertEquals("Are you doing stuff? Cause I'm not       anything", paper.read());
	}
	
	@Test
	public void whenErasingWordFromPaperWithLimitedCharactersThenErasesLastInstanceOfWordStartingFromLastCharacter() {
		paper.append("Are you doing stuff? Cause I'm not doing anything");
		paper.erase("doing", 4);
		assertEquals("Are you doing stuff? Cause I'm not d     anything", paper.read());
	}

	@Test
	public void whenErasingWordFromPaperMultipleTimesThenErasesEachLastInstanceOfWord() {
		paper.append("Are you doing stuff? Cause I'm not doing anything. But if you're doing something, then I will");
		paper.erase("doing", 5);
		paper.erase("doing", 5);
		assertEquals("Are you doing stuff? Cause I'm not       anything. But if you're       something, then I will", paper.read());
	}

	@Test
	public void whenErasingWordFromPaperWhichDoesNotExistThenDoesNothing() {
		paper.append("Are you doing stuff? Cause I'm not doing anything");
		paper.erase("lunch", 5);
		assertEquals("Are you doing stuff? Cause I'm not doing anything", paper.read());
	}

	@Test
	public void whenErasingWordFromPaperThenReturnsIndexOfErasedWord() {
		paper.append("Are you doing stuff?");
		assertEquals(8, paper.erase("doing", 5));
	}
}

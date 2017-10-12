package kata.pencil_durability;

public class Pencil {

	private final int initialPointDurability;
	private int pointDurability;
	private int length;
	private int eraserDurability;

	public Pencil(int pointDurability, int length, int eraserDurability) {
		this.initialPointDurability = pointDurability;
		this.pointDurability = pointDurability;
		this.length = length;
		this.eraserDurability = eraserDurability;
	}

	public int getPointDurability() {
		return pointDurability;
	}

	public int getLength() {
		return length;
	}

	public int getEraserDurability() {
		return eraserDurability;
	}

	public void write(String str, Paper paper) {
		for(char character : str.toCharArray()) {
			if(reducePointDurability(character))
				paper.append(String.valueOf(character));
			else
				paper.append(" ");
		}
	}

	public void erase(String str, Paper paper) {
		int charsToErase = 0;
		for(char character : str.toCharArray()) {
			if(reduceEraserDurability(character)) {
				charsToErase++;
			}
		}
		paper.erase(str, charsToErase);
	}
	
	public void sharpen() {
		if(length > 0) {
			length--;
			pointDurability = initialPointDurability;
		}
	}

	private boolean reducePointDurability(char character) {
		switch(Character.getType(character)) {
			case Character.UPPERCASE_LETTER:
				pointDurability--;
			case Character.LOWERCASE_LETTER:
				pointDurability--;
		}
		return pointDurability >= 0;
	}
	
	private boolean reduceEraserDurability(char character) {
		if(!Character.isWhitespace(character)) {
			eraserDurability--;
		}
		return eraserDurability >= 0;
	}
}

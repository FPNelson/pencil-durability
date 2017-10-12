package kata.pencil_durability;

public class Pencil {

	private final int initialPointDurability;
	private int pointDurability;
	private int length;

	public Pencil(int pointDurability, int length) {
		this.initialPointDurability = pointDurability;
		this.pointDurability = pointDurability;
		this.length = length;
	}

	public int getPointDurability() {
		return pointDurability;
	}

	public int getLength() {
		return length;
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
		paper.erase(str);
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
}

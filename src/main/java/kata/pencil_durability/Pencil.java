package kata.pencil_durability;

public class Pencil {

	private final int initialPointDurability;
	private int pointDurability;

	public Pencil(int pointDurability) {
		this.initialPointDurability = pointDurability;
		this.pointDurability = pointDurability;
	}

	public int getPointDurability() {
		return pointDurability;
	}

	public int getLength() {
		return 9;
	}

	public void write(String str, Paper paper) {
		for(char character : str.toCharArray()) {
			if(reducePointDurability(character))
				paper.append(String.valueOf(character));
			else
				paper.append(" ");
		}
	}

	public void sharpen() {
		pointDurability = initialPointDurability;
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

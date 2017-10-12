package kata.pencil_durability;

public class Pencil {

	private int pointDurability;

	public Pencil(int pointDurability) {
		this.pointDurability = pointDurability;
	}

	public void write(String str, Paper paper) {
		for(char character : str.toCharArray()) {
			if(reducePointDurability(character))
				paper.append(String.valueOf(character));
			else
				paper.append(" ");
		}
	}

	public int getPointDurability() {
		return pointDurability;
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

	public void sharpen() {
		pointDurability = 20;
	}
}

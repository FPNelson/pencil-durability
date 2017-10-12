package kata.pencil_durability;

public class Pencil {

	private int pointDurability;
	
	public Pencil(int pointDurability) {
		this.pointDurability = pointDurability;
	}
	
	public void write(String str, Paper paper) {
		for(int i = 0; i < str.length(); i++) {
			char character = str.charAt(i);
			reducePointDurability(character);
			paper.append(String.valueOf(character));
		}
	}

	public int getPointDurability() {
		return pointDurability;
	}
	
	private void reducePointDurability(char character) {
		if(Character.isLowerCase(character)) {
			pointDurability -= 1;
		}
	}
}

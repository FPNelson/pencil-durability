package kata.pencil_durability;

public class Pencil {

	public void write(String str, Paper paper) {
		paper.append(str);
	}

	public int getPointDurability() {
		return 20;
	}
}

package kata.pencil_durability;

public class Paper {

	private StringBuilder text;

	public Paper() {
		text = new StringBuilder();
	}

	public String read() {
		return text.toString();
	}

	protected void append(String str) {
		text.append(str);
	}

	protected void erase(String str) {
		int start = text.lastIndexOf(str);
		if(start != -1) {
			for(int i = 0; i < str.length(); i++) {
				text.setCharAt(start + i, ' ');
			}
		}
	}
}

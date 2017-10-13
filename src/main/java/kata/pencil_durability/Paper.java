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

	protected int erase(String str, int numCharacters) {
		int start = text.lastIndexOf(str);
		if(start != -1) {
			start += str.length() - 1;
			for(int i = 0; i < str.length() && numCharacters > 0; i++, start--, numCharacters--) {
				text.setCharAt(start, ' ');
			}
		}
		return start + 1;
	}
}

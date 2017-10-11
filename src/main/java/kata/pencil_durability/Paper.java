package kata.pencil_durability;

public class Paper {
	private StringBuilder text = new StringBuilder();
	
	public String read() {
		return this.text.toString();
	}
	
	protected void append(String text) {
		this.text.append(text);
	}
}

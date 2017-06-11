package com.billkang;

public class StringIterator {

	private String compressedString;
	int c = 0;
	private int pos = 0;
	private char ch;

	public StringIterator(String compressedString) {
		this.compressedString = compressedString;
	}

	public char next() {
		if (c > 0) {
			c--;
			return ch;
		}

		if (pos >= compressedString.length()) {
			return ' ';
		}

		ch = compressedString.charAt(pos++);
		while (pos < compressedString.length()
				&& isDigit(compressedString.charAt(pos))) {
			c = c * 10 + compressedString.charAt(pos++) - '0';
		}
		c--;
		return ch;
	}

	private boolean isDigit(char charAt) {
		return Character.isDigit(charAt);
	}

	public boolean hasNext() {
		return c > 0 || pos < compressedString.length();
	}
}
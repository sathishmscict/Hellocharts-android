package lecho.lib.hellocharts.model;

import android.graphics.Color;

public class LegendValue {

	private int color = Color.LTGRAY;
	private String text;

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}

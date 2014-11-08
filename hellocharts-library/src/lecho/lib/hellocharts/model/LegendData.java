package lecho.lib.hellocharts.model;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;

public class LegendData {
	public static final int DEFAULT_TEXT_SIZE_SP = 12;

	private int textColor = Color.LTGRAY;
	private int textSize = DEFAULT_TEXT_SIZE_SP;
	private List<LegendValue> values = new ArrayList<LegendValue>();

	public int getTextColor() {
		return textColor;
	}

	public void setTextColor(int textColor) {
		this.textColor = textColor;
	}

	public int getTextSize() {
		return textSize;
	}

	public void setTextSize(int textSize) {
		this.textSize = textSize;
	}

	public List<LegendValue> getValues() {
		return values;
	}

	public void setValues(List<LegendValue> values) {
		this.values = values;
	}

	public static LegendData generateDummyData() {
		final int num = 4;

		List<LegendValue> values = new ArrayList<LegendValue>();

		for (int i = 0; i < num; ++i) {
			LegendValue value = new LegendValue();
			value.setText("Item " + i);
			values.add(value);
		}

		LegendData data = new LegendData();
		data.setValues(values);
		return data;

	}
}

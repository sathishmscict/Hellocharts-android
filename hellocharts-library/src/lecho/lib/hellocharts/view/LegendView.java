package lecho.lib.hellocharts.view;

import lecho.lib.hellocharts.BuildConfig;
import lecho.lib.hellocharts.model.LegendData;
import lecho.lib.hellocharts.model.LegendValue;
import lecho.lib.hellocharts.renderer.LegendRenderer;
import lecho.lib.hellocharts.util.Utils;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class LegendView extends View {
	private static final String TAG = "LegendView";

	private static final int DEFAULT_INTERNAM_PADDING = 4;
	private static final int DEFAULT_COLOR_BOX_SIZE_DP = 8;

	protected LegendData data;
	protected LegendRenderer renderer;
	protected float density;
	protected float scaledDensity;

	private Paint textPaint = new Paint();
	private Paint colorPaint = new Paint();

	private FontMetricsInt fontMetrics = new FontMetricsInt();

	public LegendView(Context context) {
		this(context, null, 0);
	}

	public LegendView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public LegendView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		this.density = context.getResources().getDisplayMetrics().density;
		this.scaledDensity = context.getResources().getDisplayMetrics().scaledDensity;

		textPaint.setAntiAlias(true);

		colorPaint.setAntiAlias(true);
		colorPaint.setStyle(Style.FILL);

		setLegendData(LegendData.generateDummyData());
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		int valueIndex = 0;
		for (LegendValue value : data.getValues()) {
			canvas.drawText(value.getText(), getTextX(valueIndex), getTextY(valueIndex), textPaint);
			++valueIndex;
		}

	}

	private int getTextX(int valueIndex) {
		return getPaddingLeft();

	}

	private int getTextY(int valueIndex) {
		return getPaddingTop() + (valueIndex + 1) * fontMetrics.ascent;
	}

	public void setLegendData(LegendData data) {
		if (BuildConfig.DEBUG) {
			Log.d(TAG, "Setting data for LegendView");
		}

		if (null == data) {
			this.data = LegendData.generateDummyData();
		} else {
			this.data = data;
		}

		textPaint.setTextSize(Utils.sp2px(scaledDensity, data.getTextSize()));
		textPaint.setColor(data.getTextColor());
		textPaint.getFontMetricsInt(fontMetrics);

		ViewCompat.postInvalidateOnAnimation(LegendView.this);
	}

}

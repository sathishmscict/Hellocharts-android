package lecho.lib.hellocharts.view;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.BuildConfig;
import lecho.lib.hellocharts.model.LegendData;
import lecho.lib.hellocharts.renderer.LegendRenderer;
import lecho.lib.hellocharts.util.Utils;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.support.v4.view.ViewCompat;
import android.text.StaticLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class LegendView extends View {
	private static final String TAG = "LegendView";

	private static final int DEFAULT_INTERNAM_PADDING = 4;
	private static final int DEFAULT_COLOR_BOX_SIZE_DP = 8;

	protected LegendData data;
	protected LegendRenderer renderer;
	protected List<StaticLayout> staticLayouts = new ArrayList<StaticLayout>();
	protected float density;
	protected float scaledDensity;

	private Paint textPaint;
	private Paint colorPaint;

	public LegendView(Context context) {
		super(context, null, 0);
	}

	public LegendView(Context context, AttributeSet attrs) {
		super(context, attrs, 0);
	}

	public LegendView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		this.density = context.getResources().getDisplayMetrics().density;
		this.scaledDensity = context.getResources().getDisplayMetrics().scaledDensity;

		textPaint.setAntiAlias(true);

		colorPaint.setAntiAlias(true);
		colorPaint.setStyle(Style.FILL);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

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

		ViewCompat.postInvalidateOnAnimation(LegendView.this);
	}

}

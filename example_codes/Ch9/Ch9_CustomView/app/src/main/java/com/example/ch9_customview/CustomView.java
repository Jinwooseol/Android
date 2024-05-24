package com.example.ch9_customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class CustomView extends View {
    public CustomView(Context context) {
        super(context);
        Log.i("CustomView", "CustomView(Context)");
        setBackgroundColor(Color.BLUE);
    }
    public CustomView(Context context, AttributeSet attrs) {
        super(context);
        Log.i("CustomView", "CustomView(Context, AttributeSet)");
        setBackgroundColor(Color.BLUE);
    }
    @Override
    public void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        canvas.drawArc(new RectF(10, 10, 600, 600), 45, 320, true, paint);
    }
}

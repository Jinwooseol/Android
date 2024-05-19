package com.example.ch9_graphicbitmap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

class MyView extends View {
    public MyView(Context context) {
        super(context);
        setBackgroundColor(Color.YELLOW);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        Matrix matrix = new Matrix();
        matrix.preScale(1, -1);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.house);
        Bitmap mb = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
        Bitmap sb = Bitmap.createScaledBitmap(bitmap, 500, 300, false);
        canvas.drawBitmap(mb, 0, 0, null);
        canvas.drawBitmap(sb, 200, 200, null);
    }
}
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
    }
}
package com.example.ch12_publicimage;

import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    ImageView imageView;
    Bitmap orgBitmap, changedBitmap;
    Canvas canvas;
    Paint paint;
    Matrix matrix;
    float x1 = 0, y1 = 0, x2 = 0, y2 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        imageView.setOnTouchListener(this);
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED) == false) {
            Toast.makeText(this, "외부 스토리지 실패", Toast.LENGTH_SHORT).show();
        }
    }
    public void choose(View v) {
        Intent choosePictureIntent = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(choosePictureIntent, 0);
    }
    public void save(View v) {
        OutputStream fos;
        if (changedBitmap == null) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                ContentValues contentValues = new ContentValues(3);
                contentValues.put(MediaStore.Images.Media.DISPLAY_NAME, "MyPicture.png");
                contentValues.put(MediaStore.Images.Media.MIME_TYPE, "image/png");
                contentValues.put(MediaStore.Images.Media.RELATIVE_PATH, "Pictures/Ch12_PublicImage");
                Uri imageFileUri = getContentResolver().insert(
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                        contentValues);
                fos = getContentResolver().openOutputStream(imageFileUri);
            } else {
                String imagesDir = Environment.getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_PICTURES).toString();
                File image = new File(imagesDir, "My Picture");
                fos = new FileOutputStream(image);
            }
            changedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, fos);
            Toast.makeText(this, "변경된 사진 저장 완료", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Log.v("EXCEPTION", e.getMessage());
        }
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode == RESULT_OK) {
            Uri uri = intent.getData();
            try {
                BitmapFactory.Options bmpFactoryOptions = new BitmapFactory.Options();
                orgBitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri),
                        null, bmpFactoryOptions);
                changedBitmap = Bitmap.createBitmap(orgBitmap.getWidth(), orgBitmap.getHeight(),
                        orgBitmap.getConfig());
                canvas = new Canvas(changedBitmap);
                paint = new Paint();
                paint.setColor(Color.RED);
                paint.setStrokeWidth(10);
                matrix = new Matrix();
                canvas.drawBitmap(orgBitmap, matrix, paint);
                imageView.setImageBitmap(changedBitmap);
                imageView.setOnTouchListener(this);
            } catch (Exception e) {
                Log.v("ERROR", e.toString());

            }
        }
    }
    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction();
        if (action == MotionEvent.ACTION_DOWN) {
            x1 = event.getX();
            y1 = event.getY();
        } else if (action == MotionEvent.ACTION_MOVE) {
            x2 = event.getX();
            y2 = event.getY();
            canvas.drawLine(x1, y1, x2, y2, paint);
            imageView.invalidate();
            x1 = x2;
            y1 = y2;
        } else if (action == MotionEvent.ACTION_UP) {
            x2 = event.getX();
            y2 = event.getY();
            canvas.drawLine(x1, y1, x2, y2, paint);
            imageView.invalidate();
        }
        return true;
    }
}
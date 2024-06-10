package com.example.ch13_galaga_game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

public class Sprite {
    protected int x, y;             // 현재 좌표
    protected int width, height;    // 화면 크기
    protected int dx, dy;           // 속도
    private Bitmap bitmap;        // 이미지
    protected int id;               // 이미지 리소스 ID
    private RectF rect;           // 사각형, 충돌 검사에 사용

    public Sprite(Context context, int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
        bitmap = BitmapFactory.decodeResource(context.getResources(), id);
        width = bitmap.getWidth();
        height = bitmap.getHeight();
        rect = new RectF();
    }
    
    public int getWidth() {
        return bitmap.getWidth();
    }
    public int getHeight() {
        return bitmap.getHeight();
    }
    public void draw(Canvas c, Paint p) {
        c.drawBitmap(bitmap, x, y, p);
    }
    public void move() {
        x += dx;
        y += dy;
        rect.left = x;
        rect.right = x + width;
        rect.top = y;
        rect.bottom = y + height;
    }
    public void setDx(int dx) { this.dx = dx; }
    public void setDy(int dy) { this.dy = dy; }
    public int getDx() { return dx; }
    public int getDy() { return dy; }
    public int getX() { return x; }
    public int getY() { return y; }
    public RectF getRect() { return rect; }
    
    // 다른 Sprite와의 충돌 여부 확인
    public boolean checkCollision(Sprite other) {
        return RectF.intersects(this.getRect(), other.getRect());
    }
    public void handleCollision(Sprite other) {
        // 충돌 시의 동작 처리
    }

}

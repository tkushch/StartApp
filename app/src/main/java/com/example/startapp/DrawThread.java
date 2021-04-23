package com.example.startapp;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.Surface;
import android.view.SurfaceHolder;

public class DrawThread extends Thread {
    private boolean runFlag = false;
    private SurfaceHolder surfaceHolder;
    private int x, y, radius, h, w;

    public DrawThread(SurfaceHolder surfaceHolder, Resources resources) {
        this.surfaceHolder = surfaceHolder;
        h = resources.getDisplayMetrics().heightPixels;
        w = resources.getDisplayMetrics().widthPixels;
        x = 0;
        y = 0;
        radius = w / 10;
    }

    public void setRunning(boolean b) {
        runFlag = b;
    }

    @Override
    public void run() {
        super.run();

        while (runFlag) {
            Canvas c = null;
            try {
                c = surfaceHolder.lockCanvas(null);
                Paint paint = new Paint();
                paint.setColor(Color.WHITE);
                synchronized (surfaceHolder) {
                    c.drawColor(Color.BLACK);
                    newpoint();
                    c.drawCircle(x, y, radius, paint);
                }
                sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (c != null) {
                    surfaceHolder.unlockCanvasAndPost(c);
                }
            }

        }
    }

    protected void newpoint() {
        int newX, newY;
        do {
            newX = randint(radius, w - radius);
            newY = randint(radius, h - radius);
        }
        while (Math.sqrt(Math.pow(x - newX, 2) + Math.pow(y - newY, 2)) < (h / 10));

        x = newX;
        y = newY;
    }

    protected int randint(int a, int b) {
        return (int) (Math.random() * (b - a + 1) + a);
    }
}

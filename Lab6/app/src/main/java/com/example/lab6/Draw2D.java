package com.example.lab6;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;


public class Draw2D extends View {

    private Paint mPaint = new Paint();

    public Draw2D(Context context) {
        super(context);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }


    public Bitmap MyDraw(Bitmap bmp, ImageView iv) {
        Canvas canvas = new Canvas(bmp);
        canvas.drawARGB(80, 102, 204, 255);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(5);
        Random rand;

        int r, g, b;

        rand = new Random();

        r = rand.nextInt(255);
        g = rand.nextInt(255);
        b = rand.nextInt(255);

        mPaint.setColor(Color.rgb(r, g, b));
        int w = rand.nextInt(200) + 200;                      // размеры квадратов
        float rx = (rand.nextFloat() * iv.getWidth());
        float ry = (rand.nextFloat() * iv.getHeight());
        float rw = rx + w;
        if (rw >= iv.getWidth()) {
            rx -= w + 50;
            rw -= w + 50;
        }
        float rh = ry - w;
        if (rh <= 0) {
            ry += w + 50;
            rh += w + 50;
        }

        canvas.drawRect(rx, ry, rw, rh, mPaint);

        for (int j = 1; j <= rand.nextInt(30) + 15; j++) {                // количество кругов

            rand = new Random();

            r = rand.nextInt();
            g = rand.nextInt();
            b = rand.nextInt();

            mPaint.setColor(Color.rgb(r, g, b));

            float cr = (rw - rx) * rand.nextFloat() / 8 + 5;                    // размеры кругов
            float x = rand.nextInt(Math.round(rw - rx)) + rx;
            if (x + cr >= rw)
                x = rw - cr - 5;
            if (x - cr <= rx)
                x = rx + cr + 5;
            float y = rand.nextInt(Math.round(ry - rh)) + rh;
            if (y + cr >= ry)
                y = ry - cr - 5;
            if (y - cr <= rh)
                y = rh + cr + 5;

            canvas.drawCircle(x, y, cr, mPaint);
        }


        return bmp;

    }


    public Bitmap CreateImage(ImageView iv) {

        Bitmap bmp = Bitmap.createBitmap(iv.getWidth(), iv.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmp);

        mPaint.setAntiAlias(true);

        mPaint.setStyle(Paint.Style.FILL);

        mPaint.setColor(Color.WHITE);
        canvas.drawPaint(mPaint);

        return bmp;

    }


}
package com.example.lab6;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.support.v7.app.AppCompatActivity;

import java.net.URI;


public class MainActivity extends AppCompatActivity  {

    private Draw2D draw2D;
    private ImageView myimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        draw2D = new Draw2D(this);
        myimage = (ImageView) findViewById(R.id.imageView);
    }

    public void button_click(View v) {

        Bitmap bmp = draw2D.CreateImage(myimage);
        bmp = draw2D.MyDraw(bmp, myimage);

        myimage.setImageBitmap(bmp);
    }
}


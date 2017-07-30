package com.example.abolfazl.test.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

/**
 * Created by abolfazl on 7/30/2017.
 */

public class drawtheball extends View  {
    Paint blue;
    Rect ourRect;

    public drawtheball(Context context) {
        super(context);
        init();
    }

    private void init(){
        ourRect = new Rect();

        blue = new Paint();
        blue.setColor(Color.BLUE);
        blue.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        ourRect.set(canvas.getWidth()/10,canvas.getHeight()/10,canvas.getWidth()/5,canvas.getHeight()/5);


        canvas.drawRect(ourRect, blue);

    }


}

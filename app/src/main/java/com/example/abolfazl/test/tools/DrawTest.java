package com.example.abolfazl.test.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/**
 * Created by abolfazl on 7/30/2017.
 */

public class DrawTest extends View {

    private static final String TAG = "Desenho";

    private ShapeDrawable rectangle;
    private Paint paint;
    private float currX, currY;
    private Rect blue, gray;
    private float ax;
    private float ay;
    private float cx;
    private float cy;
    private float rcir;
    private float cax;
    private float cay;

    public DrawTest(Context context) {
        super(context);

        ax = 1;
        ay = 1;
        cx = 200;
        cy = 200;


        currX = 1;
        currY = 1;

        gray = new Rect(50,30,200,150);
        blue = new Rect(200,200,400,350);

        paint = new Paint();

        rectangle = new ShapeDrawable(new RectShape());
    }


    @Override
    public boolean isFocused() {
        Log.d(TAG, "View's On focused is called !");
        return super.isFocused();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        currX = event.getX();
        currY = event.getY();
        invalidate();

        Log.d(TAG, "View's On touch is called! X= "+currX + ", Y= "+currY);
        return super.onTouchEvent(event);
    }



    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        cax = canvas.getWidth();
        cay = canvas.getHeight();
        for (int i = 0; i < 100; i++) {
            if (cx == (canvas.getWidth() * 15) / 16 || cx == 0) {
                ax = ax * (-1);
            }
            if (cy == (canvas.getHeight() * 15) / 16 || cy == 0) {
                ay = ay * (-1);
            }
            cx = cx + ax;
            cy = cy + ay;
        }
        rcir = canvas.getHeight()/16;

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);


        //Custom View

        rectangle.getPaint().setColor(Color.BLUE);
        rectangle.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        rectangle.getPaint().setStrokeWidth(3);
        blue.set((int)(currX)-50, (int)(currY)-50, (int)(currX)+50, (int)(currY)+50);
        rectangle.setBounds(blue);
        blue = rectangle.getBounds();
        rectangle.draw(canvas);
        canvas.drawCircle(cx,cy,rcir,paint);
    }

    public void setX(float x){
        this.currX = x;
    }

    public void setY(float y){
        this.currY = y;
    }

}

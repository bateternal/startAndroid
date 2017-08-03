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
    private int speed;
    private int v0;
    private final int g = 10;
    private int at = 0;
    private int t = 0;
    float x;

    public DrawTest(Context context) {
        super(context);

        ax = 1;
        ay = 1;
        cx = 200;
        cy = 200;


        currX = 1;
        currY = 200;

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
        at = at + 1;

        t = t + 1;

        cax = canvas.getWidth();
        cay = canvas.getHeight();

        v0 = (canvas.getHeight()-blue.centerY())/10;
        x = ((-1) * (float)g * (float)t * (float)t)/2 + (float)v0 * (float)t;
        cy = canvas.getHeight()-x;
        cx = 500;
        if(x>(canvas.getHeight()*17)/18 || x<0)t=0;
        rcir = canvas.getHeight()/16;

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);


        if(currY>cy-2*rcir){
            currY=cy-2*rcir;
        }
        //Custom View

        rectangle.getPaint().setColor(Color.BLACK);
        rectangle.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        rectangle.getPaint().setStrokeWidth(3);
        blue.set(0, (int)(currY)-50, canvas.getWidth(), (int)(currY)+50);
        rectangle.setBounds(blue);
        blue = rectangle.getBounds();
        rectangle.draw(canvas);
        canvas.drawCircle(cx,cy,rcir,paint);
        paint.setColor(Color.WHITE);
        paint.setTextSize(40);
        canvas.drawText(String.valueOf(v0),canvas.getWidth()/2,currY,paint);
        postInvalidate();

    }

    public void setX(float x){
        this.currX = x;
    }

    public void setY(float y){
        this.currY = y;
    }

    public float getX(){
        return currX;
    }

    public float getY(){
        return currY;
    }

    public  float getRcir(){
        if(cy>rcir) return cy-2*rcir;
        else return 0;
    }

    public void setSpeed(){
        speed = (speed +93)%526;
    }

}

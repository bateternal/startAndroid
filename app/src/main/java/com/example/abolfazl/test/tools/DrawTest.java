package com.example.abolfazl.test.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;


import java.util.Random;




public class DrawTest extends View {

    private static final String TAG = "Desenho";

    private ShapeDrawable rectangle;
    private Paint paint;
    private Rect blue;
    private float cx = 200;
    private float cy = 200;
    private float rcir;
    private int v0;
    private int at = 0;
    private int t = 0;
    float x;
    private float rectX;
    private float rectY;
    private float rectLocate;
    Random rand = new Random();
    private float speedi = 15;
    public int score = 1;
    int sh = 0;
    float x0 = 0;
    int eybaba;
    private int page = 1;
    private float size;
    private float width;
    private int BestScore = 0 ;
    private Context conText;


    public void design(){
        paint = new Paint();
        blue = new Rect(200,200,400,350);
        rectangle = new ShapeDrawable(new RectShape());
    }

    public DrawTest(Context context) {
        super(context);
        conText = context;
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(conText);
        BestScore = sp.getInt("best", 0);
        design();
    }


    @Override
    public boolean isFocused() {
        Log.d(TAG, "View's On focused is called !");
        return super.isFocused();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }



    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        switch (page){
            case 1:
                Menu(canvas);
                break;
            case 2:
                Game(canvas);
                break;
            case 3:
                GameOver(canvas);
                break;
        }
        postInvalidate();
    }

    public void GameOver(Canvas canvas){

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(conText);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("best",BestScore);
        editor.apply();

        paint.setColor(Color.BLACK);
        rectangle.draw(canvas);
        canvas.drawCircle(cx,cy,rcir,paint);
        canvas.drawRect(rectLocate,canvas.getHeight()-rectY,rectLocate+rectX,canvas.getHeight(),paint);
        canvas.drawRect(rectLocate,0,rectLocate+rectX,canvas.getHeight()-3*rectY,paint);
        paint.setColor(Color.WHITE);
        paint.setTextSize(canvas.getWidth()/27);
        canvas.drawText("your score : " + String.valueOf(score),canvas.getWidth()/2-canvas.getWidth()/50,canvas.getHeight()/20,paint);
        paint.setColor(Color.RED);
        paint.setTextSize(canvas.getWidth()/6);
        canvas.drawText("GAME OVER",canvas.getWidth()/20,canvas.getHeight()/2,paint);
        paint.setColor(Color.GRAY);
        canvas.drawRect(canvas.getWidth()/3,6*size,(canvas.getWidth()*2)/3,7*size,paint);
        paint.setColor(Color.BLACK);
        paint.setTextSize(canvas.getWidth()/13);
        canvas.drawText("OK!",canvas.getWidth()/2-canvas.getWidth()/20,(13*size)/2,paint);
    }

    private void Menu(Canvas canvas){
        size = canvas.getHeight()/8;
        width = canvas.getWidth()/3;
        paint.setColor(Color.GRAY);
        canvas.drawRect(width,1*size,2*width,2*size,paint);
        canvas.drawRect(width,3*size,2*width,4*size,paint);
        canvas.drawRect(width,5*size,2*width,6*size,paint);
        paint.setColor(Color.BLACK);
        paint.setTextSize(canvas.getWidth()/13);
        canvas.drawText("start",width+canvas.getWidth()/12,(size*3)/2+size/10,paint);
        paint.setColor(Color.GRAY);
        canvas.drawText("Best Score : "+String.valueOf(BestScore),canvas.getWidth()/20,(canvas.getHeight()*19)/20,paint);
    }

    private void Game(Canvas canvas){
        start(canvas);
        tools(canvas);
        drawshape(canvas);
    }

    private void start(Canvas canvas){
        if(at==0){
            rectLocate = canvas.getWidth();
            rectX = (float)rand.nextInt(canvas.getWidth()/6-canvas.getWidth()/18);
            rectY = (float)rand.nextInt(canvas.getHeight()/2 - canvas.getHeight()/8) + canvas.getHeight()/8;
            eybaba = canvas.getHeight()/3-rand.nextInt(canvas.getHeight()/5);
            score = 0;
            x0 = 0;
            speedi = 15;
        }
    }

    private void tools(Canvas canvas){
        if(BestScore < score){
            BestScore = score;
            SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(conText);
            SharedPreferences.Editor editor = sp.edit();
            editor.putInt("best",BestScore);
            editor.apply();
        }
        at = at + 1;
        if(at%500==0){speedi = speedi+1;}
        if(at>100) {rectLocate = rectLocate - speedi;}
        if(rectLocate < (-1)*rectX){
            rectLocate = canvas.getWidth();
            rectX = (float)rand.nextInt(canvas.getWidth()/2-canvas.getWidth()/8);
            rectY = (float)rand.nextInt(canvas.getHeight()/2 - canvas.getHeight()/8) + canvas.getHeight()/8;
            sh = 0;
        }
        if(v0!=0) {t = t + 1;}
        if((rectY > x || x > 3*rectY)  && cx > rectLocate - rcir && cx < rectLocate + rcir + rectX){
            t = 0;
            v0 = 0;
            at = 0;
            page = 3;
        }
        if(cx > rectLocate - rcir && cx < rectLocate + rcir + rectX && rectY < x && x < 3*rectY && sh == 0){
            score = score + 1;
            sh = sh + 1;
        }
        x = ((-1) * 5 * (float)t * (float)t)/2 + (float)v0 * (float)t + x0;
        cy = canvas.getHeight()-x;
        cx = 500;
        if(x<0){
            t = 0;
            v0 = 0;
            x0 = 0;
        }
    }

    private void drawshape(Canvas canvas){
        rcir = canvas.getHeight()/32;

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);

        //Custom View

        rectangle.getPaint().setColor(Color.BLACK);
        rectangle.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        rectangle.getPaint().setStrokeWidth(3);
        blue.set(0, 150, canvas.getWidth(), 250);
        rectangle.setBounds(blue);
        blue = rectangle.getBounds();
        rectangle.draw(canvas);
        paint.setColor(Color.GRAY);
        canvas.drawCircle(cx,cy,rcir,paint);
        paint.setColor(Color.BLACK);
        canvas.drawRect(rectLocate,canvas.getHeight()-rectY,rectLocate+rectX,canvas.getHeight(),paint);
        canvas.drawRect(rectLocate,0,rectLocate+rectX,canvas.getHeight()-3*rectY,paint);
        paint.setColor(Color.WHITE);
        paint.setTextSize(canvas.getWidth()/27);
        canvas.drawText("best score : "+String.valueOf(BestScore),canvas.getWidth()/2,canvas.getHeight()/20,paint);
        canvas.drawText("score : " + String.valueOf(score),canvas.getWidth()/10,canvas.getHeight()/20,paint);
    }

    public void setx0(){
        x0 = x;
        t = 0;
        v0 = 50;
    }

    public void changePage(int p){
        page = p;
    }

    public int getPage(){
        return page;
    }

    public float getSize(){
        return size;
    }

    public float getwidth(){
        return width;
    }
}

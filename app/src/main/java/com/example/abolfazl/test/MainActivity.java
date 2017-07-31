package com.example.abolfazl.test;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abolfazl.test.tools.DrawTest;


public class MainActivity extends Activity {



    DrawTest v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        v = new DrawTest(this);
        setContentView(v);




    }



//    @Override
//    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
//        //buckysMessage.setText("onSingleTapConfirmed");
//        return false;
//    }
//
//    @Override
//    public boolean onDoubleTap(MotionEvent motionEvent) {
//        //buckysMessage.setText("onDoubleTap");
//        return false;
//    }
//
//    @Override
//    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
//        //buckysMessage.setText("onDoubleTapEvent");
//        return true;
//    }
//
//    @Override
//    public boolean onDown(MotionEvent motionEvent) {
//        //buckysMessage.setText("onDown");
//        return false;
//    }
//
//    @Override
//    public void onShowPress(MotionEvent motionEvent) {
//        //buckysMessage.setText("onShowPress");
//    }
//
//    @Override
//    public boolean onSingleTapUp(MotionEvent motionEvent) {
//        //buckysMessage.setText("onSingleTapUp");
//        return false;
//    }
//
//    @Override
//    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
//        //buckysMessage.setText("onScroll");
//        return false;
//    }
//
//    @Override
//    public void onLongPress(MotionEvent motionEvent) {
//        //buckysMessage.setText("onLongPress");
//    }
//
//    @Override
//    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
//        //buckysMessage.setText("onFling");
//        return false;
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return false;
//    }
//
//    ////////////////// End Gestures ///////////////////
//
//
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        this.gestureDetector.onTouchEvent(event);
//        try {
//            int a = (int) event.getX();
//            int a2 = (int) event.getY();
//            String s2 = String.valueOf(a2);
//            String s = String.valueOf(a);
//            String s3 = s + " " + s2;
//            v.setText(s3);
//
//        }
//        catch (Exception e){}
//        return super.onTouchEvent(event);
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}

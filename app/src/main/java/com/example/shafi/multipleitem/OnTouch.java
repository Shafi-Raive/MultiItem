package com.example.shafi.multipleitem;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;


public class OnTouch {

    public  static float xAxis = 0f;
    public  static float yAxis = 0f;
    public  static float lastYAxis = 0f;
    public  static float lastXAxis = 0f;
    public  static  boolean changeActivity = false;

    public boolean onTouch(View v, MotionEvent event) {
        final  int actionPeformed = event.getAction();

        MultipleSelectionActivity multipleSelectionActivity;

        switch(actionPeformed){
            case MotionEvent.ACTION_DOWN:{
                final float x = event.getX();
                final float y = event.getY();

                lastXAxis = Float.parseFloat(Float.toString(x));
                lastYAxis = Float.parseFloat(Float.toString(y));

//                            valuX.setText("X:"+Float.toString(lastXAxis));
//                            moveX.setText("Y:"+Float.toString(lastYAxis));

                Log.d("tag", "X :"+lastXAxis);
                Log.d("tag", "Y :"+lastYAxis);

                break;
            }

            case MotionEvent.ACTION_MOVE:{
                final float x = event.getX();
                final float y = event.getY();

                final float dx = x - lastXAxis;
                final float dy = y - lastYAxis;

                xAxis += dx;
                yAxis = dy;




//                Log.d("tag", "MOV X :"+Float.toString(xAxis));
//                yAxis = height - yAxis;
                Log.d("tag", "MOV Y :"+Float.toString(yAxis));
                break;


            }
        }
        return true;
    }




}

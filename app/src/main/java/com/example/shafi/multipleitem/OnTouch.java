package com.example.shafi.multipleitem;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class OnTouch {

    public boolean onTouch(View v, MotionEvent event) {
        final  int actionPeformed = event.getAction();
        float xAxis = 0f;
        float yAxis = 0f;

        float lastXAxis = 0f;
        float lastYAxis = 0f;
        switch(actionPeformed){
            case MotionEvent.ACTION_DOWN:{
                final float x = event.getX();
                final float y = event.getY();

                lastXAxis = x;
                lastYAxis = y;

//                            valuX.setText("X:"+Float.toString(lastXAxis));
//                            moveX.setText("Y:"+Float.toString(lastYAxis));

                Log.d("tag", "X :"+Float.toString(lastXAxis));
                Log.d("tag", "Y :"+Float.toString(lastYAxis));

                break;
            }

            case MotionEvent.ACTION_MOVE:{
                final float x = event.getX();
                final float y = event.getY();

                final float dx = x - lastXAxis;
                final float dy = y - lastYAxis;

                xAxis += dx;
                yAxis += dy;
                // yAxis = 500000 + yAxis;


//                            valuX.setText("Move_X:"+Float.toString(xAxis));
//                            moveX.setText("Move_Y:"+Float.toString(yAxis));



                Log.d("tag", "MOV X :"+Float.toString(xAxis));
                Log.d("tag", "MOV Y :"+Float.toString(yAxis));
                break;


            }
        }
        return true;
    }

    public void touchValue(){

    }

}

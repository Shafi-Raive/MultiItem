package com.example.shafi.multipleitem.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.shafi.multipleitem.OnTouch;
import com.example.shafi.multipleitem.R;
import com.example.shafi.multipleitem.model.Employee;

import java.util.ArrayList;

public class MultiAdapter extends RecyclerView.Adapter<MultiAdapter.MultiViewHolder> {

    private Context context;
    private ArrayList<Employee> employees;
    ArrayList<Integer> listPosition = new ArrayList<>();
    int x,y,z;

    public static boolean item = false;

    public MultiAdapter(Context context, ArrayList<Employee> employees) {
        this.context = context;
        this.employees = employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = new ArrayList<>();
        this.employees = employees;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MultiViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_employee, viewGroup, false);
        return new MultiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MultiViewHolder multiViewHolder, int position) {
        Employee employee = employees.get(position);
        multiViewHolder.textView.setText(employee.getName());
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    class MultiViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        private ImageView imageView;
        private LinearLayout parentLayout;


        @SuppressLint("ClickableViewAccessibility")
        MultiViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
//            imageView = itemView.findViewById(R.id.imageView);
            parentLayout = itemView.findViewById(R.id.parentLayout);

            boolean item = true;
            boolean item1 = false;

//            if(item){
//                item1 = true;
//
//                parentLayout.setOnTouchListener(new View.OnTouchListener() {
//                    @Override
//                    public boolean onTouch(View v, MotionEvent event) {
//
//                        listPosition.add(getPosition());
//                         x = listPosition.get(0);
//                         y = listPosition.get(listPosition.size() -1);
//                         z = x + 1;
//
//                        Log.d("tag","arrayList"+ listPosition);
//                        Log.d("tag","first"+ x);
//                        Log.d("tag","last"+ y);
////                    Log.d("tag7","Z"+ z);
//
//                        if(listPosition.size() == 10) {
//                            listPosition.clear();
//
//                        }else {
//                            Log.d("tag","Wrong button click");
//                        }
//
//
//                        return true;
//                    }
//                });
//
//            }else if(item1){
//
//                parentLayout.setOnTouchListener(new View.OnTouchListener() {
//                    @Override
//                    public boolean onTouch(View v, MotionEvent event) {
//
//                        listPosition.add(getPosition());
////                        int x = listPosition.get(0);
////                        int y = listPosition.get(listPosition.size() -1);
////                        int z = x + 1;
//
//                        if(z == y){
//                            Log.d("tag","Ok");
//                            v.setOnTouchListener(  new View.OnTouchListener() {
//                                @Override
//                                public boolean onTouch(View v, MotionEvent event) {
//
//                                    Log.d("tag","first"+ getPosition());
//
//                                    OnTouch touch = new OnTouch();
//                                    touch.onTouch(v,event);
//                                    return true;
//                                }
//                            });
//
//                        }else if(listPosition.size() == 10) {
//                            listPosition.clear();
//
//                        }else {
//                            Log.d("tag","Wrong button click");
//                        }
//
//                        return false;
//                    }
//                });
//
//            }



            if(item){
                item1 = true;

                parentLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        listPosition.add(getPosition());
                    int x = listPosition.get(0);
                    int y = listPosition.get(listPosition.size() -1);
                    int z = x + 1;

                        Log.d("tag","arrayList"+ listPosition);
                    Log.d("tag","first"+ x);
                    Log.d("tag","last"+ y);
//                    Log.d("tag7","Z"+ z);


                    if(z == y){
                        Log.d("tag","Ok");
                        v.setOnTouchListener(  new View.OnTouchListener() {
                            @Override
                            public boolean onTouch(View v, MotionEvent event) {

                                Log.d("tag","first"+ getPosition());

                                OnTouch touch = new OnTouch();
                                touch.onTouch(v,event);
                                return true;
                            }
                        });

                    }else if(listPosition.size() == 4) {
                        listPosition.clear();
//                        Log.d("tag7","Not Ok");
//                        Toast.makeText(context, "not listed", Toast.LENGTH_SHORT).show();
                    }else {
                        Log.d("tag","Wrong button click");
                    }

                    }
                });


            }



        }




//        void bind(final Employee employee) {
//            imageView.setVisibility(employee.isChecked() ? View.VISIBLE : View.GONE);
//            textView.setText(employee.getName());
//
//        }
    }

    public ArrayList<Employee> getAll() {
        return employees;
    }

    public ArrayList<Employee> getSelected() {
        ArrayList<Employee> selected = new ArrayList<>();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).isChecked()) {
                selected.add(employees.get(i));
            }
        }
        return selected;
    }

}

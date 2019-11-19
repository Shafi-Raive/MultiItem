package com.example.shafi.multipleitem.adapter;

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

    public static boolean item = false;
    String id;
    int f;

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


        MultiViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imageView);
            parentLayout = itemView.findViewById(R.id.parentLayout);

            parentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("tagposition",getPosition()+"");
                    OnTouch touch = new OnTouch();
                    touch.onTouch(v,event);
                    return true;
                }
            });

//            parentLayout.setOnTouchListener(new View.OnTouchListener() {
//                @Override
//                public boolean onTouch(View v, MotionEvent event) {
//
//                    OnTouch touch = new OnTouch();
//                    touch.onTouch(v,event);
//                    return true;
//                }
//            });
        }




        void bind(final Employee employee) {
            imageView.setVisibility(employee.isChecked() ? View.VISIBLE : View.GONE);
            textView.setText(employee.getName());

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//                        employee.setChecked(!employee.isChecked());
//                        imageView.setVisibility(employee.isChecked() ? View.VISIBLE : View.GONE);
//
//
//                }
//            });

//            itemView.setOnTouchListener(new View.OnTouchListener() {
//                @Override
//                public boolean onTouch(View v, MotionEvent event) {
//
//                    OnTouch touch = new OnTouch();
//                    touch.onTouch(v,event);
//                    return true;
//                }
//            });


        }
    }

    public ArrayList<Employee> getAll() {
        return employees;
    }

//    public ArrayList<Employee> getSelected() {
//        ArrayList<Employee> selected = new ArrayList<>();
//        for (int i = 0; i < employees.size(); i++) {
//            if (employees.get(i).isChecked()) {
//                selected.add(employees.get(i));
//            }
//        }
//        return selected;
//    }

    public ArrayList<Employee> getSelected() {
        ArrayList<Employee> selected = new ArrayList<>();
        ArrayList<Employee> selectedItem = new ArrayList<>();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).isChecked()) {
                selected.add(employees.get(i));
                id = String.valueOf(selectedItem.add(employees.get(i)));
                f = Integer.parseInt(id + 1);
                item = true;
                break;
            }if(item){
                selected.add(employees.get(f));
                Toast.makeText(context, "second selected", Toast.LENGTH_SHORT).show();

            }else {
                Toast.makeText(context, "no selected", Toast.LENGTH_SHORT).show();
            }

        }
        return selected;
    }
}

package com.example.shafi.multipleitem;

import android.content.DialogInterface;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Toast;

import com.example.shafi.multipleitem.adapter.MultiAdapter;
import com.example.shafi.multipleitem.model.Employee;

import java.util.ArrayList;

import static com.example.shafi.multipleitem.OnTouch.changeActivity;
import static com.example.shafi.multipleitem.OnTouch.xAxis;
import static com.example.shafi.multipleitem.OnTouch.yAxis;
import static com.example.shafi.multipleitem.config.height;

public class MultipleSelectionActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Employee> employees = new ArrayList<>();
    private MultiAdapter adapter;
    private AlertDialog.Builder alertdialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_selection);
        this.recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        getSupportActionBar().setTitle("Multiple Selection");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        adapter = new MultiAdapter(this, employees);
        recyclerView.setAdapter(adapter);

        createList();
        size();
        changeActivity();

    }

    private void changeActivity() {

        if(yAxis > 8){
            alertdialogBuilder = new AlertDialog.Builder(MultipleSelectionActivity.this);

            alertdialogBuilder.setTitle(R.string.alert_title);
            alertdialogBuilder.setMessage(R.string.alert_message);
            alertdialogBuilder.setIcon(R.drawable.ic_launcher_foreground);

            alertdialogBuilder.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });

            alertdialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();

                }
            });

            AlertDialog alertDialog = alertdialogBuilder.create();
            alertDialog.show();

        }else {
            Log.d("tag", "Nothing");
        }


    }

    private void createList() {
        employees = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Employee employee = new Employee();
            employee.setName("Employee " + (i + 1));
            // for example to show at least one selection
            if (i == 0) {
                employee.setChecked(true);
            }
            //
            employees.add(employee);
        }
        adapter.setEmployees(employees);
    }

    public void size(){
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
//        int width = size.x;
         height = size.y;

        Log.d("size",""+ height);
//        Log.d("size", ""+width);
    }

}

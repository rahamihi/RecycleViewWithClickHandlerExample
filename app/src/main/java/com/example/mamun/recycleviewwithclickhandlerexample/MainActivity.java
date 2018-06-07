package com.example.mamun.recycleviewwithclickhandlerexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> listname = new ArrayList<>();
    private List<String> listdesignation = new ArrayList<>();
    private RecycleViewAdapter recycleViewAdapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupContact();
        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        RecycleViewAdapter adapter = new RecycleViewAdapter(listname,listdesignation,this);
        recyclerView.setAdapter(adapter);




    }

    private void setupContact(){

        for (int i=0;i<20;i++){
            listname.add("mamun"+i);
            listdesignation.add("Senior Engineer" + i);
        }


    }
}

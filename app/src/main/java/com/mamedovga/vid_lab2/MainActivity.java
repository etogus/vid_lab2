package com.mamedovga.vid_lab2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String namesArr[] = {"Jack", "Ann", "Sophie", "Bruce", "Luke", "Nina"};
    private int imagesArr[] = {R.drawable.avatar, R.drawable.cpp};
    private List<String> items;
    private List<Integer> images;
    private int counter = 0;

    private RecyclerView recyclerView;

    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        items = new LinkedList<>();
        images = new LinkedList<>();

        MyAdapter myAdapter = new MyAdapter(this, items, images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        addButton = findViewById(R.id.add);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.add(namesArr[counter%6]);
                images.add(imagesArr[counter%2]);
                counter++;
                myAdapter.notifyItemInserted(items.size()-1);
            }
        });
    }
}
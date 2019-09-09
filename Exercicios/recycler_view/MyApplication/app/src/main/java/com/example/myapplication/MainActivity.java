package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private LineAdapter lineAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager( this);
        recyclerView.setLayoutManager(layoutManager);
        lineAdapter = new LineAdapter( new ArrayList( 0));
        recyclerView.setAdapter(lineAdapter);


        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(view -> insertItem());
    }

    public void insertItem() {
        UserModel model = new UserModel();
        model.setName( "Anderson");
        model.setAge( 28);
        model.setCity( "Fortaleza");
        lineAdapter.insertItem(model);
    }
}

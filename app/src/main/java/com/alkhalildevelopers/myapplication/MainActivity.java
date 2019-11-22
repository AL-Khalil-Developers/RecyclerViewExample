package com.alkhalildevelopers.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyAdapter.OnBtnClickListener {
    RecyclerView myRecyclerView;
    List<MyModel> myModelList;
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myRecyclerView = findViewById(R.id.mainRecyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myRecyclerView.setLayoutManager(layoutManager);

        myModelList = new ArrayList<>();
        myModelList.add(new MyModel("Welcome to Pakistan"));
        myModelList.add(new MyModel("Welcome to AL-Khalil Developers"));
        myModelList.add(new MyModel("Welcome to Pakistan"));
        myModelList.add(new MyModel("Welcome to Pakistan"));
        myModelList.add(new MyModel("Welcome to Pakistan"));
        myModelList.add(new MyModel("Welcome to Pakistan"));
        myModelList.add(new MyModel("Welcome to Pakistan"));
        myModelList.add(new MyModel("Welcome to Pakistan"));

        myAdapter = new MyAdapter(myModelList,this);

        myRecyclerView.setAdapter(myAdapter);

    }

    @Override
    public void onShareBtnClick(int position) {
        String selectedText = myModelList.get(position).getTextLine();
        Toast.makeText(this, selectedText, Toast.LENGTH_SHORT).show();
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_TEXT,selectedText);
        startActivity(share);

    }

    @Override
    public void onDeleteBtnClick(int position) {
        myModelList.remove(position);
        myAdapter.notifyItemRemoved(position);

    }
}

package com.example.myapplication2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        List<Country> countries = getListData();
        this.recyclerView = (RecyclerView) this.findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new CustomRecyclerViewAdapter(this, countries));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private  List<Country> getListData() {
        List<Country> list = new ArrayList<Country>();
        Country vietnam = new Country("Vietnam", "vn");
        Country usa = new Country("United States", "us");
        Country russia = new Country("Russia", "ru");
        Country australia = new Country("Australia", "au");
        Country japan = new Country("Japan", "jp");

        list.add(vietnam);
        list.add(usa);
        list.add(russia);
        list.add(australia);
        list.add(japan);

        list.add(vietnam);
        list.add(usa);
        list.add(russia);
        list.add(australia);
        list.add(japan);

        return list;
    }


}
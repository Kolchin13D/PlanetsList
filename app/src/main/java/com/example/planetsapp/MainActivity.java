package com.example.planetsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    ListView listview;
    ArrayList<Planet> planetsArray;
    private static myAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //data array
        planetsArray = new ArrayList<>();

        Planet planet1 = new Planet("earth", "1 Moons", R.drawable.earth);
        Planet planet2 = new Planet("mars", "2 Moons", R.drawable.mars);
        Planet planet3 = new Planet("jupiter", "79 Moons", R.drawable.jupiter);
        Planet planet4 = new Planet("mercury", "0 Moons", R.drawable.mercury);
        Planet planet5 = new Planet("neptune", "14 Moons", R.drawable.neptune);
        Planet planet6 = new Planet("saturn", "83 Moons", R.drawable.saturn);
        Planet planet7 = new Planet("uranus", "27 Moons", R.drawable.uranus);
        Planet planet8 = new Planet("venus", "0 Moons", R.drawable.venus);

        planetsArray.add(planet1);
        planetsArray.add(planet4);
        planetsArray.add(planet3);
        planetsArray.add(planet8);
        planetsArray.add(planet2);
        planetsArray.add(planet5);
        planetsArray.add(planet7);
        planetsArray.add(planet6);

        Collections.sort(planetsArray, Comparator.comparing(Planet::getName));
        //Collections.reverse(planetsArray);

        //adapter
        listview = findViewById(R.id.list);
        myAdapter adapter = new myAdapter(planetsArray, getApplicationContext());

        //link listliew with adapter
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,
                        "You select " + adapter.getItem(position).getName().toUpperCase(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
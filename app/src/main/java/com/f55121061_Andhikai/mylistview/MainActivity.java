package com.f55121061_Andhikai.mylistview;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private HeroAdapter adapter;
    private ArrayList<hero> heroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new HeroAdapter(this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);
        prepare();
        additem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> adapterView,
         View view, int i, long l) {
         Toast.makeText(MainActivity.this,
         heroes.get(i).getName(), Toast.LENGTH_SHORT).show();
          }
       });

    }
    private void prepare() {
        dataName =
                getResources().getStringArray(R.array.data_name);
        dataDescription =
                getResources().getStringArray(R.array.data_description);
        dataPhoto =
                getResources().obtainTypedArray(R.array.data_photo);
    }
    private void additem() {
        heroes = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            hero hero = new hero();
            hero.setPhoto(dataPhoto.getResourceId(i, -1));
            hero.setName(dataName[i]);
            hero.setDescription(dataDescription[i]);
            heroes.add(hero);
        }
        adapter.setHeroes(heroes);

    }
}
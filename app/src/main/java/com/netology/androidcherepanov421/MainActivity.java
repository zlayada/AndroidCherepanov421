package com.netology.androidcherepanov421;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final List<Sample> mSamples = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mToolBar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolBar);

        prepareSamples();
        BaseAdapter mSampleAdapter = new SampleAdapter(MainActivity.this, mSamples);

        ListView mSamplesList = findViewById(R.id.sheetView);
        mSamplesList.setAdapter(mSampleAdapter);
        mSamplesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(mSamples.get(i).getIntent());
            }
        });
    }



    private void prepareSamples() {

        mSamples.clear();

        mSamples.add(new Sample(getString(R.string.tNote), getString(R.string.category_notes), getDrawable(R.drawable.pic_notes),
                new Intent(MainActivity.this, MainActivityNotes.class)));

        mSamples.add(new Sample(getString(R.string.tAdress), getString(R.string.categoty_adress), getDrawable(R.drawable.pic_adress),
                new Intent(MainActivity.this, MainActivitySpinner.class)));

        mSamples.add(new Sample(getString(R.string.tTask), getString(R.string.category_task), getDrawable(R.drawable.pic_task),
                new Intent(MainActivity.this, MainActivityTask.class)));

    }
}
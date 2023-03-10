package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PhotoData.init(getApplicationContext());

        gridView = findViewById(R.id.grid_view);
        PhotoAdapter adapter = new PhotoAdapter(PhotoData.readPhotoJSONFile(), getApplicationContext());
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getApplicationContext(), DisplayActivity.class);
        intent.putExtra("id", gridView.getAdapter().getItemId(position));
        startActivity(intent);
    }
}
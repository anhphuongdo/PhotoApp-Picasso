package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONException;

import java.io.IOException;

public class DisplayActivity extends AppCompatActivity {

    TextView tvTitle, tvDescription;
    ImageView imvDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        tvTitle = findViewById(R.id.tv_detail_title);
        tvDescription = findViewById(R.id.tv_detail_description);
        imvDetail = findViewById(R.id.imv_detail);

        int id = (int) getIntent().getLongExtra("id", 0);
            Picasso.get().load(PhotoData.getPhotoFromId(id).getSource_photo()).into(imvDetail);
            tvDescription.setText(PhotoData.getPhotoFromId(id).getDescription_photo());
            tvTitle.setText(PhotoData.getPhotoFromId(id).getTitle_photo());
    }
}
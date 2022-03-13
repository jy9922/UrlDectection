package com.example.ursafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class UrlextractionActivity extends AppCompatActivity {

    private TextView urlView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urlextraction);

        urlView = (TextView) findViewById(R.id.checkViewUrlText);

        String extracted_url;

        Intent intent = getIntent();
        extracted_url = intent.getStringExtra("url");

        urlView.setText(extracted_url);

    }
}
package com.example.ursafe;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UrlSafe extends AppCompatActivity {
    private TextView urlView;
    public String url2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detectsafe);
        urlView = (TextView) findViewById(R.id.checkViewUrlText);
        Intent intent = getIntent();
        url2 = ((ScanQR) ScanQR.context_main).url;
        urlView.setText(url2);
    }
}

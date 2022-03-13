package com.example.ursafe;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UrlDetection extends AppCompatActivity {
    private TextView urlView;
    public String url2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detectstart);
        urlView = (TextView) findViewById(R.id.checkViewUrlText);
        Intent intent = getIntent();
        url2 = ((ScanQR) ScanQR.context_main).url;
        urlView.setText(url2);

        new Handler().postDelayed(new Runnable() {// 0.5 초 후에 실행
            @Override
            public void run() {
                // 실행할 동작 코딩
                Intent intent = new Intent(UrlDetection.this,UrlSafe.class);
                startActivity(intent);

            }
        }, 500);

    }

}


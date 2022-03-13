package com.example.ursafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import org.tensorflow.lite.Interpreter;

public class Camera extends AppCompatActivity {

    private ImageView cameraBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        cameraBtn = (ImageView) findViewById(R.id.camera_button);

        cameraBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(Camera.this,ScanQR.class);
                startActivity(intent);
            }
        });
    }
}
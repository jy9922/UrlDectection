package com.example.ursafe;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.tensorflow.lite.Interpreter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;


public class ModelActivity extends AppCompatActivity {

    // 모델 파일 인터프리터를 생성하는 공통 함수
    private Interpreter getTfliteInterpreter(String modelPath) {
        try {
            return new Interpreter(loadModelFile(ModelActivity.this, modelPath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 모델을 읽어오는 함수.
    // MappedByteBuffer 바이트 버퍼를 Interpreter 객체에 전달
    private MappedByteBuffer loadModelFile(Activity activity, String modelPath) throws IOException {
        AssetFileDescriptor fileDescriptor = activity.getAssets().openFd(modelPath);
        FileInputStream inputStream = new FileInputStream(fileDescriptor.getFileDescriptor());
        FileChannel fileChannel = inputStream.getChannel();
        long startOffset = fileDescriptor.getStartOffset();
        long declaredLength = fileDescriptor.getDeclaredLength();
        return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength);
    }

    // input, output
    float[][] input = new float[1][12];
    float[][] output = new float[1][1];

    Interpreter tflite = getTfliteInterpreter("converted_model.tflite");

    //url 분류 코드
    private TextView urlView;
    public String url2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urlextraction);

        urlView = (TextView) findViewById(R.id.checkViewUrlText);

        Intent intent = getIntent();
        url2 = ((ScanQR) ScanQR.context_main).url;

        urlView.setText(url2);

        // 인텐트의 결과는 onActivityResult 함수에서 수신.
        // 여러 개의 인텐트를 동시에 사용하기 때문에 숫자를 통해 결과 식별(FROM_ALBUM 등등)
        findViewById(R.id.qr_check_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ModelActivity.this,UrlDetection.class);
                startActivity(intent);
            }
        });
    }
}



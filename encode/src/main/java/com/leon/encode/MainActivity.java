package com.leon.encode;

import android.os.SystemClock;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mEditText;

    static {
        System.loadLibrary("encode");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = (EditText) findViewById(R.id.text);
    }

    public void encode(View view) {
        String msg = mEditText.getText().toString().trim();
        String result= encode(msg);
        mEditText.setText(result);
    }


    public void decode(View view) {
        String msg = mEditText.getText().toString().trim();
        String result = decode(msg);
        mEditText.setText(result);
    }

    public native String encode(String text);

    public native String decode(String text);
}

package com.leon.app3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("hello");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, hello(),Toast.LENGTH_SHORT).show();
    }

    public native String hello();
    public native String hello1();
    public native String hello2();
    public native String hello3();
    public native String hello4();
    public native String hello5();
    public native String hello6();

}

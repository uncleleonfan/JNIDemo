package com.leon.calljava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("calljava");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public native void callC();

    public void startCallC(View view) {
        callC();
    }

    public void calledByC() {
        Toast.makeText(this, "Called by C", Toast.LENGTH_SHORT).show();
    }

}

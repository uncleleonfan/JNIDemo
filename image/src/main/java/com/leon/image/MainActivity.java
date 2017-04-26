package com.leon.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.mt.mtxx.image.JNI;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    public static int[] arr = {1, 2, 3, 4, 5, 6};
    ImageView mImageView;
/*
    static {
        System.loadLibrary("image");
    }*/


    static
    {
        System.loadLibrary("mtimage-jni");
    }

    private Bitmap mBitmap;
    private JNI mJni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*        transferArray(arr);
        for (int i = 0; i < arr.length; i++) {
            Log.d(TAG, "onCreate: " + arr[i]);
        }*/
        mImageView = (ImageView) findViewById(R.id.image);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.timg);
        mImageView.setImageBitmap(mBitmap);

        mJni = new JNI();

    }

    public void onStartProcess(View view) {
        int[] pixels = new int[mBitmap.getWidth() * mBitmap.getHeight()];
        mBitmap.getPixels(pixels, 0, mBitmap.getWidth(), 0, 0, mBitmap.getWidth(), mBitmap.getHeight());
        mJni.StyleLomoB(pixels, mBitmap.getWidth(), mBitmap.getHeight());
        Bitmap bitmap = Bitmap.createBitmap(pixels, mBitmap.getWidth(), mBitmap.getHeight(), mBitmap.getConfig());
        mImageView.setImageBitmap(bitmap);
    }

//    public native void transferArray(int[] array);


}

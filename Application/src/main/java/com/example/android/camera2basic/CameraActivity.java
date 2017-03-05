package com.example.android.camera2basic;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import java.io.InputStream;

public class CameraActivity extends Activity {
    private FaceOverlayView mFaceOverlayView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        mFaceOverlayView = (FaceOverlayView) findViewById( R.id.container );
        InputStream stream = getResources().openRawResource( R.raw.face );
        Bitmap bitmap = BitmapFactory.decodeStream(stream);
        mFaceOverlayView.setBitmap(bitmap);


        if (null == savedInstanceState) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.container, Camera2BasicFragment.newInstance())
                    .commit();
        }
    }

}
package com.extreme.ui.functionActivity.scan.camera;

import android.content.Context;
import android.hardware.Camera;

/**
 * Instructions :
 * Created by ZZ on 2018/4/4.
 */

public class PreviewCallback implements Camera.PreviewCallback {

    private static final String TAG = PreviewCallback.class.getSimpleName();

    private final Context context;

    public PreviewCallback(Context context) {
        this.context = context;
    }

    @Override
    public void onPreviewFrame(byte[] data, Camera camera) {

    }
}

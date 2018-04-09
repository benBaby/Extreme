package com.extreme.ui.functionActivity.scan.camera;

import android.content.Context;
import android.view.SurfaceHolder;

import com.extreme.ui.functionActivity.scan.camera.open.OpenCamera;
import com.extreme.ui.functionActivity.scan.camera.open.OpenCameraInterface;

import java.io.IOException;

/**
 * Instructions : 相机管理类
 * Created by ZZ on 2018/4/4.
 */

public class CameraManager {

    private static final String TAG = CameraManager.class.getSimpleName();

    private final Context context;
    private final CameraConfigurationManager configManager;
    private final PreviewCallback previewCallback;
    private OpenCamera camera;
    private int requestedCameraId = OpenCameraInterface.NO_REQUESTED_CAMERA;

    public CameraManager(Context context) {
        this.context = context;
        this.configManager = new CameraConfigurationManager(context);
        this.previewCallback = new PreviewCallback(context);
    }

    public synchronized boolean isOpen() {
        return camera != null;
    }

    public synchronized void openDriver(SurfaceHolder holder) throws IOException {
        OpenCamera theCamera = camera;
        if (theCamera == null) {
            theCamera = OpenCameraInterface.open(requestedCameraId);
        }
    }




}

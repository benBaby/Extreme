package com.extreme.ui.functionActivity.scan.camera.open;

import android.hardware.Camera;

/**
 * Instructions :
 * Created by ZZ on 2018/4/4.
 */

public class OpenCamera {

    private final int index;
    private final Camera camera;
    private final CameraFacing facing;
    private final int orientation;

    OpenCamera(int index, Camera camera, CameraFacing facing, int orientation) {
        this.index = index;
        this.camera = camera;
        this.facing = facing;
        this.orientation = orientation;
    }


}

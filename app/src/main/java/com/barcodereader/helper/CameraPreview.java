package com.barcodereader.helper;

import android.content.Context;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

/**
 * Created by shivappa.battur on 10/12/2018
 */
public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {
    private Camera mCamera;

    public CameraPreview(Context context, Camera camera) {
        super(context);
        this.mCamera = camera;
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        try {
            mCamera.setPreviewDisplay(holder);
            mCamera.startPreview();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        if (holder.getSurface() == null)
            return;
        try {
            mCamera.stopPreview();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            mCamera.setPreviewDisplay(holder);
            mCamera.startPreview();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}

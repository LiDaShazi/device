package com.example.device;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.Preview;
import androidx.camera.core.Preview.SurfaceProvider;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;

import com.google.common.util.concurrent.ListenableFuture;
import androidx.camera.view.PreviewView;

import java.util.concurrent.ExecutionException;

public class IdentifyActivity22 extends AppCompatActivity {

    private PreviewView previewView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify2); // 自定义布局

        previewView = findViewById(R.id.previewView);

        // 检查并请求权限
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)
                != android.content.pm.PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.CAMERA}, 100);
        } else {
            startCamera();
        }

        // 5秒后显示“人脸验证成功”
        new Handler().postDelayed(() -> {
            Toast.makeText(IdentifyActivity22.this, "人脸识别成功", Toast.LENGTH_SHORT).show();

            // 再等2秒跳转到MainActivity
            new Handler().postDelayed(() -> {
                startActivity(new Intent(IdentifyActivity22.this, MainActivity.class));
                finish(); // 关闭当前界面
            }, 2000); // 2秒后跳转
        }, 5000); // 5秒后显示验证成功信息
    }

    private void startCamera() {
        // 创建CameraProvider
        ListenableFuture<ProcessCameraProvider> cameraProviderFuture = ProcessCameraProvider.getInstance(this);

        cameraProviderFuture.addListener(() -> {
            try {
                // 获取CameraProvider
                ProcessCameraProvider cameraProvider = cameraProviderFuture.get();

                // 创建Preview
                Preview preview = new Preview.Builder().build();

                // 设置Preview的SurfaceProvider
                preview.setSurfaceProvider(previewView.getSurfaceProvider());

                // 创建CameraSelector
                CameraSelector cameraSelector = new CameraSelector.Builder()
                        .requireLensFacing(CameraSelector.LENS_FACING_FRONT) // 使用前置摄像头
                        .build();

                // 绑定Lifecycle
                Camera camera = cameraProvider.bindToLifecycle(this, cameraSelector, preview);

            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        }, ContextCompat.getMainExecutor(this));
    }
}

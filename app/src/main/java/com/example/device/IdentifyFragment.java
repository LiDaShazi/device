package com.example.device;

import android.content.Context;
import android.content.Intent;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class IdentifyFragment extends Fragment {

    private CameraManager cameraManager;  // CameraManager 对象
    private String cameraId;              // 摄像头 ID
    private boolean isFlashlightOn = false; // 手电筒状态

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_identify, container, false);

        // 获取按钮
        ImageButton btnRengzheng = view.findViewById(R.id.btn_rengzheng);
        Button btnFlashLight = view.findViewById(R.id.btn_flashlight);

        // 设置指纹认证按钮的点击事件
        btnRengzheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 启动 Update Activity 修改指纹
                Intent intent = new Intent(getActivity(), Update.class); // 使用 getActivity() 获取上下文
                startActivity(intent);
            }
        });

        // 设置手电筒按钮点击事件
        btnFlashLight.setOnClickListener(v -> {
            toggleFlashlight();
        });

        // 初始化 CameraManager
        cameraManager = (CameraManager) requireContext().getSystemService(Context.CAMERA_SERVICE);

        // 获取摄像头 ID
        try {
            for (String id : cameraManager.getCameraIdList()) {
                if (cameraManager.getCameraCharacteristics(id)
                        .get(android.hardware.camera2.CameraCharacteristics.FLASH_INFO_AVAILABLE) != null) {
                    cameraId = id;
                    break;
                }
            }
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }

        return view;
    }

    private void toggleFlashlight() {
        if (cameraId == null) {
            Toast.makeText(requireContext(), "设备不支持闪光灯", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            if (isFlashlightOn) {
                cameraManager.setTorchMode(cameraId, false);  // 关闭手电筒
                isFlashlightOn = false;
                Toast.makeText(requireContext(), "手电筒已关闭", Toast.LENGTH_SHORT).show();
            } else {
                cameraManager.setTorchMode(cameraId, true);   // 打开手电筒
                isFlashlightOn = true;
                Toast.makeText(requireContext(), "手电筒已打开", Toast.LENGTH_SHORT).show();
            }
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }
}

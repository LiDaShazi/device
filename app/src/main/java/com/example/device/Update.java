package com.example.device;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Update extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);  // 将布局文件设置为 activity_main.xml

        // 获取按钮
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btnChangePassword = findViewById(R.id.btn_change_password);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btnChangeFingerprint = findViewById(R.id.btn_change_fingerprint);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btnChangeFace = findViewById(R.id.btn_change_face);

        // 设置点击事件监听器
        btnChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 启动 Update1 Activity 修改密码
                startActivity(new Intent(Update.this, Update1.class));
            }
        });

        btnChangeFingerprint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 启动 Update2 Activity 修改指纹
                startActivity(new Intent(Update.this, Update2.class));
            }
        });

        btnChangeFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 启动 Update3 Activity 修改人脸
                startActivity(new Intent(Update.this, Update3.class));
            }
        });
    }
}

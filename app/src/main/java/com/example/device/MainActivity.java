package com.example.device;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 获取注册按钮
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Button btnRegister = findViewById(R.id.btn_register);

        // 点击注册按钮进入注册流程
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 跳转到注册界面
                Intent intent = new Intent(MainActivity.this, SignActivity.class);
                startActivity(intent);
            }
        });

        // 获取登录按钮
        Button btnLogin = findViewById(R.id.btn_login);

        // 点击登录按钮进入认证流程
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 跳转到 IdentifyActivity
                Intent intent = new Intent(MainActivity.this, IdentifyActivity.class);
                startActivity(intent);
            }
        });

        // 获取忘记密码按钮
        Button btnForgotPassword = findViewById(R.id.btn_forgot_password);

        // 点击忘记密码按钮跳转到注册界面
        btnForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 跳转到 SignActivity
                Intent intent = new Intent(MainActivity.this, SignActivity.class);
                startActivity(intent);
            }
        });
    }
}

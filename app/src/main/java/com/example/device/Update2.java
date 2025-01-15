package com.example.device;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import java.util.concurrent.Executor;

public class Update2 extends AppCompatActivity {

    private BiometricPrompt biometricPrompt;
    private BiometricPrompt.PromptInfo promptInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify);

        // 初始化 BiometricPrompt
        Executor executor = ContextCompat.getMainExecutor(this);
        biometricPrompt = new BiometricPrompt(this, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Toast.makeText(Update2.this, "指纹识别成功", Toast.LENGTH_SHORT).show();

                // 5秒后跳转到下一个界面
                new Handler().postDelayed(() -> {
                    startActivity(new Intent(Update2.this, MainActivity2.class));
                    finish(); // 关闭当前界面
                }, 2000); // 2秒
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                Toast.makeText(Update2.this, "指纹识别失败，请重试", Toast.LENGTH_SHORT).show();
                // 可以在此处重新调用指纹识别
                biometricPrompt.authenticate(promptInfo);
            }

            @Override
            public void onAuthenticationError(int errorCode, CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                Toast.makeText(Update2.this, "指纹识别错误: " + errString, Toast.LENGTH_SHORT).show();
            }
        });

        promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("指纹验证")
                .setSubtitle("请验证您的指纹")
                .setNegativeButtonText("取消")
                .build();

        // 自动启动指纹识别
        biometricPrompt.authenticate(promptInfo);
    }
}

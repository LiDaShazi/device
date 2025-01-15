package com.example.device;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        // 获取控件
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) EditText etUserId = findViewById(R.id.et_user_id);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) EditText etPassword = findViewById(R.id.et_password);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) EditText etConfirmPassword = findViewById(R.id.et_confirm_password);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btnNext = findViewById(R.id.btn_next);

        // 点击下一步按钮
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userId = etUserId.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                String confirmPassword = etConfirmPassword.getText().toString().trim();

                // 验证输入
                if (userId.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    Toast.makeText(SignActivity.this, "所有字段均需填写", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!password.equals(confirmPassword)) {
                    Toast.makeText(SignActivity.this, "密码不一致", Toast.LENGTH_SHORT).show();
                    return;
                }

                // 跳转到认证界面
                Intent intent = new Intent(SignActivity.this, IdentifyActivity11.class);
                intent.putExtra("USER_ID", userId); // 将用户 ID 传递到下一界面
                intent.putExtra("PASSWORD", password); // 将密码传递到下一界面
                startActivity(intent);
            }
        });
    }
}
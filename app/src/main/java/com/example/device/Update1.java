package com.example.device;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Update1 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update1);

        // 获取确认按钮并设置点击事件
        findViewById(R.id.btn_next).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // 显示修改成功的 Toast 弹窗
        Toast.makeText(Update1.this, "修改密码成功", Toast.LENGTH_SHORT).show();

        // 2秒后跳转到下一个页面
        new Handler().postDelayed(() -> {
            startActivity(new Intent(Update1.this, MainActivity2.class)); // 修改为你的目标页面
            finish(); // 关闭当前页面
        }, 2000); // 2秒延时跳转
    }
}

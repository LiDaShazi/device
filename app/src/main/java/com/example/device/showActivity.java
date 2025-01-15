package com.example.device;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class showActivity extends AppCompatActivity {

    private boolean isSdtOn = false; // 用于切换手电筒按钮的图标状态

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_show);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 获取并设置摄像头按钮的点击事件
        ImageButton btnSxt = findViewById(R.id.btn_sxt);
        btnSxt.setOnClickListener(v -> {
            // 使用 Handler 延迟 2 秒后执行跳转
            new Handler().postDelayed(() -> {
                // 创建显式意图
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.sand.airmirror", "com.sand.airmirror.ui.debug.retry.HttpRetryRecordListActivity")); // 替换 MainActivity 为目标 Activity 的类名
                try {
                    startActivity(intent); // 启动目标应用
                } catch (Exception e) {
                    e.printStackTrace();
                    // 如果目标应用不存在，提示用户
                    Intent playStoreIntent = new Intent(Intent.ACTION_VIEW);
                    playStoreIntent.setData(android.net.Uri.parse("market://details?id=com.sand.appinfo"));
                    startActivity(playStoreIntent);
                }
            }, 2000); // 延迟 2000 毫秒（即 2 秒）
        });

        // 获取手电筒按钮的引用并设置点击事件
        ImageButton btnSdt = findViewById(R.id.btn_sdt);
        btnSdt.setOnClickListener(v -> {
            // 判断当前状态，切换图标
            if (!isSdtOn) {
                btnSdt.setImageResource(R.drawable.sdt);  // 替换为 sdt.png
            } else {
                btnSdt.setImageResource(R.drawable.sdt3);  // 替换为 sdt1.png
            }
            // 更新状态
            isSdtOn = !isSdtOn;
        });
    }
}

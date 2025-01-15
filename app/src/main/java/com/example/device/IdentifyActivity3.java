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

public class IdentifyActivity3 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_identify3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        findViewById(R.id.btn_submit).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Toast.makeText(IdentifyActivity3.this, "口令验证成功", Toast.LENGTH_SHORT).show();

        // 再等2秒跳转到IdentifyActivity3
        new Handler().postDelayed(() -> {
            startActivity(new Intent(IdentifyActivity3.this, IdentifyActivity4.class));
            finish(); // 关闭当前界面
        }, 2000); // 2秒后跳转
    }
}
package com.example.device;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DocumentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document);

        // 获取文档内容的 TextView
        TextView textViewDocument = findViewById(R.id.textViewDocument);

        // 读取 raw 文件夹中的 .txt 文件
        String documentContent = readTextFileFromRaw(R.raw.document);  // 替换为你的文件名

        if (!TextUtils.isEmpty(documentContent)) {
            textViewDocument.setText(documentContent);  // 显示文档内容
        } else {
            textViewDocument.setText("未能加载文档。");  // 如果文件为空或无法读取
        }
    }

    // 读取 raw 文件夹中的文本文件
    private String readTextFileFromRaw(int resId) {
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(getResources().openRawResource(resId)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");  // 将每行文本添加到 stringBuilder
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return stringBuilder.toString();
    }
}

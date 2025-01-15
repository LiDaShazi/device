package com.example.device;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class ManageFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_manage, container, false);

        // 获取按钮
        Button btnLlj = view.findViewById(R.id.btn_llj);
        Button btnGhr = view.findViewById(R.id.btn_ghr);

        // 设置按钮点击事件
        View.OnClickListener clickListener = v -> {
            Toast.makeText(requireContext(), "连接成功", Toast.LENGTH_SHORT).show();

            // 延迟 2 秒后跳转到 ShowActivity
            new Handler().postDelayed(() -> {
                Intent intent = new Intent(requireContext(), showActivity.class);
                startActivity(intent);
            }, 2000); // 2 秒后跳转
        };

        // 为按钮绑定事件
        btnLlj.setOnClickListener(clickListener);
        btnGhr.setOnClickListener(clickListener);

        return view;
    }
}

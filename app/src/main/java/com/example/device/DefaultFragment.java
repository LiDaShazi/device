package com.example.device;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.cardview.widget.CardView;

public class DefaultFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_default, container, false);

        // 获取卡片控件
        CardView docCardView = rootView.findViewById(R.id.docCardView);
        TextView textViewTitle = rootView.findViewById(R.id.textViewTitle);
        ImageView imageView = rootView.findViewById(R.id.imageView);

        // 设置标题和图片（可以从网络或本地动态加载）
        textViewTitle.setText("软件操作说明"); // 设置标题
        imageView.setImageResource(R.drawable.sample_image); // 设置图片资源

        // 设置点击事件
        docCardView.setOnClickListener(v -> openDocumentActivity());

        return rootView;
    }

    // 跳转到 DocumentActivity
    private void openDocumentActivity() {
        Intent intent = new Intent(getActivity(), DocumentActivity.class);
        startActivity(intent);
    }
}

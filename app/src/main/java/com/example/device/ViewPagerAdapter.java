package com.example.device;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new DefaultFragment();       // 默认页面
            case 1:
                return new IdentifyFragment();      // 设备认证
            case 2:
                return new ManageFragment();        // 设备管理
            default:
                return new DefaultFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3; // 三个页面
    }
}

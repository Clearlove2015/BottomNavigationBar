package com.odbpo.fenggou.bottomnavigationbar.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.odbpo.fenggou.bottomnavigationbar.R;

/**
 * @author: zjl
 * @Time: 2018/3/9 10:19
 * @Desc:
 */
public class MineFragment extends Fragment {

    public static MineFragment newInstance(String tag){
        MineFragment mineFragment = new MineFragment();
        return mineFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frg_mine,container,false);
        return view;
    }
}

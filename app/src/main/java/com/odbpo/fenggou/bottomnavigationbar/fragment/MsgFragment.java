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
public class MsgFragment extends Fragment {

    public static MsgFragment newInstance(String tag) {
        MsgFragment msgFragment = new MsgFragment();
        return msgFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frg_msg, container, false);
        return view;
    }
}

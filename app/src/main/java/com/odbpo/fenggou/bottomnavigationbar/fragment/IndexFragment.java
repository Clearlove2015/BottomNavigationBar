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
public class IndexFragment extends Fragment {

    public static IndexFragment newInstance(String tag){
        IndexFragment indexFragment = new IndexFragment();
        return indexFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frg_index,container,false);
        return view;
    }
}

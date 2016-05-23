package com.yjtc.cbg.yjsapp.fragment;

import android.os.Bundle;
import android.widget.Toast;

import com.yjtc.cbg.yjsapp.R;

import org.xutils.view.annotation.ContentView;

/**
 * Created by chenboge on 16/5/11.
 */
@ContentView(R.layout.discover)
public class PublishFragment extends BaseV4Fragment {


    @Override
    void initData() {

    }

    @Override
    void leftClick() {
        Toast.makeText(getActivity(), "dis left", Toast.LENGTH_SHORT).show();
    }

    @Override
    void rightClick() {
        Toast.makeText(getActivity(), "dis right", Toast.LENGTH_SHORT).show();
    }
}

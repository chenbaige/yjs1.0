package com.yjtc.cbg.yjsapp.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.yjtc.cbg.yjsapp.R;
import com.yjtc.cbg.yjsapp.View.AuctionOrderActivity;
import com.yjtc.cbg.yjsapp.View.HomePageActivity;
import com.yjtc.cbg.yjsapp.View.MineActivity;
import com.yjtc.cbg.yjsapp.util.ToastUtil;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by chenboge on 16/4/30.
 */
@ContentView(R.layout.mine)
public class MineFragment extends android.app.Fragment {

    @ViewInject(R.id.id_mine_head)
    private CircleImageView mHeadView;



    private boolean injected = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        injected = true;
        return x.view().inject(this, inflater, container);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (!injected) {
            x.view().inject(this, this.getView());
        }
    }

    @Event(value = R.id.id_mine_head)
    private void PersonInfoClick(View view) {
        startActivity(new Intent(getActivity(), MineActivity.class));
    }

    @Event(value = {R.id.id_publish, R.id.id_fans, R.id.id_attention, R.id.id_friends})
    private void startActivity(View view) {
        startActivity(new Intent(getActivity(), AuctionOrderActivity.class));
    }

    //点击我的相册
    @Event(value = R.id.id_mine_photo)
    private void Mine_Photo(View view) {
        ToastUtil.showToast(getActivity(),"我的相册");
    }


    //点击我的视频
    @Event(value = R.id.id_mine_vidio)
    private void Mine_Vedio(View view) {
        ToastUtil.showToast(getActivity(),"我的视频");
    }


    //点击我的收藏
    @Event(value = R.id.id_mine_collection)
    private void Mine_Collection(View view) {
        ToastUtil.showToast(getActivity(),"我的收藏");
    }

    //点击匠币
    @Event(value = R.id.id_mine_money)
    private void Mine_Money(View view) {
        ToastUtil.showToast(getActivity(),"匠币");
    }


    //点击更多
    @Event(value = R.id.id_mine_more)
    private void Mine_More(View view) {
        ToastUtil.showToast(getActivity(),"更多");
    }


    //点击设置
    @Event(value = R.id.id_mine_set)
    private void Mine_set(View view) {
        ToastUtil.showToast(getActivity(),"设置");
    }


    //点击编辑
    @Event(value = R.id.id_mine_edit)
    private void Mine_edit(View view) {
        ToastUtil.showToast(getActivity(),"编辑");
    }


}

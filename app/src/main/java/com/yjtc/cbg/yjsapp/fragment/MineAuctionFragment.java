package com.yjtc.cbg.yjsapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.yjtc.cbg.yjsapp.R;
import com.yjtc.cbg.yjsapp.View.AuctionOrderActivity;
import com.yjtc.cbg.yjsapp.View.NotPayingActivity;
import com.yjtc.cbg.yjsapp.util.ToastUtil;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;

/**
 * Created by chenboge on 16/5/11.
 */
@ContentView(R.layout.mine_auction)
public class MineAuctionFragment extends BaseV4Fragment {

    @Override
    void initData() {

    }

    @Override
    void leftClick() {
        Toast.makeText(getActivity(), "mine left", Toast.LENGTH_SHORT).show();
    }

    @Override
    void rightClick() {
        Toast.makeText(getActivity(), "mine right", Toast.LENGTH_SHORT).show();
    }

    @Event(value = {R.id.id_all,R.id.id_auctioning,R.id.id_auctioned,R.id.id_end})
    private void startActivity(View view){
        startActivity(new Intent(getActivity(), AuctionOrderActivity.class));
    }

    //点击未付款事件处理
    @Event(value = R.id.id_not_pay)
    private void Not_Pay(View view){
        ToastUtil.showToast(getActivity(),"未付款");
    }


    //点击待发货事件处理
    @Event(value = R.id.id_wait_trants)
    private void Wait_trantsport(View view){
        ToastUtil.showToast(getActivity(),"待发货");
    }

    //点击未收货事件处理
    @Event(value = R.id.id_not_trantsed)
    private void Not_access_good(View view){
        ToastUtil.showToast(getActivity(),"未收货");
    }

    //点击管理收货地址时间处理
    @Event(value = R.id.id_mine_collection)
    private void Mine_clooection(View view){
        ToastUtil.showToast(getActivity(),"管理收货地址");
    }

    //点击我的收藏事件处理
    @Event(value = R.id.id_mine_manager_address)
    private void Manager_address(View view){
        ToastUtil.showToast(getActivity(),"我的收藏");
    }
}

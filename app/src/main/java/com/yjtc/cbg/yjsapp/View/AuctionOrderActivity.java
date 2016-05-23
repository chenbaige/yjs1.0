package com.yjtc.cbg.yjsapp.View;

import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.yjtc.cbg.yjsapp.Adapter.AuctionOrderAdapter;
import com.yjtc.cbg.yjsapp.Presenter.AuctionOrderPresenter;
import com.yjtc.cbg.yjsapp.R;
import com.yjtc.cbg.yjsapp.View.inter.IOrderActivity;
import com.yjtc.cbg.yjsapp.Widget.YJSToolBar;
import com.yjtc.cbg.yjsapp.bean.Banner;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.List;

/**
 * Created by chen on 2016/5/15.
 */
@ContentView(R.layout.auction_order)
public class AuctionOrderActivity extends BaseActivity implements TabLayout.OnTabSelectedListener,IOrderActivity {

    public static final int STATUS_ALL = 1000;//全部参拍商品
    public static final int STATUS_AUCTIONING = 1; //正在拍卖
    public static final int STATUS_AUCTIONED = -2; //已经拍下
    public static final int STATUS_END = 0; //：已结束
    private int status = STATUS_ALL;

   // @ViewInject(R.id.id_tv)
    private TextView mTV;

    @ViewInject(R.id.id_toolbar)
    private YJSToolBar mToolbar;

    @ViewInject(R.id.tab_layout)
    private TabLayout mTablayout;

     @ViewInject(R.id.recycler_view)
    private RecyclerView mRecyclerview;

    private AuctionOrderPresenter mPresenter;

    private AuctionOrderAdapter mAdapter;

    @Override
    void initData() {
        mPresenter = new AuctionOrderPresenter(this,this);
        initTab();
        initToolBar();
        mPresenter.LoadData();
    }

    private void initToolBar() {
        mToolbar.setLeftListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mToolbar.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void initTab() {
        TabLayout.Tab tab = mTablayout.newTab();
        tab.setText(R.string.auction_all);
        tab.setTag(STATUS_ALL);
        mTablayout.addTab(tab);


        tab = mTablayout.newTab();
        tab.setText(R.string.auction_auctioning);
        tab.setTag(STATUS_AUCTIONING);
        mTablayout.addTab(tab);

        tab = mTablayout.newTab();
        tab.setText(R.string.auction_auctioned);
        tab.setTag(STATUS_AUCTIONED);
        mTablayout.addTab(tab);

        tab = mTablayout.newTab();
        tab.setText(R.string.auction_end);
        tab.setTag(STATUS_END);
        mTablayout.addTab(tab);

        mTablayout.setOnTabSelectedListener(this);
    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        //mTablayout.set
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void initUIData(List<Banner> mDatas) {
        mAdapter = new AuctionOrderAdapter(this, mDatas, R.layout.template_auction_order_item);
        mRecyclerview.setAdapter(mAdapter);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));
    }
}

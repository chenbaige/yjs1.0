package com.yjtc.cbg.yjsapp.View;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.yjtc.cbg.yjsapp.Adapter.AuctionNotPayAdapter;
import com.yjtc.cbg.yjsapp.Presenter.AuctionOrderPresenter;
import com.yjtc.cbg.yjsapp.R;
import com.yjtc.cbg.yjsapp.View.inter.IOrderActivity;
import com.yjtc.cbg.yjsapp.Widget.YJSToolBar;
import com.yjtc.cbg.yjsapp.bean.Banner;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.List;

/**
 * Created by chen on 2016/5/16.
 */
@ContentView(R.layout.not_pay)
public class NotPayingActivity extends BaseActivity implements IOrderActivity {

    @ViewInject(R.id.id_toolbar)
    private YJSToolBar mToolbar;

    @ViewInject(R.id.id_recycler_view)
    private RecyclerView mRecyclerview;

    private AuctionNotPayAdapter mAdapter;

    private AuctionOrderPresenter mPresenter;


    @Override
    void initData() {
        mPresenter = new AuctionOrderPresenter(this,this);
        mPresenter.LoadData();
    }
    @Override
    public void initUIData(List<Banner> mDatas) {
        mAdapter = new AuctionNotPayAdapter(this, mDatas, R.layout.template_auction_order_item);
        mRecyclerview.setAdapter(mAdapter);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));
    }
}

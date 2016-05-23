package com.yjtc.cbg.yjsapp.View;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.yjtc.cbg.yjsapp.Adapter.DividerItemDecoration;
import com.yjtc.cbg.yjsapp.Adapter.MessageCenterAdapter;
import com.yjtc.cbg.yjsapp.Adapter.layoutmanager.FullyLinearLayoutManager;
import com.yjtc.cbg.yjsapp.R;
import com.yjtc.cbg.yjsapp.Widget.YJSToolBar;
import com.yjtc.cbg.yjsapp.model.HomeModel;
import com.yjtc.cbg.yjsapp.model.inter.IHome;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by chen on 2016/5/23.
 */
@ContentView(R.layout.message_center)
public class MessageCenterActivity extends BaseActivity {

    @ViewInject(R.id.id_toolbar)
    private YJSToolBar mToolbar;

    @ViewInject(R.id.id_auction_message)
    private RecyclerView mRecycleView;

    private IHome home = new HomeModel();
    private MessageCenterAdapter mAdapter;

    @Override
    void initData() {
        initToolbar();
        mAdapter = new MessageCenterAdapter(this, home.getBanners(), R.layout.template_chat_news_item);
        mRecycleView.setAdapter(mAdapter);
        mRecycleView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
        mRecycleView.setLayoutManager(new FullyLinearLayoutManager(this));
    }

    private void initToolbar() {
        mToolbar.setLeftListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mToolbar.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

}

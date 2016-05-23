package com.yjtc.cbg.yjsapp.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.yjtc.cbg.yjsapp.R;
import com.yjtc.cbg.yjsapp.Widget.FragmentTabHost;
import com.yjtc.cbg.yjsapp.bean.Tab;
import com.yjtc.cbg.yjsapp.fragment.AuctioningFragment;
import com.yjtc.cbg.yjsapp.fragment.PublishFragment;
import com.yjtc.cbg.yjsapp.fragment.MineAuctionFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenboge on 16/5/11.
 */
//拍卖主框架界面
public class AuctionActivity extends AppCompatActivity {

    private FragmentTabHost mHost;
    private LayoutInflater mInflater;
    private List<Tab> tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lauout_auction);
        initData();
        initTabHost();
        initToolbar();
    }

    private void initToolbar() {
    }

    private void initData() {
        mInflater = LayoutInflater.from(this);
    }

    private void initTabHost() {
        mHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mHost.setup(this, getSupportFragmentManager(), R.id.id_main_content);
        initTab();
        for (Tab tab : tabs) {
            TabHost.TabSpec tabSpec = mHost.newTabSpec(getString(tab.getTitle()));
            tabSpec.setIndicator(buildIndcater(tab));
            mHost.addTab(tabSpec, tab.getFragment(), null);
        }
        mHost.setCurrentTab(0);
        //mHost.setOnTabChangedListener(this);

    }

    private void initTab() {
        Tab home = new Tab(R.string.auctioning, R.drawable.selector_icon_auctioning, AuctioningFragment.class);
        Tab chat = new Tab(R.string.publish, R.drawable.selector_icon_discover, PublishFragment.class);
        Tab mine = new Tab(R.string.mine_auction, R.drawable.selector_icon_mineauction, MineAuctionFragment.class);
        tabs = new ArrayList<>();
        tabs.add(home);
        tabs.add(chat);
        tabs.add(mine);
    }

    private View buildIndcater(Tab tab) {
        View view = mInflater.inflate(R.layout.tab_indicator, null);
        ImageView img = (ImageView) view.findViewById(R.id.icon_tab);
        TextView tv = (TextView) view.findViewById(R.id.txt_indicator);
        img.setImageResource(tab.getResId());
        tv.setText(tab.getTitle());
        return view;
    }


    public void AddTab(String tabName, String tabContent, int resid, Class clazz) {
        TabHost.TabSpec tabSpec = mHost.newTabSpec(tabName);
        View view = mInflater.inflate(R.layout.tab_indicator, null);
        ImageView img = (ImageView) view.findViewById(R.id.icon_tab);
        TextView tv = (TextView) view.findViewById(R.id.txt_indicator);
        img.setImageResource(resid);
        tv.setText(tabContent);
        tabSpec.setIndicator(view);
        mHost.addTab(tabSpec, clazz, null);
    }
}

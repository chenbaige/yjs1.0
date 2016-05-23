package com.yjtc.cbg.yjsapp.View;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.yjtc.cbg.yjsapp.Adapter.Art;
import com.yjtc.cbg.yjsapp.Adapter.DividerItemDecoration;
import com.yjtc.cbg.yjsapp.Adapter.HomeAdapter;
import com.yjtc.cbg.yjsapp.Adapter.MinePersonShowAdapter;
import com.yjtc.cbg.yjsapp.Presenter.MinePresenter;
import com.yjtc.cbg.yjsapp.R;
import com.yjtc.cbg.yjsapp.View.inter.IMineActivity;
import com.yjtc.cbg.yjsapp.bean.Banner;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.List;

/**
 * Created by chenboge on 16/5/5.
 */
@ContentView(R.layout.layout_mine)
public class MineActivity extends BaseActivity implements IMineActivity {

    private RecyclerView mPersonShowVIew;

    @ViewInject(R.id.id_mine_person_detail_show)
    private RecyclerView mPersonDetailShowVIew;

    private RecyclerView.Adapter mAdapter;
    private LinearLayoutManager mLayoutManager;

    private HomeAdapter mDetailAdapter;

    private MinePresenter mPresenter;

    private LayoutInflater mInflater;

    private View mHeaderView;


    @Override
    void initData() {
        mInflater=LayoutInflater.from(this);
        mHeaderView = mInflater.inflate(R.layout.mine_detail_header,null,false);
        mPersonShowVIew = (RecyclerView) mHeaderView.findViewById(R.id.id_mine_person_show);
        mPresenter = new MinePresenter(this);
        mPresenter.initGalleryData();
        mPresenter.initContentData();
    }

    @Override
    public void initGalleryData(List<Banner> banners) {
        mPersonShowVIew.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mPersonShowVIew.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MinePersonShowAdapter(this, banners, R.layout.template_imageview);
        mPersonShowVIew.setAdapter(mAdapter);
    }

    @Override
    public void initContentData(List<Art> arts) {
        mDetailAdapter = new HomeAdapter(this,arts,R.layout.template_art_show);

        mDetailAdapter.setmHeaderView(mHeaderView);

        mPersonDetailShowVIew.setAdapter(mDetailAdapter);

        mPersonDetailShowVIew.setLayoutManager(new LinearLayoutManager(this));

        mPersonDetailShowVIew.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
    }
}

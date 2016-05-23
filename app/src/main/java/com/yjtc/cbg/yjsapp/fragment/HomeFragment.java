package com.yjtc.cbg.yjsapp.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.yjtc.cbg.yjsapp.Adapter.Art;
import com.yjtc.cbg.yjsapp.Adapter.DividerItemDecoration;
import com.yjtc.cbg.yjsapp.Adapter.HomeAdapter;
import com.yjtc.cbg.yjsapp.Presenter.HomePresenter;
import com.yjtc.cbg.yjsapp.R;
import com.yjtc.cbg.yjsapp.View.PublishMessageActivity;
import com.yjtc.cbg.yjsapp.Widget.MyPopupWindow;
import com.yjtc.cbg.yjsapp.bean.Banner;
import com.yjtc.cbg.yjsapp.fragment.inter.IHomeFragment;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.List;

/**
 * Created by chenboge on 16/4/30.
 */
@ContentView(R.layout.home)
public class HomeFragment extends BaseFragment implements IHomeFragment,MyPopupWindow.OnItemClickListener {

    private HomePresenter mPresenter;

    private SliderLayout mLayout;
    private PagerIndicator mIndicator;

    @ViewInject(R.id.id_home_content)
    private RecyclerView mView;

    private HomeAdapter mAdapter;

    private LayoutInflater mInflater;

    private View HeaderView=null;

    @Override
    public void initSliderViewData(List<Banner> banners) {
        if (banners != null) {
            for (Banner banner : banners) {
                TextSliderView textSliderView = new TextSliderView(getActivity());
                textSliderView
                        .description(banner.getName())
                        .image(banner.getImgUrl());
                //点击事件
                textSliderView.setScaleType(BaseSliderView.ScaleType.Fit);
                textSliderView.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                    @Override
                    public void onSliderClick(BaseSliderView slider) {

                    }
                });

                mLayout.addSlider(textSliderView);
            }

        }

        //设置底部导航状态栏
        // sliderShow.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mLayout.setCustomIndicator(mIndicator);

        mLayout.setCustomAnimation(new DescriptionAnimation());
        mLayout.setPresetTransformer(SliderLayout.Transformer.RotateUp);
        mLayout.setDuration(3000);
    }

    @Override
    public void initGridView(List<Art> arts) {
        mAdapter = new HomeAdapter(getActivity(), arts, R.layout.template_art_show);

        mAdapter.setmHeaderView(HeaderView);

        mView.setAdapter(mAdapter);

        mView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
    }


    @Override
    public void onStop() {
        mLayout.stopAutoCycle();
        super.onStop();

    }

    @Override
    void initData() {
        mInflater=LayoutInflater.from(getActivity());
        HeaderView = mInflater.inflate(R.layout.home_header, null, false);
        mLayout = (SliderLayout) HeaderView.findViewById(R.id.slider);
        mIndicator = (PagerIndicator) HeaderView.findViewById(R.id.custom_indicator);
        mPresenter = new HomePresenter(this);
        mPresenter.initSlider();
        mPresenter.initGridView();
    }

    //toolbar左侧按钮点击事件
    @Override
    void leftClick() {
        Toast.makeText(getActivity(), "home", Toast.LENGTH_SHORT).show();
    }

    //toolbar右侧按钮点击事件
    @Override
    void rightClick() {
       // Toast.makeText(getActivity(), "righthome", Toast.LENGTH_SHORT).show();
        int[] items={R.id.id_one,R.id.id_two};
        MyPopupWindow mWindow = new MyPopupWindow(getActivity(), R.layout.home_popup, items);
        mWindow.setmListener(this);
        mWindow.showPopupWindow(mToolbar.mIVRight);
    }

    @Override
    public void OneClick() {
        startActivity(new Intent(getActivity(), PublishMessageActivity.class));
        Toast.makeText(getActivity(), "one", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void TwoClick() {
        Toast.makeText(getActivity(), "two", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ThreeClick() {
       // Toast.makeText(getActivity(), "three", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void FourClick() {

    }
}

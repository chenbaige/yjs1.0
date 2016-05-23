package com.yjtc.cbg.yjsapp.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.yjtc.cbg.yjsapp.bean.Banner;
import com.yjtc.cbg.yjsapp.fragment.inter.IHomeFragment;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.List;

/**
 * Created by chenboge on 16/4/30.
 */
@ContentView(R.layout.school)
public class SchoolFragment extends BaseFragment implements IHomeFragment {

    private HomePresenter mPresenter;

    @ViewInject(R.id.slider)
    private SliderLayout mLayout;

    @ViewInject(R.id.custom_indicator)
    private PagerIndicator mIndicator;

    @ViewInject(R.id.id_home_content)
    private RecyclerView mView;


    private HomeAdapter mAdapter;

    @Override
    public void onStop() {
        mLayout.stopAutoCycle();
        super.onStop();

    }

    @Override
    void initData() {
        mPresenter = new HomePresenter(this);
        mPresenter.initSlider();
        mPresenter.initGridView();

    }


    @Override
    void leftClick() {
        Toast.makeText(getActivity(), "school", Toast.LENGTH_SHORT).show();
    }

    @Override
    void rightClick() {
        Toast.makeText(getActivity(), "rightschool", Toast.LENGTH_SHORT).show();
    }

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

        mLayout.addOnPageChangeListener(new ViewPagerEx.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void initGridView(List<Art> arts) {

        mAdapter = new HomeAdapter(getActivity(), arts, R.layout.template_art_show);

        mView.setAdapter(mAdapter);

        mView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
    }
}

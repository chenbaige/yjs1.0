package com.yjtc.cbg.yjsapp.View;

import android.widget.TextView;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.yjtc.cbg.yjsapp.R;
import com.yjtc.cbg.yjsapp.bean.Banner;
import com.yjtc.cbg.yjsapp.model.HomeModel;
import com.yjtc.cbg.yjsapp.model.inter.IHome;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.List;

/**
 * Created by chen on 2016/5/19.
 */
@ContentView(R.layout.aauction_shop_detail)
public class AuctionShopDetailActivity extends BaseActivity {

    @ViewInject(R.id.slider)
    private SliderLayout mLayout;

    @ViewInject(R.id.id_current_page)
    private TextView mCurrentPage;


    private IHome home = new HomeModel();

    @Override
    void initData() {
        initSliderViewData(home.getBanners());
    }

    public void initSliderViewData(List<Banner> banners) {
        final int totlePage = banners.size();
        if (banners != null) {
            for (Banner banner : banners) {
                TextSliderView textSliderView = new TextSliderView(this);
                textSliderView
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
        mLayout.setCustomAnimation(null);
        mLayout.setPresetTransformer(SliderLayout.Transformer.Default);
        mLayout.setDuration(10000);

        mLayout.addOnPageChangeListener(new ViewPagerEx.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mCurrentPage.setText((position+1)+"/"+totlePage);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}

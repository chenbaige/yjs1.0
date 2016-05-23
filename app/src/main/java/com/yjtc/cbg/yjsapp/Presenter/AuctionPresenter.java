package com.yjtc.cbg.yjsapp.Presenter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.yjtc.cbg.yjsapp.Adapter.AuctionAdapter;
import com.yjtc.cbg.yjsapp.Adapter.BaseAdapter;
import com.yjtc.cbg.yjsapp.R;
import com.yjtc.cbg.yjsapp.View.AuctionShopDetailActivity;
import com.yjtc.cbg.yjsapp.Widget.TopImageBottumTextView;
import com.yjtc.cbg.yjsapp.bean.Banner;
import com.yjtc.cbg.yjsapp.fragment.inter.IAuctioningFragment;
import com.yjtc.cbg.yjsapp.model.AuctioningModel;
import com.yjtc.cbg.yjsapp.model.HomeModel;
import com.yjtc.cbg.yjsapp.model.inter.IAuctioningModel;
import com.yjtc.cbg.yjsapp.model.inter.IHome;
import com.yjtc.cbg.yjsapp.util.ToastUtil;

import java.util.List;

/**
 * Created by chenboge on 16/5/12.
 */
public class AuctionPresenter implements View.OnClickListener {

    private Context mContext;

    //拍卖中－－model和view
    private IAuctioningModel auctioningModel = new AuctioningModel();
    private IAuctioningFragment auctioningFragment;

    private AuctionAdapter mAuctioningAdapter;

    private LayoutInflater mInflater;

    private View HeaderView = null;

    //滚动广告栏的设计
    private SliderLayout mLayout;
    private PagerIndicator mIndicator;

    private IHome home = new HomeModel();

    private TextView mTextSortPopular, mTextSortTime;

    public AuctionPresenter(IAuctioningFragment auctioningFragment, Context context) {
        this.auctioningFragment = auctioningFragment;
        this.mContext = context;
        mInflater = LayoutInflater.from(mContext);
        initHomeView();
    }

    private void initHomeView() {
        HeaderView = mInflater.inflate(R.layout.auction_header, null, false);
        mLayout = (SliderLayout) HeaderView.findViewById(R.id.slider);
        mIndicator = (PagerIndicator) HeaderView.findViewById(R.id.custom_indicator);
        mTextSortPopular = (TextView) HeaderView.findViewById(R.id.id_text_sort_popular);
        mTextSortTime = (TextView) HeaderView.findViewById(R.id.id_text_sort_time);
        selectPopular();
        mTextSortPopular.setOnClickListener(this);
        mTextSortTime.setOnClickListener(this);
    }

    public void initHeaderView(RecyclerView mview) {
        initSliderViewData(home.getBanners());
        addCatagroupClick();
        mAuctioningAdapter = new AuctionAdapter(mContext, auctioningModel.getBanners(), R.layout.template_auction_home_item);
        mAuctioningAdapter.setmHeaderView(HeaderView);
        mAuctioningAdapter.setOnItemClickListener(new BaseAdapter.onItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                mContext.startActivity(new Intent(mContext, AuctionShopDetailActivity.class));
            }
        });
        mview.setAdapter(mAuctioningAdapter);
        // mview.setLayoutManager(new GridLayoutManager(mContext,4));
        mview.setLayoutManager(new LinearLayoutManager(mContext));
    }

    private void addCatagroupClick() {
        ((TopImageBottumTextView) HeaderView.findViewById(R.id.id_function_one)).setOnClickListener(this);
        ((TopImageBottumTextView) HeaderView.findViewById(R.id.id_function_two)).setOnClickListener(this);
        ((TopImageBottumTextView) HeaderView.findViewById(R.id.id_function_three)).setOnClickListener(this);
        ((TopImageBottumTextView) HeaderView.findViewById(R.id.id_function_four)).setOnClickListener(this);
        ((TopImageBottumTextView) HeaderView.findViewById(R.id.id_function_five)).setOnClickListener(this);
        ((TopImageBottumTextView) HeaderView.findViewById(R.id.id_function_six)).setOnClickListener(this);
        ((TopImageBottumTextView) HeaderView.findViewById(R.id.id_function_seven)).setOnClickListener(this);
        ((TopImageBottumTextView) HeaderView.findViewById(R.id.id_function_eight)).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //点击书画按钮时间处理
            case R.id.id_function_one:
                ToastUtil.showToast(mContext, "书画");
                break;

            //点击书画按钮时间处理
            case R.id.id_function_two:
                ToastUtil.showToast(mContext, "石料");
                break;

            //点击书画按钮时间处理
            case R.id.id_function_three:
                ToastUtil.showToast(mContext, "玉器");
                break;

            //点击书画按钮时间处理
            case R.id.id_function_four:
                ToastUtil.showToast(mContext, "篆刻");
                break;

            //点击书画按钮时间处理
            case R.id.id_function_five:
                ToastUtil.showToast(mContext, "木易");
                break;

            //点击书画按钮时间处理
            case R.id.id_function_six:
                ToastUtil.showToast(mContext, "紫砂壶");
                break;

            //点击书画按钮时间处理
            case R.id.id_function_seven:
                ToastUtil.showToast(mContext, "碑帖");
                break;

            //点击书画按钮时间处理
            case R.id.id_function_eight:
                ToastUtil.showToast(mContext, "更多");
                break;
            //按时间排序事件处理
            case R.id.id_text_sort_time:
                selectTime();
                break;

            //按人气排序时间处理
            case R.id.id_text_sort_popular:
              selectPopular();
                break;
        }
    }

    private void initSliderViewData(List<Banner> banners) {
        if (banners != null) {
            for (Banner banner : banners) {
                TextSliderView textSliderView = new TextSliderView(mContext);
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

    public void onHeaderViewEnd() {
        mLayout.stopAutoCycle();
    }

    private void reSet() {
        mTextSortPopular.setTextColor(mContext.getResources().getColor(R.color.comui_tab_text_color));
        mTextSortTime.setTextColor(mContext.getResources().getColor(R.color.comui_tab_text_color));
    }

    public void selectTime(){
        reSet();
        mTextSortTime.setTextColor(mContext.getResources().getColor(R.color.green));
    }

    public void selectPopular(){
        reSet();
        mTextSortPopular.setTextColor(mContext.getResources().getColor(R.color.green));
    }
}

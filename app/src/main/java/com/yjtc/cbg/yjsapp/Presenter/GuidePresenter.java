package com.yjtc.cbg.yjsapp.Presenter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.yjtc.cbg.yjsapp.Adapter.MyPagerAdapter;
import com.yjtc.cbg.yjsapp.R;
import com.yjtc.cbg.yjsapp.View.inter.IGuide;

import java.util.ArrayList;

/**
 * Created by chenboge on 16/4/29.
 */
public class GuidePresenter implements View.OnClickListener,ViewPager.OnPageChangeListener {

    private Context mContext;
    private IGuide GUide;
    private ViewPager mPager;
    private MyPagerAdapter mAdapter;
    private ArrayList<View> views;
    // 引导图片资源
    private static final int[] pics = {R.mipmap.guide1, R.mipmap.guide2,
            R.mipmap.guide3 };
    // 底部小点的图片
    private ImageView[] points;
    // 记录当前选中位置
    private int currentIndex;


    public GuidePresenter(IGuide GUide,Context context) {
        this.GUide = GUide;
        this.mContext=context;
        views = new ArrayList<>();
        mPager=GUide.getViewpager();
    }


    private void initPoint() {
        LinearLayout linearLayout =GUide.getLayout();

        points = new ImageView[pics.length];

        // 循环取得小点图片
        for (int i = 0; i < pics.length; i++) {
            // 得到一个LinearLayout下面的每一个子元素
            points[i] = (ImageView) linearLayout.getChildAt(i);
            // 默认都设为灰色
            points[i].setEnabled(true);
            // 给每个小点设置监听
            points[i].setOnClickListener(this);
            // 设置位置tag，方便取出与当前位置对应
            points[i].setTag(i);
        }

        // 设置当面默认的位置
        currentIndex = 0;
        // 设置为白色，即选中状态
        points[currentIndex].setEnabled(false);
    }


    private void initData() {
        // 定义一个布局并设置参数
        LinearLayout.LayoutParams mParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        // 初始化引导图片列表
        for (int i = 0; i < pics.length; i++) {
            ImageView iv = new ImageView(mContext);
            iv.setLayoutParams(mParams);
            //防止图片不能填满屏幕
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            //加载图片资源
            iv.setImageResource(pics[i]);
            views.add(iv);
        }
        mAdapter = new MyPagerAdapter(views);
        // 设置数据
        mPager.setAdapter(mAdapter);
        // 设置监听
        mPager.setOnPageChangeListener(this);

        // 初始化底部小点
        initPoint();
    }

    public void loacher(){
        initData();
    }

    @Override
    public void onClick(View v) {
        int position = (Integer) v.getTag();
        setCurView(position);
        setCurDot(position);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if(position==2){
            GUide.showLiveButton();
        }else {
            GUide.fideLiveButton();
        }
        setCurDot(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void setCurView(int position) {
        if (position < 0 || position >= pics.length) {
            return;
        }
        mPager.setCurrentItem(position);
    }

    /**
     * 设置当前的小点的位置
     */
    private void setCurDot(int positon) {
        if (positon < 0 || positon > pics.length - 1 || currentIndex == positon) {
            return;
        }
        points[positon].setEnabled(false);
        points[currentIndex].setEnabled(true);

        currentIndex = positon;

    }

}

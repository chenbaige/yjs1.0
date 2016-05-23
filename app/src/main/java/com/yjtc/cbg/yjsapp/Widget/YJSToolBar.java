package com.yjtc.cbg.yjsapp.Widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.internal.widget.TintTypedArray;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.yjtc.cbg.yjsapp.R;

/**
 * Created by chenboge on 16/5/3.
 */
public class YJSToolBar extends Toolbar implements View.OnClickListener {

    private LayoutInflater mInflater;
    private View mView;

    public ImageView mIVLeft, mIVRight, mIVRightLeft;
    private TextView mTVCenter;

    private OnClickListener leftListener;

    public void setRightListener(OnClickListener rightListener) {
        this.rightListener = rightListener;
    }

    public void setRightLeftListener(OnClickListener rightLeftListener) {
        this.rightLeftListener = rightLeftListener;
    }

    private OnClickListener rightLeftListener;

    public void setLeftListener(OnClickListener leftListener) {
        this.leftListener = leftListener;
    }

    private OnClickListener rightListener;


    public YJSToolBar(Context context) {
        this(context, null);
    }

    public YJSToolBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public YJSToolBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();

        setContentInsetsAbsolute(10, 10);

        //获取自定义属性
        if (attrs != null) {
            final TintTypedArray a = TintTypedArray.obtainStyledAttributes(getContext(), attrs,
                    R.styleable.YJSToolBar, defStyleAttr, 0);

            final Drawable leftImage = a.getDrawable(R.styleable.YJSToolBar_leftImageSrc);
            mIVLeft.setImageDrawable(leftImage);
            final Drawable rightImage = a.getDrawable(R.styleable.YJSToolBar_rightImageSrc);
            mIVRight.setImageDrawable(rightImage);
            final Drawable rightleftImage = a.getDrawable(R.styleable.YJSToolBar_rightLeftImageSrc);
            mIVRightLeft.setImageDrawable(rightleftImage);
            final String title = a.getString(R.styleable.YJSToolBar_centerTitle);
            mTVCenter.setText(title);
            a.recycle();
        }
    }

    private void initView() {
        if (mView == null) {
            mInflater = LayoutInflater.from(getContext());
            mView = mInflater.inflate(R.layout.home_toolbar, null);
            mIVLeft = (ImageView) mView.findViewById(R.id.id_toobar_left);
            mIVRight = (ImageView) mView.findViewById(R.id.id_toobar_right);
            mIVRightLeft = (ImageView) mView.findViewById(R.id.id_toobar_right_left);
            mTVCenter = (TextView) mView.findViewById(R.id.id_toobar_center);
            mIVLeft.setOnClickListener(this);
            mIVRight.setOnClickListener(this);
            mIVRightLeft.setOnClickListener(this);
            LayoutParams lp = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER);
            addView(mView, lp);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_toobar_left:
                if (leftListener == null) {
                    throw new RuntimeException("未设置点击事件");
                }
                leftListener.onClick(v);
                break;

            case R.id.id_toobar_right:
                if (rightListener == null) {
                    throw new RuntimeException("未设置点击事件");
                }else {
                    rightListener.onClick(v);
                }
                break;
            case R.id.id_toobar_right_left:
                if (rightLeftListener == null) {
                    throw new RuntimeException("未设置点击事件");
                }
                rightLeftListener.onClick(v);

                break;
        }
    }

    public void setLeftImageResource(int res_id) {
        Drawable leftImage = getResources().getDrawable(res_id);
        mIVLeft.setImageDrawable(leftImage);
    }

    public void setRightImageResource(int res_id) {
        Drawable rightImage = getResources().getDrawable(res_id);
        mIVRight.setImageDrawable(rightImage);
    }

    public void setRightLeftImageResource(int res_id) {
        Drawable rightImage = getResources().getDrawable(res_id);
        mIVRightLeft.setImageDrawable(rightImage);
    }

    public void showRightLeftImage() {
        mIVRightLeft.setVisibility(View.VISIBLE);
    }

    public void DismissRightLeftImage() {
        mIVRightLeft.setVisibility(View.GONE);
    }


    public void setCenterText(String text) {
        mTVCenter.setText(text);
    }

}

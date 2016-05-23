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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yjtc.cbg.yjsapp.R;

/**
 * Created by Administrator on 2016/5/5/005.
 */
public class YJSNumTextButton extends LinearLayout {

    private LayoutInflater mInflater;
    private View mView;

    private int value;

    private TextView mNumText;
    private TextView mDescriptionText;


    public YJSNumTextButton(Context context) {
        this(context, null);
    }

    public YJSNumTextButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public YJSNumTextButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mInflater = LayoutInflater.from(getContext());
        initView();

        //获取自定义属性
        if (attrs != null) {
            final TintTypedArray a = TintTypedArray.obtainStyledAttributes(getContext(), attrs,
                    R.styleable.YJSNumTextButton, defStyleAttr, 0);

            final String title = a.getString(R.styleable.YJSNumTextButton_newsnum);
            setNumText(title);


            final String descrition = a.getString(R.styleable.YJSNumTextButton_newstext);
            setDescriptionText(descrition);

            a.recycle();
        }
    }

    private void initView() {
        mView = mInflater.inflate(R.layout.num_text_button, this, true);
        mNumText = (TextView) mView.findViewById(R.id.id_num);
        mDescriptionText = (TextView) mView.findViewById(R.id.id_description);
    }

    public void setNumText(String s) {
        mNumText.setText(s);
    }

    public void setDescriptionText(String s) {
        mDescriptionText.setText(s);
    }

}

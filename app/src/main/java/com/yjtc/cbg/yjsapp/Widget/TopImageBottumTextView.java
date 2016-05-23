package com.yjtc.cbg.yjsapp.Widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.internal.widget.TintTypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yjtc.cbg.yjsapp.R;

/**
 * Created by chenboge on 16/5/12.
 */
public class TopImageBottumTextView extends RelativeLayout{

    private LayoutInflater mInflater;
    private View mView;

    private ImageView TopImage;
    private TextView BottumText;


    public TopImageBottumTextView(Context context) {
        this(context, null);
    }

    public TopImageBottumTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TopImageBottumTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mInflater = LayoutInflater.from(getContext());
        initView();

        //获取自定义属性
        if (attrs != null) {
            final TintTypedArray a = TintTypedArray.obtainStyledAttributes(getContext(), attrs,
                    R.styleable.TopImageBottumTextView, defStyleAttr, 0);

            final Drawable rightImage = a.getDrawable(R.styleable.TopImageBottumTextView_topImage);
            TopImage.setImageDrawable(rightImage);


            final String descrition = a.getString(R.styleable.TopImageBottumTextView_bottumText);
            BottumText.setText(descrition);

            a.recycle();
        }
    }

    private void initView() {
        mView = mInflater.inflate(R.layout.template_auctioning_header_view, this, true);
        TopImage = (ImageView) mView.findViewById(R.id.id_head);
        BottumText = (TextView) mView.findViewById(R.id.Tv);
    }



}

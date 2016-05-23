package com.yjtc.cbg.yjsapp.Widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.yjtc.cbg.yjsapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenboge on 16/5/10.
 */
public class MyPopupWindow extends PopupWindow {

    private View conentView;
    //泡泡窗口内部子item集合
    private int[] mChild;

    private OnItemClickListener mListener;

    private Context mContext;

    public void setmListener(OnItemClickListener mListener) {
        this.mListener = mListener;
    }

    public MyPopupWindow(final Activity context, int res_id, int[] items) {
        mChild = items;
        mContext = context;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        conentView = inflater.inflate(res_id, null);
        int h = context.getWindowManager().getDefaultDisplay().getHeight();
        int w = context.getWindowManager().getDefaultDisplay().getWidth();

        this.setContentView(conentView);

        this.setWidth(w / 2 + 50);

        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);

        this.setFocusable(true);
        this.setOutsideTouchable(true);

        this.update();

        ColorDrawable dw = new ColorDrawable(0000000000);

        this.setBackgroundDrawable(dw);

        this.setAnimationStyle(R.style.AnimationPreview);

        final LinearLayout mlayout = (LinearLayout) conentView
                .findViewById(mChild[0]);
        mlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.OneClick();
            }
        });

        final LinearLayout mlayout1 = (LinearLayout) conentView
                .findViewById(mChild[1]);
        mlayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.TwoClick();
            }
        });
    }

    /**
     * œ‘ æpopupWindow
     *
     * @param parent
     */
    public void showPopupWindow(View parent) {
        if (!this.isShowing()) {
            // “‘œ¬¿≠∑Ω Ωœ‘ æpopupwindow
            this.showAsDropDown(parent, parent.getLayoutParams().width / 2, 18);
        } else {
            this.dismiss();
        }
    }


    public interface OnItemClickListener {
        void OneClick();

        void TwoClick();

        void ThreeClick();

        void FourClick();
    }
}

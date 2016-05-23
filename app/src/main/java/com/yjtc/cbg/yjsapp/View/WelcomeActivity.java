package com.yjtc.cbg.yjsapp.View;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.widget.ImageView;

import com.yjtc.cbg.yjsapp.R;
import com.yjtc.cbg.yjsapp.util.SceneAnimationUtil;
import com.yjtc.cbg.yjsapp.util.ToastUtil;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by chen on 2016/5/19.
 */
@ContentView(R.layout.welcome)
public class WelcomeActivity extends BaseActivity {
    @ViewInject(R.id.id_welcome_anim)
    private ImageView mImage;

    private int[] meetPics = new int[]{
            R.mipmap.animation0001, R.mipmap.animation0002,
            R.mipmap.animation0003, R.mipmap.animation0004,
            R.mipmap.animation0005, R.mipmap.animation0006,
            R.mipmap.animation0007, R.mipmap.animation0008,
            R.mipmap.animation0009, R.mipmap.animation0010,
            R.mipmap.animation0011, R.mipmap.animation0012,
            R.mipmap.animation0013, R.mipmap.animation0014,
            R.mipmap.animation0015, R.mipmap.animation0016,
            R.mipmap.animation0017, R.mipmap.animation0018,
            R.mipmap.animation0019, R.mipmap.animation0020,
            R.mipmap.animation0021, R.mipmap.animation0022,
            R.mipmap.animation0023, R.mipmap.animation0024,
            R.mipmap.animation0025, R.mipmap.animation0026,
            R.mipmap.animation0027, R.mipmap.animation0028,
            R.mipmap.animation0029, R.mipmap.animation0030,
            R.mipmap.animation0031, R.mipmap.animation0032,
            R.mipmap.animation0033, R.mipmap.animation0034,
            R.mipmap.animation0035, R.mipmap.animation0036,
            R.mipmap.animation0037, R.mipmap.animation0038,
            R.mipmap.animation0039, R.mipmap.animation0040,
            R.mipmap.animation0041, R.mipmap.animation0042,
            R.mipmap.animation0043, R.mipmap.animation0044,
            R.mipmap.animation0045, R.mipmap.animation0046,
            R.mipmap.animation0047, R.mipmap.animation0048};


    @Override
    void initData() {
        SceneAnimationUtil anim = new SceneAnimationUtil(mImage, meetPics, 1, new SceneAnimationUtil.onAnimationEndListener() {
            @Override
            public void click() {
                startActivity(new Intent(WelcomeActivity.this, GuideActivity.class));
            }
        });

    }
}

package com.yjtc.cbg.yjsapp.View;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.yjtc.cbg.yjsapp.Presenter.GuidePresenter;
import com.yjtc.cbg.yjsapp.R;
import com.yjtc.cbg.yjsapp.View.inter.IGuide;
import com.yjtc.cbg.yjsapp.app.MyApplication;
import com.yjtc.cbg.yjsapp.bean.User;
import com.yjtc.cbg.yjsapp.util.SharperenceUtil;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by chenboge on 16/4/29.
 */
@ContentView(R.layout.guide)
public class GuideActivity extends BaseActivity implements IGuide {

    @ViewInject(R.id.ll)
    private LinearLayout mLayout;

    private GuidePresenter mPresenter;

    @ViewInject(R.id.viewpager)
    private ViewPager mPager;

    @ViewInject(R.id.id_guide_live)
    private Button LiveButton;

    private MyApplication app = null;

    @Override
    void initData() {
        mPresenter = new GuidePresenter(this, this);
        mPresenter.loacher();
        app=MyApplication.getInstanse();
        fideLiveButton();
    }

    @Override
    public ViewPager getViewpager() {
        return mPager;
    }

    @Override
    public LinearLayout getLayout() {
        return mLayout;
    }

    @Override
    public void showLiveButton() {
        LiveButton.setVisibility(View.VISIBLE);
    }

    @Override
    public void fideLiveButton() {
        LiveButton.setVisibility(View.GONE);
    }


    @Event(value = R.id.id_guide_live)
    private void live(View view) {
        String username = SharperenceUtil.getString(this, "username");
        if (username != null) {
            User user = new User(username, SharperenceUtil.getString(this, "password"));
            app.putUser(user);
            startActivity(new Intent(GuideActivity.this, LoginActivity.class));
            finish();
        } else {
            startActivity(new Intent(GuideActivity.this, GuideLogin.class));
            finish();
        }
        //startActivity(new Intent(GuideActivity.this, MineActivity.class));
    }

}

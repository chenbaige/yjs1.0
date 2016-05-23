package com.yjtc.cbg.yjsapp.Presenter;

import com.yjtc.cbg.yjsapp.View.inter.IHomePage;
import com.yjtc.cbg.yjsapp.model.HomeModel;
import com.yjtc.cbg.yjsapp.model.inter.IHome;

/**
 * Created by chenboge on 16/4/30.
 */

public class HomeActivityPresenter {

    private IHome homeModel = new HomeModel();
    private IHomePage homePage;

    public HomeActivityPresenter(IHomePage homePage) {
        this.homePage = homePage;
    }

    public void initPager() {
       // homePage.initViewPager(homeModel.getFragments());
    }

    public void showCurrentTab(int position){

    }

}

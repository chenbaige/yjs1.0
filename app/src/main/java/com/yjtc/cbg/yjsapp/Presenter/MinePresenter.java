package com.yjtc.cbg.yjsapp.Presenter;

import com.yjtc.cbg.yjsapp.View.inter.IMineActivity;
import com.yjtc.cbg.yjsapp.model.inter.IMineModel;
import com.yjtc.cbg.yjsapp.model.MineModel;

/**
 * Created by chenboge on 16/5/6.
 */
public class MinePresenter {

    private IMineModel mineModel = new MineModel();
    private IMineActivity mineActivity;

    public MinePresenter(IMineActivity mineActivity) {
        this.mineActivity = mineActivity;
    }

    public void initGalleryData() {
        mineActivity.initGalleryData(mineModel.getBanners());
    }

    public void initContentData() {
        mineActivity.initContentData(mineModel.getArts());
    }
}

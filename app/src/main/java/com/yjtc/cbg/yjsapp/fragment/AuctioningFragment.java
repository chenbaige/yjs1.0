package com.yjtc.cbg.yjsapp.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.yjtc.cbg.yjsapp.Presenter.AuctionPresenter;
import com.yjtc.cbg.yjsapp.R;
import com.yjtc.cbg.yjsapp.Widget.TopImageBottumTextView;
import com.yjtc.cbg.yjsapp.bean.Banner;
import com.yjtc.cbg.yjsapp.fragment.inter.IAuctioningFragment;
import com.yjtc.cbg.yjsapp.model.HomeModel;
import com.yjtc.cbg.yjsapp.model.inter.IHome;
import com.yjtc.cbg.yjsapp.util.ToastUtil;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.List;

/**
 * Created by chenboge on 16/5/11.
 */
@ContentView(R.layout.auction)
public class AuctioningFragment extends BaseV4Fragment implements IAuctioningFragment {

    private AuctionPresenter mPresenter;

    private View HeaderView=null;

    @ViewInject(R.id.id_home_content)
    private RecyclerView mHeaderView;

    @Override
    void initData() {
        mPresenter = new AuctionPresenter(this, getActivity());
        mPresenter.initHeaderView(mHeaderView);
        addToolBarlistener();
    }

    private void addToolBarlistener() {
        mToolbar.showRightLeftImage();
        mToolbar.setRightLeftListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    void leftClick() {
        Toast.makeText(getActivity(), "left", Toast.LENGTH_SHORT).show();
    }

    @Override
    void rightClick() {
        Toast.makeText(getActivity(), "right", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStop() {
       mPresenter.onHeaderViewEnd();
        super.onStop();
    }


}

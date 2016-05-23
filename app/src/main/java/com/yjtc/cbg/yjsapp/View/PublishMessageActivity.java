package com.yjtc.cbg.yjsapp.View;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.yjtc.cbg.yjsapp.Adapter.PublishMessageAdapter;
import com.yjtc.cbg.yjsapp.Adapter.layoutmanager.FullyGridLayoutManager;
import com.yjtc.cbg.yjsapp.Presenter.PublishMessagePresenter;
import com.yjtc.cbg.yjsapp.R;
import com.yjtc.cbg.yjsapp.View.inter.IpubMsg;
import com.yjtc.cbg.yjsapp.Widget.YJSToolBar;
import com.yjtc.cbg.yjsapp.util.ToastUtil;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

import me.iwf.photopicker.PhotoPagerActivity;
import me.iwf.photopicker.PhotoPickerActivity;
import me.iwf.photopicker.utils.PhotoPickerIntent;

/**
 * Created by chen on 2016/5/15.
 */
@ContentView(R.layout.publish_message)
public class PublishMessageActivity extends BaseActivity implements IpubMsg {
    @ViewInject(R.id.id_toolbar)
    private YJSToolBar mToolbar;

    @ViewInject(R.id.id_message_content)
    private EditText mTextContent;

    @ViewInject(R.id.id_image_content)
    private RecyclerView mImageContent;

    @ViewInject(R.id.id_current_address)
    private TextView mTextAddress;

    private ArrayList<String> mDatas = new ArrayList<>();

    //activity请求码
    private static final int INTENT_REQUEST_CODE = 2000;

    private PublishMessageAdapter mAdapter;

    private PublishMessagePresenter mPresenter;

    @Override
    void initData() {
        //mTextContent.clearFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(mTextContent.getWindowToken(), 0);
        mPresenter = new PublishMessagePresenter(this, getApplicationContext());
        initAdapter();
    }

    private void initAdapter() {
        mAdapter = new PublishMessageAdapter(this, mDatas, R.layout.template_publish_message);
        mImageContent.setAdapter(mAdapter);
        mImageContent.setLayoutManager(new FullyGridLayoutManager(this,3));
    }

    @Event(value = {R.id.id_location, R.id.id_image, R.id.id_expression, R.id.id_attention})
    private void handdle(View view) {
        switch (view.getId()) {
            case R.id.id_location:
                mPresenter.startLocation();
                break;

            case R.id.id_image:
                PhotoPickerIntent intent = new PhotoPickerIntent(PublishMessageActivity.this);
                intent.setPhotoCount(9);
                intent.setShowCamera(true);
                startActivityForResult(intent, INTENT_REQUEST_CODE);
                break;

            case R.id.id_expression:

                break;

            case R.id.id_attention:

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        List<String> photos = null;
        if (resultCode == RESULT_OK && requestCode == INTENT_REQUEST_CODE) {
            if (data != null) {
                photos = data.getStringArrayListExtra(PhotoPickerActivity.KEY_SELECTED_PHOTOS);
            }
            mDatas.clear();

            if (photos != null) {
                mDatas.addAll(photos);
            }
            mAdapter.notifyDataSetChanged();
        }
    }

    public void previewPhoto(Intent intent) {
        startActivity(intent);
        startActivityForResult(intent, INTENT_REQUEST_CODE);
    }

    @Override
    public void getImageSuccess() {
        mAdapter.getDatas();
    }

    @Override
    public void LocationSuccess(String location) {
        ToastUtil.showToast(this, location);
        mTextAddress.setVisibility(View.VISIBLE);
        mTextAddress.setText(location);
    }

}

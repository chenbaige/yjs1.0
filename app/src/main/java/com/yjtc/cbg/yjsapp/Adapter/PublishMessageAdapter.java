package com.yjtc.cbg.yjsapp.Adapter;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import com.yjtc.cbg.yjsapp.MainActivity;
import com.yjtc.cbg.yjsapp.R;
import com.yjtc.cbg.yjsapp.View.PublishMessageActivity;
import com.yjtc.cbg.yjsapp.bean.Banner;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import me.iwf.photopicker.PhotoPagerActivity;

/**
 * Created by chen on 2016/5/17.
 */
public class PublishMessageAdapter extends BaseAdapter<String, BaseViewHolder> implements View.OnClickListener{

    private ArrayList<String> photoPaths = new ArrayList<String>();

    public PublishMessageAdapter(Context mContext, ArrayList<String> mDatas, int itemViewID) {
        super(mContext, mDatas, itemViewID);
        this.photoPaths=mDatas;
    }

    @Override
    void bindData(BaseViewHolder holder, final int position) {
        Uri uri = Uri.fromFile(new File(mDatas.get(position)));

        Glide.with(mContext)
                .load(uri)
                .centerCrop()
                .thumbnail(0.1f)
                .placeholder(R.mipmap.myhead)
                .error(R.mipmap.ic_launcher)
                .into(holder.getImageView(R.id.id_image));

        holder.getImageView(R.id.id_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(mContext,"dianjia",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext, PhotoPagerActivity.class);
                intent.putExtra(PhotoPagerActivity.EXTRA_CURRENT_ITEM, position);
                intent.putExtra(PhotoPagerActivity.EXTRA_PHOTOS, photoPaths);
               // intent.putExtra(PhotoPagerActivity.EXTRA_SHOW_DELETE, true);
                if (mContext instanceof MainActivity) {
                    ((PublishMessageActivity) mContext).previewPhoto(intent);
                }
            }
        });
        holder.getImageView(R.id.id_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setMessage("确认移除已添加图片吗？");
                builder.setTitle("提示");
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        removeItem(mDatas.get(position));
                        notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();

            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}

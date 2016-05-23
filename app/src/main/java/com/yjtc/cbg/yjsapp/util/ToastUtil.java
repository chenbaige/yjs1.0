package com.yjtc.cbg.yjsapp.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by chenboge on 16/2/16.
 */
public class ToastUtil {

    public static void showToast(Context context,String s){
        Toast.makeText(context,s,Toast.LENGTH_SHORT).show();
    }


    public static void showToast(Context context,int resid){
        showToast(context,context.getString(resid));
    }
}

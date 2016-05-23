package com.yjtc.cbg.yjsapp.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2016/5/5/005.
 */
public class SharperenceUtil {
    private static final String ShareName = "yjsApp";
    private static SharedPreferences mSharedPreferences;


    private static SharedPreferences getmSharedPreferences(Context context) {
        return context.getSharedPreferences(ShareName, Context.MODE_PRIVATE);
    }

    public static String getString(Context context, String sName) {
        SharedPreferences sharedPreferences = getmSharedPreferences(context);
        return sharedPreferences.getString(sName, null);
    }

    public static void putString(Context context, String sName, String value) {
        SharedPreferences sharedPreferences = getmSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(sName, value);
        editor.commit();
    }


}

package com.application.listview;

import android.graphics.drawable.Drawable;
import android.util.Log;

/**
 * by MIlk
 * 2021.9.15
 * QQ 718243104
 * email loc1234@qq.com
 */
public class AppInfo {
    public int num = 0;
    public String appName = "";
    public String packageName = "";
    public String versionName = "";
    public int versionCode = 0;
    public Drawable appIcon = null;

    public void print() {
        Log.e("APP信息：", "名称:" + appName + "\n包名:" + packageName + "\nversionName:" + versionName + "\nversionCode:" + versionCode);
    }
}

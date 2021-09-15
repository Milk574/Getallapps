package com.application.listview;

import android.graphics.drawable.Drawable;

/**
 * by MIlk
 * 2021.9.15
 * QQ 718243104
 * email loc1234@qq.com
 */

public class MyFruit {
    private final String name;
    private final String bmName;
    private final String verName;
    private final int codeName;
    private final Drawable imageId;


    public MyFruit(String name, String bmName, int codeName, String verName, Drawable imageId) {
        this.name = name;
        this.bmName = bmName;
        this.codeName = codeName;
        this.verName = verName;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public String getbmName() {
        return bmName;
    }

    public int getcodeName() {
        return codeName;
    }

    public String getverName() {
        return verName;
    }

    public Drawable getImageId() {
        return imageId;
    }
}

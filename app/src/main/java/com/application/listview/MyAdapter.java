package com.application.listview;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * by MIlk
 * 2021.9.15
 * QQ 718243104
 * email loc1234@qq.com
 */
public class MyAdapter extends ArrayAdapter<MyFruit> {
    private final int resourceId;

    public MyAdapter(Context context, int textViewResourceId, List<MyFruit> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyFruit fruit = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.fruitImage = view.findViewById(R.id.imageview1);
            viewHolder.fruitName = view.findViewById(R.id.textview1);
            viewHolder.fruitversionName = view.findViewById(R.id.textview2);
            viewHolder.fruitversionCode = view.findViewById(R.id.textview3);
            viewHolder.fruitpackageName = view.findViewById(R.id.textview4);

            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.fruitImage.setImageDrawable(fruit.getImageId());
        viewHolder.fruitName.setText("AppName:     " + fruit.getName());
        viewHolder.fruitversionName.setText("VersionCode:" + fruit.getcodeName());
        viewHolder.fruitpackageName.setText("PackageName:            " + fruit.getbmName());
        viewHolder.fruitversionCode.setText("VersionName:             " + fruit.getverName());

        return view;
    }

    class ViewHolder {
        ImageView fruitImage;
        TextView fruitName;
        TextView fruitpackageName;
        TextView fruitversionName;
        TextView fruitversionCode;

    }

}

package com.application.listview;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * by MIlk
 * 2021.9.15
 * QQ 718243104
 * email loc1234@qq.com
 */
public class MainActivity extends AppCompatActivity {
    private final List<MyFruit> fruitList = new ArrayList<>();
    private final ArrayList<AppInfo> appList = new ArrayList<>();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (MyToast.toast != null) MyToast.toast = null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Get all Apps---by Milk");
        setContentView(R.layout.activity_main);
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setIcon(R.mipmap.ic_launcher)
                .setCancelable(false)
                .setTitle("˚*̥(∗*⁰͈꒨⁰͈)*̥哇哦~")
                .setMessage("@by Milk\n@2021.9.15\n@企鹅：718243104\n@Email：loc1234@qq.com\n@我希望能得到一个Star★")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MyToast.showLong(MainActivity.this, "@作者：Milk 开源日期@2021.9.15");
                        dialog.dismiss();

                    }
                })
                .setNegativeButton("前往仓库", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String urls = "https://github.com/Milk574/Getallapps.git";
                        MyToast.showLong(MainActivity.this, "跳转链接：" + urls);
                        Uri uri = Uri.parse(urls);
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);

                    }
                });
        dialog.show();

        List<PackageInfo> packages = getPackageManager().getInstalledPackages(0);
        AppInfo tmpInfo = new AppInfo();
        for (int i = 0; i < packages.size(); i++) {
            PackageInfo packageInfo = packages.get(i);
            if ((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0) {
                //非系统应用
                tmpInfo.appName = packageInfo.applicationInfo.loadLabel(getPackageManager()).toString();
                tmpInfo.packageName = packageInfo.packageName;
                tmpInfo.versionName = packageInfo.versionName;
                tmpInfo.versionCode = packageInfo.versionCode;
                tmpInfo.appIcon = packageInfo.applicationInfo.loadIcon(getPackageManager());
                appList.add(tmpInfo);
                tmpInfo.num = i;
                appList.add(tmpInfo);
                //tmpInfo.print();
                MyFruit a = new MyFruit(
                        tmpInfo.appName,
                        tmpInfo.packageName,
                        tmpInfo.versionCode,
                        tmpInfo.versionName,
                        tmpInfo.appIcon);
                fruitList.add(a);

            }
        }
        setTitle("Get all Apps---APP数量：" + tmpInfo.num + "   by Milk");
        //Log.e("APP：", "Number:" + tmpInfo.num);

        MyAdapter adapter = new MyAdapter(MainActivity.this, R.layout.fruit_item, fruitList);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MyFruit fruit = fruitList.get(position);
                MyToast.showLong(MainActivity.this, fruit.getName());
            }
        });

    }


}
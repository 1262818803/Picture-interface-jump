package com.example.asus.demo6;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GridView extends AppCompatActivity {
    private android.widget.GridView gridView;
    private List<Map<String, Object>> dataList;
    private SimpleAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_view);
        gridView = (android.widget.GridView) findViewById(R.id.gridview);
        //初始化数据
        initData();
        final String[] from={"img","text"};
        final int[] to={R.id.img,R.id.text};
        adapter=new SimpleAdapter(this, dataList, R.layout.gridview_item, from, to);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                //Dialog提示
               /* AlertDialog.Builder builder= new AlertDialog.Builder(GridView.this);
                builder.setTitle("提示").setMessage(dataList.get(arg2).get("text").toString()).create().show();*/
                Intent intent = new Intent(GridView.this, demos[arg2].demoClass);
                startActivity(intent);
            }
        });
    }

    void initData() {
        //图标
        int icno[] = {R.drawable.apple, R.drawable.banana,
                R.drawable.orange, R.drawable.watermelon, R.drawable.grape, R.drawable.pear,
                R.drawable.pineaoole, R.drawable.strawberry };
        //图标下的文字
        String name[]={"apple","banana","Item3","Item4","Item5","Item6","Item7","Item8","Item9"};
        dataList = new ArrayList<Map<String, Object>>();
        for (int i = 0; i <icno.length; i++) {
            Map<String, Object> map=new HashMap<String, Object>();
            map.put("img", icno[i]);
            map.put("text",name[i]);
            dataList.add(map);
        }
    }
    //点击相应图片跳转到相应界面
    //把每个activity转成class
    private static class DemoInfo {
        private final Class<? extends android.app.Activity> demoClass;
        public DemoInfo(Class<? extends android.app.Activity> demoClass) {
            this.demoClass = demoClass;
        }
    }
    //把每个activity转成xxx.class
    private static final DemoInfo[] demos = {
            new DemoInfo(apple.class),
            new DemoInfo(banana.class),
            /*new DemoInfo(ThirdGameActivity.class),
            new DemoInfo(FourthGameActivity.class),
            new DemoInfo(FifthGameActivity.class),
            new DemoInfo(SixthGameActivity.class)*/

    };
}

package com.example.asus.demo6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class food extends AppCompatActivity {
    private ListView Lv = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food);
        Lv = (ListView) findViewById(R.id.Lv);
        final String[] name = new String[] { "苹果", "香蕉", "葡萄" };

        final String[] message = new String[] {

                "苹果（学名：Malus pumila）是水果的一种，是蔷薇科苹果亚科苹果属植物，其树为落叶乔木。苹果的果实富含矿物质和维生素，是人们经常食用的水果之一。",

                "香蕉（学名：Musa nana Lour.）芭蕉科芭蕉属植物，又指其果实，热带地区广泛种植。香蕉味香、富含营养，植株为大型草本，从根状茎发出，" +
                        "由叶鞘下部形成高3～6公尺(10～20尺)的假杆；叶长圆形至椭圆形，有的长达3～3.5公尺(10～11.5尺)，宽65公分(26寸)，10～20枚簇生茎顶。穗状花序下垂 [1]  ，由假杆顶端抽出，花多数，淡黄色；果序弯垂，结果10～20串，约50～150个。" +
                        "植株结果后枯死，由根状茎长出的吸根继续繁殖，每一根株可活多年。原产亚洲东南部，台湾、海南、广东、广西等均有栽培。",

                "葡萄是世界最古老的果树树种之一，葡萄的植物化石发现于第三纪地层中，说明当时已遍布于欧、亚及格陵兰。 [1]  葡萄原产亚洲西部，世界各地均有栽培， [2]  世界各地的葡萄约95%集中分布在北半球。" };

        final int[] photo = new int[] { R.drawable.apple, R.drawable.banana, R.drawable.grape };

        List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();



        Map<String, Object> map1 = new HashMap<String, Object>();

        map1.put("photo", R.drawable.apple);

        map1.put("name", name[0]);

        data.add(map1);



        Map<String, Object> map2 = new HashMap<String, Object>();

        map2.put("photo", R.drawable.banana);

        map2.put("name", name[1]);

        data.add(map2);



        Map<String, Object> map3 = new HashMap<String, Object>();

        map3.put("photo", R.drawable.grape);

        map3.put("name", name[2]);

        data.add(map3);



        Lv.setAdapter(new SimpleAdapter(this, data, R.layout.food_item,new String[] { "photo", "name" }, new int[] { R.id.iv,R.id.tv_name }));

        Lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override

            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {



                Bundle bundle = new Bundle();

                bundle.putInt("photo", photo[arg2]);

                bundle.putString("message", message[arg2]);

                Intent intent = new Intent();

                intent.putExtras(bundle);

                intent.setClass(food.this, MoveFood.class);

                Log.i("message", message[arg2]);

                startActivity(intent);

            }

        });

    }
}

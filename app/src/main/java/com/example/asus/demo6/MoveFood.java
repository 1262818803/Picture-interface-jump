package com.example.asus.demo6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MoveFood extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.move_food);
        Bundle bundle=getIntent().getExtras();
        int id=bundle.getInt("photo");
        String message=bundle.getString("message");

        ImageView Iv=(ImageView) findViewById(R.id.Iv);
        Iv.setImageResource(id);
        TextView tv=(TextView) findViewById(R.id.tv_message);
        tv.setText(message);
        ImageView lc=(ImageView)findViewById(R.id.imv);
        lc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MoveFood.this,MapActivity.class);
                startActivity(intent);
            }
        });

    }
}

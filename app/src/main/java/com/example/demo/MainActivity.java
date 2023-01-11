package com.example.demo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Up> ups=new ArrayList<>();
    private TextView textView;
    private ImageView imageView;
    private UpAdapter upAdapter;
    private  RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         textView=this.findViewById(R.id.textview);
        imageView=this.findViewById(R.id.imageveiw);
        recyclerView=this.findViewById(R.id.recyclerview);
        initUps();
         upAdapter=new UpAdapter(ups);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(upAdapter);
        upAdapter.setOnItemClickListener(new onRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(RecyclerView parent, View view, int position) {
                //自定义点击后的功能事件 ...
                textView.setText(ups.get(position).getIntro());
                imageView.setImageResource(ups.get(position).getBackground());
            }

            @Override
            public void onItemLongClick(RecyclerView parent, View view, int position) {
                Log.d("aaaaaa","aaaaa");
                //自定义长按后的功能事件 ...
                Intent intent=new Intent(MainActivity.this,DetailActivity.class);

                intent.putExtra("up",ups.get(position));
                intent.putExtra("position",position);
                startActivityForResult(intent,1);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode==RESULT_OK) {

            int position = data.getIntExtra("position", 1);
            ups.remove(position);
            upAdapter.notifyDataSetChanged();
            if(ups.size()!=0) {

                textView.setText(ups.get(0).getIntro());
                imageView.setImageResource(ups.get(0).getBackground());
            }else {
                textView.setText("");
                imageView.setImageResource(R.mipmap.img_4);
            }
            super.onActivityResult(requestCode, resultCode, data);
        }

    }

    private void initUps(){
        Up up1=new Up("盗月社",R.mipmap.daoyueshe,R.mipmap.img,"739.5万","心里有光，哪儿都美。");
        ups.add(up1);
        Up up2=new Up("Meetfood觅食",R.mipmap.meetfood,R.mipmap.img_2,"236.2万","海外美食测评，美食的背后是文化和故事");
        ups.add(up2);
        Up up3=new Up("食贫道",R.mipmap.shipindao,R.mipmap.img_3,"269.7万","大开大合 vx:sihechuangyi");
        ups.add(up3);
        Up up4=new Up("哇塞几张",R.mipmap.wasaijizhang,R.mipmap.img_1,"166.6万","有趣的事情那么多，我先替你去试试！ 请全网@哇塞几张");
        ups.add(up4);
        textView.setText(ups.get(0).getIntro());
        imageView.setImageResource(ups.get(0).getBackground());
    }

}
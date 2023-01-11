package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {
    private  Up up;
    private  int position;
    private ImageView avatar;
    private TextView name;
    private  TextView fans;
    private Button cancel;
    private  boolean flag=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent=getIntent();
        up= (Up) intent.getSerializableExtra("up");
        position=intent.getIntExtra("position",1);
        avatar=this.findViewById(R.id.avatar);
        name=this.findViewById(R.id.name);
        fans=this.findViewById(R.id.fans);
        cancel=this.findViewById(R.id.cancel);
        avatar.setImageResource(up.getAvatar());
        name.setText(up.getName());
        fans.setText(String.valueOf(up.getFans()));
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"取关成功",Toast.LENGTH_SHORT).show();
                flag=true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(flag==true) {
            Intent intent = new Intent();
            intent.putExtra("position",position);
           setResult(RESULT_OK, intent);
        }
        else {
            setResult(RESULT_CANCELED);
        }
        finish();
    }


}
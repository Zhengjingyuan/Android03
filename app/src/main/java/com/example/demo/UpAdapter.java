package com.example.demo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UpAdapter extends RecyclerView.Adapter<UpAdapter.ViewHolder> implements View.OnClickListener ,View.OnLongClickListener{
    private  List<Up>ups;
    private onRecyclerViewItemClickListener onRecyclerViewItemClickListener;
    private RecyclerView rvParent;
    public UpAdapter(List<Up>ups) {
        this.ups=ups;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        rvParent = (RecyclerView) parent;
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.up_item,parent,false);
        view.setOnClickListener(this);
        view.setOnLongClickListener(this);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull UpAdapter.ViewHolder holder, int position) {
        Up up=ups.get(position);
        if(up!=null) {
            holder.textView.setText(up.getName());
            holder.imageView.setImageResource(up.getAvatar());
        }

    }

    @Override
    public int getItemCount() {
        return ups.size();
    }

    static class  ViewHolder extends  RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.avatar);
            textView=itemView.findViewById(R.id.name);
        }
    }


    //重载点击事件，指定点击事件时执行自定义的onItemClick
    @Override
    public void onClick(View view) {
        int position = rvParent.getChildAdapterPosition(view);
        if (onRecyclerViewItemClickListener != null)
            onRecyclerViewItemClickListener.onItemClick(rvParent, view, position);
    }



    @Override
    public boolean onLongClick(View v) {
        int position = rvParent.getChildAdapterPosition(v);
        if (onRecyclerViewItemClickListener != null)
            onRecyclerViewItemClickListener.onItemLongClick(rvParent, v, position);
        return true;
    }

    //实例化自定义接口
    public void setOnItemClickListener(onRecyclerViewItemClickListener onRecyclerViewItemClickListener) {
        this.onRecyclerViewItemClickListener = onRecyclerViewItemClickListener;
    }


}

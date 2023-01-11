package com.example.demo;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public interface onRecyclerViewItemClickListener{
    void onItemClick(RecyclerView parent, View view, int position);
    void onItemLongClick(RecyclerView parent, View view, int position);
}

package com.jiubao.rxjavasample.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiubao.rxjavasample.R;
import com.jiubao.rxjavasample.model.Item;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/12/4.
 */

public class ItemListAdapter extends RecyclerView.Adapter {
    List<Item> images;
    static class DebounceViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.imageIv)
        ImageView imageTv;
        @BindView(R.id.descriptionTv)
        TextView descriptionTv;

        public DebounceViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item,parent,false);
        return new DebounceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        DebounceViewHolder debounceViewHolder = (DebounceViewHolder) holder;
        Item image = images.get(position);
        Glide.with(holder.itemView.getContext())
                .load(image.imageUrl)
                .into(debounceViewHolder.imageTv);
        debounceViewHolder.descriptionTv.setText(image.description);
    }

    public void setImages(List<Item> images) {
        this.images = images;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return images == null ? 0 : images.size();
    }
}

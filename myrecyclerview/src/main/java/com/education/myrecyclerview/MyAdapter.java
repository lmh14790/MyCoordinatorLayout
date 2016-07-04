package com.education.myrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by zhonghang on 16/6/29.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<NewsData> newsDatas;

    interface ItemClickListener {
        void onTitleClick(View v, int position);

        void onImageClick(View v, int position);

        void onSubtitleClick(View v, int position);
    }

    private ItemClickListener listener;

    public void setListener(ItemClickListener listener) {
        this.listener = listener;
    }

    public MyAdapter(List<NewsData> dataList) {
        newsDatas = dataList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        MyViewHolder holder = new MyViewHolder(convertView);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        NewsData itemData = newsDatas.get(position);
        holder.textviewTitle.setText(itemData.getTitle());
        holder.textviewSubtitle.setText(itemData.getSubTitle());
    }

    @Override
    public int getItemCount() {
        return newsDatas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textviewTitle;
        TextView textviewSubtitle;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageview);
            textviewTitle = (TextView) itemView.findViewById(R.id.textview_title);
            textviewSubtitle = (TextView) itemView.findViewById(R.id.textview_subtitle);
            textviewTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onTitleClick(v, getLayoutPosition());
                    }
                }
            });
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onImageClick(v, getLayoutPosition());
                    }
                }
            });
            textviewSubtitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onSubtitleClick(v, getLayoutPosition());
                    }
                }
            });
        }
    }
}

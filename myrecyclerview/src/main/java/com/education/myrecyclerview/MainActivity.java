package com.education.myrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<NewsData> newsDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        newsDatas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            newsDatas.add(new NewsData("标题" + i, "", "说明" + i));
        }
        MyAdapter adapter = new MyAdapter(newsDatas);
        //LinearLayoutManager manager = new LinearLayoutManager(this);
        //manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        GridLayoutManager manager=new GridLayoutManager(this,2);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager);
        adapter.setListener(new MyAdapter.ItemClickListener() {
            @Override
            public void onTitleClick(View v, int position) {
                Toast.makeText(MainActivity.this, "上标题的点击事件:" + newsDatas.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onImageClick(View v, int position) {
                Toast.makeText(MainActivity.this, "图片的点击事件:" + newsDatas.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSubtitleClick(View v, int position) {

            }
        });
        recyclerView.setAdapter(adapter);
    }
}

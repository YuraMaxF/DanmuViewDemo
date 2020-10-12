package com.yuramax.danmuviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * author : weijun
 * e-mail : 1301892339@qq.com
 * time   : 2020/10/12
 * desc   :
 * version: 1.0
 */
public class MainActivity extends AppCompatActivity {

    private static final int MSG_START = 1;
    private static final int MSG_STOP = 2;

    private RecyclerView recyclerView;

    private List<Integer> mList = new ArrayList<>();
    private MyHandler mHandler;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHandler = new MyHandler(this);
        initUI();
        initData();
        initRv();
    }

    private void initRv() {
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        layoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);

        DanmuChildAdapter adapter = new DanmuChildAdapter(mList);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                Toast.makeText(MainActivity.this,position + "",Toast.LENGTH_SHORT).show();
            }
        });

        View view = getLayoutInflater().inflate(R.layout.item_header, null);
        adapter.addHeaderView(view);
    }

    private void initData() {
        for (int i = 0;i <= 10;i++){
            mList.add(i);
        }
    }

    private void initUI() {
        recyclerView = findViewById(R.id.rv);
    }

    private Runnable scrollRunnable = new Runnable() {
        @Override
        public void run() {
            if (recyclerView != null){
                recyclerView.scrollBy(3,0);
            }
            mHandler.postDelayed(scrollRunnable,10);
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        mHandler.postDelayed(scrollRunnable,10);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mHandler.removeCallbacks(scrollRunnable);
    }

    private static class MyHandler extends Handler {

        private WeakReference<Activity> reference;

        public MyHandler(Activity activity){
            reference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            MainActivity activity = (MainActivity) reference.get();
            if (activity != null){
                switch (msg.what){
                    case MSG_START:

                        break;
                    case MSG_STOP:

                        break;
                }
            }
        }
    }
}

package com.example.liaoshudong1231;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.liaoshudong1231.adapter.MyAdapter;
import com.example.liaoshudong1231.base.BaseActivity;
import com.example.liaoshudong1231.base.BasePresenter;
import com.example.liaoshudong1231.bean.ShpBean;
import com.example.liaoshudong1231.http.HttpUrl;
import com.example.liaoshudong1231.mvp.IPresenterImpl;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends BaseActivity {
    //@BindView(R.id.recy)
   private RecyclerView recy;
    private Unbinder bind;
    private List<ShpBean.RankingBean> list = new ArrayList<>();

    @Override
    protected void initData() {
        //网络
        mPrensenter.onPresenter(HttpUrl.SHPURL);
        //绑定
        bind = ButterKnife.bind(this);


    }

    @Override
    protected BasePresenter initPrensenter() {
        return new IPresenterImpl();
    }

    @Override
    protected void initViews() {
        recy= findViewById(R.id.recy);
        recy.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected int inityout() {
        return R.layout.activity_main;
    }

    @Override
    public void onSuccess(String json) {
        Gson gson = new Gson();
        ShpBean shpBean = gson.fromJson(json, ShpBean.class);
        List<ShpBean.RankingBean> ranking = shpBean.getRanking();
        list.addAll(ranking);
        MyAdapter myAdapter = new MyAdapter(this, list);
        recy.setAdapter(myAdapter);
        //点击
        myAdapter.setCallback(new MyAdapter.onClickCallback() {
            @Override
            public void setonclick(String potion) {
                Toast.makeText(MainActivity.this, potion, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onError(String error) {

    }
    @OnClick(R.id.tv_name)
    public void nameClick(View view){
        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
        startActivity(intent);
    }

    //销毁
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bind!=null){
            bind.unbind();
        }
    }
}

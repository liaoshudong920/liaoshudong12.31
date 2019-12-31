package com.example.liaoshudong1231.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.liaoshudong1231.contract.IContract;

/**
 * Time:2019/12/31   9:20
 * <p>
 * Author:Dell廖述东
 * <p>
 * Description:
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IContract.IView {
    public P mPrensenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(inityout());
        initViews();
        mPrensenter=initPrensenter();
        if (mPrensenter!=null){
            mPrensenter.onActh(this);
        }
        initData();
    }

    protected abstract void initData();

    protected abstract P initPrensenter();

    protected abstract void initViews();

    protected abstract int inityout();
}

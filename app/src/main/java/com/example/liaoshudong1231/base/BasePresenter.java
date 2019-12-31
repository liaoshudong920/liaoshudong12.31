package com.example.liaoshudong1231.base;

import com.example.liaoshudong1231.contract.IContract;

import java.lang.ref.WeakReference;

/**
 * Time:2019/12/31   9:16
 * <p>
 * Author:Dell廖述东
 * <p>
 * Description:
 */
public abstract class BasePresenter<V extends IContract.IView> implements IContract.Ipresenter {
    private WeakReference<V> mVWeakReference;

    public BasePresenter() {
        initViewModel();
    }
    //绑定
    protected void onActh(V v){
        mVWeakReference = new WeakReference<>(v);
    }
    //解绑
    protected void  onDetory(){
        if (mVWeakReference!=null){
            mVWeakReference.clear();
            mVWeakReference=null;
        }
    }
    public V getView(){
        return mVWeakReference.get();
    }

    protected abstract void initViewModel();
}

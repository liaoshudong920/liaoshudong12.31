package com.example.liaoshudong1231.mvp;

import com.example.liaoshudong1231.contract.IContract;
import com.example.liaoshudong1231.net.NetUtlis;

/**
 * Time:2019/12/31   9:15
 * <p>
 * Author:Dell廖述东
 * <p>
 * Description:
 */
public class IModelImpl implements IContract.IModel {
    @Override
    public void onGetInfo(String url, IContract.ICallback callback) {
        NetUtlis.getInstance().GetInfo(url, new NetUtlis.NetCallback() {
            @Override
            public void onSuccess(String json) {
                callback.onSuccess(json);
            }

            @Override
            public void onError(String error) {
                callback.onError(error);
            }
        });
    }

}

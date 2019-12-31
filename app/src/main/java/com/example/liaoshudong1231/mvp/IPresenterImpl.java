package com.example.liaoshudong1231.mvp;

import com.example.liaoshudong1231.base.BasePresenter;
import com.example.liaoshudong1231.contract.IContract;

/**
 * Time:2019/12/31   9:19
 * <p>
 * Author:Dell廖述东
 * <p>
 * Description:
 */
public class IPresenterImpl extends BasePresenter {
    private IModelImpl iModel;

    @Override
    protected void initViewModel() {
        iModel = new IModelImpl();
    }

    @Override
    public void onPresenter(String url) {
        iModel.onGetInfo(url, new IContract.ICallback() {
            @Override
            public void onSuccess(String json) {
                getView().onSuccess(json);
            }

            @Override
            public void onError(String error) {
                getView().onError(error);
            }
        });
    }
}

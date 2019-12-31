package com.example.liaoshudong1231.contract;

/**
 * Time:2019/12/31   9:12
 * <p>
 * Author:Dell廖述东
 * <p>
 * Description:
 */
public interface IContract {
    //Model
    interface IModel{
        void onGetInfo(String url,ICallback callback);
    }
    //接口回调
    interface ICallback{
        void onSuccess(String json);
        void onError(String error);
    }
    //View
    interface IView{
        void onSuccess(String json);
        void onError(String error);
    }
    //Presenter
    interface Ipresenter{
        void onPresenter(String url);
    }

}

package com.example.liaoshudong1231.net;

import android.content.Context;
import android.net.ConnectivityManager;

import com.example.liaoshudong1231.app.App;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Time:2019/12/31   8:58
 * <p>
 * Author:Dell廖述东
 * <p>
 * Description:
 */
public class NetUtlis {

    private final OkHttpClient okHttpClient;

    //构造函数
    public NetUtlis() {
        //拦截器
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5,TimeUnit.SECONDS)
                .addInterceptor(interceptor.setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
    }
    private  static class MyNetUtlis{
        private static NetUtlis netUtlis = new NetUtlis();
    }

    public static NetUtlis getInstance() {
        return MyNetUtlis.netUtlis;
    }
    //接口回调
    public interface NetCallback{
        void onSuccess(String json);
        void onError(String error);
    }
    //get
    public void GetInfo(String url,NetCallback callback){
        Request request= new Request.Builder()
                .get()
                .url(url)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onError(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                callback.onSuccess(response.body().string());
            }
        });

    }
//    //网络判断
//    public boolean iswang(){
//        ConnectivityManager connectivityManager = (ConnectivityManager) App.context.getSystemService(Context.CONNECTIVITY_SERVICE);
//
//
//    }



}

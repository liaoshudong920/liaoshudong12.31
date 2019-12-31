package com.example.liaoshudong1231.glide;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.example.liaoshudong1231.R;
import com.example.liaoshudong1231.app.App;

/**
 * Time:2019/12/31   9:40
 * <p>
 * Author:Dell廖述东
 * <p>
 * Description:
 */
public class NetGlide {
    public static void LodingImage(String url, ImageView imageView){
        Glide.with(App.context)
                .load(url)
                .error(R.drawable.ic_launcher_background)
                .priority(Priority.HIGH)
                .error(R.drawable.ic_launcher_background)
                .into(imageView);
    }
}

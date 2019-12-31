package com.example.liaoshudong1231;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.uuzuche.lib_zxing.activity.CodeUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnLongClick;
import butterknife.Unbinder;

public class Main2Activity extends AppCompatActivity {
    @BindView(R.id.code_image)
    ImageView codeimage;
    private Unbinder bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //初始化
        CodeUtils.init(this);
        //绑定
        bind = ButterKnife.bind(this);
        //生成二维码
        Bitmap image = CodeUtils.createImage("廖述东", 200, 200, BitmapFactory.decodeResource(getResources(), R.drawable.head));
        codeimage.setImageBitmap(image);
    }
    @OnLongClick(R.id.code_image)
    public void Longimage(View view){
        CodeUtils.analyzeByImageView(codeimage, new CodeUtils.AnalyzeCallback() {
            @Override
            public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                Toast.makeText(Main2Activity.this, result, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnalyzeFailed() {
                Toast.makeText(Main2Activity.this, "解析失败", Toast.LENGTH_SHORT).show();
            }
        });

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

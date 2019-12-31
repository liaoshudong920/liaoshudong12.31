package com.example.liaoshudong1231.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.liaoshudong1231.R;
import com.example.liaoshudong1231.bean.ShpBean;
import com.example.liaoshudong1231.glide.NetGlide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Time:2019/12/31   9:30
 * <p>
 * Author:Dell廖述东
 * <p>
 * Description:
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {
    private Context context;
    private List<ShpBean.RankingBean> list = new ArrayList<>();

    public MyAdapter(Context context, List<ShpBean.RankingBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.one_item, null);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.one_rank.setText(list.get(position).getRank()+"");
        holder.one_name.setText(list.get(position).getName()+"");
        NetGlide.LodingImage(list.get(position).getAvatar(),holder.one_image);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.setonclick(list.get(position).getName()+"");
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.one_rank)
        TextView one_rank;
        @BindView(R.id.one_image)
        ImageView one_image;
        @BindView(R.id.one_name)
        TextView one_name;
        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    public interface onClickCallback{
        void setonclick(String potion);
    }
    public onClickCallback callback;

    public void setCallback(onClickCallback callback) {
        this.callback = callback;
    }
}

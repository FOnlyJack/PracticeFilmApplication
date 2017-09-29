package com.example.changemax.sqhappy.ui.adapter;

import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.changemax.sqhappy.R;
import com.example.changemax.sqhappy.model.network.entity.ActorsBean;
import com.orhanobut.logger.Logger;

import java.util.List;

/**
 * Created by ChangeMax on 2017/3/20.   电影详情的RV  导演演员
 */

public class FilmDetailRvAdapter extends BaseMultiItemQuickAdapter<ActorsBean, BaseViewHolder> {


    public FilmDetailRvAdapter(List<ActorsBean> data) {
        super(data);

        addItemType(ActorsBean.ACTOR, R.layout.film_detail_credit_actor_item);
        addItemType(ActorsBean.DIRECTOR, R.layout.film_detail_credit_director_item);
        addItemType(ActorsBean.DEFULT, R.layout.film_detail_credit_director_item);
    }

    @Override
    protected void convert(BaseViewHolder helper, ActorsBean item) {
        switch (helper.getItemViewType()) {

            case ActorsBean.ACTOR:

                String name = item.getName();
                Glide.with(mContext)
                        .load(item.getImg())
                        .fitCenter()
                        .centerCrop()
                        .crossFade()
                        .into((ImageView) helper.getView(R.id.iv_credit_actor));
                if (TextUtils.isEmpty(name)) {
                    helper.setText(R.id.tv_actor_typename, item.getNameEn())
                            .setText(R.id.tv_actor_typename_en, item.getRoleName());
                } else {
                    helper.setText(R.id.tv_actor_typename, name)
                            .setText(R.id.tv_actor_typename_en, item.getRoleName());
                }
                break;
            case ActorsBean.DIRECTOR:
                Glide.with(mContext)
                        .load(item.getImg())
                        .fitCenter()
                        .centerCrop()
                        .crossFade()
                        .into((ImageView) helper.getView(R.id.iv_credit_director));
                helper.setText(R.id.tv_credit_director, "导演")
                        .setText(R.id.tv_director_typename, item.getName());
                break;
            case ActorsBean.DEFULT:
                String dename = item.getName();
                Glide.with(mContext)
                        .load(item.getImg())
                        .fitCenter()
                        .centerCrop()
                        .crossFade()
                        .into((ImageView) helper.getView(R.id.iv_credit_director));
                if (TextUtils.isEmpty(dename)) {
                    helper.setText(R.id.tv_credit_director, "演员")
                            .setText(R.id.tv_director_typename_en, item.getNameEn())
                            .setText(R.id.tv_director_typename_en, item.getRoleName());
                } else {
                    helper.setText(R.id.tv_credit_director, "演员")
                            .setText(R.id.tv_director_typename, dename)
                            .setText(R.id.tv_director_typename_en, item.getRoleName());
                }
        }

    }
}

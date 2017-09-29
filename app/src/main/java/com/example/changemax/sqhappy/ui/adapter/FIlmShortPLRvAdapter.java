package com.example.changemax.sqhappy.ui.adapter;


import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.changemax.sqhappy.R;
import com.example.changemax.sqhappy.model.network.entity.FilmReviewsBean;
import com.example.changemax.sqhappy.utils.TimeUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * Created by ChangeMax on 2017/3/16.
 */

public class FIlmShortPLRvAdapter extends BaseQuickAdapter<FilmReviewsBean.DataBean.MiniBean.ListBean, BaseViewHolder> {


    public FIlmShortPLRvAdapter(int layoutResId, List<FilmReviewsBean.DataBean.MiniBean.ListBean> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, FilmReviewsBean.DataBean.MiniBean.ListBean item) {
        GlideLoad(helper, item.getHeadImg());
        helper.setText(R.id.tv_short_rv_name, item.getNickname())
                .setText(R.id.tv_short_rv_pinglun_content,item.getContent())
                .setText(R.id.tv_short_rv_pingfen, String.valueOf(item.getRating()))
                .setText(R.id.tv_short_rv_pinglun_time, getFormatDateTime("MM-dd HH:mm", String.valueOf(item.getCommentDate())));
    }

    private void GlideLoad(BaseViewHolder helper, String drawable) {
        Glide.with(mContext)
                .load(drawable)
                .fitCenter()
                .crossFade()
                .into((ImageView) helper.getView(R.id.iv_short_hear_pingluner));
    }
    //String类型数字字符串转成日期
    private String getFormatDateTime(String pattern, String date) {
        Long dateTime = Long.parseLong(date);
        Date d = new Date(dateTime);
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(d);
    }
}

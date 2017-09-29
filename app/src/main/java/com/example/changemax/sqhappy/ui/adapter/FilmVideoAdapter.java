package com.example.changemax.sqhappy.ui.adapter;


import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.changemax.sqhappy.R;
import com.example.changemax.sqhappy.model.network.entity.FilmVideoBean;
import com.example.changemax.sqhappy.ui.view.JCVAutoFullVideoView;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * Created by ChangeMax on 2017/3/16.
 */
public class FilmVideoAdapter extends BaseQuickAdapter<FilmVideoBean.VideoListBean, BaseViewHolder> {

    private JCVAutoFullVideoView jcvAutoFullVideoView;

    public FilmVideoAdapter(int layoutResId, List<FilmVideoBean.VideoListBean> data, JCVAutoFullVideoView jcVideo) {
        super(layoutResId, data);
        this.jcvAutoFullVideoView = jcVideo;
    }


    @Override
    protected void convert(BaseViewHolder helper, FilmVideoBean.VideoListBean item) {

        helper.setText(R.id.tv_video_title_list_name, item.getTitle())
                .setText(R.id.tv_video_title_list_time, item.getLength() + "");
        Glide.with(mContext)
                .load(item.getImage())
                .fitCenter()
                .crossFade()
                .into((ImageView) helper.getView(R.id.iv_video_title_list_bg));
    }
}

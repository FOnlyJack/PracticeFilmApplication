package com.example.changemax.sqhappy.ui.adapter;


import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.changemax.sqhappy.R;
import com.example.changemax.sqhappy.model.network.entity.FilmIsHitingBean;

import java.util.List;


/**
 * Created by ChangeMax on 2017/3/16.
 */

public class FragHitRvAdapter extends BaseQuickAdapter<FilmIsHitingBean.MsBean, BaseViewHolder> {


    public FragHitRvAdapter(int layoutResId, List<FilmIsHitingBean.MsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, FilmIsHitingBean.MsBean item) {
        StringBuilder stringBuilder = new StringBuilder("今天有" + item.getCC() + "家影院放映" + item.getNearestShowtimeCount() + "场");
        String r = String.valueOf(item.getR());
        if (r.contains("-1")) {
            r = "暂无评分";
        } else {
            r = String.valueOf(item.getR());
        }
        boolean is3D = item.isIs3D();
        boolean isDMAX = item.isIsDMAX();
        boolean isIMAX = item.isIsIMAX();
        boolean isIMAX3D = item.isIsIMAX3D();
        if (isIMAX == false && is3D == false && isDMAX == false && isIMAX3D == false) {
            //2d
            helper.setImageDrawable(R.id.iv_film_versions, null);
        } else if (is3D == true && isIMAX3D == false) {
            //3d
            GlideLoad(helper, R.drawable.ic_3d);
        } else if (is3D == true && isIMAX3D == true) {
            //3d max
            GlideLoad(helper, R.drawable.ic_3d_imax);
        } else {
            //2d max
            GlideLoad(helper, R.drawable.ic_2d_imax);
        }
        Glide.with(mContext)
                .load(item.getImg())
                .fitCenter()
                .crossFade()
                .into((ImageView) helper.getView(R.id.iv_film));

        helper.setText(R.id.tv_frag_hit_rv_content, item.getTCn())
                .setText(R.id.show_pingfen, r)
                .setText(R.id.tv_commonSpecial, item.getCommonSpecial())
                .setText(R.id.tv_NearestCinemaCount, stringBuilder.toString());
    }

    private void GlideLoad(BaseViewHolder helper, int drawable) {
        Glide.with(mContext)
                .load(drawable)
                .fitCenter()
                .crossFade()
                .into((ImageView) helper.getView(R.id.iv_film_versions));
    }
}

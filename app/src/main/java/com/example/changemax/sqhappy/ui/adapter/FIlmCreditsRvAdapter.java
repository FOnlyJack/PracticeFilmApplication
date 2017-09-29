package com.example.changemax.sqhappy.ui.adapter;


import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.changemax.sqhappy.R;
import com.example.changemax.sqhappy.model.network.entity.FilmCreditsBean;
import java.util.List;

/**
 * Created by ChangeMax on 2017/3/24.
 */

public  class FIlmCreditsRvAdapter extends BaseQuickAdapter<FilmCreditsBean.TypesBean, BaseViewHolder> {


    public FIlmCreditsRvAdapter(int layoutResId, List<FilmCreditsBean.TypesBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, FilmCreditsBean.TypesBean item) {

        GlideLoad(helper, item.getPersons().get(0).getImage(), R.id.iv_film_credits_image);
        helper.setText(R.id.tv_credit_personate, item.getPersons().get(0).getName())
                .setText(R.id.tv_credit_personateCn, item.getPersons().get(0).getNameEn());
        GlideLoad(helper, item.getPersons().get(0).getImage(), R.id.iv_rolecover_img);
    }

    private void GlideLoad(BaseViewHolder helper, String drawable, int imageView) {
        Glide.with(mContext)
                .load(drawable)
                .fitCenter()
                .crossFade()
                .error(R.drawable.film_header_default_blur_bg)
                .into((ImageView) helper.getView(imageView));
    }
}

package com.example.changemax.sqhappy.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.changemax.sqhappy.R;
import com.example.changemax.sqhappy.ui.BaseFragment;

/**
 * Created by ChangeMax on 2017/3/16.
 * 即将上映
 */

public class FilmComingFragment extends BaseFragment {
    public static final String ARG_PAGE = "ARG_PAGE_COMING";
    private int mPage;

    public static FilmComingFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        FilmComingFragment filmComingFragment = new FilmComingFragment();
        filmComingFragment.setArguments(args);
        return filmComingFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_film_conimg;
    }

    @Override
    public void initView() {

    }
}

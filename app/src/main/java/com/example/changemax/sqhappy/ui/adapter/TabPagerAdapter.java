package com.example.changemax.sqhappy.ui.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.changemax.sqhappy.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by ChangeMax on 2017/3/16.
 */
public class TabPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragmentList = new ArrayList<>();
    private String tabTitlestop[] = new String[]{"热映","待映"};
    private final int PAGE_COUNT = 2;
    private Context context;

    public TabPagerAdapter(FragmentManager fm, Context context, List<Fragment> mFragmentList) {
        super(fm);
        this.context = context;
        this.mFragmentList = mFragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    public View getTabView(int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.tablayout_item, null);
        TextView tv = (TextView) view.findViewById(R.id.tv_tablayout_top);
        tv.setText(tabTitlestop[position]);
        return view;
    }
}

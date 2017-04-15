package com.codefiti.happymoments.Adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {

    public List<View> mList;
    private final Context mContext;
    View mPrimaryItem;

    public ViewPagerAdapter(Context mContext, List<View> mList){
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public int getItemPosition(Object object) {
        if (mList.contains((View) object)) {
            return mList.indexOf((View) object);
        } else {
            return POSITION_NONE;
        }
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position,
                               Object object) {
        super.setPrimaryItem(container, position, object);
        mPrimaryItem = (View) object;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    public void addView(View view, int index) {
        mList.add(index, view);
        notifyDataSetChanged();
    }

    public void removeView(int index) {
        mList.remove(index);
        notifyDataSetChanged();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View v = mList.get(position);

        ViewGroup parent = (ViewGroup) v.getParent();
        if (parent != null) { parent.removeAllViews(); }
        ((ViewPager)container).addView(v);
        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}

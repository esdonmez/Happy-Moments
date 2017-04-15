package com.codefiti.happymoments.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.codefiti.happymoments.Models.CompanyModel;
import com.codeifit.happymoments.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class GiftAdapter extends BaseAdapter {
    private Context mContext;
    private List<CompanyModel> posts;


    public GiftAdapter(Context c, List<CompanyModel> posts) {
        mContext = c;
        this.posts = posts;
    }


    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.gift_item, parent, false);
        } else {
            v = (View) convertView;
        }
        Picasso.with(mContext).load(posts.get(position).getImage()).into(((ImageView) v.findViewById(R.id.imgCompany)));

        return v;
    }
}
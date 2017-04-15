package com.codefiti.happymoments.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.codefiti.happymoments.Models.PostModel;
import com.codeifit.happymoments.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TimelineAdapter extends BaseAdapter {
    private Context mContext;
    private List<PostModel> posts;


    public TimelineAdapter(Context c, List<PostModel> posts) {
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
            v = inflater.inflate(R.layout.timeline_item, parent, false);
        } else {
            v = (View) convertView;
        }
        ((TextView) v.findViewById(R.id.txtTimeline_Date)).setText(posts.get(position).getDay() + "\n"+posts.get(position).getMonth());
        Picasso.with(mContext).load(posts.get(position).getProfileImage()).into(((ImageView) v.findViewById(R.id.imgTimeline_Profile)));
        if(posts.get(position).getPaid()){
           // ((ImageView) v.findViewById(R.id.imgTimeline_Profile))
        }
        else{

        }
        return v;
    }
}
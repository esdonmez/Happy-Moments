package com.codefiti.happymoments.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.codefiti.happymoments.Models.NotificationModel;
import com.codeifit.happymoments.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NotificationAdapter extends BaseAdapter {

    private Context mContext;
    private List<NotificationModel> notifications;


    public NotificationAdapter(Context c, List<NotificationModel> notifications)
    {
        mContext = c;
        this.notifications = notifications;
    }


    @Override
    public int getCount()
    {
        return notifications.size();
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
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View v;

        if (convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.notification_item, parent, false);
        }

        else
        {
            v = (View) convertView;
        }

        Picasso.with(mContext).load(notifications.get(position).getProfileImage()).into(((ImageView)v.findViewById(R.id.profile_image)));
        ((TextView)v.findViewById(R.id.name)).setText(notifications.get(position).getFullName() + " seni mutlu etti.");
        return v;
    }
}

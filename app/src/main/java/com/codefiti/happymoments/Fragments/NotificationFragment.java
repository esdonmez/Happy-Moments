package com.codefiti.happymoments.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import com.codefiti.happymoments.Adapters.NotificationAdapter;
import com.codefiti.happymoments.Models.NotificationModel;
import com.codeifit.happymoments.R;
import java.util.ArrayList;
import java.util.List;

public class NotificationFragment extends Fragment
{
    private static final String ARG_PARAM1 = "param1";
    GridView listNotifications;
    public static List<NotificationModel> MyNotifications = new ArrayList<NotificationModel>();
    static Object obj;


    public NotificationFragment() {
        // Required empty public constructor
    }


    public static NotificationFragment newInstance(String param1) {
        NotificationFragment fragment = new NotificationFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        MyNotifications.add(new NotificationModel(0, "https://happymoments.blob.core.windows.net/companies/itunes.png", "Seray", "Elif Seray"));
        MyNotifications.add(new NotificationModel(0, "https://happymoments.blob.core.windows.net/companies/itunes.png", "Seray", "Elif Seray"));
        MyNotifications.add(new NotificationModel(0, "https://happymoments.blob.core.windows.net/companies/itunes.png", "Seray", "Elif Seray"));

        View view =  inflater.inflate(R.layout.fragment_notification, container, false);
        listNotifications = (GridView)view.findViewById(R.id.listNotifications);
        listNotifications.setAdapter(new NotificationAdapter(getContext(),MyNotifications));

        listNotifications.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v, int pos, long id) {

                obj = (Object) MyNotifications.get(pos);

                //Intent intent = new Intent(getActivity(), DetailsNotificationActivity.class);
                //startActivity(intent);
            }
        });

        return view;
    }
}

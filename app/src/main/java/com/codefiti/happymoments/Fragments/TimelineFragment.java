package com.codefiti.happymoments.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import com.codefiti.happymoments.Adapters.TimelineAdapter;
import com.codefiti.happymoments.MakeHappyActivity;
import com.codefiti.happymoments.Models.PostModel;
import com.codeifit.happymoments.R;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TimelineFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    List<PostModel> Posts = new ArrayList<PostModel>();
    GridView ListPosts;
    private String mParam1;


    public TimelineFragment() {
        // Required empty public constructor
    }


    public static TimelineFragment newInstance(String param1) {
        TimelineFragment fragment = new TimelineFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        Posts.add(new PostModel(UUID.randomUUID(),"https://scontent-frt3-1.xx.fbcdn.net/v/t1.0-9/10402425_10205093470446705_2213252356138306690_n.jpg?oh=216af852eec0fdc63b9a7d351f210477&oe=582D1F8E","21","Haz",false,"",1,"Barış Ceviz","Vejeteryan oldu",""));
        Posts.add(new PostModel(UUID.randomUUID(),"https://scontent-frt3-1.xx.fbcdn.net/v/t1.0-1/13062273_10209267267503704_7060982458535832978_n.jpg?oh=748e9923ebf55d9d41e80f744663cf9c&oe=57F89E47","21","Haz",false,"",1,"Barış Ceviz","Vejeteryan oldu",""));
        Posts.add(new PostModel(UUID.randomUUID(),"https://scontent-frt3-1.xx.fbcdn.net/v/t1.0-9/12670617_1022745354433809_4190960828865626342_n.jpg?oh=99acca019bbc28d00f2ca0a7997a570a&oe=58330C91","21","Haz",false,"",1,"Barış Ceviz","Vejeteryan oldu",""));
        Posts.add(new PostModel(UUID.randomUUID(),"https://scontent-frt3-1.xx.fbcdn.net/v/t1.0-9/13239353_10154116813053326_3093839460781166325_n.jpg?oh=a7f969f34f612b1addd277a19190c7be&oe=57F95A33","21","Haz",false,"",1,"Barış Ceviz","Vejeteryan oldu",""));
        Posts.add(new PostModel(UUID.randomUUID(),"https://scontent-frt3-1.xx.fbcdn.net/v/t1.0-1/13419286_10154276083664521_5907844780189798578_n.jpg?oh=f1f2fbe759b8ca295388e12fe16af648&oe=5828FBA1","21","Haz",false,"",1,"Barış Ceviz","Vejeteryan oldu",""));

        View view = inflater.inflate(R.layout.fragment_timeline, container, false);
        ListPosts = (GridView)view.findViewById(R.id.listTimeline);

        ListPosts.setAdapter(new TimelineAdapter(getContext(),Posts));

        ListPosts.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v,   int pos, long id) {

                Intent intent = new Intent(getActivity(), MakeHappyActivity.class);
                //Intent intent = new Intent(getActivity(), SSSActivity.class);
                startActivity(intent);

            }

        });

        return view;
    }
}

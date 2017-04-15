package com.codefiti.happymoments.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import com.codefiti.happymoments.Adapters.GiftAdapter;
import com.codefiti.happymoments.Models.CompanyModel;
import com.codefiti.happymoments.TokenActivity;
import com.codeifit.happymoments.R;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GiftFragment extends Fragment
{
    private static final String ARG_PARAM1 = "param1";
    GridView listGift;
    List<CompanyModel> Companies = new ArrayList<CompanyModel>();
    private String mParam1;


    public GiftFragment() {
        // Required empty public constructor
    }


    public static GiftFragment newInstance(String param1) {
        GiftFragment fragment = new GiftFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        Companies.add(new CompanyModel(UUID.randomUUID(),"Mealbox","https://happymoments.blob.core.windows.net/companies/mealbox.png"));
        Companies.add(new CompanyModel(UUID.randomUUID(),"Hepsiburada","https://happymoments.blob.core.windows.net/companies/hepsiburada.png"));
        Companies.add(new CompanyModel(UUID.randomUUID(),"Windows Store","https://happymoments.blob.core.windows.net/companies/windowsstore.png"));
        Companies.add(new CompanyModel(UUID.randomUUID(),"Play Store","https://happymoments.blob.core.windows.net/companies/playstore.png"));
        Companies.add(new CompanyModel(UUID.randomUUID(),"Trendyol","https://happymoments.blob.core.windows.net/companies/trendyol.png"));
        Companies.add(new CompanyModel(UUID.randomUUID(),"Markafoni","https://happymoments.blob.core.windows.net/companies/markafoni.png"));
        Companies.add(new CompanyModel(UUID.randomUUID(),"Starbucks","https://happymoments.blob.core.windows.net/companies/starbucks.png"));
        View view = inflater.inflate(R.layout.fragment_gift, container, false);

        listGift = (GridView)view.findViewById(R.id.listCompanies);
        listGift.setAdapter(new GiftAdapter(getContext(),Companies));

        listGift.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v,   int pos, long id) {

                Intent intent = new Intent(getActivity(), TokenActivity.class);
                startActivity(intent);

            }

        });

        return view;
    }
}

package com.codefiti.happymoments.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import com.codefiti.happymoments.Adapters.WalletAdapter;
import com.codefiti.happymoments.DetailsGiftWalletActivity;
import com.codefiti.happymoments.Models.MyGiftcardModel;
import com.codeifit.happymoments.R;
import java.util.ArrayList;
import java.util.List;

public class WalletFragment extends Fragment
{
    private static final String ARG_PARAM1 = "param1";
    GridView listCoupons;
    private String mParam1;
    public static List<MyGiftcardModel> MyCoupons = new ArrayList<MyGiftcardModel>();
    static Object obj;


    public WalletFragment() {
        // Required empty public constructor
    }


    public static WalletFragment newInstance(String param1) {
        WalletFragment fragment = new WalletFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        MyCoupons.add(new MyGiftcardModel("InStore","2016-11-02",50,"XXXXX-YYYYY-ZZZZZ-QQQQQ-WWWWW","https://happymoments.blob.core.windows.net/qrcodes/887e5fe8-89e7-4e4a-8601-8564c264bb16.png","Markafoni","https://happymoments.blob.core.windows.net/companies/itunes.png","https://happymoments.blob.core.windows.net/companies/itunes_cover.png"));
        MyCoupons.add(new MyGiftcardModel("InStore","2016-11-02",50,"XXXXX-YYYYY-ZZZZZ-QQQQQ-WWWWW","https://happymoments.blob.core.windows.net/qrcodes/887e5fe8-89e7-4e4a-8601-8564c264bb16.png","Markafoni","https://happymoments.blob.core.windows.net/companies/itunes.png","https://happymoments.blob.core.windows.net/companies/itunes_cover.png"));
        MyCoupons.add(new MyGiftcardModel("InStore","2016-11-02",50,"XXXXX-YYYYY-ZZZZZ-QQQQQ-WWWWW","https://happymoments.blob.core.windows.net/qrcodes/887e5fe8-89e7-4e4a-8601-8564c264bb16.png","Markafoni","https://happymoments.blob.core.windows.net/companies/itunes.png","https://happymoments.blob.core.windows.net/companies/itunes_cover.png"));
        MyCoupons.add(new MyGiftcardModel("InStore","2016-11-02",50,"XXXXX-YYYYY-ZZZZZ-QQQQQ-WWWWW","https://happymoments.blob.core.windows.net/qrcodes/887e5fe8-89e7-4e4a-8601-8564c264bb16.png","Markafoni","https://happymoments.blob.core.windows.net/companies/itunes.png","https://happymoments.blob.core.windows.net/companies/itunes_cover.png"));
        MyCoupons.add(new MyGiftcardModel("InStore","2016-11-02",50,"XXXXX-YYYYY-ZZZZZ-QQQQQ-WWWWW","https://happymoments.blob.core.windows.net/qrcodes/887e5fe8-89e7-4e4a-8601-8564c264bb16.png","Markafoni","https://happymoments.blob.core.windows.net/companies/itunes.png","https://happymoments.blob.core.windows.net/companies/itunes_cover.png"));
        MyCoupons.add(new MyGiftcardModel("InStore","2016-11-02",50,"XXXXX-YYYYY-ZZZZZ-QQQQQ-WWWWW","https://happymoments.blob.core.windows.net/qrcodes/887e5fe8-89e7-4e4a-8601-8564c264bb16.png","Markafoni","https://happymoments.blob.core.windows.net/companies/itunes.png","https://happymoments.blob.core.windows.net/companies/itunes_cover.png"));

        View view =  inflater.inflate(R.layout.fragment_wallet, container, false);
        listCoupons = (GridView)view.findViewById(R.id.listCoupons);
        listCoupons.setAdapter(new WalletAdapter(getContext(),MyCoupons));

        listCoupons.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v, int pos, long id) {

                obj = (Object) MyCoupons.get(pos);

                Intent intent = new Intent(getActivity(), DetailsGiftWalletActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}

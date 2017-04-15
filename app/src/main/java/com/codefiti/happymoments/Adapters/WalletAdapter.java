package com.codefiti.happymoments.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.codefiti.happymoments.Models.MyGiftcardModel;
import com.codeifit.happymoments.R;
import com.squareup.picasso.Picasso;
import java.util.List;

public class WalletAdapter extends BaseAdapter
{
    private Context mContext;
    private List<MyGiftcardModel> coupons;


    public WalletAdapter(Context c, List<MyGiftcardModel> coupons)
    {
        mContext = c;
        this.coupons = coupons;
    }


    @Override
    public int getCount()
    {
        return coupons.size();
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
            v = inflater.inflate(R.layout.wallet_item, parent, false);
        }

        else
        {
            v = (View) convertView;
        }

        //Picasso.with(mContext).load(coupons.get(position).getLogo()).into(((ImageView) v.findViewById(R.id.imgWallet_Logo)));
        Picasso.with(mContext).load(coupons.get(position).getCoverImage()).into(((ImageView)v.findViewById(R.id.imgWallet_CoverImage)));
        ((TextView)v.findViewById(R.id.txtWallet_Date)).setText(coupons.get(position).getExpireDate());
        ((TextView)v.findViewById(R.id.txtWallet_Money)).setText(coupons.get(position).getMoney().toString());
        ((TextView)v.findViewById(R.id.txtWallet_Status)).setText(coupons.get(position).getStatus());

        return v;
    }
}

package com.codefiti.happymoments.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.codefiti.happymoments.Fragments.WalletFragment;
import com.codefiti.happymoments.Models.MyGiftcardModel;
import com.codeifit.happymoments.R;
import com.squareup.picasso.Picasso;
import java.util.List;

public class DetailsWalletGiftAdapter extends BaseAdapter{

    private Context mContext;
    private List<MyGiftcardModel> coupons;


    public DetailsWalletGiftAdapter(Context c, List<MyGiftcardModel> coupons)
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
    public View getView(int position, View convertView, ViewGroup parent) {
        View v;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.activity_details_gift_wallet, parent, false);
        } else {
            v = (View) convertView;
        }

        Picasso.with(mContext).load(WalletFragment.MyCoupons.get(position).getLogo()).into(((ImageView) v.findViewById(R.id.storeImage)));
        ((TextView) v.findViewById(R.id.expire_date)).setText(WalletFragment.MyCoupons.get(position).getExpireDate());
        ((TextView) v.findViewById(R.id.money)).setText(WalletFragment.MyCoupons.get(position).getMoney().toString());
        ((TextView) v.findViewById(R.id.check_code)).setText(WalletFragment.MyCoupons.get(position).getStatus());
        Picasso.with(mContext).load(WalletFragment.MyCoupons.get(position).getQRCode()).into(((ImageView) v.findViewById(R.id.qrCode)));

        return v;
    }
}

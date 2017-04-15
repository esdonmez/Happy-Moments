package com.codefiti.happymoments.Adapters;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.codefiti.happymoments.Models.MyGiftcardModel;
import com.codefiti.happymoments.Models.TokenModel;
import com.codeifit.happymoments.R;
import com.squareup.picasso.Picasso;
import java.util.List;

public class TokenAdapter extends BaseAdapter
{
    private Context mContext;
    private List<Integer> tokens;
    ImageView add, remove;
    int i = 0;
    View view;
    TextView message;


    public TokenAdapter(Context c, List<Integer> tokens)
    {
        mContext = c;
        this.tokens = tokens;
    }


    @Override
    public int getCount()
    {
        return tokens.size();
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
        final LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null)
        {
            v = inflater.inflate(R.layout.token_item, parent, false);
            add = (ImageView) v.findViewById(R.id.add);
            remove = (ImageView) v.findViewById(R.id.remove);

            add.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    i++;
                    v =  inflater.inflate(R.layout.activity_token, null);
                    message = (TextView) v.findViewById(R.id.message);
                    message.setText(i + " adet hediye çekiniz var.");
                }
            });

            remove.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    i--;
                    v =  inflater.inflate(R.layout.activity_token, null);
                    message = (TextView) v.findViewById(R.id.message);

                    if(i > 0)
                    {
                        message.setText(i + " adet hediye çekiniz var.");
                    }
                    else
                    {
                        message.setText("Hiçbir hediye çeki seçmediniz.");
                    }
                }

            });

        }

        else
        {
            v = (View) convertView;

            add = (ImageView) v.findViewById(R.id.add);
            remove = (ImageView) v.findViewById(R.id.remove);

            add.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    i++;
                    v =  inflater.inflate(R.layout.activity_token, null);
                    message = (TextView) v.findViewById(R.id.message);

                    message.setText(i + " adet hediye çekiniz var.");
                }
            });

            remove.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    i--;
                    v =  inflater.inflate(R.layout.activity_token, null);
                    message = (TextView) v.findViewById(R.id.message);

                    if(i > 0)
                    {
                        message.setText(i + " adet hediye çekiniz var.");
                    }
                    else
                    {
                        message.setText("Hiçbir hediye çeki seçmediniz.");
                    }
                }

            });
        }

        return v;
    }
}

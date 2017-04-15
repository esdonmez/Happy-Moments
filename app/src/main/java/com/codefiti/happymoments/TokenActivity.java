package com.codefiti.happymoments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.codefiti.happymoments.Adapters.TokenAdapter;
import com.codefiti.happymoments.Models.CompanyModel;
import com.codeifit.happymoments.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class TokenActivity extends AppCompatActivity {

    GridView listTokens;
    private List<Integer> tokenList = new ArrayList<Integer>();
    private int totalToken;
    public static CompanyModel company;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_token);

        listTokens = (GridView)findViewById(R.id.listTokens);
        listTokens.setAdapter(new TokenAdapter(this,tokenList));

        if(tokenList.size() != 0)
            tokenList.clear();

        DefineCompany();

        listTokens.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int pos, long id) {


            }
        });
    }

    private void DefineCompany() {
        ImageView image = (ImageView) findViewById(R.id.imgCompany);
        Picasso.with(getApplicationContext()).load(company.getImage()).into(image);
    }
}

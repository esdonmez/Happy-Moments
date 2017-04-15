package com.codefiti.happymoments;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.codeifit.happymoments.R;
import static com.codeifit.happymoments.R.layout.activity_sss;

public class SSSActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    RelativeLayout top1, top2, top3, top4, top5, top6, top7, top8, top9;
    TextView text1, text2, text3, text4, text5, text6, text7, text8, text9;
    RelativeLayout toolbar;
    ImageButton hamburgerButton;
    DrawerLayout drawer;
    NavigationView navigationView;
    TextView toolbarTitle;
    Intent intent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_sss);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        toolbar = (RelativeLayout) findViewById(R.id.toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        hamburgerButton = (ImageButton) findViewById(R.id.hamburgerButton);
        toolbarTitle = (TextView) findViewById(R.id.toolbar_title);

        hamburgerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (drawer.isDrawerVisible(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    drawer.openDrawer(GravityCompat.START);
                }
            }
        });

        navigationView.setNavigationItemSelectedListener(this);

        top1 = (RelativeLayout) findViewById(R.id.ssstop1);
        top2 = (RelativeLayout) findViewById(R.id.ssstop2);
        top3 = (RelativeLayout) findViewById(R.id.ssstop3);
        top4 = (RelativeLayout) findViewById(R.id.ssstop4);
        top5 = (RelativeLayout) findViewById(R.id.ssstop5);
        top6 = (RelativeLayout) findViewById(R.id.ssstop6);
        top7 = (RelativeLayout) findViewById(R.id.ssstop7);
        top8 = (RelativeLayout) findViewById(R.id.ssstop8);
        top9 = (RelativeLayout) findViewById(R.id.ssstop9);
        text1 = (TextView)findViewById(R.id.text1);
        text2 = (TextView)findViewById(R.id.text2);
        text3 = (TextView)findViewById(R.id.text3);
        text4 = (TextView)findViewById(R.id.text4);
        text5 = (TextView)findViewById(R.id.text5);
        text6 = (TextView)findViewById(R.id.text6);
        text7 = (TextView)findViewById(R.id.text7);
        text8 = (TextView)findViewById(R.id.text8);
        text9 = (TextView)findViewById(R.id.text9);

        top1.setOnClickListener(layoutListener);
        top2.setOnClickListener(layoutListener);
        top3.setOnClickListener(layoutListener);
        top4.setOnClickListener(layoutListener);
        top5.setOnClickListener(layoutListener);
        top6.setOnClickListener(layoutListener);
        top7.setOnClickListener(layoutListener);
        top8.setOnClickListener(layoutListener);
        top9.setOnClickListener(layoutListener);
    }

    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        drawer.closeDrawers();
        item.setCheckable(false);
        int id = item.getItemId();
        if (id == R.id.nav_contact) {
            intent = new Intent(SSSActivity.this, ContactActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_settings) {
            intent = new Intent(SSSActivity.this, SettingsActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_sss) {
            intent = new Intent(SSSActivity.this, SSSActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_howtouse) {
            //intent = new Intent(ContactActivity.this, HowToUseActivity.class);
            //startActivity(intent);
        } else if (id == R.id.nav_home) {
            intent = new Intent(SSSActivity.this, MainActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_creditcards) {

        } else if (id == R.id.nav_logout) {
            quit();
        }
        return true;
    }

    public void quit()
    {
        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.alert_dialog_logout, null);
        dialogBuilder.setView(dialogView);


        dialogBuilder.setTitle("Çıkış Yap");
        dialogBuilder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                Intent intent = new Intent(SSSActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                System.exit(0);
            }
        });
        dialogBuilder.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //pass
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }

    private View.OnClickListener layoutListener = new View.OnClickListener() {
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.ssstop1:
                    if(text1.getVisibility() == View.GONE)
                    {
                        text1.setVisibility(View.VISIBLE);
                    }
                    else if(text1.getVisibility() == View.VISIBLE)
                    {
                        text1.setVisibility(View.GONE);
                    }
                    break;
                case R.id.ssstop2:
                    if(text2.getVisibility() == View.GONE)
                    {
                        text2.setVisibility(View.VISIBLE);
                    }
                    else if(text2.getVisibility() == View.VISIBLE)
                    {
                        text2.setVisibility(View.GONE);
                    }
                    break;
                case R.id.ssstop3:
                    if(text3.getVisibility() == View.GONE)
                    {
                        text3.setVisibility(View.VISIBLE);
                    }
                    else if(text3.getVisibility() == View.VISIBLE)
                    {
                        text3.setVisibility(View.GONE);
                    }
                    break;
                case R.id.ssstop4:
                    if(text4.getVisibility() == View.GONE)
                    {
                        text4.setVisibility(View.VISIBLE);
                    }
                    else if(text4.getVisibility() == View.VISIBLE)
                    {
                        text4.setVisibility(View.GONE);
                    }
                    break;
                case R.id.ssstop5:
                    if(text5.getVisibility() == View.GONE)
                    {
                        text5.setVisibility(View.VISIBLE);
                    }
                    else if(text5.getVisibility() == View.VISIBLE)
                    {
                        text5.setVisibility(View.GONE);
                    }
                    break;
                case R.id.ssstop6:
                    if(text6.getVisibility() == View.GONE)
                    {
                        text6.setVisibility(View.VISIBLE);
                    }
                    else if(text6.getVisibility() == View.VISIBLE)
                    {
                        text6.setVisibility(View.GONE);
                    }
                    break;
                case R.id.ssstop7:
                    if(text7.getVisibility() == View.GONE)
                    {
                        text7.setVisibility(View.VISIBLE);
                    }
                    else if(text7.getVisibility() == View.VISIBLE)
                    {
                        text7.setVisibility(View.GONE);
                    }
                    break;
                case R.id.ssstop8:
                    if(text8.getVisibility() == View.GONE)
                    {
                        text8.setVisibility(View.VISIBLE);
                    }
                    else if(text8.getVisibility() == View.VISIBLE)
                    {
                        text8.setVisibility(View.GONE);
                    }
                    break;
                case R.id.ssstop9:
                    if(text9.getVisibility() == View.GONE)
                    {
                        text9.setVisibility(View.VISIBLE);
                    }
                    else if(text9.getVisibility() == View.VISIBLE)
                    {
                        text9.setVisibility(View.GONE);
                    }
                    break;
                default:
                    break;
            }
        }
    };
}

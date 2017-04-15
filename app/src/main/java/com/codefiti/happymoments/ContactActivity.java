package com.codefiti.happymoments;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
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
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.codeifit.happymoments.R;

public class ContactActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ImageView img;
    RelativeLayout toolbar;
    ImageButton hamburgerButton;
    DrawerLayout drawer;
    NavigationView navigationView;
    TextView toolbarTitle;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        toolbar = (RelativeLayout) findViewById(R.id.toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        hamburgerButton = (ImageButton) findViewById(R.id.hamburgerButton);
        toolbarTitle = (TextView) findViewById(R.id.toolbar_title);

        img = (ImageView)findViewById(R.id.facebook);
        img.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://facebook.com"));
                startActivity(intent);
            }
        });

        img = (ImageView)findViewById(R.id.twitter);
        img.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://twitter.com"));
                startActivity(intent);
            }
        });

        img = (ImageView)findViewById(R.id.youtube);
        img.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://youtube.com"));
                startActivity(intent);
            }
        });

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
            intent = new Intent(ContactActivity.this, ContactActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_settings) {
            intent = new Intent(ContactActivity.this, SettingsActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_sss) {
            intent = new Intent(ContactActivity.this, SSSActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_howtouse) {
            //intent = new Intent(ContactActivity.this, HowToUseActivity.class);
            //startActivity(intent);
        } else if (id == R.id.nav_home) {
            intent = new Intent(ContactActivity.this, MainActivity.class);
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
                Intent intent = new Intent(ContactActivity.this, LoginActivity.class);
                startActivity(intent);
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
}

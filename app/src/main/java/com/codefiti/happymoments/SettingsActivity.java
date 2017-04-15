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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.codeifit.happymoments.R;

public class SettingsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    RelativeLayout toolbar;
    ImageButton hamburgerButton;
    DrawerLayout drawer;
    NavigationView navigationView;
    TextView toolbarTitle;
    Intent intent;
    LinearLayout pinButton;
    LinearLayout freezeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        toolbar = (RelativeLayout) findViewById(R.id.toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        hamburgerButton = (ImageButton) findViewById(R.id.hamburgerButton);
        toolbarTitle = (TextView) findViewById(R.id.toolbar_title);
        pinButton = (LinearLayout) findViewById(R.id.pinButton);
        freezeButton = (LinearLayout) findViewById(R.id.freezeButton);

        pinButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                pin_onClick(v);
            }
        });

        freezeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freeze_onClick(v);
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
            intent = new Intent(SettingsActivity.this, ContactActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_settings) {
            intent = new Intent(SettingsActivity.this, SettingsActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_sss) {
            intent = new Intent(SettingsActivity.this, SSSActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_howtouse) {
            //intent = new Intent(ContactActivity.this, HowToUseActivity.class);
            //startActivity(intent);
        } else if (id == R.id.nav_home) {
            intent = new Intent(SettingsActivity.this, MainActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_creditcards) {

        } else if (id == R.id.nav_logout) {
            quit();
        }
        return true;
    }

    public void pin_onClick(View v)
    {
        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.alert_dialog_change_pin, null);
        dialogBuilder.setView(dialogView);


        dialogBuilder.setTitle("Pin Değiştir");
        dialogBuilder.setPositiveButton("Kaydet", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //do something with edt.getText().toString();
            }
        });
        dialogBuilder.setNegativeButton("İptal Et", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //pass
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }

    public void freeze_onClick(View v)
    {
        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.alert_dialog_freeze_account, null);
        dialogBuilder.setView(dialogView);


        dialogBuilder.setTitle("Hesabımı Dondur");
        dialogBuilder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //do something with edt.getText().toString();
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

    public void quit()
    {
        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.alert_dialog_logout, null);
        dialogBuilder.setView(dialogView);


        dialogBuilder.setTitle("Çıkış Yap");
        dialogBuilder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                Intent intent = new Intent(SettingsActivity.this, LoginActivity.class);
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

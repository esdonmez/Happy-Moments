package com.codefiti.happymoments;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.codefiti.happymoments.Fragments.GiftFragment;
import com.codefiti.happymoments.Fragments.NotificationFragment;
import com.codefiti.happymoments.Fragments.TimelineFragment;
import com.codefiti.happymoments.Fragments.UserFragment;
import com.codefiti.happymoments.Fragments.WalletFragment;
import com.codeifit.happymoments.R;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    private DrawerLayout drawer;
    private ImageButton hamburgerButton;
    private ImageButton notificationButton;
    private NavigationView leftNavigationView;
    private NavigationView rightNavigationView;
    Intent intent;
    private RelativeLayout user;
    private RelativeLayout timeline;
    private RelativeLayout gift;
    private RelativeLayout wallet;
    private UserFragment userFragment;
    private TimelineFragment timelineFragment;
    private GiftFragment giftFragment;
    private WalletFragment walletFragment;
    android.support.v4.app.FragmentTransaction fragmentTransaction;
    NotificationFragment notificationFragment;
    private ImageView userImage;
    private ImageView timelineImage;
    private ImageView giftImage;
    private ImageView walletImage;
    final int color = Color.argb(117,250,250,250); //transparan
    final int color2 = Color.rgb(250,250,250); //normal

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        leftNavigationView = (NavigationView) findViewById(R.id.nav_left_view);
        rightNavigationView = (NavigationView) findViewById(R.id.nav_right_view);
        hamburgerButton = (ImageButton) findViewById(R.id.hamburgerButton);
        notificationButton = (ImageButton) findViewById(R.id.notificationButton);
        userImage = (ImageView) findViewById(R.id.userImage);
        user = (RelativeLayout) findViewById(R.id.userButton);
        timelineImage = (ImageView) findViewById(R.id.timelineImage);
        timeline = (RelativeLayout) findViewById(R.id.timelineButton);
        giftImage = (ImageView) findViewById(R.id.giftImage);
        gift = (RelativeLayout) findViewById(R.id.giftButton);
        walletImage = (ImageView) findViewById(R.id.walletImage);
        wallet = (RelativeLayout) findViewById(R.id.walletButton);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        notificationFragment = new NotificationFragment();
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.notificationFragment,notificationFragment);
        fragmentTransaction.commit();

        user.setOnClickListener(bottombarListener);
        timeline.setOnClickListener(bottombarListener);
        gift.setOnClickListener(bottombarListener);
        wallet.setOnClickListener(bottombarListener);

        userImage.setColorFilter(color2, android.graphics.PorterDuff.Mode.MULTIPLY);
        timelineImage.setColorFilter(color, android.graphics.PorterDuff.Mode.MULTIPLY);
        giftImage.setColorFilter(color, android.graphics.PorterDuff.Mode.MULTIPLY);
        walletImage.setColorFilter(color, android.graphics.PorterDuff.Mode.MULTIPLY);

        userFragment = new UserFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, userFragment).commit();

        hamburgerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                  if (drawer.isDrawerVisible(GravityCompat.START) && !drawer.isDrawerVisible(GravityCompat.END)) {
                        drawer.closeDrawer(GravityCompat.START);
                } else if(drawer.isDrawerVisible(GravityCompat.END) && !drawer.isDrawerVisible(GravityCompat.START)) {
                      drawer.openDrawer(GravityCompat.START);
                      drawer.closeDrawer(GravityCompat.END);
                  }else if(!drawer.isDrawerVisible(GravityCompat.START) && !drawer.isDrawerVisible(GravityCompat.END)){
                      drawer.openDrawer(GravityCompat.START);
                  }
            }
        });

        notificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (drawer.isDrawerVisible(GravityCompat.END) && !drawer.isDrawerVisible(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.END);
                } else if(drawer.isDrawerVisible(GravityCompat.START) && !drawer.isDrawerVisible(GravityCompat.END)) {
                    drawer.openDrawer(GravityCompat.END);
                    drawer.closeDrawer(GravityCompat.START);
                } else if (!drawer.isDrawerVisible(GravityCompat.END) && !drawer.isDrawerVisible(GravityCompat.START)){
                    drawer.openDrawer(GravityCompat.END);
                }
            }
        });

        leftNavigationView.setNavigationItemSelectedListener(this);
        rightNavigationView.setNavigationItemSelectedListener(this);
    }

    private View.OnClickListener bottombarListener = new View.OnClickListener() {
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.userButton:
                    drawer.closeDrawers();
                    userImage.setColorFilter(color2, android.graphics.PorterDuff.Mode.MULTIPLY);
                    timelineImage.setColorFilter(color, android.graphics.PorterDuff.Mode.MULTIPLY);
                    giftImage.setColorFilter(color, android.graphics.PorterDuff.Mode.MULTIPLY);
                    walletImage.setColorFilter(color, android.graphics.PorterDuff.Mode.MULTIPLY);
                    userFragment = new UserFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, userFragment).commit();
                    break;
                case R.id.timelineButton:
                    drawer.closeDrawers();
                    userImage.setColorFilter(color, android.graphics.PorterDuff.Mode.MULTIPLY);
                    timelineImage.setColorFilter(color2, android.graphics.PorterDuff.Mode.MULTIPLY);
                    giftImage.setColorFilter(color, android.graphics.PorterDuff.Mode.MULTIPLY);
                    walletImage.setColorFilter(color, android.graphics.PorterDuff.Mode.MULTIPLY);
                    timelineFragment = new TimelineFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, timelineFragment).commit();
                    break;
                case R.id.giftButton:
                    drawer.closeDrawers();
                    userImage.setColorFilter(color, android.graphics.PorterDuff.Mode.MULTIPLY);
                    timelineImage.setColorFilter(color, android.graphics.PorterDuff.Mode.MULTIPLY);
                    giftImage.setColorFilter(color2, android.graphics.PorterDuff.Mode.MULTIPLY);
                    walletImage.setColorFilter(color, android.graphics.PorterDuff.Mode.MULTIPLY);
                    giftFragment = new GiftFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, giftFragment).commit();
                    break;
                case R.id.walletButton:
                    drawer.closeDrawers();
                    userImage.setColorFilter(color, android.graphics.PorterDuff.Mode.MULTIPLY);
                    timelineImage.setColorFilter(color, android.graphics.PorterDuff.Mode.MULTIPLY);
                    giftImage.setColorFilter(color, android.graphics.PorterDuff.Mode.MULTIPLY);
                    walletImage.setColorFilter(color2, android.graphics.PorterDuff.Mode.MULTIPLY);
                    walletFragment = new WalletFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, walletFragment).commit();
                    break;
                default:
                    break;
            }
        }
    };

    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if(drawer.isDrawerOpen(GravityCompat.END)){
            drawer.closeDrawer(GravityCompat.END);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.notification, menu);
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        drawer.closeDrawers();
        item.setCheckable(false);
        int id = item.getItemId();
        if (id == R.id.nav_contact) {
            intent = new Intent(MainActivity.this, ContactActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_settings) {
            intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_sss) {
            intent = new Intent(MainActivity.this, SSSActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_howtouse) {
            //intent = new Intent(MainActivity.this, HowToUseActivity.class);
            //startActivity(intent);
        } else if (id == R.id.nav_home) {
            intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_creditcards) {
            intent = new Intent(MainActivity.this, MyCreditCardsActivity.class);
            startActivity(intent);
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
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
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
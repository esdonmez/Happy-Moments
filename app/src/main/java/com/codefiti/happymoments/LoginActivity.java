package com.codefiti.happymoments;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;
import com.codefiti.happymoments.Core.DataClient;
import com.codefiti.happymoments.Models.ResultContext;
import com.codeifit.happymoments.R;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class LoginActivity extends AppCompatActivity
{
    CallbackManager callbackManager;
    public static DataClient Client = new DataClient("http://happymomentsapi.azurewebsites.net");
    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;
    private ViewFlipper mViewFlipper;
    private Context mContext;
    private final GestureDetector detector = new GestureDetector(new SwipeGestureDetector());
    View first;
    View second;
    View third;
    GradientDrawable fColor;
    GradientDrawable sColor;
    GradientDrawable tColor;
    int color;
    int color2;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_login);

        callbackManager = CallbackManager.Factory.create();
        final LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions("email");

        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                AccessToken token = loginResult.getAccessToken();
                String accessToken = token.getToken();

               /* if(accessToken != null)
                {
                    ResultContext<UserModel> meContext = LoginActivity.Client.GetMe();
                    if(!meContext.IsSuccess)
                    {
                        return;
                    }

                    UserFragment.user = meContext.Data;
                    if(UserFragment.user != null)
                    {
                        // local storage
                        Intent form = new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(form);
                    }
                }*/
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        first = findViewById(R.id.first);
        second = findViewById(R.id.second);
        third = findViewById(R.id.third);

        color = Color.argb(140, 139, 195, 74); //transparan
        color2 = Color.rgb(139,195,74); //normal

        fColor= (GradientDrawable)first.getBackground();
        sColor= (GradientDrawable)second.getBackground();
        tColor= (GradientDrawable)third.getBackground();

        fColor.setColor(color2);
        sColor.setColor(color);
        tColor.setColor(color);

        mContext = this;
        mViewFlipper = (ViewFlipper) this.findViewById(R.id.view_flipper);
        mViewFlipper.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(final View view, final MotionEvent event) {
                detector.onTouchEvent(event);
                return true;
            }
        });
    }

    class SwipeGestureDetector extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            try {
                // right to left swipe
                if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY )
                {
                    i++;
                    if(i < 3)
                    {
                        mViewFlipper.setInAnimation(AnimationUtils.loadAnimation(mContext, R.anim.left_in));
                        mViewFlipper.setOutAnimation(AnimationUtils.loadAnimation(mContext, R.anim.left_out));
                        mViewFlipper.showNext();

                        if(i == 0)
                        {
                            fColor.setColor(color2);
                            sColor.setColor(color);
                            tColor.setColor(color);
                        }

                        else if(i == 1)
                        {
                            fColor.setColor(color);
                            sColor.setColor(color2);
                            tColor.setColor(color);
                        }

                        else if(i == 2)
                        {
                            fColor.setColor(color);
                            sColor.setColor(color);
                            tColor.setColor(color2);
                        }

                        return true;
                    }
                    else
                    {
                        i--;
                        return false;
                    }
                }

                else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY)
                {
                    i--;
                    if(i >= 0)
                    {
                        mViewFlipper.setInAnimation(AnimationUtils.loadAnimation(mContext, R.anim.right_in));
                        mViewFlipper.setOutAnimation(AnimationUtils.loadAnimation(mContext,R.anim.right_out));
                        mViewFlipper.showPrevious();

                        if(i == 0)
                        {
                            fColor.setColor(color2);
                            sColor.setColor(color);
                            tColor.setColor(color);
                        }

                        else if(i == 1)
                        {
                            fColor.setColor(color);
                            sColor.setColor(color2);
                            tColor.setColor(color);
                        }

                        else if(i == 2)
                        {
                            fColor.setColor(color);
                            sColor.setColor(color);
                            tColor.setColor(color2);
                        }
                        return true;
                    }

                    else
                    {
                        i++;
                        return false;
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return false;
        }
    }

    public void onBackPressed() {
        moveTaskToBack(true);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Intent form = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(form);
        }
    }

    class TokenReq extends AsyncTask<String,Void,ResultContext<String>> {
        private Exception exception;

        protected ResultContext<String> doInBackground(String... urls){
            ResultContext<String> resultContext = LoginActivity.Client.GetToken("","a~b~c");
            return resultContext;
        }

        protected void onPostExecute(String data){
            //TOKEN İşlemi
            Intent form = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(form);
        }
    }
}

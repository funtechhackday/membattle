package com.membattle;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;
import android.widget.TextView;

public class Splash extends Activity {
    private SharedPreferences mSettings;

    public static final String APP_PREFERENCES = "mysettings";
    private TextView textreg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String custom_font = "fonts/Mr_Lonely.otf";

        setContentView(R.layout.activity_splash);
        Typeface CF = Typeface.createFromAsset(getAssets(), custom_font);
        textreg = (TextView) findViewById(R.id.splashtite);
        textreg.setTypeface(CF);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // По истечении времени, запускаем главный активити, а Splash Screen закрываем
//                Intent intent = new Intent(Splash.this, FirstStartActivity.class);
//                startActivity(intent);
                mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
                String login = mSettings.getString("login", "no");
                Log.i("code", "first: "+login);
                if(login=="no"){
                    overridePendingTransition(0,0);
                    TaskStackBuilder.create(getApplicationContext())
                            .addNextIntentWithParentStack(new Intent(getApplicationContext(), AuthActivity.class))
                            .addNextIntent(new Intent(getApplicationContext(), FirstStartActivity.class))
                            .startActivities();

                }
                else {
                    overridePendingTransition(0,0);
                    Intent i = new Intent(Splash.this, NavigationActivity.class);
                    startActivity(i);
                }

            }
        }, 2000);
    }
}

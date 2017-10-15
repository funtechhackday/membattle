package com.membattle;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Севастьян on 14.10.2017.
 */

public class Profile extends Fragment {
    TextView username, coins, countgames, countwins;
    private SharedPreferences mSettings;
    public static final String APP_PREFERENCES = "mysettings";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.profile, container, false);
        mSettings = getActivity().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        username = (TextView) v.findViewById(R.id.profileusername);
        coins = (TextView) v.findViewById(R.id.profilecoins);
        countgames = (TextView) v.findViewById(R.id.countgames);
        countwins = (TextView) v.findViewById(R.id.countwins);
        String user, c, Countg, Countw;
        user = mSettings.getString("login", "username");
        c = String.valueOf(mSettings.getInt("coins", 0));
        Countg = String.valueOf(mSettings.getInt("countgames",0));
        Countw = String.valueOf(mSettings.getInt("countcoins",0));
        username.setText(user);
        coins.setText(c);
        countgames.setText(Countg);
        countwins.setText(Countw);
        return  v;
    }
}

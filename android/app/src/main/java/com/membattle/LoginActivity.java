package com.membattle;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends Activity {
    private static final String APP_PREFERENCES = "settings";
    TextView title;
    EditText login, password;
    Button enter;
    private SharedPreferences mSettings;
    private APIService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = (EditText) findViewById(R.id.loginenter);
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        password = (EditText) findViewById(R.id.passlogin);
        enter = (Button) findViewById(R.id.butenter);
        title = (TextView) findViewById(R.id.titlelogin);
        String custom_font = "fonts/Mr_Lonely.otf";
        Typeface CF = Typeface.createFromAsset(getAssets(), custom_font);
        title.setTypeface(CF);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://192.168.0.142:8000/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                service = retrofit.create(APIService.class);

                RegistrationUser user = new RegistrationUser(login.getText().toString(), password.getText().toString());
                Call<User> call = service.auth(user);
                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        Log.i("code", response.code()+"");
                        User user = response.body();
                        if(response.code()==403){
                            Toast.makeText(getApplicationContext(), "Ошибка входа!", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Вход выполнен!", Toast.LENGTH_SHORT).show();

                            Log.i("code", "coins: "+user.getCoins());

                            SharedPreferences.Editor editor = mSettings.edit();
                            editor.putString("login", login.getText().toString());
                            editor.putInt("coins", user.getCoins());
                            editor.apply();

                            Intent i = new Intent(LoginActivity.this, NavigationActivity.class);
                            i.putExtra("login", login.getText().toString());
                            i.putExtra("coins", user.getCoins());
                            startActivity(i);
                        }
                        //Log.i("code", user.getMessage());
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {

                    }
                });
            }
        });
    }
}

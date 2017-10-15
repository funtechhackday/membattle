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

import junit.framework.Test;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.WebSocket;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AuthActivity extends Activity {
    Button Registration, LogIn;
    private OkHttpClient client;
    TextView textreg;
    private SharedPreferences mSettings;
    EditText Login, Pass, Repeat;
    public static final String APP_PREFERENCES = "mysettings";
    private APIService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        Login = (EditText) findViewById(R.id.loginreg);
        Pass = (EditText) findViewById(R.id.passreg);
        Repeat = (EditText) findViewById(R.id.repeatpassreg);
        textreg = (TextView) findViewById(R.id.textReg);
        Registration = (Button) findViewById(R.id.butreg);
        LogIn = (Button) findViewById(R.id.buttoenter);
        String custom_font = "fonts/Mr_Lonely.otf";
        Typeface CF = Typeface.createFromAsset(getAssets(), custom_font);
        textreg.setTypeface(CF);
        Registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                SharedPreferences.Editor editor = mSettings.edit();
//                editor.putString("login", Login.getText().toString());
//                editor.apply();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://192.168.0.142:8000/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                service = retrofit.create(APIService.class);

                RegistrationUser user = new RegistrationUser(Login.getText().toString(), Pass.getText().toString());
                Call<User> call = service.registration(user);
                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        Log.i("code", response.code()+"");
                        User user = response.body();
                        if(Pass.getText().toString().equals(Repeat.getText().toString())){
                            if(user.getStatus()==409){
                                Toast.makeText(getApplicationContext(), "Такой пользователь уже существует!", Toast.LENGTH_SHORT).show();
                            }
                            if(user.getStatus()==200){
                                Toast.makeText(getApplicationContext(), "Регистрация прошла успешна!", Toast.LENGTH_SHORT).show();

                                SharedPreferences.Editor editor = mSettings.edit();
                                editor.putString("login", Login.getText().toString());
                                editor.putInt("coins", 0);
                                editor.apply();

                                Intent i = new Intent(AuthActivity.this, NavigationActivity.class);
                                startActivity(i);
                            }
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Пароли отличаются!", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {

                    }
                });

//                Intent i = new Intent(AuthActivity.this, NavigationActivity.class);
//                startActivity(i);
            }
        });
        LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AuthActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
    }
}

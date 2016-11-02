package com.example.rdjong.pokedroid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rdjong.pokedroid.Model.Data;
import com.example.rdjong.pokedroid.Model.Me;
import com.example.rdjong.pokedroid.Model.Token;
import com.example.rdjong.pokedroid.Model.User;
import com.example.rdjong.pokedroid.Remote.ServiceGenerator;
import com.example.rdjong.pokedroid.Remote.LoginService;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    String Token;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etLogEmail = (EditText) findViewById(R.id.etLogEmail);
        final EditText etLogPassword = (EditText) findViewById(R.id.etLogPassword);
        final Button btnLog = (Button) findViewById(R.id.btnLog);
        final Context context = getApplicationContext();

        btnLog.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final String email = etLogEmail.getText().toString();
                final String password = etLogPassword.getText().toString();
                final int duration = Toast.LENGTH_SHORT;
                final Token notaToken = new Token("lol");
                final LoginService loginService = ServiceGenerator.createService(LoginService.class, notaToken);
                final Me me = new Me(email, password);
                Call<Token> call = loginService.createMe(me);
                call.enqueue(new Callback<Token>() {
                    @Override
                    public void onResponse(Call<Token> call, Response<Token> response) {
                        if (response.isSuccessful()) {
                            Log.d("lol", response.toString());
                            Log.d("lol", response.message());
                            Log.d("lol", response.body().getToken());
                            Log.d("lol", response.headers().toString());
                            Log.d("lol", response.raw().toString());
                            Token = response.body().getToken();
                            CharSequence text = Token + "\n" + "success";
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                        } else {
                            CharSequence text = email + ":" + password + "\n" + "404";
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Token> call, Throwable t) {
                        // something went completely south (like no internet connection)
                        CharSequence text = email + "\n"+ "500";
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        Log.d("Error", t.getMessage());
                    }
                });
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
    @Override
    protected void onStop(){
        super.onStop();

        SharedPreferences  settings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("token_string", Token);
        editor.commit();
;
    }
}

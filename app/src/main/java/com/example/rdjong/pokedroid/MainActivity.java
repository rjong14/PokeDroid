package com.example.rdjong.pokedroid;



import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.rdjong.pokedroid.Model.Token;

public class MainActivity extends AppCompatActivity {



    private Token getToken(){
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String token_string = settings.getString("token_string", "");

        return new Token(token_string);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Token token = getToken();
        final TextView textView = (TextView) findViewById(R.id.textView);
        final Button btnGoUsers = (Button) findViewById(R.id.btnGoUsers);
        final Button btnlogout = (Button) findViewById(R.id.btn_logout);

        btnGoUsers.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent uIntent = new Intent(MainActivity.this, UserListActivity.class);
                MainActivity.this.startActivity(uIntent);
            }
        });
        btnlogout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences  settings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor editor = settings.edit();
                editor.putString("token_string", "");
                editor.commit();
                finish();
            }
        });
        Log.d("main", "main");
        Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
        if(token.getToken().equals("")) {
            MainActivity.this.startActivity(loginIntent);
            finish();
        } else{
            textView.setText("You are logged in");
        }
    }

}

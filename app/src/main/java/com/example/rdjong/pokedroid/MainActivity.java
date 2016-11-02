package com.example.rdjong.pokedroid;



import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Context;

import com.example.rdjong.pokedroid.Model.Token;

public class MainActivity extends AppCompatActivity {



    private Token getToken(){
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String token_string = settings.getString("token_string", "");
        Token myToken = new Token(token_string);

        return myToken;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Token token = getToken();
        final TextView textView = (TextView) findViewById(R.id.textView);
        final Button btnGoUsers = (Button) findViewById(R.id.btnGoUsers);

        btnGoUsers.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent uIntent = new Intent(MainActivity.this, UserListActivity.class);
                MainActivity.this.startActivity(uIntent);
            }
        });

        Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
        if(token.getToken() == "") {
            MainActivity.this.startActivity(loginIntent);
            finish();
        } else{
            textView.append(token.getToken());
        }
    }
}

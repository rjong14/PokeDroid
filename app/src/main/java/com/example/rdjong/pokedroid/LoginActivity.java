package com.example.rdjong.pokedroid;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etLogEmail = (EditText) findViewById(R.id.etLogEmail);
        final EditText etLogPassword = (EditText) findViewById(R.id.etLogPassword);
        final Button btnLog = (Button) findViewById(R.id.btnLog);


        btnLog.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final String email = etLogEmail.getText().toString();
                final String password = etLogPassword.getText().toString();

                Context context = getApplicationContext();
                CharSequence text = email + "\n"+ password;
                int duration = Toast.LENGTH_SHORT;
                final Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                finish();
            }
        });
    }
}

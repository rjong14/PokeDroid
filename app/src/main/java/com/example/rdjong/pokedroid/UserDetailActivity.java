package com.example.rdjong.pokedroid;

/**
 * Created by rdjong on 25-10-16.
 */

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;

import com.example.rdjong.pokedroid.Model.Token;

public class UserDetailActivity extends AppCompatActivity {

    private Token getToken(){
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String token_string = settings.getString("token_string", "");

        return new Token(token_string);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);

        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(UserDetailFragment.ARG_ITEM_ID,
                    getIntent().getStringExtra(UserDetailFragment.ARG_ITEM_ID));
            arguments.putString(UserDetailFragment.ARG_TOKEN,
                    getIntent().getStringExtra(UserDetailFragment.ARG_TOKEN));
            UserDetailFragment fragment = new UserDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.user_detail_container, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {

            navigateUpTo(new Intent(this, UserListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

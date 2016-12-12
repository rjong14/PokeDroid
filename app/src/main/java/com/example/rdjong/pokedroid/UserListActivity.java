package com.example.rdjong.pokedroid;

/**
 * Created by rdjong on 25-10-16.
 */


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;

import android.view.View;
import com.example.rdjong.pokedroid.Adapter.UserAdapter;
import com.example.rdjong.pokedroid.Model.Token;
import com.example.rdjong.pokedroid.Model.User;
import com.example.rdjong.pokedroid.Remote.ServiceGenerator;
import com.example.rdjong.pokedroid.Remote.UserService;


import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class UserListActivity extends AppCompatActivity {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    private Token getToken(){
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String token_string = settings.getString("token_string", "");
        Token myToken = new Token(token_string);

        return myToken;
    }

    private void getList(){
        final UserService userService = new ServiceGenerator().createService(UserService.class, getToken());
        Call<List<User>> call = userService.getUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {
                    View recyclerView = findViewById(R.id.user_list);
                    assert recyclerView != null;
                    Log.d("resp","success");
                    Log.d("resp", response.message());
                    Log.d("resp", response.body().toString());
                    Log.d("resp", response.toString());
                    Log.d("resp", response.raw().toString());
                    Log.d("resp", response.raw().body().toString());

                    if(response.body() == null) {
                        Log.d("resp", "body null");
                    }
                    Log.d("res", String.valueOf(response.body().size()));

                    setupRecyclerView((RecyclerView) recyclerView, response.body());
                } else {

                    Log.d("error message", "500");
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                // there is more than just a failing request (like: no internet connection)
                Log.d("resp","fail");
                Log.d("resp", call.toString());
                Log.d("resp", t.getMessage());
                t.getCause();

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Add user placeholder", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        getList();

        if (findViewById(R.id.user_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }
    }

    @Override
    protected void onResume(){
        super.onResume();
        getList();

    }

    private void setupRecyclerView(@NonNull final RecyclerView recyclerView, List<User> users) {

        recyclerView.setAdapter(new UserAdapter(users, mTwoPane, this));
    }


}

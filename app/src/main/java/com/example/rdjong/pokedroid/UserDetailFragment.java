package com.example.rdjong.pokedroid;

/**
 * Created by rdjong on 25-10-16.
 */

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.rdjong.pokedroid.Model.PutUser;
import com.example.rdjong.pokedroid.Model.Token;
import com.example.rdjong.pokedroid.Model.User;
import com.example.rdjong.pokedroid.Remote.ServiceGenerator;
import com.example.rdjong.pokedroid.Remote.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class UserDetailFragment extends Fragment {


    public static final String ARG_ITEM_ID = "item_id";
    public static final String ARG_TOKEN = "token";


    private User mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public UserDetailFragment() {
    }

    private void makeView(Activity activity){
        final Activity act = activity;
        final Button udbtnsave = ((Button) act.findViewById(R.id.ud_btn_save));

        if(udbtnsave != null) {
            udbtnsave.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    final String email = ((EditText) act.findViewById(R.id.ud_et_email)).getText().toString();
                    final String password = ((EditText) act.findViewById(R.id.ud_et_password)).getText().toString();
                    putUser(email, password, act);
                }
            });

        }
        // view stuff
        CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) act.findViewById(R.id.toolbar_layout);
        if(((EditText) act.findViewById(R.id.ud_et_email)) != null) {
            ((EditText) act.findViewById(R.id.ud_et_email)).setText(mItem.getLocal().getEmail());
            //((TextView) act.findViewById(R.id.user_detail)).setText(mItem.getLocal().getEmail());
        }
        if (appBarLayout != null) {
            appBarLayout.setTitle(mItem.getLocal().getEmail());
        }
    }

    private void putUser(String e, String p, Activity activity) {;
        final Activity act = activity;
        if (getArguments().containsKey(ARG_ITEM_ID)) {
            final UserService userService = new ServiceGenerator().createService(UserService.class, new Token(getArguments().getString(ARG_TOKEN)));

            Call<User> call = null;
            if (e != null && !e.equals("") && p != null && !p.equals("")) {
                Log.d("put 1", e + ":" + p);
                PutUser user = new PutUser(e,p);
                Log.d("put", user.getEmail() + ":" + p);
                call = userService.putUser(getArguments().getString(ARG_ITEM_ID), user);
            }

            if(call != null) {
                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (response.isSuccessful()) {
                            if (response.body() != null) {
                                Log.d("putuser", response.body().getLocal().getEmail());
                                act.finish();
                            }
                        } else {
                            Log.d("error message", "500");
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        // there is more than just a failing request (like: no internet connection)
                        Log.d("resp", "fail");
                        Log.d("resp", call.toString());
                        t.getCause();
                    }
                });
            }
        }
    }

    private void callUser(Activity activity){
        final Activity act = activity;
        if (getArguments().containsKey(ARG_ITEM_ID)) {
            final UserService userService = new ServiceGenerator().createService(UserService.class, new Token(getArguments().getString(ARG_TOKEN)));
            Call<User> call = userService.getUser(getArguments().getString(ARG_ITEM_ID));
            call.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    if (response.isSuccessful()) {

                        if (response.body() != null) {
                            Log.d("user", response.body().getLocal().getEmail());
                                mItem = response.body();
                                makeView(act);
                        }
                    } else {
                        // parse the response body …
                        // … and use it to show error information

                        // … or just log the issue like we’re doing :)
                        Log.d("error message", "500");
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    // there is more than just a failing request (like: no internet connection)
                    Log.d("resp", "fail");
                    Log.d("resp", call.toString());
                    Log.d("resp", t.getMessage());
                    t.getCause();
                }
            });
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            Activity activity = this.getActivity();
            callUser(activity);
            Log.d("oncreate", "aftercall");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        onActivityCreated(savedInstanceState);
        return inflater.inflate(R.layout.user_detail, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

}

package com.example.rdjong.pokedroid;

import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rdjong.pokedroid.Model.Local;
import com.example.rdjong.pokedroid.Model.Pokemon;
import com.example.rdjong.pokedroid.Model.Role;
import com.example.rdjong.pokedroid.Model.Token;
import com.example.rdjong.pokedroid.Model.User;
import com.example.rdjong.pokedroid.Remote.ServiceGenerator;
import com.example.rdjong.pokedroid.Remote.UserService;
import com.example.rdjong.pokedroid.dummy.DummyUsers;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A fragment representing a single User detail screen.
 * This fragment is either contained in a {@link UserListActivity}
 * in two-pane mode (on tablets) or a {@link UserDetailActivity}
 * on handsets.
 */
public class UserDetailFragment extends Fragment {

    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";
    public static final String ARG_TOKEN = "token";

    /**
     * The dummy content this fragment is presenting.
     */
    private User mItem;

    private Object lock = new Object();
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public UserDetailFragment() {
    }

    private synchronized void callUser(Activity activity){
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
                            if(mItem != null) {

                                CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) act.findViewById(R.id.toolbar_layout);
                                if (appBarLayout != null) {
                                    appBarLayout.setTitle(mItem.getLocal().getEmail());
                                }
                            }
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
    public synchronized void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Activity activity = this.getActivity();
        callUser(activity);
        Log.d("oncreate","aftercall");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.user_detail, container, false);
        Log.d("createView","first");
        // Show the dummy content as text in a TextView.

        if (mItem != null) {
            Log.d("createView","no null");
            ((TextView) rootView.findViewById(R.id.user_detail)).setText(mItem.getLocal().getEmail());
        }

        return rootView;
    }
}

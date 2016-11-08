package com.example.rdjong.pokedroid;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rdjong.pokedroid.Model.Local;
import com.example.rdjong.pokedroid.Model.Pokemon;
import com.example.rdjong.pokedroid.Model.Role;
import com.example.rdjong.pokedroid.Model.User;
import com.example.rdjong.pokedroid.dummy.DummyUsers;

import java.util.ArrayList;

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

    /**
     * The dummy content this fragment is presenting.
     */
    private User mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public UserDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Do a get call on users with the arg as id!!!!!!!!
            //mItem = DummyUsers.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
            mItem = new User("1", "lolRole", 1, new ArrayList<Pokemon>(), new Local("pass", "email" + 1));
            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.getLocal().getEmail());
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.user_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.user_detail)).setText(mItem.getLocal().getEmail());
        }

        return rootView;
    }
}

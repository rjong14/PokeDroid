package com.example.rdjong.pokedroid.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rdjong.pokedroid.UserListActivity;
import com.example.rdjong.pokedroid.ViewHolder.ListUserViewHolder;
import com.example.rdjong.pokedroid.Model.User;
import com.example.rdjong.pokedroid.R;
import com.example.rdjong.pokedroid.UserDetailActivity;
import com.example.rdjong.pokedroid.UserDetailFragment;

import java.util.List;

/**
 * Created by rdjong on 2-11-16.
 */
public class UserAdapter
        extends RecyclerView.Adapter<ListUserViewHolder> {

    private final List<User> mValues;
    private boolean mTwoPane;
    private Context context;
    View view;

    public UserAdapter(List<User> users, boolean mTwoPane, Context context) {
        mValues = users;
        this.mTwoPane = mTwoPane;
        this.context = context;
        view = new View(context);
    }

    @Override
    public ListUserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_list_content, parent, false);
        return new ListUserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListUserViewHolder holder, int position) {
        holder.setmUser(mValues.get(position));
        holder.setmEmailView(mValues.get(position).getLocal().getEmail());
        holder.setmRoleView(mValues.get(position).getRole());

        holder.getmView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((UserListActivity)context).findViewById(R.id.user_detail_container) != null) {
                    Log.d("container", "not null");
                    mTwoPane = true;
                }
                Log.d("click: ", String.valueOf(mTwoPane));
                if (mTwoPane) {

                    Bundle arguments = new Bundle();
                    arguments.putString(UserDetailFragment.ARG_ITEM_ID, holder.getmUser().getId());
                    UserDetailFragment fragment = new UserDetailFragment();
                    fragment.setArguments(arguments);
                    ((UserListActivity)context).getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.user_detail_container, fragment)
                            .commit();
                } else {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, UserDetailActivity.class);
                    intent.putExtra(UserDetailFragment.ARG_ITEM_ID, holder.getmUser().getId());

                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

}

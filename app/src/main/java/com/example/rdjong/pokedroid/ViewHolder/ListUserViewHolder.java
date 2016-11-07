package com.example.rdjong.pokedroid.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.rdjong.pokedroid.Model.User;
import com.example.rdjong.pokedroid.R;

/**
 * Created by rdjong on 2-11-16.
 */
public class ListUserViewHolder extends RecyclerView.ViewHolder {
        private final View mView;
        private final TextView mEmailView;
        private final TextView mRoleView;
        private User mUser;

        public ListUserViewHolder(View view) {
            super(view);
            mView = view;
            mEmailView = (TextView) view.findViewById(R.id.id);
            mRoleView = (TextView) view.findViewById(R.id.content);
        }

    public View getmView() {
        return mView;
    }

    public TextView getmRoleView() {
        return mRoleView;
    }

    public void setmRoleView(String text){
        this.mRoleView.setText(text);
    }

    public TextView getmEmailView() {
        return mEmailView;
    }

    public void setmEmailView(String text){
        this.mEmailView.setText(text);
    }

    public User getmUser() {
        return mUser;
    }

    public void setmUser(User mUser) {
        this.mUser = mUser;
    }

    @Override
        public String toString() {
            return super.toString() + " '" + mRoleView.getText() + "'";
        }
}

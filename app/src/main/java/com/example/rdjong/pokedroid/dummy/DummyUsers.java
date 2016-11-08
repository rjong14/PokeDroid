package com.example.rdjong.pokedroid.dummy;

import com.example.rdjong.pokedroid.Model.Local;
import com.example.rdjong.pokedroid.Model.Pokemon;
import com.example.rdjong.pokedroid.Model.Role;
import com.example.rdjong.pokedroid.Model.User;

import java.util.ArrayList;
import java.util.List;

public class DummyUsers {

    public static final List<User> USERS = new ArrayList<User>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addUser(createUser(i));
        }
    }

    private static void addUser(User user) {
        USERS.add(user);
    }

    private static User createUser(int position) {
        List<Pokemon> pokelist = new ArrayList<Pokemon>();
        return new User(String.valueOf(position), "lolrole", 1, pokelist, new Local("pass", "email" + position));
    }

}

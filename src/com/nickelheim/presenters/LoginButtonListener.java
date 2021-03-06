package com.nickelheim.presenters;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.nickelheim.activities.LoginActivity;
import com.nickelheim.activities.LoginSuccessActivity;
import com.nickelheim.models.UserList;

public class LoginButtonListener {
    public static final String USERNAME = "username";
    private Context context;
    private LoginActivity view;
    private UserList model;
    
    public LoginButtonListener(LoginActivity view, Context context, UserList model) {
        this.view = view;
        this.model = model;
        this.context = context;
        
    }
     
    public void attemptLogin() {
        String username = view.getUsername();
        String password = view.getPassword();
        boolean isValidUser = model.isValidUser(username, password);
        if(isValidUser) {
            Intent intent  = new Intent(view, LoginSuccessActivity.class);
            intent.putExtra(USERNAME, username);
            view.startActivity(intent);
        } else {
            Toast.makeText(this.context, "Login not successful.  Try again.", Toast.LENGTH_LONG).show();
        }

    }
}

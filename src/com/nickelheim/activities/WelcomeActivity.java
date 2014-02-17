package com.nickelheim.activities;

import com.nickelheim.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.nickelheim.presenters.WelcomeButtonListener;
import com.nickelheim.views.AbstractWelcomeActivity;

public class WelcomeActivity extends AbstractWelcomeActivity {
    private WelcomeButtonListener listener;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
	listener = new WelcomeButtonListener(this);

    }


    public void startLogin(View view) {
	listener.beginLogin();
    }


    public void startRegister(View view) {
	listener.beginRegister();
    }
}

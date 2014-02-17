package com.nickelheim.presenters;

import com.nickelheim.views.AbstractWelcomeActivity;
import android.content.Intent;
import com.nickelheim.activities.LoginActivity;

public class WelcomeButtonListener {

    private AbstractWelcomeActivity view;

    public WelcomeButtonListener(AbstractWelcomeActivity view) {
	this.view = view;
    }

    public void beginLogin() {
	Intent intent  = new Intent(view, LoginActivity.class);
	view.startActivity(intent);
    }

    public void beginRegister() {
	// Intent intent = new Intent(this, );
    }


}

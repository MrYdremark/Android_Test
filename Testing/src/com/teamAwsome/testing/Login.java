package com.teamAwsome.testing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Login extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		Button chkLog = (Button) findViewById(R.id.bLogin);
		Button chkReg = (Button) findViewById(R.id.bRegister);
		final EditText username = (EditText) findViewById(R.id.etUsername);
		final EditText password = (EditText) findViewById(R.id.etPassword);
		
		chkLog.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				String checkUsr = username.getText().toString();
				String checkPass = password.getText().toString();
				// When a user fills in the information we need to take the information and send it to the database
				// In the database might return a true or false response if the username and password is a match?
				if(checkUsr.contentEquals("a") && checkPass.contentEquals("a")) {
					Intent openMap = new Intent("com.teamAwsome.testing.MAP");
					startActivity(openMap);
				} else {
					// Something
				}
			}
		});
		chkReg.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent register = new Intent("com.teamAwsome.testing.REGISTER");
				startActivity(register);
			}
		});
		
	}
}

package com.teamAwsome.testing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		
		Button regi = (Button) findViewById(R.id.bReg);
		final EditText fname = (EditText) findViewById(R.id.regFname);
		final EditText lname = (EditText) findViewById(R.id.regLname);
		final EditText email = (EditText) findViewById(R.id.regEmail);
		final EditText pass1 = (EditText) findViewById(R.id.regPass1);
		final EditText pass2 = (EditText) findViewById(R.id.regPass2);
		
		regi.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				String fnametos = fname.getText().toString();
				String lnametos = lname.getText().toString();
				String emailtos = email.getText().toString();
				String pass1tos = pass1.getText().toString();
				String pass2tos = pass2.getText().toString();
				// Send data to database, Check if not in database. If not: Add to database and go to login.
				if(
						fnametos.length() != 0 &&
						lnametos.length() != 0 &&
						emailtos.length() != 0 &&
						pass1tos.length() != 0 &&
						pass2tos.length() != 0) {
					Intent openLogin = new Intent("com.teamAwsome.testing.REGCOMPLETE");
					startActivity(openLogin);
				} else {
					// Do Something
				}
			}
		});
	}
}

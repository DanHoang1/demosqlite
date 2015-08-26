package com.vitpr.android.demosqlite.acitvities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class EditPage extends Activity implements OnClickListener {
	private String mode;
	private Button mBtadd, mBtdelete,mBtupdate,mBtback;
	private EditText mEtname, mEtemail, mEtpassword, mEtphone, mEtplace;
	private EditText mEtid;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail_page);

		// get the values passed to the activity from the calling activity
		// determine the mode - add, update or delete
		if (this.getIntent().getExtras() != null) {
			Bundle bundle = this.getIntent().getExtras();
			mode = bundle.getString("mode");
		}

		// get references to the buttons and attach listeners
		mBtback = (Button) findViewById(R.id.detail_bt_back);
		 mBtback.setOnClickListener(this);
		mBtadd = (Button) findViewById(R.id.detail_bt_add);
		 mBtadd.setOnClickListener(this);
		mBtdelete = (Button) findViewById(R.id.detail_bt_delete);
		mBtdelete.setOnClickListener(this);
		mBtupdate = (Button) findViewById(R.id.detail_bt_update);
		mBtupdate.setOnClickListener(this);
		mEtid = (EditText) findViewById(R.id.detail_et_id);
		mEtname = (EditText) findViewById(R.id.detail_et_name);
		mEtemail = (EditText) findViewById(R.id.detail_et_email);
		mEtpassword = (EditText) findViewById(R.id.detail_et_password);
		mEtphone = (EditText) findViewById(R.id.detail_et_phone);
		mEtplace = (EditText) findViewById(R.id.detail_et_place);
		// if in add mode disable the delete option
//		if (mode.trim().equalsIgnoreCase("add")) {
//			mBtdelete.setEnabled(false);
//	}
	}	
	public void onClick(View v) {
		// get values from the spinner and the input text fields
		// String myContinent = continentList.getSelectedItem().toString();
		int myID = Integer.parseInt(mEtid.getText()+"");
		String myName = mEtname.getText().toString();
		String myEmail = mEtemail.getText().toString();
		String myPassword = mEtpassword.getText().toString();
		String myPhone = mEtphone.getText().toString();
		String myPlace = mEtplace.getText().toString();

//		// check for blanks
//		if (myName.trim().equalsIgnoreCase("")) {
//			Toast.makeText(getBaseContext(), "Please ENTER your name", Toast.LENGTH_LONG).show();
//			return;
//		}
//		// check for blanks
//		if (myEmail.trim().equalsIgnoreCase("")) {
//			Toast.makeText(getBaseContext(), "Please ENTER your email", Toast.LENGTH_LONG).show();
//			return;
//		}
//		// check for blanks
//		if (myPassword.trim().equalsIgnoreCase("")) {
//			Toast.makeText(getBaseContext(), "Please ENTER your password", Toast.LENGTH_LONG).show();
//			return;
//		}
//		// check for blanks
//		if (myPhone.trim().equalsIgnoreCase("")) {
//			Toast.makeText(getBaseContext(), "Please ENTER your phone", Toast.LENGTH_LONG).show();
//			return;
//		}
//		// check for blanks
//		if (myPlace.trim().equalsIgnoreCase("")) {
//			Toast.makeText(getBaseContext(), "Please ENTER your place", Toast.LENGTH_LONG).show();
//			return;
//		}
		switch (v.getId()) {
		case R.id.detail_bt_add:
			DBHelper save = new DBHelper(this);
			Contact contact = new Contact(myName, myEmail, myPassword, myPhone, myPlace);
			contact._name		=myName;
			contact._email		=myEmail;
			contact._password	=myPassword;
			contact._phone		=myPhone;
			contact._place		=myPlace;
			save.addContact(contact);
			finish();
			break;
		case R.id.detail_bt_delete:
			DBHelper delete = new DBHelper(this);
			Contact contact1 = new Contact(myID,myName, myEmail, myPassword, myPhone, myPlace);
			contact1._id		=myID;
			contact1._name		=myName;
			contact1._email		=myEmail;
			contact1._password	=myPassword;
			contact1._phone		=myPhone;
			contact1._place		=myPlace;
			//delete.deleteContact(contact1);
			delete.deleteContact(contact1);
			Log.e("loi roi",myName);
			finish();
			break;
		case R.id.detail_bt_update:
			DBHelper update= new DBHelper(this);
			Contact contact2 = new Contact();
			contact2._id		=myID;
			contact2._name		=myName;
			contact2._email		=myEmail;
			contact2._password	=myPassword;
			contact2._phone		=myPhone;
			contact2._place		=myPlace;
			update.updateContact(contact2);
			finish();
			break;
		case R.id.detail_bt_back:
			finish();
			break;
			
			
		}

	}
		

}

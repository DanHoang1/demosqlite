package com.vitpr.android.demosqlite.acitvities;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// mBtAdd = (Button)findViewById(R.layout.main_bt_add);

	}

	@Override
	protected void onResume() {
		super.onResume();
		DBHelper db = new DBHelper(this);
		List<Contact> contacts = db.getAllContacts();
		ListView list = (ListView) findViewById(R.id.ListView);
		ArrayAdapter<Contact> adapter = new MyListAdapter(this, contacts);
		list.setAdapter(adapter);
	}

	class MyListAdapter extends ArrayAdapter<Contact> {

		public MyListAdapter(Context context, List<Contact> items) {
			super(context, 0, items);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// Make sure have a view to work with (may have been given null)
			if (convertView == null) {
				convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_view, parent, false);
			}
			// find the car to work with
			Contact currentCar = getItem(position);
			// fill the view
			TextView id = (TextView) convertView.findViewById(R.id.view_tv_id);
			id.setText(currentCar.getID() + " ");
			TextView name = (TextView) convertView.findViewById(R.id.view_tv_name);
			name.setText(currentCar.getName() + " ");
			TextView email = (TextView) convertView.findViewById(R.id.view_tv_email);
			email.setText(currentCar.getEmail() + " ");
			TextView password = (TextView) convertView.findViewById(R.id.view_tv_password);
			password.setText(currentCar.getPassword() + "");
			TextView phone = (TextView) convertView.findViewById(R.id.view_tv_phone);
			phone.setText(currentCar.getPhone() + "");
			TextView place = (TextView) convertView.findViewById(R.id.view_tv_place);
			place.setText(currentCar.getPlace() + "");
			Button button = (Button) convertView.findViewById(R.id.view_bt_edit);
			button.setOnClickListener(new OnClickListener() {

				public void onClick(View v) {
					// starts a new Intent to add a Country
					Intent Editpage = new Intent(MainActivity.this, EditPage.class);
					Bundle bundle = new Bundle();
					bundle.putString("mode", "add");
					Editpage.putExtras(bundle);
					MainActivity.this.startActivity(Editpage);
				}

			});
			return convertView;
		}

	}
}

package com.vitpr.android.demosqlite.acitvities;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SearchPage extends Activity implements OnClickListener{
	private String mode;
	private DBHelper dbhelper = new DBHelper(this);
	private EditText  mEtsearch;
	private Button mBtbutton;
	private TextView mTvresult; 

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_page);
		SQLiteDatabase db = dbhelper.getReadableDatabase();
		if (this.getIntent().getExtras() != null) {
			Bundle bundle = this.getIntent().getExtras();
			mode = bundle.getString("mode");
		}

		mBtbutton = (Button) findViewById(R.id.search_bt_button);
		mBtbutton.setOnClickListener(this);
		mEtsearch = (EditText) findViewById(R.id.search_et_search);
		mTvresult=(TextView)findViewById(R.id.search_tv_result);
	}
	public void onClick(View v) {
		SQLiteDatabase db = dbhelper.getReadableDatabase();
		String mySearch = mEtsearch.getText().toString();
		//String myResult = mTvresult.getText().toString();
		Cursor timkiem=db.rawQuery("SELECT * FROM TABLE_CONTACTS" +""+
				"WHERE KEY_NAME ='"+mySearch+"';", null);
				//-fetch record
				if(timkiem.getCount()!=0){
					timkiem.moveToFirst();//go to first row
				String a=timkiem.getString(1).toString();
				mTvresult.setText(a);
				}
				else{
				//display some notice here saying no data found
					mTvresult.setText("not exist in data");
				}
		

	}
	
}

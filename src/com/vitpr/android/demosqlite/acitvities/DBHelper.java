package com.vitpr.android.demosqlite.acitvities;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
 
public class DBHelper extends SQLiteOpenHelper {
 
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "contactsManager";
 
    // Contacts table name
    private static final String TABLE_CONTACTS = "contacts";
 
    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL="email";
    private static final String KEY_PASSWORD="password";
    private static final String KEY_PHONE = "phone";
    private static final String KEY_PLACE="place";
 
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
 
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"+ KEY_EMAIL + " TEXT,"+ KEY_PASSWORD + " TEXT,"
                + KEY_PHONE + " TEXT," + KEY_PLACE + " TEXT"+ ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }
 
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
 
        // Create tables again
        onCreate(db);
    }
 
    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */
 
    // Adding new contact
	void addContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName()); // Contact Name
        values.put(KEY_EMAIL, contact.getEmail()); // Contact Email
        values.put(KEY_PASSWORD, contact.getPassword()); // Contact Password
        values.put(KEY_PHONE, contact.getPhone()); // Contact Phone
        values.put(KEY_PLACE, contact.getPlace()); // Contact Place
 
        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        db.close(); // Closing database connection
    }
 
    // Getting single contact
    Contact getContact(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
 
        Cursor cursor = db.query(TABLE_CONTACTS, new String[] { KEY_ID,
                KEY_NAME,KEY_EMAIL,KEY_PASSWORD, KEY_PHONE,KEY_PLACE, }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        //Integer.parseInt(cursor.getString(0)),
        Contact contact = new Contact(
                cursor.getString(1), cursor.getString(2),cursor.getString(3),cursor.getString(4), cursor.getString(5));
        // return contact
        return contact;
    }
     
    // Getting All Contacts
    public List<Contact> getAllContacts() {
        List<Contact> contactList = new ArrayList<Contact>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;
 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Contact contact = new Contact();
              //contact.setID(Integer.parseInt(cursor.getString(0)));
                contact.setID(cursor.getInt(0));
                contact.setName(cursor.getString(1));
                contact.setEmail(cursor.getString(2));
                contact.setPassword(cursor.getString(3));
                contact.setPhone(cursor.getString(4));
                contact.setPlace(cursor.getString(5));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
 
        // return contact list
        return contactList;
    }
 
    // Updating single contact
    public int updateContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName());
        values.put(KEY_EMAIL, contact.getEmail());
        values.put(KEY_PASSWORD, contact.getPassword());
        values.put(KEY_PHONE, contact.getPhone());
        values.put(KEY_PLACE, contact.getPlace());
 
        // updating row
        return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.getID()) });
    }
 
    // Deleting single contact
    public void deleteContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.getID()) });
        db.close();
    }
 
    public Integer deleteTitle(String name) 
    {	SQLiteDatabase db = this.getWritableDatabase();
        //return db.delete(TABLE_CONTACTS, KEY_NAME + "=" + name, null)>0;
    	return db.delete(TABLE_CONTACTS, "name=?",new String[]{name});
    }
    public Cursor searchByInputText(String inputText)  {
    	SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT docid as _id," +
                KEY_NAME +  " from " + TABLE_CONTACTS +
                " where " + KEY_NAME + " MATCH '" + inputText + "';";
        //Cursor cursor = db.rawQuery(selectQuery, null);
        Cursor mCursor = db.rawQuery(query,null);
  
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
  
    }
  
    // Getting contacts Count
    public int getContactsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
 
        // return count
        return cursor.getCount();
    }

	
}
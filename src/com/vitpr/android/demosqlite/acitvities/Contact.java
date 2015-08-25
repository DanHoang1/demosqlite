package com.vitpr.android.demosqlite.acitvities;

public class Contact {
		//private variables
	    int _id;
	    String _name;
	    String _email;
	    String _password;
	    String _phone;
	    String _place;
	    
	     
	    // Empty constructor
	    public Contact(){
	         
	    }
	    // constructor
	    public  Contact(int id, String name,String email,String password ,String phone,String place){
	        this._id = id;
	        this._name = name;
	        this._email=email;
	        this._password=password;
	        this._phone = phone;
	        this._place=place;
	    }
	     
	    // constructor
	    public Contact(String name,String email,String password ,String phone,String place){
	    	this._name = name;
	        this._email=email;
	        this._password=password;
	        this._phone = phone;
	        this._place=place;
	    }
	    // getting ID
	    public int getID(){
	        return this._id;
	    }
	     
	    // setting id
	    public void setID(int id){
	        this._id = id;
	    }
	     
	    // getting name
	    public String getName(){
	        return this._name;
	    }
	     
	    // setting name
	    public void setName(String name){
	        this._name = name;
	    }
	    // getting email
	    public String getEmail(){
	        return this._email;
	    }
	     
	    // setting phone
	    public void setEmail(String email){
	        this._email = email;
	    }
	    // getting password
	    public String getPassword(){
	        return this._password;
	    }
	     
	    // setting password
	    public void setPassword(String password){
	        this._password = password;
	    }
	    // getting phone
	    public String getPhone(){
	        return this._phone;
	    }
	     
	    // setting phone
	    public void setPhone(String phone){
	        this._phone = phone;
	    }
	 // getting place
	    public String getPlace(){
	        return this._place;
	    }
	     
	    // setting phone
	    public void setPlace(String place){
	        this._place = place;
	    }
}

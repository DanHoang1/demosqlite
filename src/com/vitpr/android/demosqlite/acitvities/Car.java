package com.vitpr.android.demosqlite.acitvities;

import java.util.concurrent.locks.Condition;

/**
 * Store information about a car 
 */
 
public class Car {
	private String name;
	private String email;
	private String password;
	private String phone;
	private String place;
	
	public Car(String name,String email,String password,String phone,String place){
		super();
		this.name=name;
		this.email=email;
		this.password=password;
		this.phone=phone;
		this.place=place;
		}
	public String getName(){
		return name;
	}
	public String getEmail(){
		return email;
	}
	public String getPassword(){
		return password;
	}
	public String getPhone(){
		return phone;
	}
	public String getPlace(){
		return place;
	}
	
	

}

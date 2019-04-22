package com.example.Company_data.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Company {
	@Id
	public ObjectId _id;
	
	public String Name;
	public String City;
	public String Team_member;
	
	public  Company() {}
	
	public Company( ObjectId _id,String Name, String City, String Team_member)
	{
		this._id = _id;
		this.Name = Name;
		this.City = City;
		this.Team_member = Team_member;
	}

	public String get_id() {
		return _id.toHexString();
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getPhone_number() {
		return City;
	}

	public void setPhone_number(String City) {
		this.City = City;
	}

	public String getAddress() {
		return Team_member;
	}

	public void setAddress(String Team_member) {
		this.Team_member = Team_member;
	}
}

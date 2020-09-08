package model;

import java.util.Date;

public class Teacher extends CourseModel {
	private String name;
	private String surname;
	private String adress;
	private Date dob;
	private String phone;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Teacher [name=" + name + ", surname=" + surname + ", adress=" + adress + ", dob=" + dob + ", phone="
				+ phone + "]";
	}
	
}

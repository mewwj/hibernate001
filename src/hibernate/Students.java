package hibernate;

import java.sql.Blob;
import java.util.Date;





public class Students {
	   private int sid;
	   private String name;
	   private Date biirthday;
	   private Blob picture;
	   private Address address;
	   public Students(){
		   
	   }
	   public Students(int sid, String name, Date biirthday) {
		//super();
		this.sid = sid;
		this.name = name;
		this.biirthday = biirthday;
		//this.address=address;
	   }
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBiirthday() {
		return biirthday;
	}
	public void setBiirthday(Date biirthday) {
		this.biirthday = biirthday;
	}
	
	public Blob getPicture() {
		return picture;
	}
	public void setPicture(Blob picture) {
		this.picture = picture;
	}
	
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Students [sid=" + sid + ", name=" + name + ", biirthday=" + biirthday + ", getSid()=" + getSid()
				+ ", getName()=" + getName() + ", getBiirthday()=" + getBiirthday() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	   
	

}

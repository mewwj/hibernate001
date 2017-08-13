package hibernate;

public class Address {
   private String address;
   private String postcode;
   private String tel;
   
   public Address(){}

   public Address(String address, String postcode, String tel) {
	//super();
	this.address = address;
	this.postcode = postcode;
	this.tel = tel;
  }

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getPostcode() {
	return postcode;
}

public void setPostcode(String postcode) {
	this.postcode = postcode;
}

public String getTel() {
	return tel;
}

public void setTel(String tel) {
	this.tel = tel;
}
   
}

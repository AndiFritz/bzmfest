package at.bischoffritz.tasks.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {

	private int id;
	private String fname;
	private String lname;
	private String email;
	private String mobile;
	private String telephone;
	private String city;
	private String address;
	private String gebyear;
	private String tshirt;
	private String time;
	private String place;
	private String task;
	
	public Person(int id, String fname, String lname, String email,
			String mobile, String telephone, String city, String address, String gebyear, String tshirt, String time,
			String place, String task) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.mobile = mobile;
		this.telephone = telephone;
		this.city = city;
		this.address = address;
		this.gebyear = gebyear;
		this.tshirt = tshirt;
		this.time = time;
		this.place = place;
		this.task = task;
	}
	
	public Person(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobie() {
		return mobile;
	}

	public void setMobie(String mobile) {
		this.mobile = mobile;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getTshirt() {
		return tshirt;
	}

	public void setTshirt(int tshirt) {
		StringBuilder sb = new StringBuilder();
		sb.append(tshirt);
		this.tshirt = sb.toString();
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getTask() {
		return task;
	}

	public void setTask(int task) {
		StringBuilder sb = new StringBuilder();
		sb.append(task);
		this.task = sb.toString();
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAdress() {
		return address;
	}

	public void setAdress(String address) {
		this.address = address;
	}

	public String getGebyear() {
		return gebyear;
	}

	public void setGebyear(String gebyear) {
		this.gebyear = gebyear;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setTshirt(String tshirt) {
		this.tshirt = tshirt;
	}

	public void setTask(String task) {
		this.task = task;
	}
	
	
	
	
}

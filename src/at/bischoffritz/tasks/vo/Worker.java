package at.bischoffritz.tasks.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Worker {

	private String fname;
	private String lname;
	private int id;
	private String email;
	private String mobile;
	private String telephone;
	private String tshirt;
	private String date;
	private String start;
	private String end; 
	private String place;
	private String task;
	
	public Worker(int id, String fname, String lname, String email, String mobile, String telephone, String tshirt, String date, String start, String end, String place, String task){
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.mobile = mobile;
		this.telephone = telephone;
		this.tshirt = tshirt;
		this.date = date;
		this.start= start;
		this.end = end;
		this.place = place;
		this.task = task;
	}
	
	public Worker(){
		
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getFk_tshirt() {
		return tshirt;
	}

	public String getTshirt() {
		return tshirt;
	}

	public void setTshirt(String tshirt) {
		this.tshirt = tshirt;
	}

	public void setFk_tshirt(String tshirt) {
		this.tshirt = tshirt;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
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

	public void setTask(String task) {
		this.task = task;
	}
	
	
}

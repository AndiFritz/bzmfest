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
	private int fk_tshirt;
	private String date;
	private String start;
	private String end; 
	private String place;
	private String task;
	
	public Worker(String fname, String lname, int id, String email, String mobile, String telephone, int fk_tshirt, String date, String start, String end, String place, String task){
		this.fname = fname;
		this.lname = lname;
		this.id = id;
		this.email = email;
		this.mobile = mobile;
		this.telephone = telephone;
		this.fk_tshirt = fk_tshirt;
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

	public int getFk_tshirt() {
		return fk_tshirt;
	}

	public void setFk_tshirt(int fk_tshirt) {
		this.fk_tshirt = fk_tshirt;
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

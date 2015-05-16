package at.bischoffritz.tasks.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Termin {
	
	private int id;
	private String name;
	private String date;
	private String start;
	private String end;
	
	public Termin(int id, String name, String date, String start, String end) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.start = start;
		this.end = end;
	}
	
	public Termin(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	
}

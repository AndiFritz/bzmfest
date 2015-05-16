package at.bischoffritz.tasks.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Tshirt {

	private int id;
	private String name;
	public Tshirt(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Tshirt(){
		
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
	
	
}

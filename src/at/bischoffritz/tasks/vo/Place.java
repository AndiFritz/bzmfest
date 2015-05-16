package at.bischoffritz.tasks.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Place {

	private int id;
	private String name;
	
	public Place(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Place(){
		
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	
}

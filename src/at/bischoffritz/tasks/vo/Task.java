package at.bischoffritz.tasks.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Task {

	private int id;
	private String name;
	
	public Task(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Task(){
		
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	
}

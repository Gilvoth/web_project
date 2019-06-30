package model;

public class Urgency {

private int id;
private String name;

	public Urgency() {}
	
	public Urgency(int id, String name) {
		
		this.id = id;
		this.name = name;
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

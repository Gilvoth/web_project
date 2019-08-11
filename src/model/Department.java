package model;

public class Department {

private int id;
private String name;
private String name_boss;

	public Department(){
	}
	
	
	public Department(int id, String name, String name_boss) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.name_boss = name_boss;
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
	public String getName_boss() {
		return name_boss;
	}
	public void setName_boss(String name_boss) {
		this.name_boss = name_boss;
	}
	
}

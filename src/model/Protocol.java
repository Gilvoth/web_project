package model;

import java.time.LocalDate;


public class Protocol {
	
private int id;
private String content;
//private java.sql.Date date;
private LocalDate date;
private int id_user;

	public Protocol() {}
	
	public Protocol(int id, String content, int id_user) { // for create create
		this.id = id;
    	this.content = content;
		//this.date = new java.sql.Date(id_user);
		//Date utilDate;
		//java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		//02 12 2019 this.date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		this.id_user = id_user;
	}

	public Protocol(int id, String content, LocalDate date, int id_user) { // for select
		this.id = id;
    	this.content = content;
    	this.date = date;
		this.id_user = id_user;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}


}

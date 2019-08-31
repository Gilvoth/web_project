package model;

public class Notification {
private int id;
private int id_creator;
private int id_type;
private String date;
private int id_document;
private int id_receiver;

	public Notification() {}
	
	public Notification(int id, int id_creator, int id_type, String date, int id_document, int id_receiver) {
		this.id=id;
		this.id_creator=id_creator;
		this.id_type=id_type;
		this.date=date;
		this.id_document=id_document;
		this.id_receiver=id_receiver;
	}

	public Notification(int id_creator, int id_type, String date, int id_document, int id_receiver) {
		this.id_creator=id_creator;
		this.id_type=id_type;
		this.date=date;
		this.id_document=id_document;
		this.id_receiver=id_receiver;
	}
	
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getId_creator() {
	return id_creator;
}
public void setId_creator(int id_creator) {
	this.id_creator = id_creator;
}
public int getId_type() {
	return id_type;
}
public void setId_type(int id_type) {
	this.id_type = id_type;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public int getId_document() {
	return id_document;
}
public void setId_document(int id_document) {
	this.id_document = id_document;
}
public int getId_receiver() {
	return id_receiver;
}
public void setId_receiver(int id_receiver) {
	this.id_receiver = id_receiver;
}
	
	
}

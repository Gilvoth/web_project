package model;

import java.util.ArrayList; //for roles



public class Fdoc {

private	int id;
private int id_type_int;
private String id_type;
private String id_contractor;
private byte[] blob;
private String name;
private String content;
private String creator_name;
private String creator_second;
private int id_urgency;
private String urgency;
private String date_cre;
private int status_finished;
private String rec_date;
private ArrayList<String> receiver_list;
private ArrayList<String> sender_list;
private String dep;


public byte[] getBlob() {
	return blob;
}


public void setBlob(byte[] blob) {
	this.blob = blob;
}


//jsp looking for getter and setter 
public String getDep() {
	return dep;
}


public void setDep(String dep) {
	this.dep = dep;
}


public String getRec_date() {
	return rec_date;
}


public void setRec_date(String rec_date) {
	this.rec_date = rec_date;
}


public int getStatus_finished() {
	return status_finished;
}


public void setStatus_finished(int status_finished) {
	this.status_finished = status_finished;
}


public String getDate_cre() {
	return date_cre;
}


public void setDate_cre(String date_cre) {
	this.date_cre = date_cre;
}


public String getUrgency() {
	return urgency;
}


public void setUrgency(String urgency) {
	this.urgency = urgency;
}


public String getCreator_second() {
	return creator_second;
}


public void setCreator_second(String creator_second) {
	this.creator_second = creator_second;
}


public String getCreator_name() {
	return creator_name;
}


public void setCreator_name(String creator_name) {
	this.creator_name = creator_name;
}


public String getContent() {
	return content;
}


public void setContent(String content) {
	this.content = content;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getId_contractor() {
	return id_contractor;
}


public void setId_contractor(String id_contractor) {
	this.id_contractor = id_contractor;
}


public String getId_type() {
	return id_type;
}


public void setId_type(String id_type) {
	this.id_type = id_type;
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public ArrayList<String> getReceiver_list() {
	return receiver_list;
}

public void setReceiver_list(ArrayList<String> receiver_list) {
	this.receiver_list = receiver_list;
}

public ArrayList<String> getSender_list() {
	return sender_list;
}

public void setSender_list(ArrayList<String> sender_list) {
	this.sender_list = sender_list;
}


	public Fdoc() {}

	
	public Fdoc(int id, String id_type, String id_contractor, String name, String content, String creator_name, String creator_second, String urgency,
			String date_cre, int status_finished, String rec_date, ArrayList<String> receiver_list,
			ArrayList<String> sender_list, String dep) {
		// TODO Auto-generated constructor stub
		this.setId(id);
		this.setId_type(id_type);
    	this.setId_contractor(id_contractor);
    	this.setName(name);
    	this.setContent(content);
        this.setCreator_name(creator_name);
        this.setCreator_second(creator_second);
        this.setUrgency(urgency); 
        this.setDate_cre(date_cre);
        this.setStatus_finished(status_finished);
        this.setRec_date(rec_date);
        
        this.receiver_list = new ArrayList<String>(); // 
        if (receiver_list != null) {
           for (String r : receiver_list) {
              this.receiver_list.add(r); }
           }
        
        this.sender_list = new ArrayList<String>(); // 
        if (sender_list != null) {
           for (String r : sender_list) {
              this.sender_list.add(r); }
           } 
        
        this.setDep(dep);
        
	}	
	
	public Fdoc(int id, int id_type_int, String id_type, String id_contractor, String name, String content, String creator_name, String creator_second, 
			int id_urgency, String urgency,
			String date_cre, int status_finished, String rec_date, ArrayList<String> receiver_list,
			ArrayList<String> sender_list, String dep, byte[] blob) {
		// TODO Auto-generated constructor stub
		this.setId(id);
		this.setId_type(id_type);
		this.setId_type_int(id_type_int);		
    	this.setId_contractor(id_contractor);
    	this.setName(name);
    	this.setContent(content);
        this.setCreator_name(creator_name);
        this.setCreator_second(creator_second);
        this.setId_urgency(id_urgency);
        this.setUrgency(urgency); 
        this.setDate_cre(date_cre);
        this.setStatus_finished(status_finished);
        this.setRec_date(rec_date);
        
        this.receiver_list = new ArrayList<String>(); // 
        if (receiver_list != null) {
           for (String r : receiver_list) {
              this.receiver_list.add(r); }
           }
        
        this.sender_list = new ArrayList<String>(); // 
        if (sender_list != null) {
           for (String r : sender_list) {
              this.sender_list.add(r); }
           } 
        
        this.setDep(dep);
        this.setBlob(blob);
        
	}


	public int getId_type_int() {
		return id_type_int;
	}


	public void setId_type_int(int id_type_int) {
		this.id_type_int = id_type_int;
	}


	public int getId_urgency() {
		return id_urgency;
	}


	public void setId_urgency(int id_urgency) {
		this.id_urgency = id_urgency;
	}	

}

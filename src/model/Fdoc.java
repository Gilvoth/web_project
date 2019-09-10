package model;

import java.math.BigDecimal;
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
private String date_registry;
private int id_tru;
private String tru;
private int id_law;
private String law;
private int id_division;
private String division;
private BigDecimal price;
private boolean paid;
private String add_agr;
private BigDecimal price_add_agr;
private ArrayList<Integer> ifo;


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


	public String getDate_registry() {
		return date_registry;
	}


	public void setDate_registry(String date_registry) {
		this.date_registry = date_registry;
	}


	public String getTru() {
		return tru;
	}


	public void setTru(String tru) {
		this.tru = tru;
	}


	public String getLaw() {
		return law;
	}


	public void setLaw(String law) {
		this.law = law;
	}


	public String getDivision() {
		return division;
	}


	public void setDivision(String division) {
		this.division = division;
	}


	public BigDecimal getPrice() {
		return price;
	}


	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	public boolean isPaid() {
		return paid;
	}


	public void setPaid(boolean paid) {
		this.paid = paid;
	}


	public String getAdd_agr() {
		return add_agr;
	}


	public void setAdd_agr(String add_agr) {
		this.add_agr = add_agr;
	}


	public BigDecimal getPrice_add_agr() {
		return price_add_agr;
	}


	public void setPrice_add_agr(BigDecimal price_add_agr) {
		this.price_add_agr = price_add_agr;
	}


	public ArrayList<Integer> getIfo() {
		return ifo;
	}


	public void setIfo(ArrayList<Integer> ifo) {
		this.ifo = ifo;
	}	

	public Fdoc(int id, int id_type_int, String id_type, String id_contractor, String name, String content, String creator_name, String creator_second, 
			int id_urgency, String urgency,
			String date_cre, int status_finished, String rec_date, ArrayList<String> receiver_list,
			ArrayList<String> sender_list, String dep, byte[] blob, String date_registry, int id_tru, String tru, 
			int id_law, String law, int id_division, String division, BigDecimal price, boolean paid,
			String add_agr, BigDecimal price_add_agr, ArrayList<Integer> ifo) {
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
        this.setDate_registry(date_registry);
        this.setTru(tru);
        this.setLaw(law);
        this.setDivision(division);
        this.setPrice(price);
        this.setPaid(paid);
        this.setAdd_agr(add_agr);
        this.setPrice_add_agr(price_add_agr);
        
        this.ifo = new ArrayList<Integer>(); // 
        if (ifo != null) {
           for (Integer r : ifo) {
              this.ifo.add(r); }
           } 
        
	}


	public int getId_tru() {
		return id_tru;
	}


	public void setId_tru(int id_tru) {
		this.id_tru = id_tru;
	}


	public int getId_law() {
		return id_law;
	}


	public void setId_law(int id_law) {
		this.id_law = id_law;
	}


	public int getId_division() {
		return id_division;
	}


	public void setId_division(int id_division) {
		this.id_division = id_division;
	}	
	
}

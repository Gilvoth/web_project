package model;

import java.math.BigDecimal;
import java.util.ArrayList; //for roles



public class Doc {

private	int id;
private int id_type;
private int id_contractor;
private byte[] blob;
private String name;
private String content;
private int creator;
private int id_urgency;
private String date_cre;
private int status_finished;
private String rec_date;
private ArrayList<String> receiver_list;
private ArrayList<String> sender_list;
private int current_dep;

private String date_registry;
private int id_tru;
private int id_law;
private int id_division;
private BigDecimal price;
private boolean paid;
private String add_agr;
private BigDecimal price_add_agr;
private ArrayList<Integer> ifo;
private ArrayList<String> protocol;

	
	public Doc() {}

	public Doc(int id_type, int id_contractor, String name, String content, int creator, int id_urgency,
			String date_cre, int status_finished, String rec_date, ArrayList<String> receiver_list,
			ArrayList<String> sender_list, int current_dep, String date_registry, int id_tru, int id_law, int id_division, 
			BigDecimal price, boolean paid, String add_agr, BigDecimal price_add_agr, ArrayList<Integer> ifo) {
		// TODO Auto-generated constructor stub
    	this.id_type = id_type;
    	this.id_contractor = id_contractor;
    	this.name = name;
    	this.content = content;
        this.creator = creator;
        this.id_urgency = id_urgency; 
        this.date_cre = date_cre;
        this.status_finished = status_finished;
        this.rec_date = rec_date;
        
        this.receiver_list = new ArrayList<String>(); // aka 
        if (receiver_list != null) {
           for (String r : receiver_list) {
              this.receiver_list.add(r); }
           }
        
        this.sender_list = new ArrayList<String>(); // aka 
        if (sender_list != null) {
           for (String r : sender_list) {
              this.sender_list.add(r); }
           } 
        
        this.current_dep = current_dep;
        this.setDate_registry(date_registry);
        this.setId_tru(id_tru);
        this.setId_law(id_law);
        this.setId_division(id_division);
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
/*
	public Doc(int id, int id_type, int id_contractor, String name, String content, int creator, int id_urgency,
			String date_cre, int status_finished, String rec_date, ArrayList<String> receiver_list,
			ArrayList<String> sender_list, int current_dep) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.id_type = id_type;
    	this.id_contractor = id_contractor;
    	this.name = name;
    	this.content = content;
        this.creator = creator;
        this.id_urgency = id_urgency; 
        this.date_cre = date_cre;
        this.status_finished = status_finished;
        this.rec_date = rec_date;
        
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
        
        this.current_dep = current_dep;
        
	}	
*/
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_type() {
		return id_type;
	}

	public void setId_type(int id_type) {
		this.id_type = id_type;
	}

	public int getId_contractor() {
		return id_contractor;
	}

	public void setId_contractor(int id_contractor) {
		this.id_contractor = id_contractor;
	}

	public byte[] getBlob() {
		return blob;
	}

	public void setBlob(byte[] blob) {
		this.blob = blob;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getCreator() {
		return creator;
	}

	public void setCreator(int creator) {
		this.creator = creator;
	}

	public int getId_urgency() {
		return id_urgency;
	}

	public void setId_urgency(int id_urgency) {
		this.id_urgency = id_urgency;
	}

	public String getDate_cre() {
		return date_cre;
	}

	public void setDate_cre(String date_cre) {
		this.date_cre = date_cre;
	}

	public int getStatus_finished() {
		return status_finished;
	}

	public void setStatus_finished(int status_finished) {
		this.status_finished = status_finished;
	}

	public String getRec_date() {
		return rec_date;
	}

	public void setRec_date(String rec_date) {
		this.rec_date = rec_date;
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

	public int getCurrent_dep() {
		return current_dep;
	}

	public void setCurrent_dep(int current_dep) {
		this.current_dep = current_dep;
	}

	public String getDate_registry() {
		return date_registry;
	}

	public void setDate_registry(String date_registry) {
		this.date_registry = date_registry;
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

	public ArrayList<String> getProtocol() {
		return protocol;
	}

	public void setProtocol(ArrayList<String> protocol) {
		this.protocol = protocol;
	}
	
//Чтение протокола
	public Doc(int id, ArrayList<String> protocol) {
		// TODO Auto-generated constructor stub
    	this.id = id;
        
        this.protocol = new ArrayList<String>(); // aka 
        if (protocol != null) {
           for (String p : protocol) {
              this.protocol.add(p); }
           }
        
	}	
	
	
}

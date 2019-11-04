package model;

import java.util.ArrayList; //for roles

public class User {
	private int id;
	private String name;
	
	private String second;
	private String login;
	private String password;
    private int id_department;
    private ArrayList<String> roles;
    private String dep_name;
    private boolean confirmed;


    public User() {}    //как в Metanit инициализируем   
    public User(User user) {}    //как в Metanit инициализируем
 
//для взятия массива с формы редактирования ролей    
    public User(int id, String name, String second, String login, String password, int id_department, String[] roles, boolean confirmed) {

        this.id = id;
    	this.name = name;
    	this.second = second;
    	this.login = login;
    	this.password = password;
        this.id_department = id_department; 
        
        this.roles = new ArrayList<String>(); // aka ROLES
        if (roles != null) {
           for (String r : roles) {
              this.roles.add(r); }
           }
        this.confirmed = confirmed;
           
    }


//редактирование в setroleedit    
    public User(int id, String name, String second, String login, String password, int id_department, ArrayList<String> roles, boolean confirmed) {
        this.id = id;
    	this.name = name;
    	this.second = second;
    	this.login = login;
    	this.password = password;
        this.id_department = id_department; 
        
        this.roles = new ArrayList<String>(); // aka ROLES
        if (roles != null) {
           for (String r : roles) {
              this.roles.add(r); }
           }
        this.confirmed = confirmed;
    } 
    
    public User(String name, String second, String login, String password, int id_department, ArrayList<String> roles) {
    	this.name = name;
    	this.second = second;
    	this.login = login;
    	this.password = password;
        this.id_department = id_department; 
        
        this.roles = new ArrayList<String>(); // aka ROLES
        if (roles != null) {
           for (String r : roles) {
              this.roles.add(r); }
           }          
    } 
    
    public int getId() { // getname => name // rule = JSTL convert getMethod in Method
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getName() { // getname => name // rule = JSTL convert getMethod in Method
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getSecond() { // getname => name // rule = JSTL convert getMethod in Method
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    public int getId_department() { // getname => name // rule = JSTL convert getMethod in Method
        return id_department;
    }

    public void setId_department(int id_department) {
        this.id_department = id_department;
    }    
    
    public ArrayList<String> getRoles() {
        return roles;
     }

    
    public void setRoles(ArrayList<String> roles) {
        this.roles = roles;
     }
	public String getDep_name() {
		return dep_name;
	}
	public void setDep_name(String dep_name) {
		this.dep_name = dep_name;
	}

    public User(int id, String name, String second, String login, String password, int id_department, ArrayList<String> roles, String dep_name, boolean confirmed) {
        this.id = id;
    	this.name = name;
    	this.second = second;
    	this.login = login;
    	this.password = password;
        this.id_department = id_department; 
        
        this.roles = new ArrayList<String>(); // aka ROLES
        if (roles != null) {
           for (String r : roles) {
              this.roles.add(r); }
           }
        this.dep_name = dep_name;
        this.confirmed = confirmed;
    }
    
	public boolean isConfirmed() {
		return confirmed;
	}
	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	} 	
	
}

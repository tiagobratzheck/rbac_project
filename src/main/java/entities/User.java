package entities;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private String name;
	private String password;
	private List<Roles> roles = new ArrayList<>();
	
	public User() {
		
	}

	public User(String name, String password) {		
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Roles> getRoles(){
		return roles;
	}
	
	public void addRoles(Roles role) {
		roles.add(role);
	}

	@Override
	public String toString() {
		return " User { name= " + name + ", roles= " + roles + " } ";
	}
	
}

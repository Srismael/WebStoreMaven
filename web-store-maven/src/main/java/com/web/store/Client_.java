package com.web.store;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="client_")
public class Client_ {
	
	public Client_(String name_client, String last_name, String username, String pass, String email) {
		this.name_client = name_client;
		this.last_name = last_name;
		this.username = username;
		this.pass = pass;
		this.email = email;
	}
	
	public Client_() {
		
	}

	public int getId_client() {
		return Id_client;
	}

	public void setId_client(int id_client) {
		Id_client = id_client;
	}

	public String getName_client() {
		return name_client;
	}

	public void setName_client(String name_client) {
		this.name_client = name_client;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

	@Override
	public String toString() {
		return "Client_ [Id_client=" + Id_client + ", name_client=" + name_client + ", last_name=" + last_name
				+ ", username=" + username + ", pass=" + pass + ", email=" + email + "]";
	}
	
	
	

	public List<Credit_Card> getCCC() {
		return CCC;
	}

	public void setCCC(List<Credit_Card> cCC) {
		CCC = cCC;
	}
	


	public List<Delivery_Address> getDAO() {
		return DAO;
	}

	public void setDAO(List<Delivery_Address> dAO) {
		DAO = dAO;
	}







	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id_client")
	private int Id_client;
	

	@Column(name="name_client")
	private String name_client;
	
	@Column(name="last_name")
	private String last_name;
	
	@Column(name="username")
	private String username;
	
	@Column(name="pass")
	private String pass;
	
	@Column(name="email")
	private String email;
	
	@OneToMany(mappedBy = "client_")
	private List<Credit_Card> CCC;
	
	@OneToMany(mappedBy = "theClient_")
	private List<Delivery_Address> DAO;
	
	

}

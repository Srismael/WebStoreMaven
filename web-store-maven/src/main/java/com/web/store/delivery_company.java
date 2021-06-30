package com.web.store;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="delivery_company")
public class delivery_company {
	
	


	public delivery_company(String name_company, String adreess_Company, int phone_company) {
		super();
		this.name_company = name_company;
		this.Adreess_Company = adreess_Company;
		this.Phone_company = phone_company;
	}

	public delivery_company() {
		
	}

	public int getId_delivery_company() {
		return id_delivery_company;
	}

	public void setId_delivery_company(int id_delivery_company) {
		this.id_delivery_company = id_delivery_company;
	}

	public String getName_company() {
		return name_company;
	}

	public void setName_company(String name_company) {
		this.name_company = name_company;
	}

	public String getAdreess_Company() {
		return Adreess_Company;
	}

	public void setAdreess_Company(String adreess_Company) {
		Adreess_Company = adreess_Company;
	}
	

	public int getPhone_company() {
		return Phone_company;
	}

	public void setPhone_company(int phone_company) {
		Phone_company = phone_company;
	}



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_delivery_company")
	private int id_delivery_company;
	
	@Column(name="name_company")
	private String name_company;
	
	@Column(name="Adreess_Company")
	private String Adreess_Company;
	
	@Column(name="Phone_company")
	private int Phone_company;
	
	@OneToMany(mappedBy = "DPDC")
	private List<Delivery_packagues> DAO;
	
	
	
	
	
	

}

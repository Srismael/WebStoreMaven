package com.web.store;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="Country")
public class Country {
	
	

	public Country(String name_country) {
		super();
		this.name_country = name_country;
	}

	public Country() {
		
	}

	public int getId_country() {
		return id_country;
	}

	public void setId_country(int id_country) {
		this.id_country = id_country;
	}


	public String getName_country() {
		return name_country;
	}

	public void setName_country(String name_country) {
		this.name_country = name_country;
	}



	public List<Delivery_Address> getDAC() {
		return DAC;
	}

	public void setDAC(List<Delivery_Address> dAC) {
		DAC = dAC;
	}



	



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_country")
	private int id_country;
	
	@Column(name="name_country")
	private String name_country;
	
	@OneToMany(mappedBy = "thecountryS", cascade= CascadeType.ALL)
	private List<State> SC;
	
	@OneToMany(mappedBy = "theCountry", cascade= CascadeType.ALL)
	private List<Delivery_Address> DAC;
	
	
	

}

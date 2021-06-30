package com.web.store;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="State")
public class State {
	
	

	public int getId_state() {
		return id_state;
	}


	public void setId_state(int id_state) {
		this.id_state = id_state;
	}


	public String getName_state() {
		return name_state;
	}


	public void setName_state(String name_state) {
		this.name_state = name_state;
	}


	


	public Country getThecountryS() {
		return thecountryS;
	}


	public void setThecountryS(Country thecountryS) {
		this.thecountryS = thecountryS;
	}


	public List<Delivery_Address> getDAS() {
		return DAS;
	}


	public void setDAS(List<Delivery_Address> dAS) {
		DAS = dAS;
	}




	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_state")
	private int id_state;
	

	@Column(name="name_state")
	private String name_state;
	
	@ManyToOne
    @JoinColumn(name = "fk_id_country")
    private Country thecountryS;
	
	@OneToMany(mappedBy = "theState", cascade= CascadeType.ALL)
	private List<Delivery_Address> DAS;
	
	@OneToMany(mappedBy = "theStatec", cascade= CascadeType.ALL)
	private List<City> SCount;

}

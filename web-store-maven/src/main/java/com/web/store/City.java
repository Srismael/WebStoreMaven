package com.web.store;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="City")
public class City {
	


	public int getId_city() {
		return id_city;
	}

	public void setId_city(int id_city) {
		this.id_city = id_city;
	}

	public String getName_city() {
		return name_city;
	}

	public void setName_city(String name_city) {
		this.name_city = name_city;
	}

	

	public State getTheStatec() {
		return theStatec;
	}



	public void setTheStatec(State theStatec) {
		this.theStatec = theStatec;
	}



	public List<Delivery_Address> getDACity() {
		return DACity;
	}



	public void setDACity(List<Delivery_Address> dACity) {
		DACity = dACity;
	}
	



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_city")
	private int id_city;
	
	@Column(name="name_city")
	private String name_city;
	
	@ManyToOne()
    @JoinColumn(name = "fk_id_state")
    private State theStatec;
	
	@OneToMany(mappedBy = "theCity", cascade= CascadeType.ALL)
	private List<Delivery_Address> DACity;
	
	
}

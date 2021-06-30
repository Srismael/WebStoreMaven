package com.web.store;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="Delivery_Address")
public class Delivery_Address {
	
	

	public Delivery_Address(String street, int number_delivery, Client_ theClient_, Country theCountry,
			State theState, City theCity) {
		super();
		this.street = street;
		this.number_delivery = number_delivery;
		this.theClient_ = theClient_;
		this.theCountry = theCountry;
		this.theState = theState;
		this.theCity = theCity;
	}



	public Delivery_Address() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getId_delivery() {
		return id_delivery;
	}

	public void setId_delivery(int id_delivery) {
		this.id_delivery = id_delivery;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	

	
	
	public int getNumber_delivery() {
		return number_delivery;
	}



	public void setNumber_delivery(int number_delivery) {
		this.number_delivery = number_delivery;
	}



	public List<Purchase_Order> getPODA() {
		return PODA;
	}



	public void setPODA(List<Purchase_Order> pODA) {
		PODA = pODA;
	}



	public Client_ getTheClient_() {
		return theClient_;
	}


	public void setTheClient_(Client_ theClient_) {
		this.theClient_ = theClient_;
	}


	public Country getTheCountry() {
		return theCountry;
	}


	public void setTheCountry(Country theCountry) {
		this.theCountry = theCountry;
	}


	public State getTheState() {
		return theState;
	}


	public void setTheState(State theState) {
		this.theState = theState;
	}


	public City getTheCity() {
		return theCity;
	}


	public void setTheCity(City theCity) {
		this.theCity = theCity;
	}




	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_delivery")
	private int id_delivery;
	
	@Column(name="street")
	private String street;
	
	@Column(name="number_delivery")
	private int number_delivery;
	
	@ManyToOne()
    @JoinColumn(name = "fk_Id_client")
    private Client_ theClient_;
	
	@ManyToOne()
    @JoinColumn(name = "fk_id_country")
    private Country theCountry;
	
	@ManyToOne()
    @JoinColumn(name = "fk_id_state")
    private State theState;
	
	@ManyToOne()
    @JoinColumn(name = "fk_id_city")
    private City theCity;
	
	@OneToMany(mappedBy = "DPO")
	private List<Purchase_Order>  PODA;

}

package com.web.store;

import javax.persistence.*;


@Entity
@Table(name="Credit_Card")
public class Credit_Card {
	
	
	


	public Credit_Card(String cardholder, int card_number, int cvv, Client_ client_, Type_ tp) {
		super();
		this.cardholder = cardholder;
		this.card_number = card_number;
		this.cvv = cvv;
		this.client_ = client_;
		this.Tp = tp;
	}


	public Credit_Card() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId_credit_card() {
		return id_credit_card;
	}


	public void setId_credit_card(int id_credit_card) {
		this.id_credit_card = id_credit_card;
	}


	public String getCardholder() {
		return cardholder;
	}


	public void setCardholder(String cardholder) {
		this.cardholder = cardholder;
	}


	public int getCard_number() {
		return card_number;
	}


	public void setCard_number(int card_number) {
		this.card_number = card_number;
	}


	public int getCvv() {
		return cvv;
	}


	public void setCvv(int cvv) {
		this.cvv = cvv;
	}




	public Type_ getTp() {
		return Tp;
	}


	public void setTp(Type_ tp) {
		Tp = tp;
	}


	public Client_ getClient_() {
		return client_;
	}


	public void setClient_(Client_ client_) {
		this.client_ = client_;
	}





	




	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_credit_card")
	private int id_credit_card;
	
	@Column(name="cardholder")
	private String cardholder;
	
	@Column(name="card_number")
	private int card_number;
	
	@Column(name="cvv")
	private int cvv;
	
	
	
	
	@ManyToOne( cascade= CascadeType.ALL )
    @JoinColumn(name = "fk_Id_client")
    private Client_ client_;
	
	
	@ManyToOne( cascade= CascadeType.ALL)
    @JoinColumn(name = "fk_id_type")
    private Type_ Tp;
	

}

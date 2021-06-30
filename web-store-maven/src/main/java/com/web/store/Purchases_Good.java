package com.web.store;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="purchases_good")
public class Purchases_Good {
	
	
	
	public int getId_purchases_good() {
		return id_purchases_good;
	}

	public void setId_purchases_good(int id_purchases_good) {
		this.id_purchases_good = id_purchases_good;
	}

	public Purchase_Order getThePurchase_Order() {
		return thePurchase_Order;
	}

	public void setThePurchase_Order(Purchase_Order thePurchase_Order) {
		this.thePurchase_Order = thePurchase_Order;
	}

	public Article getTheArticle() {
		return theArticle;
	}

	public void setTheArticle(Article theArticle) {
		this.theArticle = theArticle;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_purchases_good")
	private int id_purchases_good;
	
	@ManyToOne()
    @JoinColumn(name = "fk_id_purchase_order")
    private Purchase_Order thePurchase_Order;
	
	@ManyToOne()
    @JoinColumn(name = "fk_id_Article")
    private Article theArticle;
	
	

}

package com.web.store;

import javax.persistence.*;



public class Billing {
	

	public int getId_billing() {
		return id_billing;
	}

	public void setId_billing(int id_billing) {
		this.id_billing = id_billing;
	}

	public String getInvoice() {
		return invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getDate_billing() {
		return date_billing;
	}

	public void setDate_billing(String date_billing) {
		this.date_billing = date_billing;
	}

	public Purchase_Order getPurchase_Order() {
		return Purchase_Order;
	}

	public void setPurchase_Order(Purchase_Order purchase_Order) {
		Purchase_Order = purchase_Order;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_billing")
	private int id_billing;
	
	@Column(name="invoice")
	private String invoice;
	
	@Column(name="amount")
	private String amount;
	
	@Column(name="date_billing")
	private String date_billing;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_id_purchase_order")
	private Purchase_Order Purchase_Order  ;

}

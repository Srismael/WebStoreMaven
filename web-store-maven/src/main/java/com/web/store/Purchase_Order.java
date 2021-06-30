package com.web.store;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Purchase_Order")
public class Purchase_Order {
	
	


	public int getId_purchase_order() {
		return id_purchase_order;
	}


	public void setId_purchase_order(int id_purchase_order) {
		this.id_purchase_order = id_purchase_order;
	}


	public Date getDate_order() {
		return date_order;
	}


	public void setDate_order(Date date_order) {
		this.date_order = date_order;
	}


	public Delivery_Address getDAPO() {
		return DAPO;
	}


	public void setDAPO(Delivery_Address dAPO) {
		DAPO = dAPO;
	}


	public Delivery_packagues getDPO() {
		return DPO;
	}


	public void setDPO(Delivery_packagues dPO) {
		DPO = dPO;
	}




	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_purchase_order")
	private int id_purchase_order;
	
	@Column(name="date_order")
	private Date date_order;
	
	
	@ManyToOne()
    @JoinColumn(name = "fk_id_delivery")
    private Delivery_Address DAPO;
	
	
	@ManyToOne()
    @JoinColumn(name = "fk_id_delivery_packagues")
    private Delivery_packagues DPO;
	
	@OneToMany(mappedBy = "thePurchase_Order")
	private List<Purchases_Good>  PGD;

}

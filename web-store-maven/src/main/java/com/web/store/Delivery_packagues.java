package com.web.store;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Delivery_packagues")
public class Delivery_packagues {
	
	

	public int getId_delivery_packagues() {
		return id_delivery_packagues;
	}

	public void setId_delivery_packagues(int id_delivery_packagues) {
		this.id_delivery_packagues = id_delivery_packagues;
	}

	public String getDate_packague() {
		return date_packague;
	}

	public void setDate_packague(String date_packague) {
		this.date_packague = date_packague;
	}

	

	public delivery_company getDPDC() {
		return DPDC;
	}

	public void setDPDC(delivery_company dPDC) {
		DPDC = dPDC;
	}

	public List<Purchase_Order> getDPPO() {
		return DPPO;
	}

	public void setDPPO(List<Purchase_Order> dPPO) {
		DPPO = dPPO;
	}



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_delivery_packagues")
	private int id_delivery_packagues;
	
	@Column(name="date_packague")
	private String date_packague;
	
	@ManyToOne()
    @JoinColumn(name = "fk_id_delivery_company")
    private delivery_company DPDC;
	
	@OneToMany(mappedBy = "DPO")
	private List<Purchase_Order> DPPO;
	
	

}

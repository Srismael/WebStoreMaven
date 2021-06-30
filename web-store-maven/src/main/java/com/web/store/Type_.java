package com.web.store;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="Type_")
public class Type_ {
	
	
	
	public Type_(String type_) {
		super();
		this.type_ = type_;
	}

	public Type_() {
		
	}

	public int getId_type_() {
		return id_type_;
	}

	public void setId_type_(int id_type_) {
		this.id_type_ = id_type_;
	}

	public String getType_() {
		return type_;
	}

	public void setType_(String type_) {
		this.type_ = type_;
	}
	
	

	public List<Credit_Card> getCC() {
		return CC;
	}

	public void setCC(List<Credit_Card> cC) {
		this.CC = cC;
	}







	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_type_")
	private int id_type_;
	
	@Column(name="type_")
	private String type_;
	
	@OneToMany(mappedBy = "Tp", cascade= CascadeType.ALL)
	private List<Credit_Card> CC;

}

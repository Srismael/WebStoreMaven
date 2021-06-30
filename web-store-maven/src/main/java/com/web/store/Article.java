package com.web.store;


import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="Article")
public class Article {
	
	

	public Article(String name_article, String description_article, int price_article, int stock_article) {
		super();
		this.name_article = name_article;
		this.description_article = description_article;
		this.price_article = price_article;
		this.stock_article = stock_article;
	}

	public Article() {
		
	}

	public int getId_Article() {
		return id_Article;
	}

	public void setId_Article(int id_Article) {
		this.id_Article = id_Article;
	}

	public String getName_article() {
		return name_article;
	}

	public void setName_article(String name_article) {
		this.name_article = name_article;
	}

	public String getDescription_article() {
		return description_article;
	}

	public void setDescription_article(String description_article) {
		this.description_article = description_article;
	}


	public int getPrice_article() {
		return price_article;
	}

	public void setPrice_article(int price_article) {
		this.price_article = price_article;
	}

	public int getStock_article() {
		return stock_article;
	}

	public void setStock_article(int stock_article) {
		this.stock_article = stock_article;
	}

	@Override
	public String toString() {
		return "Article [id_Article=" + id_Article + ", name_article=" + name_article + ", description_article="
				+ description_article + ", price_article=" + price_article + ", stock_article=" + stock_article + "]";
	}



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_Article")
	private int id_Article;
	
	@Column(name="name_article")
	private String name_article;
	
	@Column(name="description_article")
	private String description_article;
	
	@Column(name="price_article")
	private int price_article;
	
	@Column(name="stock_article")
	private int stock_article;
	
	@OneToMany(mappedBy = "theArticle")
	private List<Purchases_Good>  PGD;

}

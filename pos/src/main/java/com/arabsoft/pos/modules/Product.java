package com.arabsoft.pos.modules;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Product {
	@Id
	@SequenceGenerator(name="product_generator", sequenceName="product_sequence", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="product_generator")
    private Long id;
    @Column(nullable=false)
    private String name;
    @Column(nullable=false)
    private String description;
    @Column(nullable=false)
    private double price;
    @Column(nullable=false)
    private String imageUrl;
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id",referencedColumnName="id")
	@JsonIgnoreProperties("products")
	private Category category;
    @OneToMany(fetch = FetchType.EAGER, mappedBy="product")
	@JsonIgnoreProperties("product")
	private List<Promotion> promotions = new ArrayList<>();
    
    public Product() {}
    
    public Product(String name, String description, double price, Category category) {
    	this.name = name; 
    	this.description = description;
    	this.price = price;
    	this.category = category;
    }
    
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public void setId(Long id) {
		this.id = id;
	}
}

package com.arabsoft.pos.modules;

import javax.persistence.*;

@Entity
public class Category {
	@Id
	@SequenceGenerator(name="category_generator", sequenceName="category_sequence", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="category_generator")
    private Long id;
    @Column(nullable=false)
    private String name;
    /*@OneToMany(fetch = FetchType.EAGER, mappedBy="category")
	@JsonIgnoreProperties("category")
	private List<Product> products = new ArrayList<>();*/
    
    public Category() {}
    
    public Category(String name) {
    	this.name = name;
    }
    
    /*public Category(String name, List<Product> products) {
    	this(name);
    	this.products = products;
    }*/
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/*public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}*/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}

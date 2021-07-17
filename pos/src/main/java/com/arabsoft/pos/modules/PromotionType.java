package com.arabsoft.pos.modules;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class PromotionType {
	@Id
	@SequenceGenerator(name="promotiontype_generator", sequenceName="promotiontype_sequence", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="promotiontype_generator")
    private Long id;
    @Column(nullable=false)
    private String name;
    @Column(nullable=false)
    private int discount_percent;
    @OneToMany(fetch = FetchType.EAGER, mappedBy="promotiontype", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("promotiontype")
	private List<Promotion> promotions = new ArrayList<>();
    
    public PromotionType() {}
    
    public PromotionType(String name, int discount_percent) {
    	this.name = name;
    	this.discount_percent = discount_percent;
    }
    
    public PromotionType(String name, int discount_percent, List<Promotion> promotions) {
    	this(name, discount_percent);
    	this.promotions = promotions;
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
	public int getDiscount_percent() {
		return discount_percent;
	}
	public void setDiscount_percent(int discount_percent) {
		this.discount_percent = discount_percent;
	}
	public List<Promotion> getPromotions() {
		return promotions;
	}
	public void setPromotions(List<Promotion> promotions) {
		this.promotions = promotions;
	}
}

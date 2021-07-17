package com.arabsoft.pos.modules;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Promotion {
	@Id
	@SequenceGenerator(name="promotion_generator", sequenceName="promotion_sequence", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="promotion_generator")
    private Long id;
    @Column(nullable=false)
    private Date start_date;
    @Column(nullable=false)
    private Date end_date;
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id",referencedColumnName="id")
	@JsonIgnoreProperties("promotions")
    private Product product;
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "promotiontype_id",referencedColumnName="id")
	@JsonIgnoreProperties("promotions")
	private PromotionType promotiontype;
    
    public Promotion() {}
    
    public Promotion(Date start_date, Date end_date, PromotionType promotiontype) {
    	this.start_date = start_date;
    	this.end_date = end_date;
    	this.setPromotiontype(promotiontype);
    }
    
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public Long getId() {
		return id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public PromotionType getPromotiontype() {
		return promotiontype;
	}

	public void setPromotiontype(PromotionType promotiontype) {
		this.promotiontype = promotiontype;
	}
}

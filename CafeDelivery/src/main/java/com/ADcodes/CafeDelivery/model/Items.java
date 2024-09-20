package com.ADcodes.CafeDelivery.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "items")
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemId;

    @Column(nullable = false)
    private String itemName;

    //item category
    @Column(nullable = false)
    private String itemCate;

    @Column(nullable = false)
    private String itemSize;

    @Column(nullable = false)
    private Double itemPrice;

    private String itemDescription;
    
    private String itemImageUrl;

    private String itemNotes;


    //getters and setters

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemSize() {
		return itemSize;
	}

	public void setItemSize(String itemSize) {
		this.itemSize = itemSize;
	}

	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public String getItemImageUrl() {
		return itemImageUrl;
	}

	public void setItemImageUrl(String itemImageUrl) {
		this.itemImageUrl = itemImageUrl;
	}

	public String getItemNotes() {
		return itemNotes;
	}

	public void setItemNotes(String itemNotes) {
		this.itemNotes = itemNotes;
	}

	public String getItemCate() {
		return itemCate;
	}

	public void setItemCate(String itemCate) {
		this.itemCate = itemCate;
	}

    

}

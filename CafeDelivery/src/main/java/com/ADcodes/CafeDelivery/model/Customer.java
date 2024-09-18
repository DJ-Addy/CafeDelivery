package com.ADcodes.CafeDelivery.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cust_id;

    @Column(nullable = false)
    private String custFirstName;

    @Column(nullable = false)
    private String custLastName;

    @Column(unique = true, nullable = false)
    private String custEmail;

    private String custPhoneNum;

    
    @ManyToOne
    @JoinColumn(name = "cust_address_id")
    private Address address;
    
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;




    //getters and setters

	public Integer getCust_id() {
		return cust_id;
	}

	public String getCustFirstName() {
		return custFirstName;
	}

	public String getCustLastName() {
		return custLastName;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public String getCustPhoneNum() {
		return custPhoneNum;
	}

	public void setCust_id(Integer cust_id) {
		this.cust_id = cust_id;
	}

	public void setCustFirstName(String custFirstName) {
		this.custFirstName = custFirstName;
	}

	public void setCustLastName(String custLastName) {
		this.custLastName = custLastName;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public void setCustPhoneNum(String custPhoneNum) {
		this.custPhoneNum = custPhoneNum;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

    






}

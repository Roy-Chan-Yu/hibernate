package com.pouchen.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Customer {

	
	private String street;
	private String city;
	private String state;
	
	@Column(name="VIP_STREET_NAME")
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	@Column(name="VIP_CITY_NAME")
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Column(name="VIP_STATE_NAME")
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}

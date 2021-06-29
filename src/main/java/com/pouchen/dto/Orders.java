package com.pouchen.dto;

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table (name="USER_ORDERS")
public class Orders {
	@EmbeddedId
	private int userId;
	private String userName;
	@Temporal (TemporalType.DATE)
	private Date joinedDate;

	@Embedded
	private Customer customer;
 	
	@Embedded
	private Customer vipCustomer;
	
	public Customer getVipCustomer() {
		return vipCustomer;
	}
	public void setVipCustomer(Customer vipCustomer) {
		this.vipCustomer = vipCustomer;
	}

	@AttributeOverrides({
		@AttributeOverride (name="street", column=@Column(name="NORMAL_HOME_STREET_NAME")),
		@AttributeOverride (name="city", column=@Column(name="NORMAL_HOME_CITY_NAME")),
		@AttributeOverride (name="state", column=@Column(name="NORMAL_HOME_STATE_NAME"))})
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getUserId() {
		return userId;
	}	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
//	@Transient -- not to persistent
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
}

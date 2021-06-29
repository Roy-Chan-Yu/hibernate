package com.pouchen.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)// Per Class TABLE_PER
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "VEHICLE_TYPE", discriminatorType = DiscriminatorType.STRING)
public class Vehicle {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "VEHICLE_ID")
	private int vehicleId;
	private String vehicleName;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@NotFound(action = NotFoundAction.IGNORE)
	private UserDetails2 userDetails2;
	
	public UserDetails2 getUserDetails2() {
		return userDetails2;
	}
	public void setUserDetails2(UserDetails2 userDetails2) {
		this.userDetails2 = userDetails2;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vecleName) {
		this.vehicleName = vecleName;
	}
	
}

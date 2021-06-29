package com.pouchen.dto;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue(value = "Car") Parent(Dtype) -> DiscriminatorColumn(name), DEFAULT
public class FourWheeler extends Vehicle {

	private String steeringWheel;

	public String getSteeringWheel() {
		return steeringWheel;
	}

	public void setSteeringWheel(String steeringHandle) {
		this.steeringWheel = steeringHandle;
	}
	
	
}

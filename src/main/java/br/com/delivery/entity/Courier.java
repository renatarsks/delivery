package br.com.delivery.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Courier implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5915923075021436721L;

	@Id
	@Column(name = "cpf", nullable = false, unique = true)
	private String cpf;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "vehicle_capacity")
	private String vehicleCapacity;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVehicleCapacity() {
		return vehicleCapacity;
	}

	public void setVehicleCapacity(String vehicleCapacity) {
		this.vehicleCapacity = vehicleCapacity;
	}
	
	

}

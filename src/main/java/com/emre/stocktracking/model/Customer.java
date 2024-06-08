package com.emre.stocktracking.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "customer")
@Getter @Setter @NoArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Size(min = 3)
	private String company;
	
	private String phone;

	@Column(name = "fax_number")
	private String faxNumber;
	
	private String email;
	
	private String address;

	public Customer(String company, String phone, String faxNumber, String email, String address) {
		this.company = company;
		this.phone = phone;
		this.faxNumber = faxNumber;
		this.email = email;
		this.address = address;
	}

	@Override
	public String toString() {
		return id + " - " + company;
	} 
	
	
}

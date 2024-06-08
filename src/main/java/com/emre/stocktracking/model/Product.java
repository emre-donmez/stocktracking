package com.emre.stocktracking.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;


@Entity
@Table(name = "product")
@Getter @Setter @NoArgsConstructor
public class Product {
	
	@Id
	@NotNull
	@Positive
	@Column(name = "barcode_id")
	private Long barcodeId;

	@NotNull
	@Size(min = 3)
	private String name;

	public Product(Long barcodeId, String name) {
		this.barcodeId = barcodeId;
		this.name = name;
	}

	@Override
	public String toString() {
		return barcodeId + " - " + name;
	}

}

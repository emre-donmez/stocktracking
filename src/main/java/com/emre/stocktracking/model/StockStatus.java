package com.emre.stocktracking.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stock_status")
@Getter @NoArgsConstructor
public class StockStatus {
	
	@Id
	@Column(name = "barcode_id")
	private int barcodeId;

	private String name;
	
	private int quantity;

	@Column(name = "average_cost")
	private double averageCost;
}

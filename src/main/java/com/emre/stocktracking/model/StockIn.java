package com.emre.stocktracking.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Table(name="stock_in")
@Getter @Setter @NoArgsConstructor
public class StockIn {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name= "barcode_id")
	@NotNull
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "supplier_id")
	@NotNull
	private Supplier supplier;
	
	@NotNull
	@Positive
	private int quantity;
	
	@NotNull
	@Min(value = 0)
	private Long price;

	@Column(name = "entry_date")
	private Date entryDate;

	public StockIn(Product product, Supplier supplier, int piece, Long price, Date entryDate) {
		this.product = product;
		this.supplier = supplier;
		this.quantity = piece;
		this.price = price;
		this.entryDate = entryDate;
	}
}

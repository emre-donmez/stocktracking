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
@Table(name="stock_out")
@Getter @Setter @NoArgsConstructor
public class StockOut {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name= "barcode_id")
	@NotNull
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	@NotNull
	private Customer customer;
	
	@NotNull
	@Positive
	private int quantity;
	
	@NotNull
	@Min(value = 0)
	private Long price;

	@Column(name = "release_date")
	private Date releaseDate;

	public StockOut(Product product, Customer customer, int piece, Long price, Date releaseDate) {
		this.product = product;
		this.customer = customer;
		this.quantity = piece;
		this.price = price;
		this.releaseDate = releaseDate;
	}
}

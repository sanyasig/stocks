package com.sanyasi.stocks.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @author sanyasir
 *
 */

public class Trade {

	private Date date;
	private int quantity;
	private Indicator indicator;
	private BigDecimal price;
	
	public Trade(Date date, int quantity, Indicator indicator, BigDecimal price) {
		super();
		this.date = date;
		this.quantity = quantity;
		this.indicator = indicator;
		this.price = price;
	}
	
	public Trade() {
	}

	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Indicator getIndicator() {
		return indicator;
	}
	
	public void setIndicator(Indicator indicator) {
		this.indicator = indicator;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
}

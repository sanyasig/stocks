package com.sanyasi.stocks.model;

/**
 * 
 * @author sanyasir
 *
 */

public class Stock {
	
	private StockType type;
	private StockSymbol symbol;
	private Double lastDividend;
	private Double fixedDividend;
	private Double parValue;
	
	public Stock(StockType type, StockSymbol symbol, Double lastDividend, Double fixedDividend, Double parValue) {
		this.type = type;
		this.symbol = symbol;
		this.lastDividend = lastDividend;
		this.fixedDividend = fixedDividend;
		this.parValue = parValue;
	}

	public Stock() {
	}

	public StockType getType() {
		return type;
	}
	
	public void setType(StockType type) {
		this.type = type;
	}
	
	public StockSymbol getSymbol() {
		return symbol;
	}
	
	public void setSymbol(StockSymbol symbol) {
		this.symbol = symbol;
	}
	
	public Double getLastDividend() {
		return lastDividend;
	}
	
	public void setLastDividend(Double lastDividend) {
		this.lastDividend = lastDividend;
	}
	
	public Double getFixedDividend() {
		return fixedDividend;
	}
	
	public void setFixedDividend(Double fixedDividend) {
		this.fixedDividend = fixedDividend;
	}
	
	public Double getParValue() {
		return parValue;
	}
	
	public void setParValue(Double parValue) {
		this.parValue = parValue;
	}
	
}

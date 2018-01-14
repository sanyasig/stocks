package com.sanyasi.stocks.model;

public enum StockSymbol {
	TEA("tea"), 
	POP("pop"), 
	ALE("ale"), 
	GIN("gin"), 
	JOE("joe");
	
	private String name;
	
	private StockSymbol(String tname) {
		name = tname;
	}
	
	public String getName() {
		return name;
	}
 }

package com.sanyasi.stocks.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sanyasi.stocks.exception.StockException;
import com.sanyasi.stocks.model.Stock;
import com.sanyasi.stocks.model.StockSymbol;
import com.sanyasi.stocks.model.StockType;
import com.sanyasi.stocks.model.Trade;

public class StockServiceImpl implements StockService {
	 private List<Stock> stocks;
	 private  List<Trade> trades = new ArrayList();
	 
	public StockServiceImpl() {
		stocks = buildStocks();
		trades = new ArrayList();
	}

	@Override
	public Double computeDividendYield(Stock stock, double marketValue) throws StockException {
		double divident = 0;
		if(marketValue != 0) {
			if(stock.getType().equals(StockType.COMMOM)) {
				divident = stock.getLastDividend()/marketValue;
				stock.setLastDividend(divident);
			} else {
				divident = (stock.getFixedDividend() * stock.getParValue()) / marketValue;
				stock.setLastDividend(divident);
			}
		}
		return divident;
	}

	@Override
	public Double computePERatio(Stock stock, double marketValue) throws StockException {
		double peRatio = 0;
		try {
			double divident = computeDividendYield(stock, marketValue);
			peRatio = marketValue/divident;
		} catch (NumberFormatException e) {
			throw new StockException("Error calculating PE Ratio");
		}
		return peRatio;
		
	}

	@Override
	public void recordTrade(Trade trade) throws StockException {
		trades.add(trade);
	}

	@Override
	public Double computeStockPrice(Stock stock, Date lastDateTimestamp) throws StockException {
		return null;
	}

	@Override
	public Double computeGBCEShareIndex() {
		return null;
	}
	
	@Override
	public Stock getStockBySymbol(StockSymbol stockSymbol) {
		Stock stock = null;
		for (Stock eachStock :stocks) {
			if (eachStock.getSymbol().getName().equals(stockSymbol.getName())) {
				stock = eachStock;
			}
		}
		
		return stock;
	}
	
	
	private ArrayList<Stock> buildStocks () {
		
        ArrayList<Stock> allStocks = new ArrayList<>();

        Stock teaSock = new Stock();
        teaSock.setSymbol(StockSymbol.TEA);
        teaSock.setType(StockType.COMMOM);
        teaSock.setLastDividend(0d);
        teaSock.setFixedDividend(null);
        teaSock.setParValue(100d);
        allStocks.add(teaSock);

        Stock popStock = new Stock();
        popStock.setSymbol(StockSymbol.POP);
        popStock.setType(StockType.COMMOM);
        popStock.setLastDividend(8d);
        popStock.setFixedDividend(null);
        popStock.setParValue(100d);
        allStocks.add(popStock);

        Stock aleStock = new Stock();
        aleStock.setSymbol(StockSymbol.ALE);
        aleStock.setType(StockType.COMMOM);
        aleStock.setLastDividend(23d);
        aleStock.setFixedDividend(null);
        aleStock.setParValue(60d);
        allStocks.add(aleStock);

        Stock ginStock = new Stock();
        ginStock.setSymbol(StockSymbol.GIN);
        ginStock.setType(StockType.PREFERRED);
        ginStock.setLastDividend(8d);
        ginStock.setFixedDividend(0.02d);
        ginStock.setParValue(100d);
        allStocks.add(ginStock);

        Stock joeStock = new Stock();
        joeStock.setSymbol(StockSymbol.JOE);
        joeStock.setType(StockType.COMMOM);
        joeStock.setLastDividend(13d);
        joeStock.setFixedDividend(null);
        joeStock.setParValue(250d);
        allStocks.add(joeStock);
        
        return allStocks;
	}

}

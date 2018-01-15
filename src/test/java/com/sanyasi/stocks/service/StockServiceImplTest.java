package com.sanyasi.stocks.service;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;

import com.sanyasi.stocks.exception.StockException;
import com.sanyasi.stocks.model.Indicator;
import com.sanyasi.stocks.model.Stock;
import com.sanyasi.stocks.model.StockSymbol;
import com.sanyasi.stocks.model.Trade;

public class StockServiceImplTest {

	StockServiceImpl unit = new StockServiceImpl();

	@Test
	public void testDividendYieldWith0marketRate() throws StockException {
		Stock stock = getStockByString("pop");
		Double divident = unit.computeDividendYield(stock, 0);
		assertEquals("", divident, 0, 0.5);
	}
	
	@Test
	public void testDividendYield() throws StockException {
		Stock stock = getStockByString("joe");
		Double divident = unit.computeDividendYield(stock, 10);
		assertEquals("", divident, 1.3, 0.5);
	}

	@Test
	public void testComputePERatioWith0MarketRate() throws StockException {
		Stock stock = getStockByString("pop");
		Double pr = unit.computePERatio(stock, 0);
		assertEquals("", pr, 0, 0.5);
	}

	@Test
	public void testComputePERatio() throws StockException {
		Stock stock = getStockByString("Tea");
		Double pr = unit.computePERatio(stock, 3);
		assertEquals("", pr, 0, 0.5);
	}
	
	@Test
	public void testBuyTrade() throws StockException {
		
		Stock stock = getStockByString("joe");
		Trade trade = new Trade();
		trade.setIndicator(Indicator.BUY);
		trade.setStock(stock);
		trade.setQuantity(20);
		
		unit.recordTrade(trade);
		
		Trade savedTrade = unit.getAllRecordedTrade().get(0);
		assertEquals("Stock saved Failed", savedTrade.getQuantity(), 20, 0);
		assertEquals("Stock saved Failed", savedTrade.getIndicator(), Indicator.BUY);
		assertEquals("Stock saved Failed", savedTrade.getStock().getSymbol().getName().toLowerCase(), "joe");
	}

	@Test
	public void tesSellTrade() throws StockException {
		
		Stock stock = getStockByString("Tea");
		Trade trade = new Trade();
		trade.setIndicator(Indicator.SELL);
		trade.setStock(stock);
		trade.setQuantity(200);
		
		unit.recordTrade(trade);
		
		Trade savedTrade = unit.getAllRecordedTrade().get(0);
		assertEquals("Stock saved Failed", savedTrade.getQuantity(), 200, 0);
		assertEquals("Stock saved Failed", savedTrade.getIndicator(), Indicator.SELL);
		assertEquals("Stock saved Failed", savedTrade.getStock().getSymbol().getName().toLowerCase(), "tea");
	}
	
	@Test
	public void testComputeStockPrice() throws StockException {
		Long currDate = new Date().getTime();
		Stock stock = getStockByString("Tea");
		Trade trade1 = new Trade(new Date(currDate-1500), 20, Indicator.BUY, new BigDecimal(20));
		trade1.setStock(stock);
		unit.recordTrade(trade1);
		Trade trade2 = new Trade(new Date(currDate-1590), 20, Indicator.SELL, new BigDecimal(90));
		trade2.setStock(stock);
		unit.recordTrade(trade2);
		Trade trade3 = new Trade(new Date(currDate-1500), 20, Indicator.BUY, new BigDecimal(120));
		trade3.setStock(stock);
		unit.recordTrade(trade3);
		Double sPrice = unit.computeStockPrice(stock, new Date());
		assertEquals("Invalid Stock Proce", sPrice, 76.6, 1);
	}
	
	@Test
	public void testComputeStockPriceWithNoStock() throws StockException {
		Long currDate = new Date().getTime();
		Stock stock = getStockByString("pop");
		Trade trade1 = new Trade(new Date(currDate-1500), 20, Indicator.BUY, new BigDecimal(20));
		trade1.setStock(stock);
		unit.recordTrade(trade1);
		Trade trade2 = new Trade(new Date(currDate-1590), 20, Indicator.SELL, new BigDecimal(90));
		trade2.setStock(stock);
		unit.recordTrade(trade2);
		Trade trade3 = new Trade(new Date(currDate-1500), 20, Indicator.BUY, new BigDecimal(120));
		trade3.setStock(stock);
		unit.recordTrade(trade3);
		Double sPrice = unit.computeStockPrice( getStockByString("tea"), new Date());
		assertEquals("Invalid Stock Price", sPrice, 0.0, 1);
	}

	@Test
	public void testComputeGBCEShareIndex() throws StockException {
		Long currDate = new Date().getTime();
		Stock stock = getStockByString("pop");
		Trade trade1 = new Trade(new Date(currDate-1500), 2, Indicator.BUY, new BigDecimal(2000));
		trade1.setStock(stock);
		unit.recordTrade(trade1);
		Trade trade2 = new Trade(new Date(currDate-1590), 5, Indicator.SELL, new BigDecimal(900));
		trade2.setStock(stock);
		unit.recordTrade(trade2);
		
		assertEquals("Invalid GBSE Share", unit.computeGBCEShareIndex(), 1341, 1);
	}

	@Test
	public void testGetStockBySymbol() {
		Stock stock = unit.getStockBySymbol(StockSymbol.GIN);
		assertEquals("Invalid Stock returned", stock.getSymbol().getName(), "gin");
	}
	
	private Stock getStockByString (String name) {
		Stock stock = null;
		StockSymbol stockSymbol = null;
		for (StockSymbol symbol : StockSymbol.values()) {
			if (symbol.getName().equalsIgnoreCase(name)) {
				stockSymbol = symbol;				
		     }
		}
		stock = unit.getStockBySymbol(stockSymbol);
		return stock;
	}

}

package com.sanyasi.stocks.service;

import java.util.Date;

import com.sanyasi.stocks.exception.StockException;
import com.sanyasi.stocks.model.Stock;
import com.sanyasi.stocks.model.Trade;

/**
 * 
 * @author sanyasir
 *
 */

public interface StockService {
	/**
	 * 
	 * @param stock Divided to calculated for 
	 * @return dividentYeild
	 * @throws StockException if the details in the stock are invalid
	 */
	Double computeDividendYield(Stock stock) throws StockException;

    /**
     * 
     * @param stock 
     * @return pE ratio
     * @throws StockException if the details in the stock are invalid
     */
	Double computePERatio(Stock stock) throws StockException;
	
	/**
	 * 
	 * @param trade
	 * @throws StockException
	 */
    void recordTrade(Trade trade) throws StockException;

 /**
  * 
  * @param stock
  * @param lastDateTimestamp
  * @return
  * @throws StockException if the details in the stock are invalid 
  */
    Double computeStockPrice(Stock stock, Date lastDateTimestamp) throws StockException;

    /**
     * 
     * @return GRBCE share index
     */
    Double computeGBCEShareIndex();
}
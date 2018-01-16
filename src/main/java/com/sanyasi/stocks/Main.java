package com.sanyasi.stocks;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.sanyasi.stocks.exception.StockException;
import com.sanyasi.stocks.model.Indicator;
import com.sanyasi.stocks.model.Stock;
import com.sanyasi.stocks.model.StockSymbol;
import com.sanyasi.stocks.model.Trade;
import com.sanyasi.stocks.service.StockService;
import com.sanyasi.stocks.service.StockServiceImpl;

/**
 * 
 * @author sanyasir
 *
 */

public class Main {
	
	private static Scanner inScanner;

	private static void readAndProcessRrade(Scanner in, StockService stockService) throws StockException {
		System.out.println("Please select on of the optoins ");

		while (true) {
			Utils.printMainMenu();
			int userInput = 0;
			do {
				while (!in.hasNextInt()) {
					System.out.println("Invalid input selected, try again !");
					Utils.printMainMenu();
					in.next();
				}
				userInput = in.nextInt();
				break;
			} while (true);

			switch (userInput) {
			case 1:
				// calculate all the details required to
				calulateValues(in, stockService);
				break;
			case 2:
				// GBSE all Share index
				System.out.println("GBCE All Share Index is : " + stockService.computeGBCEShareIndex());
				break;
			case 3:
				// exit
				System.out.println("Good Bye and May the Force be with you");
				System.exit(0);
				break;
			default:
				break;
			}
		}
	}

	private static void calulateValues(Scanner in, StockService stockService) throws StockException {

		Stock stock = getUserStock(in, stockService);

		if (stock != null) {
			Utils.printStockActoinMenu();

			int userInput = 0;
			boolean validInput = false;
			while(!validInput) {

			  do {
	               while (!in.hasNextInt()) {
	                    System.out.println("Invalid input selected, try again !");
	                    Utils.printStockActoinMenu();
	                    in.next(); 
	                }
	                userInput = in.nextInt();
	                if(userInput > 0 || userInput < 7) {
	                	System.out.println("Invalid Input");
	                	Utils.printStockActoinMenu();
	                }
	                break;
	            } while (true);
				switch (userInput) {
			
				case 1:
					double marketPrice = Utils.readMarketProcice(in);
					Double divident = stockService.computeDividendYield(stock, marketPrice);
					System.out.println("Divident Yeild : " + divident);
					validInput = true;
					break;
	
				case 2:
					marketPrice = Utils.readMarketProcice(in);
					System.out.println("P/E Ration  : " + stockService.computePERatio(stock, marketPrice));
					validInput = true;
					break;
				// buy
				case 3:
					Trade trade  = getUserTrade(in);
					trade.setIndicator(Indicator.BUY);
					trade.setStock(stock);
					stockService.recordTrade(trade);
					validInput = true;
					break;	
			    // sell
				case 4:
					Trade sellTrade  = getUserTrade(in);
					sellTrade.setIndicator(Indicator.SELL);
					sellTrade.setStock(stock);
					stockService.recordTrade(sellTrade);
					validInput = true;
					break;	
				case 5:
					System.out.println("Stock Price in Last 15 Minutes is" + stockService.computeStockPrice(stock, new Date()));
					validInput = true;
					break;
				case 6:
					return;
				default:
					break;
				}
		}
		}
			}

	private static Stock getUserStock(Scanner in, StockService stockService) {
		System.out.println("Please Key-in the Symbol of a Stock");
		Stock stock = null;
		for (StockSymbol symbol : StockSymbol.values()) {
			System.out.println(symbol.name());
		}

		String sType = null;
		while (in.hasNext()) {
			if (in.hasNext()) {
				sType = in.next();
				break;
			}
		}
		if (Utils.getAllstockSymbols().contains(sType.toLowerCase())) {

			// need to find a way to go to the previous menu
			StockSymbol stockSymbol = null;
			for (StockSymbol symbol : StockSymbol.values()) {
				if (symbol.getName().equalsIgnoreCase(sType)) {
					stockSymbol = symbol;				
				}
			}				

			stock = stockService.getStockBySymbol(stockSymbol);
		}
		return stock;
	}
	
	private static Trade getUserTrade(Scanner in) {
		
		System.out.println("Enter timestamp (dd/MM/yyyy HH:mm), quantity of shares and price. Sepereted by comma");
		Trade trade = new Trade();
		Date date = new Date();
		String[] array = new String[4];
		
		try {
			inScanner = new Scanner(System.in);
			String userTrade = inScanner.nextLine();
			array =  userTrade.split(",");

            if (array.length != 3) {
                System.out.println("Please put all the values separated by comma");
                return null;
            }
		
    	    String dateStr = array[0].trim();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy HH:mm");
	
			date = dateFormat.parse(dateStr);
		
		} catch (ParseException e) {
			System.out.println("Error Parsing Trade");
			System.out.println("No Trades Added");
			e.printStackTrace();
		}
		trade.setDate(date);
		trade.setQuantity(Integer.parseInt(array[1]));
		trade.setPrice(new BigDecimal(array[2]));
		return trade;
	
	}
	
	public static void main(String[] args) throws StockException {
		System.out.println("### Super Simple Stocks ###\n");
		Scanner in = new Scanner(System.in);
		StockService stockService = new StockServiceImpl();
		while(true) {
			System.out.println("**Super Simple Stock**");
			readAndProcessRrade(in, stockService);
		}
		
	}
}

package com.sanyasi.stocks;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

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

	
	private static void readAndProcessRrade(Scanner in) throws StockException {
		// need to populate from enum 
		ArrayList<String> allStocks = new ArrayList<String>();
		
		System.out.println("Please select on of the optoins ");
		
		while(true) {
			
			Utils.printMainMenu();
             
            int userInput = 0;
			while (in.hasNext()) {
				 if (in.hasNextInt()) {
					 userInput = in.nextInt();
					 break;
                  } 
			}
            
             if(userInput < 1 || userInput >3 ) {
            	 System.out.println("Invalid input selected, try again ");
            	 System.out.println("");
             }
             // user selected valid input
             else  {
            	 switch (userInput) {
				case 1:
					//calculate all the details required to
					calulateValues(allStocks, in);
					break;
				case 2:
						//calculate GBCE
						break;
						
				case 3:
					//exit
					System.out.println("Good Bye and May the Force be with you");
					System.exit(0);
					break;
				default:
					break;
				}
             }
		}
		
	}
 
	private static void calulateValues(ArrayList<String> allStocks, Scanner in) throws StockException {
		StockService stockService = new StockServiceImpl();

		System.out.println("Please Key-in the Symbol of a Stock");

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

		if (getAllstockSymbols().contains(sType.toLowerCase())) {

			// need to find a way to go to the previous menu
			StockSymbol stockSymbol = null;
			for (StockSymbol symbol : StockSymbol.values()) {
				if (symbol.getName().equalsIgnoreCase(sType)) {
					stockSymbol = symbol;				
				}
			}				

			Stock stock = stockService.getStockBySymbol(stockSymbol);

			Utils.printStockActoinMenu();

			int userInput = 0;
			while (in.hasNext()) {
				if (in.hasNextInt()) {
					userInput = in.nextInt();
					break;
				}
			}

			switch (userInput) {
			
				case 1:
					double marketPrice = readMarketProcice(in);
					Double divident = stockService.computeDividendYield(stock, marketPrice);
					System.out.println("Divident Yeild : " + divident);
					break;
	
				case 2:
					marketPrice = readMarketProcice(in);
					System.out.println("P/E Ration  : " + stockService.computePERatio(stock, marketPrice));
					break;
				// buy
				case 3:
					Trade trade  = getUserTrade(in);
					trade.setIndicator(Indicator.BUY);
					stockService.recordTrade(trade);
					break;	
			    // sell
				case 4:
					Trade sellTrade  = getUserTrade(in);
					sellTrade.setIndicator(Indicator.SELL);
					stockService.recordTrade(sellTrade);
					break;	
				case 5:
					return;
				default:
					break;
			}

		} else {
			System.out.println("Entered Stock Type Does not Exists");
		}

	}
	
	private static double readMarketProcice(Scanner in) {
		System.out.println("Enter Market Price");
		
	    double userInput = 0;
					while (in.hasNext()) {
						 if (in.hasNextInt()) {
							 userInput = in.nextDouble();
							 break;
		                  } 
					}
		return userInput;
	}

	private static ArrayList<String> getAllstockSymbols() {
		ArrayList<String> allSymbols = new  ArrayList<>();
		for (StockSymbol syb : StockSymbol.values()) {
			allSymbols.add(syb.getName().toLowerCase());
		}
		return allSymbols;
	}

	private static Trade getUserTrade(Scanner in) {
		
		System.out.println("Enter timestamp (dd/MM/yyyy HH:mm), quantity of shares and price. Sepereted by comma");
		Trade trade = new Trade();
		Date date = new Date();
		String[] array = new String[4];
		   while (in.hasNext()) {
               if (in.hasNextLine()) {
                       String line = in.nextLine();
                       array = line.split(",");

                       if (array.length != 4) {
                           System.out.println("Please put all the values separated by comma");
                           break;
                       }
                   }
               }
		    String dateStr = array[0].trim();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy HH:mm");
		try {
			date = dateFormat.parse(dateStr);
		} catch (ParseException e) {
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
		while(true) {
			System.out.println("**Super Simple Stock**");
			readAndProcessRrade(in);
		}
		
	}
}

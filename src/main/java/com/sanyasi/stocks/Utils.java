package com.sanyasi.stocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sanyasi.stocks.model.StockSymbol;

public class Utils {

	public static void printMainMenu() {
	
		System.out.println("");
		System.out.println("**** Main Menu****");
		System.out.println("1 - Calculate the Details about the Stock");
		System.out.println("2 - Calculate the GBCE All ");
		System.out.println("3 - Exit");
	
	}

	public static void printStockActoinMenu() {
		
		System.out.println("Please Enter the Calculations you want to perform on the stock");
		System.out.println("1. Calculate dividend yield ");
		System.out.println("2. Calculate the P/E ratio ");
		System.out
				.println("3. Record a BUY  trade with timestamp, quantity of shares, buy or sell indicator and price ");
		System.out.println(
				"4. Record a SELL  trade with timestamp, quantity of shares, buy or sell indicator and price ");
		System.out.println("5. Calculate Stock Price based on trades recorded in the past 15 minutes");
		System.out.println("6. Go to previous menu");
	
	}

	public static Double computeGeometricValue(List<Double> prices) {
		
		double value = 1d;
		for (Double price : prices) {
			value = value * price;
		}
		if(prices.size()  < 1) {
			System.out.println("No Trades Found");
			return 0.0;
		}
		
		System.out.println((double)1/prices.size());
		return Math.pow(value, (double)1/prices.size());
	}

	public static double readMarketProcice(Scanner in) {
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

	public static ArrayList<String> getAllstockSymbols() {
		
		ArrayList<String> allSymbols = new ArrayList<>();
		for (StockSymbol syb : StockSymbol.values()) {
			allSymbols.add(syb.getName().toLowerCase());
		}
		return allSymbols;
	}

}

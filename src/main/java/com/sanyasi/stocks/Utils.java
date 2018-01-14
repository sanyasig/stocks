package com.sanyasi.stocks;

public class Utils {

	public static void printMainMenu() {
		 System.out.println("");
         System.out.println("**** Main Menu****");
         System.out.println("1 - Calculate the Details about the Stock" );
         System.out.println("2 - Calculate the GBCE All ");
         System.out.println("3 - Exit");
	}

	public static void printStockActoinMenu() {
		System.out.println("Please Enter the Calculations you want to perform on the stock");
        System.out.println("1. Calculate dividend yield ");
        System.out.println("2. Calculate the P/E ratio ");
        System.out.println("3. Record a BUY  trade with timestamp, quantity of shares, buy or sell indicator and price ");
        System.out.println("4. Record a SELL  trade with timestamp, quantity of shares, buy or sell indicator and price ");
        System.out.println("5. Calculate Stock Price based on trades recorded in the past 15 minutes");
        System.out.println("6. Go to previous menu");		
	}
	

}

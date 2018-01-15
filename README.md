# A Simple Stocks used to calculate

* Divident and P/E ratio for a Given stock
* Record a Trade
* Calculate Volume Weighted Stock Price
* Calculate Volume Weighted Stock Price


## To build
  run : *gradle clean fatjat --debug*
## To run Unit Tests
  run :  *gradle clean test*

## To Run the Application:
use the included jar and run 
  run : *java -jar stocks-all-1.0.jar*
  
  
## Expected results of all unit tests from gradle

10:20:54.422 [DEBUG] [TestEventLogger] 
10:20:54.422 [DEBUG] [TestEventLogger] Gradle Test Executor 3 STARTED
10:20:54.433 [DEBUG] [TestEventLogger] 
10:20:54.434 [DEBUG] [TestEventLogger] com.sanyasi.stocks.service.StockServiceImplTest STARTED
10:20:54.493 [DEBUG] [TestEventLogger] 
10:20:54.493 [DEBUG] [TestEventLogger] com.sanyasi.stocks.service.StockServiceImplTest > testComputePERatio STARTED
10:20:54.498 [DEBUG] [TestEventLogger] 
10:20:54.498 [DEBUG] [TestEventLogger] com.sanyasi.stocks.service.StockServiceImplTest > testComputePERatio PASSED
10:20:54.500 [DEBUG] [TestEventLogger] 
10:20:54.501 [DEBUG] [TestEventLogger] com.sanyasi.stocks.service.StockServiceImplTest > testComputeGBCEShareIndex STARTED
10:20:54.507 [DEBUG] [TestEventLogger] 
10:20:54.507 [DEBUG] [TestEventLogger] com.sanyasi.stocks.service.StockServiceImplTest > testComputeGBCEShareIndex STANDARD_OUT
10:20:54.507 [DEBUG] [TestEventLogger]     0.5
10:20:54.507 [DEBUG] [TestEventLogger] 
10:20:54.507 [DEBUG] [TestEventLogger] com.sanyasi.stocks.service.StockServiceImplTest > testComputeGBCEShareIndex PASSED
10:20:54.507 [DEBUG] [TestEventLogger] 
10:20:54.507 [DEBUG] [TestEventLogger] com.sanyasi.stocks.service.StockServiceImplTest > testComputeStockPriceWithNoStock STARTED
10:20:54.507 [DEBUG] [TestEventLogger] 
10:20:54.512 [DEBUG] [TestEventLogger] com.sanyasi.stocks.service.StockServiceImplTest > testComputeStockPriceWithNoStock PASSED
10:20:54.512 [DEBUG] [TestEventLogger] 
10:20:54.515 [DEBUG] [TestEventLogger] com.sanyasi.stocks.service.StockServiceImplTest > testDividendYield STARTED
10:20:54.515 [DEBUG] [TestEventLogger] 
10:20:54.515 [DEBUG] [TestEventLogger] com.sanyasi.stocks.service.StockServiceImplTest > testDividendYield PASSED
10:20:54.515 [DEBUG] [TestEventLogger] 
10:20:54.515 [DEBUG] [TestEventLogger] com.sanyasi.stocks.service.StockServiceImplTest > testBuyTrade STARTED
10:20:54.515 [DEBUG] [TestEventLogger] 
10:20:54.515 [DEBUG] [TestEventLogger] com.sanyasi.stocks.service.StockServiceImplTest > testBuyTrade PASSED
10:20:54.515 [DEBUG] [TestEventLogger] 
10:20:54.515 [DEBUG] [TestEventLogger] com.sanyasi.stocks.service.StockServiceImplTest > tesSellTrade STARTED
10:20:54.515 [DEBUG] [TestEventLogger] 
10:20:54.515 [DEBUG] [TestEventLogger] com.sanyasi.stocks.service.StockServiceImplTest > tesSellTrade PASSED
10:20:54.516 [DEBUG] [TestEventLogger] 
10:20:54.516 [DEBUG] [TestEventLogger] com.sanyasi.stocks.service.StockServiceImplTest > testDividendYieldWith0marketRate STARTED
10:20:54.516 [DEBUG] [TestEventLogger] 
10:20:54.517 [DEBUG] [TestEventLogger] com.sanyasi.stocks.service.StockServiceImplTest > testDividendYieldWith0marketRate PASSED
10:20:54.517 [DEBUG] [TestEventLogger] 
10:20:54.517 [DEBUG] [TestEventLogger] com.sanyasi.stocks.service.StockServiceImplTest > testComputePERatioWith0MarketRate STARTED
10:20:54.517 [DEBUG] [TestEventLogger] 
10:20:54.517 [DEBUG] [TestEventLogger] com.sanyasi.stocks.service.StockServiceImplTest > testComputePERatioWith0MarketRate PASSED
10:20:54.517 [DEBUG] [TestEventLogger] 
10:20:54.517 [DEBUG] [TestEventLogger] com.sanyasi.stocks.service.StockServiceImplTest > testComputeStockPrice STARTED
10:20:54.517 [DEBUG] [TestEventLogger] 
10:20:54.517 [DEBUG] [TestEventLogger] com.sanyasi.stocks.service.StockServiceImplTest > testComputeStockPrice PASSED
10:20:54.518 [DEBUG] [TestEventLogger] 
10:20:54.518 [DEBUG] [TestEventLogger] com.sanyasi.stocks.service.StockServiceImplTest > testGetStockBySymbol STARTED
10:20:54.518 [DEBUG] [TestEventLogger] 
10:20:54.518 [DEBUG] [TestEventLogger] com.sanyasi.stocks.service.StockServiceImplTest > testGetStockBySymbol PASSED
10:20:54.518 [DEBUG] [TestEventLogger] 
10:20:54.518 [DEBUG] [TestEventLogger] com.sanyasi.stocks.service.StockServiceImplTest PASSED
10:20:54.518 [DEBUG] [TestEventLogger] 
10:20:54.518 [DEBUG] [TestEventLogger] Gradle Test Executor 3 PASSED

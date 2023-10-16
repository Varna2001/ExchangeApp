package Exchange;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ExchangeApp {

 public static void main(String[] args) {

  // To add list of country and exchange rate
  List<ExchangeType> exchangeType = new LinkedList<ExchangeType>();
  exchangeType.add(new ExchangeType("Japan","JPY", 100.00));
  exchangeType.add(new ExchangeType("Singapore","SGD",2300));
  exchangeType.add(new ExchangeType("American","USD",2400));
  exchangeType.add(new ExchangeType("China","CNY",2500));

  System.out.println("Exchange Type");
  ExchangeType e = new ExchangeType();
  e.showType(exchangeType);

  // To add list of amount and charge rate
  List<ExchangeAmount> exchangeAmount = new LinkedList<ExchangeAmount>();
  exchangeAmount.add(new ExchangeAmount(1, 50000, 5000));
  exchangeAmount.add(new ExchangeAmount(50001, 100000, 10000));
  exchangeAmount.add(new ExchangeAmount(100001, 10000000, 12000));

  System.out.println("\nExchange Rate");
  
  ExchangeAmount eamount = new ExchangeAmount();
  eamount.showRate(exchangeAmount);

  int finalamount = 0;
  int finalcharge = 0;
  double finalrate = 0;
  ExchangeType currentCountryType = null;
  ExchangeAmount currentCountryAmount = null;
  boolean checkInput = false;

  while (!checkInput) {
   System.out.println("Please enter the amount you want to exchange from : ");
   Scanner scanner = new Scanner(System.in);
   String userInput = scanner.nextLine();
   SplitChar splitchar = new SplitChar(userInput);
   String countrycode = splitchar.CountryCode();
   int inputamount = splitchar.inputAmount();
   int changedexchangeamount = 0;

   for (ExchangeType Extype : exchangeType) {
    // Check currency type
    if (countrycode.toUpperCase().equals(Extype.getExchangeUnit())) {
     currentCountryType = Extype;
     changedexchangeamount = ((int) (currentCountryType.getExchangeRate() * inputamount));

     for (ExchangeAmount Examount : exchangeAmount) {
      if (changedexchangeamount >= 1 && changedexchangeamount >= Examount.getAmountEnd()) {
       currentCountryAmount = Examount;
      }
      if (changedexchangeamount >= Examount.getAmountStart()
        && changedexchangeamount <= Examount.getAmountEnd()) {
       currentCountryAmount = Examount;
      }
      if (changedexchangeamount >= Examount.getAmountStart()) {
       currentCountryAmount = Examount;

      }

     }

     if (changedexchangeamount >= 1 && changedexchangeamount <= currentCountryAmount.getAmountEnd()) {
      finalamount = changedexchangeamount - currentCountryAmount.getExchangecharge();
     }
     if (changedexchangeamount >= currentCountryAmount.getAmountStart()
       && changedexchangeamount <= currentCountryAmount.getAmountEnd()) {
      finalamount = changedexchangeamount - currentCountryAmount.getExchangecharge();
     }
     if (changedexchangeamount >= currentCountryAmount.getAmountStart()) {
      finalamount = changedexchangeamount - currentCountryAmount.getExchangecharge();
     }
     finalcharge = currentCountryAmount.getExchangecharge();
     finalrate = currentCountryType.getExchangeRate();
     checkInput = true;

     // Show Final result as needs
     System.out.println(inputamount + countrycode.toUpperCase() + " = " + finalamount + " Kyat");
     System.out.println("Transfer Fee = " + finalcharge + " Kyat" + "\nToday Rate : ");
     System.out.println("1" + countrycode.toUpperCase() + " = " + finalrate + " Kyat");
     scanner.close();
    }
   }
   if (!checkInput)
    System.err.println("Invalid input");
  }
 }

 

}
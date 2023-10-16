package exchange;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ExchangeApp {

	public static void main(String[] args) {

		// To add list of country and exchange rate
		List<ExchangeType> exchangetype = new LinkedList<ExchangeType>();
		exchangetype.add(new ExchangeType("Japan", "JPY", 21.01));
		exchangetype.add(new ExchangeType("Singapore", "SGD", 2300));
		exchangetype.add(new ExchangeType("American", "USD", 2400));
		exchangetype.add(new ExchangeType("China", "CNY", 1200));

		System.out.println("Exchange Type");
		showType(exchangetype);

		// To add list of amount and charge rate
		List<ExchangeAmount> exchangeamount = new LinkedList<ExchangeAmount>();
		exchangeamount.add(new ExchangeAmount(1, 50000, 5000));
		exchangeamount.add(new ExchangeAmount(50001, 100000, 10000));
		exchangeamount.add(new ExchangeAmount(100001, 10000000, 12000));

		System.out.println("\nExchange Rate");
		showRate(exchangeamount);

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
			// String userInput = "100001jpy";
			SplitChar splitchar = new SplitChar(userInput);
			String countrycode = splitchar.CountryCode();
			int inputamount = splitchar.inputAmount();

			for (ExchangeType Extype : exchangetype) {
				// Check currency type
				if (countrycode.toUpperCase().equals(Extype.getExchangeUnit())) {
					currentCountryType = Extype;

					for (ExchangeAmount Examount : exchangeamount) {
						if (inputamount >= 1 && inputamount >= Examount.getAmountEnd()) {
							currentCountryAmount = Examount;
						}
						if (inputamount >= Examount.getAmountStart() && inputamount <= Examount.getAmountEnd()) {
							currentCountryAmount = Examount;
						}
						if (inputamount >= Examount.getAmountStart()) {
							currentCountryAmount = Examount;

						}
					}

					if (inputamount >= 1 && inputamount <= currentCountryAmount.getAmountEnd()) {
						finalamount = ((int) (currentCountryType.getExchangeRate() * inputamount)); //- currentCountryAmount.getExchangecharge();
					}
					if (inputamount >= currentCountryAmount.getAmountStart()
							&& inputamount <= currentCountryAmount.getAmountEnd()) {
						finalamount = ((int) (currentCountryType.getExchangeRate() * inputamount)); //- currentCountryAmount.getExchangecharge();
					}
					if (inputamount >= currentCountryAmount.getAmountStart()) {
						finalamount = ((int) (currentCountryType.getExchangeRate() * inputamount)); //- currentCountryAmount.getExchangecharge();
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

			// scanner.close();

			// Show Final result as needs
//		System.out.println(inputamount + countrycode.toUpperCase() + " = " + finalamount + " Kyat");
//		System.out.println("Transfer Fee = " + finalcharge + " Kyat" + "\nToday Rate : ");
//		System.out.println("1" + countrycode.toUpperCase() + " = " + finalrate + " Kyat");
		}

	}

//To show list of Exchange Type
	public static void showType(List<ExchangeType> l) {
		int num = 1;
		int fixnum = 1;
		String arrow = "->";
		String kyat = "Kyat";
		System.out.println("+-------+----------------------+-----------------------+");
		System.out.printf("| %-5s | %-20s | %-21s |%n", "No", "Country", "ExchangeUnit");
		System.out.println("+-------+----------------------+-----------------------+");

		for (ExchangeType e : l) {
			System.out.printf("| %-5s | %-20s | %1s %1s %1s %-6s %-5s |%n", num, e.getCountry(), fixnum,
					e.getExchangeUnit(), arrow, e.getExchangeRate(), kyat);
			System.out.println("+-------+----------------------+-----------------------+");
			num++;
		}
	}

	// To show list of Exchange Rate
	public static void showRate(List<ExchangeAmount> l) {
		int num = 1;
		String arrow = "~";
		String kyat = "ks";
		String largestRate = null;
		System.out.println("+-------+----------------------+-----------------------+");
		System.out.printf("| %-5s | %-20s | %-21s |%n", "No", "ExchangeAmount", "ExchangeFee");
		System.out.println("+-------+----------------------+-----------------------+");

		for (ExchangeAmount e : l) {
			largestRate = Integer.toString(e.getAmountEnd());
			if (num == 3) {
				largestRate = "";
			}
			System.out.printf("| %-5s | %-7s %1s %-10s | %-5s %-15s |%n", num, e.getAmountStart(), arrow,
					largestRate, e.getExchangecharge(), kyat);
			System.out.println("+-------+----------------------+-----------------------+");
			num++;
			// System.out.println(e.getNo());

		}
	}

}
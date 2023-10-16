package Exchange;

import java.util.List;

public class ExchangeType {
  String country;
  String exchangeUnit;
  double exchangeRate;

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getExchangeUnit() {
    return exchangeUnit;
  }

  public void setExchangeUnit(String exchangeUnit) {
    this.exchangeUnit = exchangeUnit;
  }

  public double getExchangeRate() {
    return exchangeRate;
  }

  public void setExchangeRate(double exchangeRate) {
    this.exchangeRate = exchangeRate;
  }
  
  public ExchangeType() {
   
  }

  public ExchangeType(String country, String exchangeUnit, double exchangeRate) {
    this.country = country;
    this.exchangeUnit = exchangeUnit;
    this.exchangeRate = exchangeRate;
  }
//To show list of Exchange Type
 public void showType(List<ExchangeType> l) {
  int numn = 1;
  int fixnum = 1;
  String arrow = "->";
  String kyat = "Kyat";
  System.out.println("+-------+----------------------+-------------------------------+");
  System.out.printf("| %-5s | %-20s | %-29s |%n", "No", "Country", "ExchangeUnit");
  System.out.println("+-------+----------------------+-------------------------------+");

  for (ExchangeType e : l) {
   System.out.printf("| %-5s | %-20s | %1s %1s %1s %-6s %-13s |%n", numn, e.getCountry(), fixnum,
     e.getExchangeUnit(), arrow, e.getExchangeRate(), kyat);
   System.out.println("+-------+----------------------+-------------------------------+");
   numn++;
  }
 }

}
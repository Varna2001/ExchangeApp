package Exchange;

import java.util.List;

public class ExchangeAmount {
 int amountStart;
 int amountEnd;
 int exchangecharge;
 public int getAmountStart() {
  return amountStart;
 }

 public void setAmountStart(int amountStart) {
  this.amountStart = amountStart;
 }

 public int getAmountEnd() {
  return amountEnd;
 }

 public void setAmountEnd(int amountEnd) {
  this.amountEnd = amountEnd;
 }

 public int getExchangecharge() {
  return exchangecharge;
 }

 public void setExchangecharge(int exchangecharge) {
  this.exchangecharge = exchangecharge;
 }

 public ExchangeAmount() {
  // TODO Auto-generated constructor stub
 }

 public ExchangeAmount(int amountStart, int amountEnd, int exchangecharge) {
  this.amountStart = amountStart;
  this.amountEnd = amountEnd;
  this.exchangecharge = exchangecharge;
  // TODO Auto-generated constructor stub
 }

 // To show list of Exchange Rate
  public void showRate(List<ExchangeAmount> l) {
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
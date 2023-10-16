package Exchange;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitChar {
    private String userInput;

    // Constructor
    public SplitChar(String userInput) {
        this.userInput = userInput;
    }

    //To split country type
    public String CountryCode() {
        if (userInput.length() >= 3) {
            String countrycode = userInput.substring(userInput.length() - 3);
            return countrycode;
        } else {
            System.out.println("Invalid input");
        }
    return null;
    }
    
    //To split entered amount
    public int inputAmount () {
      Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(userInput);
        if (matcher.find()) {
            String firstInteger = matcher.group();
            int intValue = Integer.parseInt(firstInteger);
            //System.out.println("First integer: " + intValue);
            return intValue;
        } else {
            System.out.println("Invalid input.");
        }
      return 0;
    }
}
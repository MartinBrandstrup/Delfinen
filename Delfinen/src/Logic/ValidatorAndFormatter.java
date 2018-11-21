/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Martin L.B.
 */
public class ValidatorAndFormatter
{

    public static boolean isValidEmail(String emailAddress)
    {
        Matcher matcher = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE).matcher(emailAddress);
        if(matcher.find())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static boolean isValidDate(String dateToValidate)
    {
        try
        {
            LocalDate.parse(dateToValidate);
        }
        catch(DateTimeParseException dtpe)
        {
            return false;
        }

        return true;
    }

    public static double round(double value, int places)
    {
        if(places < 0)
        {
            throw new IllegalArgumentException();
        }

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    /**
     * Parses the given long to a string representing kr. and øre.
     *
     * @param price - the given price that needs formatting
     *
     * @return String in format "kr,øre"
     */
    public static String formatLongToString(long price)
    {
        String priceString = Long.toString(price);
        String result = "";

        if(priceString.length() < 2)
        {
            return result += "0 kr.";
        }

        String kr = priceString.substring(0, priceString.length() - 2);
        String øre = priceString.substring(priceString.length() - 2, priceString.length());

        result = kr + "," + øre + " kr.";

        return result;
    }
}

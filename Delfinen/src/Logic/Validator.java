/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Martin L.B.
 */
public class Validator
{

    static boolean isValidEmail(String emailAddress)
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

    static boolean isValidDate(String dateToValidate)
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
}

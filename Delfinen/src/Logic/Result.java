/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Martin L.B.
 */
public class Result implements Serializable
{
    private SwimmingStyle swimmingStyle;
    private LocalDate date;
    private double result;

    public Result(SwimmingStyle swimmingStyle, LocalDate date, double result)
    {
        this.swimmingStyle = swimmingStyle;
        this.date = date;
        this.result = result;
    }

    public SwimmingStyle getSwimmingStyle()
    {
        return swimmingStyle;
    }

    public void setSwimmingStyle(SwimmingStyle swimmingStyle)
    {
        this.swimmingStyle = swimmingStyle;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public void setDate(LocalDate date)
    {
        this.date = date;
    }

    public double getResult()
    {
        return result;
    }
    
    public void setResult(double result)
    {
        this.result = result;
    }
    
    
}

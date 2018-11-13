/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Kasper Jeppesen & Martin L.B.
 */
public class Member
{

    //Arrears is noted in 'øre', ex 500.00 kr. = 50000
    private boolean paidCurrentYear, activityStatus;
    private int zipCode, memberID;
    private long phoneNumber, arrearsBalance;

    private String name, address, city, emailAddress, memberType;
    private LocalDate dateOfBirth, dateOfJoining;

    public Member(boolean paidCurrentYear, boolean activityStatus, int zipCode,
            int memberID, long phoneNumber, long arrearsBalance,
            String name, String address, String city,
            String emailAddress, String memberType, LocalDate dateOfBirth,
            LocalDate dateOfJoining)
    {
        this.paidCurrentYear = paidCurrentYear;
        this.activityStatus = activityStatus;
        this.zipCode = zipCode;
        this.memberID = memberID;
        this.phoneNumber = phoneNumber;
        this.arrearsBalance = arrearsBalance;
        this.name = name;
        this.address = address;
        this.city = city;
        this.emailAddress = emailAddress;
        this.memberType = memberType;
        this.dateOfBirth = dateOfBirth;
        this.dateOfJoining = dateOfJoining;
    }

    //Calculates the member's age based on the current date
    public int getAge()
    {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    //Returns the date payment is due for the current year
    public LocalDate getNextPaymentDate()
    {
        int monthOfJoining = dateOfJoining.getMonthValue();
        int dayOfJoining = dateOfJoining.getDayOfMonth();
        int currentYear = LocalDate.now().getYear();

        return LocalDate.of(currentYear, monthOfJoining, dayOfJoining);
    }

    //Resets the arrearBalance, so that the debt is removed
    public void payArrears()
    {
        arrearsBalance = 0;
    }

    //Sets payment as registered for the current year
    public void registerPayment()
    {
        paidCurrentYear = true;
    }

    //If member is currently active, sets to passive and vice versa
    public void switchActivityStatus()
    {
        if(activityStatus == true)
        {
            activityStatus = false;
        }
        activityStatus = true;
    }
    
    
    
    public boolean hasPaidCurrentYear()
    {
        return paidCurrentYear;
    }

    public boolean isActiveMember()
    {
        return activityStatus;
    }

    public String getActivityStatus()
    {
        if(activityStatus == true)
        {
            return "Active";
        }
        return "Passive";
    }
    
    
    
    public int getZipCode()
    {
        return zipCode;
    }

    public int getMemberID()
    {
        return memberID;
    }

    public long getPhoneNumber()
    {
        return phoneNumber;
    }

    public long getArrearsBalance()
    {
        return arrearsBalance;
    }

    public String getName()
    {
        return name;
    }

    public String getAddress()
    {
        return address;
    }

    public String getCity()
    {
        return city;
    }

    public String getEmailAddress()
    {
        return emailAddress;
    }

    public String getMemberType()
    {
        return memberType;
    }

    public LocalDate getDateOfJoining()
    {
        return dateOfJoining;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Kasper Jeppesen & Martin L.B.
 */
public class Member implements Serializable
{

    //Arrears is noted in 'øre', ex 500.00 kr. = 50000
    private boolean paidCurrentYear, activityStatus, isCompetitiveSwimmer;
    private int zipCode, memberID;
    private long phoneNumber, arrearsBalance, membershipPrice;

    private String name, address, city, emailAddress;
    private LocalDate dateOfBirth, dateOfJoining;

    public Member(boolean paidCurrentYear, boolean activityStatus,
            boolean isCompetitiveSwimmer, int zipCode, int memberID,
            long phoneNumber, long arrearsBalance, long membershipPrice,
            String name, String address, String city, String emailAddress,
            LocalDate dateOfBirth, LocalDate dateOfJoining)
    {
        this.paidCurrentYear = paidCurrentYear;
        this.activityStatus = activityStatus;
        this.isCompetitiveSwimmer = isCompetitiveSwimmer;
        this.zipCode = zipCode;
        this.memberID = memberID;
        this.phoneNumber = phoneNumber;
        this.arrearsBalance = arrearsBalance;
        this.name = name;
        this.address = address;
        this.city = city;
        this.emailAddress = emailAddress;
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

    //Calculates yearly membership cost for a given member. Return is in 'øre'
    //so that 500 kr. = 50000
    public void calculateMembershipPrice() throws IllegalArgumentException
    {
        if(getAge() <= 0 || getAge() > 150)
        {
            throw new IllegalArgumentException();
        }

        long yearlyCost = 0;

        if(activityStatus == false)
        {
            yearlyCost = 50000;
        }
        else if(getAge() <= 18)
        {
            yearlyCost = 100000;
        }
        else
        {
            yearlyCost = 160000;
        }
        if(getAge() >= 65)
        {
            yearlyCost = yearlyCost / 100 * 75;
        }

        this.membershipPrice = yearlyCost;
    }

    //Checks if the payment is overdue, and adds to the Member's arrears if true
    public void checkPaymentOverdue()
    {
        Period untilNextPayment = Period.between(getNextPaymentDate(), LocalDate.now());

        if(paidCurrentYear == false
                && untilNextPayment.getDays() > 0
                && untilNextPayment.getMonths() >= 0)
        {
            arrearsBalance += membershipPrice;
        }
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

    public void setPaidCurrentYear(boolean paidCurrentYear)
    {
        this.paidCurrentYear = paidCurrentYear;
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

    public String getActivityStatusString()
    {
        if(activityStatus == true)
        {
            return "Active";
        }
        return "Passive";
    }

    public boolean isCompetitiveSwimmer()
    {
        return isCompetitiveSwimmer();
    }

    public String getCompetitiveSwimmerString()
    {
        if(isCompetitiveSwimmer == true)
        {
            return "Competitive Swimmer";
        }
        return "Recreational Swimmer";
    }

    public void setZipCode(int zipCode)
    {
        this.zipCode = zipCode;
    }

    public void setMemberID(int memberID)
    {
        this.memberID = memberID;
    }

    public void setPhoneNumber(long phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public void setArrearsBalance(long arrearsBalance)
    {
        this.arrearsBalance = arrearsBalance;
    }

    public void setMembershipPrice(long membershipPrice)
    {
        this.membershipPrice = membershipPrice;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public void setEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress;
    }

    public void setDateOfBirth(LocalDate dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    public void setDateOfJoining(LocalDate dateOfJoining)
    {
        this.dateOfJoining = dateOfJoining;
    }

    public boolean getActivityStatus()
    {
        return activityStatus;
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

    public LocalDate getDateOfJoining()
    {
        return dateOfJoining;
    }

    @Override
    public String toString()
    {
        return new StringBuffer("Is membership price paid for the current year : ").append(this.paidCurrentYear)
                .append("\n, Is member active : ").append(this.activityStatus)
                .append("\n, Is member a competitive swimmer : ").append(this.isCompetitiveSwimmer)
                .append("\n, Zip Code : ").append(this.zipCode)
                .append("\n, MemberID : ").append(this.memberID)
                .append("\n, Phone Number : ").append(this.phoneNumber)
                .append("\n, Member's arrears balance : ").append(this.arrearsBalance)
                .append("\n, Name : ").append(this.name)
                .append("\n, Address : ").append(this.address)
                .append("\n, City : ").append(this.city)
                .append("\n, Email Address : ").append(this.emailAddress)
                .append("\n, Birthdate : ").append(this.dateOfBirth)
                .append("\n, Joining date : ").append(this.dateOfJoining)
                .toString();
    }

}

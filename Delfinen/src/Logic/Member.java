/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import static Logic.Validator.isValidDate;
import static Logic.Validator.isValidEmail;

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
            LocalDate dateOfBirth, LocalDate dateOfJoining) throws IllegalArgumentException
    {
        if(zipCode < 1000 || zipCode > 9999 || memberID < 1
                || phoneNumber < 10000000 || phoneNumber > 99999999
                || arrearsBalance < 0 || membershipPrice < 0
                || name == null || name.isEmpty() == true
                || address == null || address.isEmpty() == true
                || city == null || city.isEmpty() == true)
        {
            throw new IllegalArgumentException();
        }

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

        if(isValidEmail(emailAddress) == false
                || isValidDate(dateOfBirth.toString()) == false
                || isValidDate(dateOfJoining.toString()) == false)
        {
            throw new IllegalArgumentException();
        }
        
        calculateMembershipPrice();
    }

    /**
     * Calculates the member's age based on the current date
     *
     * @return An integer representing age
     */
    public int getAge()
    {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    /**
     * Calculates the date member's next payment is due for the current year
     *
     * @return A LocalDate for next payment
     */
    public LocalDate getNextPaymentDate()
    {
        int monthOfJoining = dateOfJoining.getMonthValue();
        int dayOfJoining = dateOfJoining.getDayOfMonth();
        int currentYear = LocalDate.now().getYear();

        return LocalDate.of(currentYear, monthOfJoining, dayOfJoining);
    }

    /**
     * Calculates the member's current membership price based on year and
     * activity status, then proceeds to update this information for the given
     * member (object). The price is set as a long value representing the
     * smallest currency value available and will need to be formatted in a UI.
     */
    public void calculateMembershipPrice()
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
    
     /**
     * Parses the given long to a string representing kr. and øre.
     * 
     * @param price The given price that needs formatting
     * 
     * @return String in format 'kr,øre'
     */
    public String formatLongToString(long price)
    {
        String priceString = Long.toString(price);
        String result = "";
        
        if(priceString.length() < 2)
        {
            return result += "0 kr.";
        }
        
        String kr = priceString.substring(0, priceString.length()-2);
        String øre = priceString.substring(priceString.length()-2, priceString.length());
        
        result = kr + "," + øre + " kr.";
        
        return result;
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

    public long getMembershipPrice()
    {
        return membershipPrice;
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

    public LocalDate getDateOfBirth()
    {
        return dateOfBirth;
    }

    public LocalDate getDateOfJoining()
    {
        return dateOfJoining;
    }

    @Override
    public String toString()
    {
        return new StringBuffer("\nName: ").append(this.name)
                .append(", Is membership price paid for the current year: ").append(this.paidCurrentYear)
                .append(", Is member active: ").append(this.activityStatus)
                .append(", Is member a competitive swimmer: ").append(this.isCompetitiveSwimmer)
                .append(", Zip Code: ").append(this.zipCode)
                .append(", MemberID: ").append(this.memberID)
                .append(", Phone Number: ").append(this.phoneNumber)
                .append(", Member's arrears balance: ").append(this.arrearsBalance)
                .append(", Address: ").append(this.address)
                .append(", City: ").append(this.city)
                .append(", Email Address: ").append(this.emailAddress)
                .append(", Birthdate: ").append(this.dateOfBirth)
                .append(", Joining date: ").append(this.dateOfJoining)
                .toString();
    }

}

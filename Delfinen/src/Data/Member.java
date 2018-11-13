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

    private boolean paidCurrentYear, activityStatus;
    private int zipCode, memberID;
    private long phoneNumber, arrearsBalance;

    private String name, address, city, emailAddress, memberType;
    private LocalDate dateOfBirth, dateOfJoining;

    public Member
            (boolean paidCurrentYear, boolean activityStatus, int zipCode,
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

    public int getAge()
    {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }
    
    public LocalDate getNextPaymentDate()
    {
        int monthOfJoining = dateOfJoining.getMonthValue();
        int dayOfJoining = dateOfJoining.getDayOfMonth();
        int currentYear = LocalDate.now().getYear();
        
        return LocalDate.of(currentYear, monthOfJoining, dayOfJoining);
    }

}

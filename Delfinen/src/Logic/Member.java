/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import static Logic.ValidatorAndFormatter.isValidDate;
import static Logic.ValidatorAndFormatter.isValidEmail;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

/**
 *
 * @author Martin L.B.
 */
public class Member implements Serializable
{

    private boolean paidCurrentYear, activityStatus, isCompetitiveSwimmer, tournamentEligibility;
    private int zipCode, memberID;
    private long phoneNumber, arrearsBalance, membershipPrice;
    private String name, address, city, emailAddress;
    private LocalDate dateOfBirth, dateOfJoining;
    private ArrayList<Team> teamMemberships = new ArrayList();
    private ArrayList<TournamentEvent> tournamentParticipations = new ArrayList();
    private ArrayList<Result> swimmingResults = new ArrayList();

    public Member(boolean paidCurrentYear, boolean activityStatus,
            boolean isCompetitiveSwimmer, boolean tournamentEligibility,
            int zipCode, int memberID, long phoneNumber, long arrearsBalance,
            long membershipPrice, String name, String address, String city,
            String emailAddress, LocalDate dateOfBirth, LocalDate dateOfJoining,
            ArrayList<Team> teamMemberships,
            ArrayList<TournamentEvent> tournamentParticipations,
            ArrayList<Result> swimmingResults) throws IllegalArgumentException
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
        this.tournamentEligibility = tournamentEligibility;
        this.zipCode = zipCode;
        this.memberID = memberID;
        this.phoneNumber = phoneNumber;
        this.arrearsBalance = arrearsBalance;
        this.membershipPrice = membershipPrice;
        this.name = name;
        this.address = address;
        this.city = city;
        this.emailAddress = emailAddress;
        this.dateOfBirth = dateOfBirth;
        this.dateOfJoining = dateOfJoining;
        this.teamMemberships = teamMemberships;
        this.tournamentParticipations = tournamentParticipations;
        this.swimmingResults = swimmingResults;

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

    /**
     * Checks if payment is overdue, and adds the overdue payment to the
     * member's (object) arrears if true. Use hasPaidCurrentYear() to get the
     * boolean result for payment.
     */
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
     * Resets the member's (object) arrears so that any remaining debt is paid.
     */
    public void payArrears()
    {
        arrearsBalance = 0;
    }

    /**
     * Marks the member's (object) payment as paid for the current year.
     */
    public void registerPayment()
    {
        paidCurrentYear = true;
    }

    /**
     * If a member (object) is currently active, sets the status to passive and
     * vice versa.
     */
    public void switchActivityStatus()
    {
        if(activityStatus == true)
        {
            activityStatus = false;
        }
        activityStatus = true;
    }

    /**
     * Checks the member's (object) activity status and returns a string
     * corresponding to the boolean result.
     *
     * @return String "Active" if true, "Passive" if false
     */
    public String getActivityStatusString()
    {
        if(activityStatus == true)
        {
            return "Active";
        }
        return "Passive";
    }

    /**
     * Checks the member's (object) status as a competitive swimmer and returns
     * a string corresponding to the boolean result.
     *
     * @return String "Competitive Swimmer" if true and "Recreational Swimmer"
     * if false
     */
    public String getCompetitiveSwimmerString()
    {
        if(isCompetitiveSwimmer == true)
        {
            return "Competitive Swimmer";
        }
        return "Recreational Swimmer";
    }

    /**
     * Registers the member (object) on a given team (object).
     *
     * @param team - the Team to populate with this member
     */
    public void registerSwimmerOnTeam(Team team)
    {
        teamMemberships.add(team);
    }

    /**
     * Registers the member (object) on a given tournament event (object).
     *
     * @param tournament - the TournamentEvent to populate with this member
     */
    public void registerSwimmerInTournament(TournamentEvent tournament)
    {
        tournamentParticipations.add(tournament);
    }

    /**
     * Registers a new result (object) for a member (object) marked as a
     * competitive swimmer. The result is saved with a swimming style (enum), a
     * LocalDate ("d/MM/yyyy") and a double ("ss/ms"). !Warning! Each member
     * (object) can only contain one result per swimming style (enum). To
     * enforce this, this method also removes any previous existing instances of
     * Results in the given style.
     *
     * @param style - a String used to describe one of the existing
     * SwimmingStyle ENUMs. If the String is in an incorrect format, throws
     * exception
     * @param resultDate - a String used to describe the date the result was
     * made. If the String is in an incorrect format, throws exception
     * @param result - the time result in seconds and milliseconds
     *
     * @throws IllegalArgumentException
     */
    public void registerNewSwimmingResult(String style, String resultDate, double result) throws IllegalArgumentException
    {
        if(this.isCompetitiveSwimmer == false)
        {
            System.out.println("The Member is not a competitive swimmer");
            return;
        }
        if(result < 0 || result > 60)
        {
            throw new IllegalArgumentException();
        }

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("d/MM/yyyy");

        LocalDate resultLocalDate;
        SwimmingStyle styleEnum = SwimmingStyle.valueOf(style);

        try
        {
            resultLocalDate = LocalDate.parse(resultDate, dateFormat);
        }
        catch(DateTimeParseException dtpe)
        {
            throw new IllegalArgumentException();
        }

        for(Result r : swimmingResults)
        {
            if(r.getSwimmingStyle().equals(styleEnum))
            {
                swimmingResults.remove(r);
            }
        }

        swimmingResults.add(new Result(styleEnum, resultLocalDate, result));
    }

    /**
     * Searches the member (object) for any results (object) of a given swimming
     * style (enum). Returns null if no such style exists.
     *
     * @param style - a String used to describe one of the existing
     * SwimmingStyle ENUMs. If the String is in an incorrect format, throws
     * exception
     *
     * @return The specific Result
     *
     * @throws IllegalArgumentException
     */
    public Result getResultByStyle(String style) throws IllegalArgumentException
    {
        if(this.isCompetitiveSwimmer == false)
        {
            System.out.println("The Member is not a competitive swimmer");
            return null;
        }
        SwimmingStyle styleEnum = SwimmingStyle.valueOf(style);

        for(Result r : swimmingResults)
        {
            if(r.getSwimmingStyle().equals(styleEnum))
            {
                return r;
            }
        }
        System.out.println("This member did not yet have a result recorded in the specified style");
        return null;
    }

    /**
     * If a member (object) is currently eligible for tournament participation,
     * sets the status to false and vice versa.
     */
    public void switchTournamentEligibility()
    {
        if(tournamentEligibility == true)
        {
            tournamentEligibility = false;
        }
        tournamentEligibility = true;
    }

    @Override
    public String toString()
    {
        return new StringBuffer("\nName: ").append(this.name)
                .append(", Is membership price paid for the current year: ").append(this.paidCurrentYear)
                .append(", Is member active: ").append(this.activityStatus)
                .append(", Is member a competitive swimmer: ").append(this.isCompetitiveSwimmer)
                .append(", Is member eligible for tournament participation: ").append(this.tournamentEligibility)
                .append(", Zip Code: ").append(this.zipCode)
                .append(", MemberID: ").append(this.memberID)
                .append(", Phone Number: ").append(this.phoneNumber)
                .append(", Member's arrears balance: ").append(this.arrearsBalance)
                .append(", Yearly cost of membership: ").append(this.membershipPrice)
                .append(", Address: ").append(this.address)
                .append(", City: ").append(this.city)
                .append(", Email Address: ").append(this.emailAddress)
                .append(", Birthdate: ").append(this.dateOfBirth)
                .append(", Joining date: ").append(this.dateOfJoining)
                .append(", ArrayList of teams member is a part of: ").append(this.teamMemberships)
                .append(", ArrayList of member's tournament participations: ").append(this.tournamentParticipations)
                .append(", ArrayList of member's swimming results: ").append(this.swimmingResults)
                .toString();
    }

    @Override
    public boolean equals(Object obj)
    {
        if(!(obj instanceof Member))
        {
            return false;
        }

        Member m = (Member) obj;

        return (m.name.equals(this.name) && m.memberID == (this.memberID));
    }

    public void setPaidCurrentYear(boolean paidCurrentYear)
    {
        this.paidCurrentYear = paidCurrentYear;
    }

    public void setActivityStatus(boolean activityStatus)
    {
        this.activityStatus = activityStatus;
    }

    public void setIsCompetitiveSwimmer(boolean isCompetitiveSwimmer)
    {
        this.isCompetitiveSwimmer = isCompetitiveSwimmer;
    }

    public void setTournamentEligibility(boolean tournamentEligibility)
    {
        this.tournamentEligibility = tournamentEligibility;
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

    public boolean hasPaidCurrentYear()
    {
        return paidCurrentYear;
    }

    public boolean isActiveMember()
    {
        return activityStatus;
    }

    public boolean isCompetitiveSwimmer()
    {
        return isCompetitiveSwimmer;
    }

    public boolean isTournamentEligible()
    {
        return tournamentEligibility;
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

    public ArrayList<Team> getTeamMemberships()
    {
        return teamMemberships;
    }

    public ArrayList<TournamentEvent> getTournamentParticipations()
    {
        return tournamentParticipations;
    }

    public ArrayList<Result> getSwimmingResults()
    {
        return swimmingResults;
    }
}

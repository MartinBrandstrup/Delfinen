/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.DataAccessor;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Martin L.B.
 */
public class Controller

{

    //private DataAccessorHardCoded data;
    private DataAccessor data;
    private ArrayList<Member> memberList = new ArrayList();
    private ArrayList<Team> teamList;
    private ArrayList<TournamentEvent> tournamentList;
    private int MIDcounter = 1;

    public Controller(DataAccessor data)
    {
        this.data = data;
    }

    /**
     * Retrieves the list of members (object) from the source and updates the
     * currently in use member list in the Controller class. Should be called
     * when launching the program to make sure you have the most recently update
     *
     * @param zipCode an integer of exactly 4 digits
     * @param phoneNumber a long of exactly 8 digits
     * @param name
     * @throws Exception
     */
    //MemberID, membershipPrice, paidCurrentYear, membershipStatus og 
    //dateOfJoining bliver automatisk genereret.
    //Hvis der sker en fejl kan man kalde .set på Member og .setMID på
    //Controller for at ændre counteren. paidCurrentYear og activityStatus
    //er sat til true som default
    public void registerNewMember(int zipCode, long phoneNumber,
            String name, String address, String city,
            String email, LocalDate dateOfBirth) throws IllegalArgumentException
    {
        System.out.print("member" + memberList.size());
        memberList.add(new Member(true, true, false, zipCode, MIDcounter,
                phoneNumber, 0, 0, name, address, city, email, dateOfBirth,
                LocalDate.now()));

        getLastAddedMember().calculateMembershipPrice();

        ++MIDcounter;
    }

    public Member getLastAddedMember()
    {
        return memberList.get(memberList.size() - 1);
    }

    public Member getMemberByID(int memberID) throws NullPointerException
    {
        for(Member m : memberList)
        {
            if(m.getMemberID() == memberID)
            {
                return m;
            }
        }
        throw new NullPointerException("No member with given ID!");
    }

    public ArrayList<Member> getMemberlist()
    {
        return memberList;
    }

    /**
     * Retrieves the list of members (object) from the source and updates the
     * currently in use member list in the Controller class. Should be called
     * when launching the program to make sure you have the most recently update
     *
     * @throws Exception
     */
    public void updateMemberList() throws Exception
    {
        if(this.data.getMemberList() != null)
        {
            this.memberList = this.data.getMemberList();
        }
    }

    public ArrayList<Member> getMemberList()
    {
        return memberList;
    }

    /**
     * Saves the currently in use list of members (object) from the Controller
     * class and saves them to the source. Should be called when closing the
     * program to make sure any newly added data is not lost. A save button
     * might also implement this method.
     *
     * @throws Exception
     */
    public void saveMemberList() throws Exception
    {
        data.saveMemberList(memberList);
    }

    public int getMIDcounter()
    {
        return MIDcounter;
    }

    public void setMIDcounter(int MIDcounter)
    {
        this.MIDcounter = MIDcounter;
    }

    public void registerMemberToTeam(CompetitiveSwimmer member, Team team)
    {
        member.registerSwimmerOnTeam(team);
        team.addMember(member);
    }

    //Source: https://www.oodlestechnologies.com/blogs/Email-Validation-In-Java
    static boolean validateEmail(String emailAddress)
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

    static boolean validateDate(String dateToValidate)
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

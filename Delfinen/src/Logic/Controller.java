/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.DataAccessor;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Martin L.B.
 */
public class Controller

{

    //private DataAccessorHardCoded data;
    private DataAccessor data;
    private ArrayList<Member> memberList = new ArrayList();
    private ArrayList<Team> teamList = new ArrayList();
    private ArrayList<TournamentEvent> tournamentList = new ArrayList();
    private int MIDCounter = 1;

    public Controller(DataAccessor data)
    {
        this.data = data;
    }

    /**
     * The remaining parameters of the Member class (memberID, membershipPrice,
     * paidCurrentYear, membershipSatus and dateOfJoining) will automatically be
     * generated.
     *
     * @param zipCode an integer of exactly 4 digits
     * @param phoneNumber a long of exactly 8 digits
     * @param name String containing full name
     * @param address String containing physical address
     * @param city String containing city
     * @param email String containing a valid email address
     * @param dateOfBirth a LocalDate representing birthday
     *
     * @throws IllegalArgumentException
     */
    //Hvis der sker en fejl kan man kalde .set på Member og .setMID på
    //Controller for at ændre counteren
    public void registerNewMember(int zipCode, long phoneNumber,
            String name, String address, String city,
            String email, LocalDate dateOfBirth) throws IllegalArgumentException
    {
        System.out.print("member" + memberList.size());
        memberList.add(new Member(true, true, false, zipCode, MIDCounter,
                phoneNumber, 0, 0, name, address, city, email, dateOfBirth,
                LocalDate.now()));

        getLastAddedMember().calculateMembershipPrice();

        ++MIDCounter;
    }

    /**
     * Retrieves the last member (object) added to the ArrayList
     *
     * @return A Member object
     */
    public Member getLastAddedMember()
    {
        return memberList.get(memberList.size() - 1);
    }

    /**
     * Retrieves member (object) with the given member ID
     *
     * @param memberID
     *
     * @return A Member object
     */
    public Member getMemberByID(int memberID) throws NullPointerException
    {
        for(Member m : memberList)
        {
            if(m.getMemberID() == memberID)
            {
                return m;
            }
        }
        throw new NullPointerException("No member with given ID");
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

    public ArrayList<Member> getMemberList()
    {
        return memberList;
    }

    public int getMIDCounter()
    {
        return MIDCounter;
    }

    /**
     * Retrieves the member ID integer from the last added member from the
     * source to make sure you are using the correct implementation of the MID
     * counter in the Controller Class.
     *
     * @throws Exception
     */
    public void updateMIDCounter() throws Exception
    {
        this.MIDCounter = data.getMIDCounter(getLastAddedMember());
    }

    public void setMIDCounter(int MIDcounter)
    {
        this.MIDCounter = MIDcounter;
    }

    /**
     * Retrieves all information from the source (files, database etc.) and
     * updates the local instances of this information in the Controller Class.
     *
     * @throws Exception
     */
    public void updateEverythingFromSource() throws Exception
    {
        updateMemberList();
        updateMIDCounter();
    }

    /**
     * Saves all local instances of information from the Controller Class to the
     * source (files, database etc.).
     *
     * @throws Exception
     */
    public void saveEverythingToSource() throws Exception
    {
        saveMemberList();
    }

    /**
     * Upgrades a regular member (object) to a CompetitiveSwimmer (SubClass to
     * Member Class) by removing the provided Member from the localized instance
     * of the ArrayList memberList in the Controller Class and creating a new
     * instance of CompetitiveSwimmer in the same ArrayList with the same
     * parameters as the original Member object.
     *
     * @param member Will only recognize members (object) already existing in
     * the ArrayList that are not null
     *
     * @throws IllegalArgumentException
     */
    public void upgradeMemberToCompetitive(Member member) throws IllegalArgumentException
    {
        if(member == null || !memberList.contains(member))
        {
            throw new IllegalArgumentException();
        }

        int memberListIndex = -1;

        for(int i = 0; i < memberList.size(); i++)
        {
            if(memberList.get(i).getMemberID() == member.getMemberID())
            {
                memberListIndex = i;
            }
        }
        if(memberListIndex < 0)
        {
            return;
        }
        
        memberList.add(memberListIndex, new CompetitiveSwimmer(
                member.hasPaidCurrentYear(), member.getActivityStatus(), true,
                member.getZipCode(), member.getMemberID(),
                member.getPhoneNumber(), member.getArrearsBalance(), 0,
                member.getName(), member.getAddress(), member.getCity(),
                member.getEmailAddress(), member.getDateOfBirth(),
                member.getDateOfJoining(), false, null, null, null));
        memberList.get(memberListIndex).calculateMembershipPrice();
        memberList.remove(memberListIndex + 1);
    }

    public void registerMemberToTeam(CompetitiveSwimmer member, Team team)
    {
        member.registerSwimmerOnTeam(team);
        team.addMember(member);
    }
    
    public void createTeam(boolean isJuniorTeam, String teamName, 
            String trainer, SwimmingStyle swimmingStyle)
    {
        teamList.add(new Team(isJuniorTeam, teamName, trainer, swimmingStyle, null));
    }
            

}

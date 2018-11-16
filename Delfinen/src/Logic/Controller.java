/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.DataAccessorHardCoded;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Martin L.B.
 */
public class Controller

{

    private DataAccessorHardCoded data;
    //private DataAccessorHardFile data;
    private ArrayList<Member> memberList;
    private ArrayList<Team> teamList;
    private ArrayList<TournamentEvent> tournamentList;
    private int MIDcounter = 1;

    //MemberID, membershipPrice, paidCurrentYear, membershipStatus og 
    //dateOfJoining bliver automatisk genereret.
    //Hvis der sker en fejl kan man kalde .set på Member og .setMID på
    //Controller for at ændre counteren. paidCurrentYear og activityStatus
    //er sat til true som default
    public void registerNewMember(int zipCode, long phoneNumber,
            String name, String address, String city,
            String email, LocalDate dateOfBirth)
    {
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
        for(int i = 0; i < memberList.size(); i++)
        {
            if(memberList.get(i).getMemberID() == memberID)
            {
                return memberList.get(i);
            }
        }
        throw new NullPointerException("No member with given ID!");
    }

    public ArrayList<Member> getMemberlist()
    {
        return memberList;
    }

    //Skal helst kaldes før getMemberList() første gang man indlæser programmet
    //for at sikre at det er den nyeste liste man får fat i
    public void updateMemberList(ArrayList members)
    {
        this.memberList = data.getMemberList();
    }

    public ArrayList<Member> getMemberList()
    {
        return memberList;
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
}

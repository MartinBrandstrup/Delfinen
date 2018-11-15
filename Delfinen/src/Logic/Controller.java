/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.CompetitiveSwimmer;
import Data.DataAccessor;
import Data.DataAccessorHardCoded;
import Data.Member;
import Data.TournamentEvent;
import Data.Team;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Martin L.B.
 */
public class Controller

{

    private DataAccessorHardCoded data;
    private MembershipPrice calculator;
    private ArrayList<Member> memberList;
    private ArrayList<Team> teamList;
    private ArrayList<TournamentEvent> tournamentList;
    private int MIDcounter = 1;

    //MemberID og dateOfJoining bliver automatisk genereret.
    //Hvis der sker en fejl kan man kalde .set på Member og .setMID på
    //Controller for at ændre counteren. paidCurrentYear og activityStatus
    //er sat til true som default
    public void registerNewMember(int zipCode, long phoneNumber,
            String name, String address, String city,
            String email, LocalDate dateOfBirth)
    {
        memberList.add(new Member(true, true, zipCode, MIDcounter, phoneNumber,
                0, 0, name, address, city, email, "Recreational Swimmer",
                dateOfBirth, LocalDate.now()));

        getLastAddedMember().setMembershipPrice(getMembershipPrice(getLastAddedMember()));

        ++MIDcounter;
    }

    public Member getLastAddedMember()
    {
        return memberList.get(memberList.size() - 1);
    }

    public ArrayList<Member> getMemberlist()
    {
        return memberList;
    }

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

    public long getMembershipPrice(Member member)
    {
        int age = member.getAge();
        boolean activityStatus = member.getActivityStatus();

        return calculator.calculateMembershipPrice(age, activityStatus);
    }

    public void registerMemberToTeam(CompetitiveSwimmer member, Team team)
    {
        member.registerSwimmerOnTeam(team);
        team.addMember(member);
    }
}

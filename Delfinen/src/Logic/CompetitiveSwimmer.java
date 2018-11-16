/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Martin L.B.
 */
public class CompetitiveSwimmer extends Member
{

    boolean tournamentEligibility;
    ArrayList<Team> teamMemberships;
    ArrayList<TournamentEvent> tournamentParticipations;

    public CompetitiveSwimmer(boolean paidCurrentYear, boolean activityStatus,
            int zipCode, int memberID, long phoneNumber, long arrearsBalance, 
            long membershipPrice, String name, String address, String city, 
            String emailAddress, String memberType, LocalDate dateOfBirth, 
            LocalDate dateOfJoining,
            boolean tournamentEligibility,
            ArrayList<Team> teamMemberships,
            ArrayList<TournamentEvent> tournamentParticipations)
    {
        super(paidCurrentYear, activityStatus, zipCode, memberID, phoneNumber,
                arrearsBalance, membershipPrice, name, address, city, emailAddress, memberType,
                dateOfBirth, dateOfJoining);

        this.tournamentEligibility = tournamentEligibility;
        this.teamMemberships = teamMemberships;
        this.tournamentParticipations = tournamentParticipations;
    }

    public void registerSwimmerOnTeam(Team team)
    {
        teamMemberships.add(team);
    }

    public void registerSwimmerInTournament(TournamentEvent tournament)
    {
        tournamentParticipations.add(tournament);
    }

    public void switchTournamentEligibility()
    {
        if(tournamentEligibility == true)
        {
            tournamentEligibility = false;
        }
        tournamentEligibility = true;
    }

    public void setTournamentEligibility(boolean tournamentEligibility)
    {
        this.tournamentEligibility = tournamentEligibility;
    }
    
    
    
    
}

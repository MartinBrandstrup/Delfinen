/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author 69lem
 */
public class CompetitiveSwimmer extends Member
{

    boolean tournamentEligibility;
    ArrayList<Team> teamMemberships;
    ArrayList<TournamentEvent> tournamentParticipations;

    public CompetitiveSwimmer(boolean paidCurrentYear, boolean activityStatus,
            int zipCode, int memberID, long phoneNumber, long arrearsBalance,
            String name, String address, String city, String emailAddress,
            String memberType, LocalDate dateOfBirth, LocalDate dateOfJoining,
            boolean tournamentEligibility,
            ArrayList<Team> teamMemberships,
            ArrayList<TournamentEvent> tournamentParticipations)
    {
        super(paidCurrentYear, activityStatus, zipCode, memberID, phoneNumber,
                arrearsBalance, name, address, city, emailAddress, memberType,
                dateOfBirth, dateOfJoining);

        this.tournamentEligibility = tournamentEligibility;
        this.teamMemberships = teamMemberships;
        this.tournamentParticipations = tournamentParticipations;
    }
    
    

}

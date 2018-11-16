/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Logic.Team;
import Logic.TournamentEvent;
import Logic.Member;
import java.util.ArrayList;

/**
 *
 * @author Martin L.B. prøver at løse problemmet
 */
public interface DataAccessor
{

    public ArrayList<Member> getMemberList();
    
    public ArrayList<Team> getTeamList();

    public ArrayList<TournamentEvent> getTournamentList();

    public void saveMemberList(ArrayList<Member> memberList);

    public void saveTeamList(ArrayList<Team> teamList);

    public void saveTournamentList(ArrayList<TournamentEvent> tournamentList);
}

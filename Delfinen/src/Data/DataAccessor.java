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
 * @author Martin L.B.
 */
public interface DataAccessor
{

    public ArrayList<Member> getMemberList() throws Exception;
    
    public ArrayList<Team> getTeamList() throws Exception;

    public ArrayList<TournamentEvent> getTournamentList() throws Exception;

    public void saveMemberList(ArrayList<Member> memberList) throws Exception;

    public void saveTeamList(ArrayList<Team> teamList) throws Exception;

    public void saveTournamentList(ArrayList<TournamentEvent> tournamentList) throws Exception;
}

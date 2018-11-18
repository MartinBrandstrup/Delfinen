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

    /**
     * Retrieves the list of members (object) from the source.
     *
     * @return An ArrayList of Members
     * @throws ClassNotFoundException
     */
    public ArrayList<Member> getMemberList() throws Exception;

    /**
     * Retrieves the list of teams (object) from the source.
     *
     * @return An ArrayList of Teams
     * @throws ClassNotFoundException
     */
    public ArrayList<Team> getTeamList() throws Exception;

    /**
     * Retrieves the list of tournament events (object) from the source.
     *
     * @return An ArrayList of TournamentEvents
     * @throws ClassNotFoundException
     */
    public ArrayList<TournamentEvent> getTournamentList() throws Exception;

    /**
     * Saves the current list of members (object) to the source
     *
     * @param memberList
     * @throws IOException
     */
    public void saveMemberList(ArrayList<Member> memberList) throws Exception;

    /**
     * Saves the current list of teams (object) to the source
     *
     * @param teamList
     * @throws IOException
     */
    public void saveTeamList(ArrayList<Team> teamList) throws Exception;

    /**
     * Saves the current list of tournament events (object) to the source
     *
     * @param tournamentList
     * @throws IOException
     */
    public void saveTournamentList(ArrayList<TournamentEvent> tournamentList) throws Exception;
}

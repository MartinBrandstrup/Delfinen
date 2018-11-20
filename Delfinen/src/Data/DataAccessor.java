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
     * Retrieves the MIDCounter integer from a given Member object.
     * Designed for use to update the MID counter in the Controller class.
     *
     * @param member the last added member to the Controller's ArrayList. Can be
     * other Member objects as well if required.
     * @throws Exception
     */
    public int getMIDCounter(Member member) throws Exception;

    /**
     * Saves the current list of members (object) to the source
     *
     * @param memberList
     * @throws Exception
     */
    public void saveMemberList(ArrayList<Member> memberList) throws Exception;

    /**
     * Saves the current list of teams (object) to the source
     *
     * @param teamList
     * @throws Exception
     */
    public void saveTeamList(ArrayList<Team> teamList) throws Exception;

    /**
     * Saves the current list of tournament events (object) to the source
     *
     * @param tournamentList
     * @throws Exception
     */
    public void saveTournamentList(ArrayList<TournamentEvent> tournamentList) throws Exception;
}

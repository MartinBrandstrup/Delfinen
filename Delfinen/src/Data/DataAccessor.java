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
     * 
     * @throws ClassNotFoundException - if any of the objects contained in file
     * are illegal or unrecognizable
     */
    public ArrayList<Member> getMemberList() throws Exception;

    /**
     * Retrieves the list of teams (object) from the source.
     *
     * @return An ArrayList of Teams
     * 
     * @throws ClassNotFoundException - if any of the objects contained in file
     * are illegal or unrecognizable
     */
    public ArrayList<Team> getTeamList() throws Exception;

    /**
     * Retrieves the list of tournament events (object) from the source.
     *
     * @return An ArrayList of TournamentEvents
     *
     * @throws ClassNotFoundException - if any of the objects contained in file
     * are illegal or unrecognizable
     */
    public ArrayList<TournamentEvent> getTournamentList() throws Exception;

    /**
     * Retrieves the MIDCounter integer from a given Member object. Designed for
     * use to update the MID counter in the Controller class.
     *
     * @param member - the last added member to the Controller's ArrayList. Can
     * be other Member objects as well if required.
     *
     * @return an integer representing the member ID for the given Member
     * 
     * @throws Exception - if an IO exception occurs
     */
    public int getMIDCounter(Member member) throws Exception;

    /**
     * Saves the current list of members (object) to the source
     *
     * @param memberList - the list of members (object) to be saved to source
     * 
     * @throws Exception - if an IO exception occurs
     */
    public void saveMemberList(ArrayList<Member> memberList) throws Exception;

    /**
     * Saves the current list of teams (object) to the source
     *
     * @param teamList - the list of teams (object) to be saved to source
     *
     * @throws Exception - if an IO exception occurs
     */
    public void saveTeamList(ArrayList<Team> teamList) throws Exception;

    /**
     * Saves the current list of tournament events (object) to the source
     *
     * @param tournamentList - the list of events (object) to be saved to source
     *
     * @throws Exception - if an IO exception occurs
     */
    public void saveTournamentList(ArrayList<TournamentEvent> tournamentList) throws Exception;
}

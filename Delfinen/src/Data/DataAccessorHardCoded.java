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
public class DataAccessorHardCoded implements DataAccessor
{

    private ArrayList<Member> memberList;
    
    @Override
    public ArrayList<Member> getMemberList()
    {
        memberList.add(new Member(false, false, 2800, 010, 14548645, 50000, 50000, 
                "Johanne Jaeger", "Fiktiv Vej 23", "Kongens Lyngby", 
                "Johanne.j@test.dk", "Competitive", LocalDate.of(1993, 04, 12),
                LocalDate.of(2009, 12, 10)));
        
        return memberList;
    }

    @Override
    public ArrayList<Team> getTeamList()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<TournamentEvent> getTournamentList()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveMemberList(ArrayList<Member> memberList)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveTeamList(ArrayList<Team> teamList)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveTournamentList(ArrayList<TournamentEvent> tournamentList)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

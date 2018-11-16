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
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author Freiden
 */
public class DataAccessorFile implements DataAccessor
{
    //Returnerer "C:\Users\*username*\Documents" - burde fungere på både 
    //engelsk og dansk styresystem, men måske ikke på MAC maskiner
    String input = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();
    
    @Override
    public ArrayList<Member> getMemberList()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Logic.Team;
import Logic.TournamentEvent;
import Logic.Member;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    String filepath = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();

    @Override
    public ArrayList<Member> getMemberList() throws Exception
    {
        ArrayList<Member> memberList = null;
        
        try
        {
            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            boolean objectExist = true;
            while(objectExist)
            {
                Member m = null;
                m = (Member) objectIn.readObject();
                
                if(m != null)
                {
                    memberList.add(m);
                }
                objectExist = false;
            }
            
            objectIn.close();
            System.out.println("The Objects have been read from the file");

            return memberList;
        }
        catch(IOException ex)
        {
            System.out.println("Something went wrong");
            return null;
        }
    }

    @Override
    public ArrayList<Team> getTeamList() throws Exception
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<TournamentEvent> getTournamentList() throws Exception
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveMemberList(ArrayList<Member> memberList) throws Exception
    {
        try
        {
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            for(Member o : memberList)
            {
                objectOut.writeObject(o);
            }

            objectOut.close();
            System.out.println("The Objects were succesfully written to a file");
        }
        catch(IOException ex)
        {
            System.out.println("Something went wrong");
        }
    }

    @Override
    public void saveTeamList(ArrayList<Team> teamList) throws Exception
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveTournamentList(ArrayList<TournamentEvent> tournamentList) throws Exception
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

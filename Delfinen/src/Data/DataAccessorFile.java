/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Logic.Team;
import Logic.TournamentEvent;
import Logic.Member;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
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
    String filepath = FileSystemView.getFileSystemView().getDefaultDirectory()
            .getPath();

    @Override
    public ArrayList<Member> getMemberList() throws ClassNotFoundException
    {
        ArrayList<Member> memberList = new ArrayList();

        try
        {
            Files.createDirectories(Paths.get(filepath + "\\Delfinen"));
            File tempFile = new File(filepath + "\\Delfinen\\Members.dat");
            if(tempFile.exists() == false && tempFile.isFile() == false)
            {
                System.out.println("File \"Members.dat\" does not exist");
                return null;
            }

            FileInputStream fileIn = new FileInputStream(filepath + "\\Delfinen\\Members.dat");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            boolean objectExist = true;
            while(objectExist)
            {
                Member m = (Member) objectIn.readObject();

                if(m != null)
                {
                    memberList.add(m);
                }
                else
                {
                    objectExist = false;
                }
            }

            objectIn.close();
            System.out.println("The Objects have been read from the file");

            return memberList;
        }
        catch(EOFException eofe)
        {
            System.out.println(eofe);
            System.out.println("The file has been read");
            return memberList;
        }
        catch(IOException ex)
        {
            System.out.println(ex);
            return null;
        }
    }

    @Override
    public ArrayList<Team> getTeamList() throws ClassNotFoundException
    {
        ArrayList<Team> teamList = new ArrayList();

        try
        {
            Files.createDirectories(Paths.get(filepath + "\\Delfinen"));
            File tempFile = new File(filepath + "\\Delfinen\\Teams.dat");
            if(tempFile.exists() == false && tempFile.isFile() == false)
            {
                System.out.println("File \"Teams.dat\" does not exist");
                return null;
            }
            FileInputStream fileIn = new FileInputStream(filepath + "\\Delfinen\\Teams.dat");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            boolean objectExist = true;
            while(objectExist)
            {
                Team t = (Team) objectIn.readObject();

                if(t != null)
                {
                    teamList.add(t);
                }
                else
                {
                    objectExist = false;
                }
            }

            objectIn.close();
            System.out.println("The Objects have been read from the file");

            return teamList;
        }
        catch(EOFException eofe)
        {
            System.out.println(eofe);
            System.out.println("The file has been read");
            return teamList;
        }
        catch(IOException ex)
        {
            System.out.println(ex);
            return null;
        }
    }

    @Override
    public ArrayList<TournamentEvent> getTournamentList() throws ClassNotFoundException
    {
        ArrayList<TournamentEvent> tournamentList = new ArrayList();

        try
        {
            Files.createDirectories(Paths.get(filepath + "\\Delfinen"));
            File tempFile = new File(filepath + "\\Delfinen\\Events.dat");
            if(tempFile.exists() == false && tempFile.isFile() == false)
            {
                System.out.println("File \"Events.dat\" does not exist");
                return null;
            }

            FileInputStream fileIn = new FileInputStream(filepath + "\\Delfinen\\Events.dat");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            boolean objectExist = true;
            while(objectExist)
            {
                TournamentEvent e = (TournamentEvent) objectIn.readObject();

                if(e != null)
                {
                    tournamentList.add(e);
                }
                else
                {
                    objectExist = false;
                }
            }

            objectIn.close();
            System.out.println("The Objects have been read from the file");

            return tournamentList;
        }
        catch(EOFException eofe)
        {
            System.out.println(eofe);
            System.out.println("The file has been read");
            return tournamentList;
        }
        catch(IOException ex)
        {
            System.out.println(ex);
            return null;
        }
    }

    @Override
    public void saveMemberList(ArrayList<Member> memberList) throws IOException
    {
        try
        {
            Files.createDirectories(Paths.get(filepath + "\\Delfinen"));
            FileOutputStream fileOut = new FileOutputStream(filepath + "\\Delfinen\\Members.dat");
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
            System.out.println(ex);
            throw new IOException();
        }
    }

    @Override
    public void saveTeamList(ArrayList<Team> teamList) throws IOException
    {
        try
        {
            Files.createDirectories(Paths.get(filepath + "\\Delfinen"));
            FileOutputStream fileOut = new FileOutputStream(filepath + "\\Delfinen\\Teams.dat");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            for(Team t : teamList)
            {
                objectOut.writeObject(t);
            }

            objectOut.close();
            System.out.println("The Objects were succesfully written to a file");
        }
        catch(IOException ex)
        {
            System.out.println(ex);
            throw new IOException();
        }
    }

    @Override
    public void saveTournamentList(ArrayList<TournamentEvent> tournamentList) throws IOException
    {
        try
        {
            Files.createDirectories(Paths.get(filepath + "\\Delfinen"));
            FileOutputStream fileOut = new FileOutputStream(filepath + "\\Delfinen\\Events.dat");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            for(TournamentEvent e : tournamentList)
            {
                objectOut.writeObject(e);
            }

            objectOut.close();
            System.out.println("The Objects were succesfully written to a file");
        }
        catch(IOException ex)
        {
            System.out.println(ex);
            throw new IOException();
        }
    }

}

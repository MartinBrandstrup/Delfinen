/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.DataAccessor;
import Data.Member;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Martin L.B.
 */
public class Controller

{

    private DataAccessor data;
    //private MemberList memberlist;
    private ArrayList<Member> memberlist;
    private int MIDcounter = 1;

    //MemberID og dateOfJoining bliver automatisk genereret.
    //Hvis der sker en fejl kan man kalde .set på Member og .setMID på
    //Controller for at ændre counteren
    public void registerNewMember(int zipCode, long phoneNumber,
            String name, String address, String city,
            String email, LocalDate dateOfBirth)
    {
        memberlist.add(new Member(true, true, zipCode,
                MIDcounter, phoneNumber, 0, name, address, city, email,
                "Recreational Swimmer", dateOfBirth, LocalDate.now()));
        ++MIDcounter;
    }

    public ArrayList<Member> getMemberlist()
    {
        return memberlist;
    }

    public void getMemberListFromFile(ArrayList members)
    {
        this.memberlist = data.getMemberList();
    }

    public int getMIDcounter()
    {
        return MIDcounter;
    }

    public void setMIDcounter(int MIDcounter)
    {
        this.MIDcounter = MIDcounter;
    }
}

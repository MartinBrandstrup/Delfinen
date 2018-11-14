/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.DataAccessor;
import Data.Member;
import Data.MemberList;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Martin L.B.
 */
public class Controller

{

    private DataAccessor data;
    private MemberList memberlist;
    private int MIDcounter = 1;

    
    //MemberID og dateOfJoining bliver automatisk genereret.
    //Hvis der sker en fejl kan man kalde .set på medlemmet og .setMID på
    //controlleren for at ændre counteren
    public void registerNewMember(boolean paidCurrentYear, 
            boolean activityStatus, int zipCode, long phoneNumber, 
            long arrearsBalance, String name, String address, String city, 
            String email, String memberType, LocalDate dateOfBirth)
    {
        memberlist.getMemberlist().add(new Member(paidCurrentYear, activityStatus, zipCode, 
                MIDcounter, phoneNumber, arrearsBalance, name, address, city, email, 
                memberType, dateOfBirth, LocalDate.now()));
        ++MIDcounter;
    }

    public void setMIDcounter(int MIDcounter)
    {
        this.MIDcounter = MIDcounter;
    }
    
    public ArrayList<Member> saveMemberListToFile()
    {
        return memberlist.getMemberlist();
    }
}

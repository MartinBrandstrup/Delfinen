/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.ArrayList;

/**
 *
 * @author 69lem
 */
public class MemberList
{

    ArrayList<Member> memberlist;

    public MemberList(ArrayList<Member> memberlist)
    {
        this.memberlist = memberlist;
    }

    public ArrayList<Member> getMemberlist()
    {
        return memberlist;
    }

    //Technically a setter
    public void getMemberListFromFile(ArrayList members)
    {
        this.memberlist = members;
    }

}

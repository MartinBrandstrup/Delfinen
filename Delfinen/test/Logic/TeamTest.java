/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 69lem
 */
public class TeamTest
{
    private Member jens;
    private Member johanne;
    private Member alice;
    ArrayList<Member> memberList = new ArrayList();
    
    public TeamTest()
    {
        jens = new Member(true, true, false, false, 2800, 1, 14548645,
                0, 0, "Jens", "Fiktiv Vej 21",
                "Kongens Lyngby", "Jens@gmail.com",
                LocalDate.of(1993, 6, 12), LocalDate.now());
        johanne = new Member(false, false, true, true, 2800, 81, 14548645,
                50000, 0, "Johanne Jaeger", "Fiktiv Vej 23",
                "Kongens Lyngby", "Johanne.j@gmail.dk",
                LocalDate.of(1993, 4, 12), LocalDate.of(2009, 12, 10));
        alice = new Member(false, true, false, false, 2800, 82, 23657845,
                0, 0, "Alice Lauritzen", "Fiktiv Vej 25",
                "Kongens Lyngby", "Alice.l@test.dk",
                LocalDate.of(2004, 6, 14), LocalDate.of(2014, 3, 7));

        memberList.add(jens);
        memberList.add(johanne);
        memberList.add(alice);

        for(Member m : memberList)
        {
            m.calculateMembershipPrice();
        }
    }

    /**
     * Test of addMember method, of class Team.
     */
    @Test
    public void testAddMember()
    {
        System.out.println("addMember");
        Member member = null;
        Team instance = null;
        instance.addMember(member);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeMemberByID method, of class Team.
     */
    @Test
    public void testRemoveMemberByID()
    {
        System.out.println("removeMemberByID");
        Member member = null;
        int memberID = 0;
        Team instance = null;
        instance.removeMemberByID(member, memberID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIsJuniorTeam method, of class Team.
     */
    @Test
    public void testGetIsJuniorTeam()
    {
        System.out.println("getIsJuniorTeam");
        Team instance = null;
        boolean expResult = false;
        boolean result = instance.getIsJuniorTeam();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTeamName method, of class Team.
     */
    @Test
    public void testGetTeamName()
    {
        System.out.println("getTeamName");
        Team instance = null;
        String expResult = "";
        String result = instance.getTeamName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTeamName method, of class Team.
     */
    @Test
    public void testSetTeamName()
    {
        System.out.println("setTeamName");
        String teamName = "";
        Team instance = null;
        instance.setTeamName(teamName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTrainer method, of class Team.
     */
    @Test
    public void testGetTrainer()
    {
        System.out.println("getTrainer");
        Team instance = null;
        String expResult = "";
        String result = instance.getTrainer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTrainer method, of class Team.
     */
    @Test
    public void testSetTrainer()
    {
        System.out.println("setTrainer");
        String trainer = "";
        Team instance = null;
        instance.setTrainer(trainer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSwimmingStyle method, of class Team.
     */
    @Test
    public void testGetSwimmingStyle()
    {
        System.out.println("getSwimmingStyle");
        Team instance = null;
        SwimmingStyle expResult = null;
        SwimmingStyle result = instance.getSwimmingStyle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSwimmingStyle method, of class Team.
     */
    @Test
    public void testSetSwimmingStyle()
    {
        System.out.println("setSwimmingStyle");
        SwimmingStyle swimmingStyle = null;
        Team instance = null;
        instance.setSwimmingStyle(swimmingStyle);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTeamMembers method, of class Team.
     */
    @Test
    public void testGetTeamMembers()
    {
        System.out.println("getTeamMembers");
        Team instance = null;
        ArrayList<Member> expResult = null;
        ArrayList<Member> result = instance.getTeamMembers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

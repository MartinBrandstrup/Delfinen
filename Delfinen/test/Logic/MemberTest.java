/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import static Logic.ValidatorAndFormatter.formatLongToString;
import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Martin L.B.
 */
public class MemberTest
{

    private Member jens;
    private Member johanne;
    private Member alice;
    private Team teamA;
    ArrayList<Member> memberList = new ArrayList();

    public MemberTest()
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
        teamA = new Team(true, "Team A", "Flemming", SwimmingStyle.BREASTSTROKE);
        
        memberList.add(jens);
        memberList.add(johanne);
        memberList.add(alice);

        for(Member m : memberList)
        {
            m.calculateMembershipPrice();
        }
    }

    //Mangler flere tests
    @Test
    public void testGetAge()
    {
        //Skal rettes til afhængig af dags dato
        assertEquals(25, johanne.getAge());
    }

    @Test
    public void testGetNextPaymentDate()
    {
        assertEquals(LocalDate.of(2018, 12, 10), johanne.getNextPaymentDate());
    }

    @Test
    public void testCalculateMembershipPrice()
    {
        johanne.calculateMembershipPrice();
        assertEquals(50000, johanne.getMembershipPrice());
        johanne.setMembershipPrice(0);
    }

    @Test
    public void testCheckPaymentOverdue()
    {

    }

    @Test
    public void testFormatLongToString()
    {
        johanne.calculateMembershipPrice();
        long membershipPrice = johanne.getMembershipPrice();
        assertEquals("500,00 kr.", formatLongToString(membershipPrice));
        johanne.setMembershipPrice(0);
    }

    @Test
    public void testPayArrears()
    {
        assertEquals(50000, johanne.getArrearsBalance());
        johanne.payArrears();
        assertEquals(0, johanne.getArrearsBalance());
    }

    @Test
    public void testRegisterPayment()
    {
        assertFalse(johanne.hasPaidCurrentYear());
        johanne.registerPayment();
        assertTrue(johanne.hasPaidCurrentYear());
    }

    @Test
    public void testSwitchActivityStatus()
    {
        assertFalse(johanne.isActiveMember());
        johanne.switchActivityStatus();
        assertTrue(johanne.isActiveMember());
    }

    @Test
    public void testGetActivityStatusString()
    {
        assertEquals("Passive", johanne.getActivityStatusString());
        assertEquals("Active", alice.getActivityStatusString());
    }
    
    @Test
    public void testGetCompetitiveSwimmerString()
    {
        assertEquals("Competitive Swimmer", johanne.getCompetitiveSwimmerString());
        assertEquals("Recreational Swimmer", alice.getCompetitiveSwimmerString());
    }
    
    @Test
    public void testRegisterSwimmerOnTeam()
    {
        
    }
    
    @Test
    public void testRegisterSwimmerInTournament()
    {
        
    }
    
    @Test
    public void testRegisterNewSwimmingResult()
    {
        
    }
    
    @Test
    public void testGetResultByStyle()
    {
        
    }
    
    @Test
    public void testSwitchTournamentEligibility()
    {
        
    }
}

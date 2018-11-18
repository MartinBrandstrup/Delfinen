/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Martin L.B.
 */
public class MemberTest
{

    private Member johanne;

    public MemberTest()
    {
        johanne = new Member(false, false, true, 2800, 81, 14548645, 
                50000, 50000, "Johanne Jaeger", "Fiktiv Vej 23", 
                "Kongens Lyngby", "Johanne.j@test.dk", 
                LocalDate.of(1993, 04, 12), LocalDate.of(2009, 12, 10));
    }

    //Mangler flere tests
    @Test
    public void testGetAge()
    {
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
        
    }
    
    @Test
    public void testCheckPaymentOverdue()
    {
        
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
        
    }
}

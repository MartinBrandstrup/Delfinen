/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Freiden
 */
public class ControllerTest
{
    
    public ControllerTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void testRegisterNewMember()
    {
        Controller ctrl = new Controller();
        ArrayList<Member> memberList = null;
        
        memberList.add(new Member(false, false, true, 2800, 1, 14548645, 
                50000, 50000, "Johanne Jaeger", "Fiktiv Vej 23", 
                "Kongens Lyngby", "Johanne.j@test.dk", 
                LocalDate.of(1993, 04, 12), LocalDate.of(2009, 12, 10)));
        
        ctrl.registerNewMember(2800, 14548645, 
                "Johanne Jaeger", "Fiktiv Vej 23", "Kongens Lyngby", 
                "Johanne.j@test.dk", LocalDate.of(1993, 04, 12));
        
        assertEquals(memberList.get(0), (ctrl.getMemberList()));
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.DataAccessorFile;
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
    
    
    //Mangler en override @Override Equals på member, men ellers dur den
    @Test
    public void testRegisterNewMember()
    {
        DataAccessorFile data = new DataAccessorFile();
        Controller ctrl = new Controller(data);
        ArrayList<Member> memberList = new ArrayList();
        
        memberList.add(new Member(true, true, false, 2800, 81, 14548645, 
                0, 0, "Johanne Jaeger", "Fiktiv Vej 23", 
                "Kongens Lyngby", "Johanne.j@gmail.dk", 
                LocalDate.of(1993, 4, 12), LocalDate.now()));
        
        ctrl.registerNewMember(2800, 14548645, 
                "Johanne Jaeger", "Fiktiv Vej 23", "Kongens Lyngby", 
                "Johanne.j@test.dk", LocalDate.of(1993, 4, 12));
        
        assertEquals(memberList.get(0), (ctrl.getMemberList()));
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
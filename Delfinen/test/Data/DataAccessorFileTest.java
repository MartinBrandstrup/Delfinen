/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Logic.Member;
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
 * @author Martin L.B.
 */
public class DataAccessorFileTest
{
    private ArrayList<Member> memberList;

    public DataAccessorFileTest()
    {
        memberList.add(new Member(false, false, true, 2800, 010, 14548645, 
                50000, 50000, "Johanne Jaeger", "Fiktiv Vej 23", 
                "Kongens Lyngby", "Johanne.j@test.dk", 
                LocalDate.of(1993, 04, 12), LocalDate.of(2009, 12, 10)));
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
    public void testSaveMemberList()
    {
        //assertEquals("", )
    }
    
    
//    @Test
//    public void testDirPath()
//    {
//        assertEquals("", FileSystemView.getFileSystemView().getDefaultDirectory().getPath());
//    }
}

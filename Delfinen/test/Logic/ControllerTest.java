/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.DataAccessorFile;
import java.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Freiden
 */
public class ControllerTest
{

    DataAccessorFile data = new DataAccessorFile();
    Controller ctrl = new Controller(data);

    private Member jens;
    private Member johanne;
    private Member alice;

    public ControllerTest()
    {

        jens = new Member(true, true, false, 2800, 1, 14548645,
                0, 0, "Jens", "Fiktiv Vej 21",
                "Kongens Lyngby", "Jens@gmail.com",
                LocalDate.of(1993, 6, 12), LocalDate.now());

        johanne = new Member(false, false, true, 2800, 81, 14548645,
                50000, 0, "Johanne Jaeger", "Fiktiv Vej 23",
                "Kongens Lyngby", "Johanne.j@gmail.dk",
                LocalDate.of(1993, 4, 12), LocalDate.of(2009, 12, 10));

        alice = new Member(false, true, false, 2800, 82, 23657845,
                0, 0, "Alice Lauritzen", "Fiktiv Vej 25",
                "Kongens Lyngby", "Alice.l@gmail.com",
                LocalDate.of(2004, 6, 14), LocalDate.of(2014, 3, 7));

        ctrl.getMemberList().add(jens);
        ctrl.getMemberList().add(johanne);
        ctrl.getMemberList().add(alice);

        for(Member m : ctrl.getMemberList())
        {
            m.calculateMembershipPrice();
        }
    }

    @Test
    public void testRegisterNewMember()
    {
        ctrl.setMIDCounter(1);
        ctrl.registerNewMember(2800, 14548645,
                "Jens", "Fiktiv Vej 21", "Kongens Lyngby",
                "Jens@gmail.com", LocalDate.of(1993, 6, 12));

        assertEquals(ctrl.getMemberList().get(ctrl.getMemberList().size() - 1), (ctrl.getMemberList().get(0)));
        ctrl.getMemberList().remove(ctrl.getLastAddedMember());
        ctrl.setMIDCounter(1);
    }

    @Test
    public void testUpgradeMemberToCompetitiveSwimmer()
    {
        assertTrue(johanne.isCompetitiveSwimmer());
        assertFalse(alice.isCompetitiveSwimmer());
        assertTrue(ctrl.getMemberList().get(2).equals(alice));
        assertTrue(ctrl.getMemberList().get(1).equals(johanne));

        ctrl.upgradeMemberToCompetitive(ctrl.getMemberList().get(2));

        assertTrue(ctrl.getMemberList().get(2).getName().equals("Alice Lauritzen"));
        assertEquals(82, ctrl.getMemberList().get(2).getMemberID());
        assertTrue(ctrl.getMemberList().get(1).equals(johanne));

    }

}

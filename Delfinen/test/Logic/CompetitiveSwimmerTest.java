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
 * @author 69lem
 */
public class CompetitiveSwimmerTest
{
        private Member johanne;

    public CompetitiveSwimmerTest()
    {
        johanne = new CompetitiveSwimmer(false, false, 2800, 010, 14548645, 50000, 50000, 
                "Johanne Jaeger", "Fiktiv Vej 23", "Kongens Lyngby", 
                "Johanne.j@test.dk", "Competitive Swimmer", LocalDate.of(1993, 04, 12),
                LocalDate.of(2009, 12, 10), true, null, null);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

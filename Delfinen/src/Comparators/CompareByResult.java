/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comparators;

import Logic.Member;
import Logic.SwimmingStyle;
import java.util.Comparator;

/**
 *
 * @author 69lem
 */
public class CompareByResult implements Comparator<Member>       
{
        private SwimmingStyle style; 

    public CompareByResult(SwimmingStyle style)
    {
        this.style = style;
    }
        
//    @Override
//    public int compare(Member o1, Member o2)
//    {
//       o1.getResultList().get(1).getSwimmingStyle() == SwimmingStyle.BACKCRAWL;
//                   int i1 = -1;
//            int i2 = -1;
//            
//            for(Result r : ((Member) o2).getResultList())
//            {
//                if(r.getSwimmingStyle().equals(style))
//                {
//                    
//                }
//            }
//            if(((Member) o2).getResultList().get> ((Member) o1).getMemberID())
//            {
//                return -1;
//            }
//            if(((Member) o2).getMemberID()< ((Member) o1).getMemberID())
//            {
//                return 1;
//            }
//            return 0;
//        }
//    }
//    
}

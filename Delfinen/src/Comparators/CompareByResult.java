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

    @Override
    public int compare(Member o1, Member o2) throws IllegalArgumentException
    {
        if(o1.getResultList().isEmpty() || o2.getResultList().isEmpty())
        {
            throw new IllegalArgumentException();
        }
        int i1;
        int i2;
        
        for (i1 = 0; i1 < o1.getResultList().size(); i1++)
        {
            if(o1.getResultList().get(i1).getSwimmingStyle().equals(style))
            {
                break;
            }
        }
        for (i2 = 0; i2 < 10; i2++)
        {
            if(o2.getResultList().get(i2).getSwimmingStyle().equals(style))
            {
                break;
            }
            
        }
        
        if(o2.getResultList().get(i2).getResult() > o1.getResultList().get(i1).getResult())
        {
            return -1;
        }
        if(o2.getResultList().get(i2).getResult() > o1.getResultList().get(i1).getResult())
        {
            return 1;
        }
        return 0;
    }
}

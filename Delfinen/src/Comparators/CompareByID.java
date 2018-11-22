/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comparators;

import Logic.Member;
import java.util.Comparator;

/**
 *
 * @author 69lem
 */
public class CompareByID implements Comparator<Member>
{

    @Override
    public int compare(Member o1, Member o2)
    {
           {
            if(o2.getMemberID() > o1.getMemberID())
            {
                return -1;
            }
            if(o2.getMemberID()< o1.getMemberID())
            {
                return 1;
            }
            return 0;
        }
    }
    
}

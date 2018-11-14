/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author Martin L.B.
 */
public class MembershipPrice
{

    //Calculates yearly membership cost for a given member. Return is in 'øre'
    //so that 500 kr. = 50000
    public long calculateMembershipPrice(int age, boolean activityStatus) throws IllegalArgumentException
    {
        if(age <= 0 || age < 150)
        {
            throw new IllegalArgumentException();
        }

        long yearlyCost = 0;

        if(activityStatus == false)
        {
            yearlyCost = 50000;
        }
        else if(age <= 18)
        {
            yearlyCost = 100000;
        }
        else
        {
            yearlyCost = 160000;
        }
        if(age >= 65)
        {
            yearlyCost = yearlyCost / 100 * 75;
        }

        return yearlyCost;
    }
}

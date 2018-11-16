/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Martin L.B.
 */
public class Team implements Serializable
{

    private String teamName;
    private String trainer;
    private SwimmingStyle swimmingStyle;
    private ArrayList<CompetitiveSwimmer> teamMembers;
    
    public void addMember(CompetitiveSwimmer member)
    {
        teamMembers.add(member);
    }
    
    public void removeMemberByID(Member member, int memberID)
    {
        for(int i = 0; i < teamMembers.size(); i++)
        {
            if(member.getMemberID() == memberID)
            {
                teamMembers.remove(i);
            }
        }
    }

    public String getTeamName()
    {
        return teamName;
    }

    public void setTeamName(String teamName)
    {
        this.teamName = teamName;
    }

    public String getTrainer()
    {
        return trainer;
    }

    public void setTrainer(String trainer)
    {
        this.trainer = trainer;
    }

    public SwimmingStyle getSwimmingStyle()
    {
        return swimmingStyle;
    }

    public void setSwimmingStyle(SwimmingStyle swimmingStyle)
    {
        this.swimmingStyle = swimmingStyle;
    }

    public ArrayList<CompetitiveSwimmer> getTeamMembers()
    {
        return teamMembers;
    }
    
}

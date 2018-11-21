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
 * @author Martin L.B. & Kasper Jeppesen
 */
public class Team implements Serializable
{

    private boolean isJuniorTeam;
    private String teamName, trainer;
    private SwimmingStyle swimmingStyle;
    private ArrayList<Member> teamMembers;

    public Team(boolean isJuniorTeam, String teamName, String trainer,
            SwimmingStyle swimmingStyle, ArrayList<Member> teamMembers)
            throws IllegalArgumentException
    {
        if(teamName.isEmpty() || trainer.isEmpty())
        {
            throw new IllegalArgumentException();
        }
        this.isJuniorTeam = isJuniorTeam;
        this.teamName = teamName;
        this.trainer = trainer;
        this.swimmingStyle = swimmingStyle;
        this.teamMembers = teamMembers;
    }

    public void addMember(Member member)
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

    public boolean getIsJuniorTeam()
    {
        return isJuniorTeam;
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

    public ArrayList<Member> getTeamMembers()
    {
        return teamMembers;
    }

}

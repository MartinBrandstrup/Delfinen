/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Logic.Member;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Martin L.B.
 */
public class DataAccessorTempTest
{

    //Midlertidig test fil, da jeg ikke kan overskue hvordan man skriver
    //unit tests til filtesting. Hvis jeg får ekstra tid vil jeg forsøge
    //at omskrive til en ordentlig unit test
    public static void main(String[] args)
    {
        DataAccessorFile data = new DataAccessorFile();
        Scanner scanner = new Scanner(System.in);
        ArrayList<Member> memberList = new ArrayList();

        memberList.add(new Member(false, false, true, 2800, 81, 14548645,
                50000, 0, "Johanne Jaeger", "Fiktiv Vej 23",
                "Kongens Lyngby", "Johanne.j@test.dk",
                LocalDate.of(1993, 4, 12), LocalDate.of(2009, 12, 10)));
        memberList.add(new Member(false, true, false, 2800, 82, 23657845,
                0, 0, "Alice Lauritzen", "Fiktiv Vej 25",
                "Kongens Lyngby", "Alice.l@test.dk",
                LocalDate.of(2004, 6, 14), LocalDate.of(2014, 3, 7)));
        for(Member m : memberList)
        {
            m.calculateMembershipPrice();
        }

        System.out.println("Memberlist size is: " + memberList.size());
        scanner.nextLine();

        try
        {
            data.saveMemberList(memberList);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }

        scanner.nextLine();

        ArrayList toRemove = new ArrayList();
        for(int i = 0; i < memberList.size(); i++)
        {
            toRemove.add(memberList.get(i));
            System.out.println("Removed member: " + i + " = " + memberList.get(i).getName());
        }
        
        memberList.removeAll(toRemove);
        
        
        System.out.println("Memberlist size is: " + memberList.size());
        
        scanner.nextLine();
        
        
        if(memberList.isEmpty())
        {
            System.out.println("Local instance of memberlist reset");
        }

        scanner.nextLine();

        try
        {
            memberListToString(data.getMemberList());
            System.out.println("Printed entire list from file");
            System.out.println("Memberlist size is: " + memberList.size());
        }
        catch(ClassNotFoundException ex)
        {
        }

        scanner.nextLine();

        memberListToString(memberList);
        System.out.println("Memberlist size is: " + memberList.size());
        System.out.println("Printed entire list from local instance");

        scanner.nextLine();

        try
        {
            data.saveMemberList(memberList);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        System.out.println("Overwritten file with zero members");
        System.out.println("Memberlist size is: " + memberList.size());

        scanner.nextLine();

        try
        {
            memberListToString(data.getMemberList());
            System.out.println("Printed entire list from file");
            System.out.println("Memberlist size is: " + memberList.size());
        }
        catch(ClassNotFoundException ex)
        {
        }

        scanner.nextLine();

        memberList.add(new Member(false, false, true, 2800, 81, 14548645,
                50000, 50000, "Johanne Jaeger", "Fiktiv Vej 23",
                "Kongens Lyngby", "Johanne.j@test.dk",
                LocalDate.of(1993, 4, 12), LocalDate.of(2009, 12, 10)));
        memberList.add(new Member(false, true, false, 2800, 82, 23657845,
                0, 100000, "Alice Lauritzen", "Fiktiv Vej 25",
                "Kongens Lyngby", "Alice.l@test.dk",
                LocalDate.of(2004, 6, 14), LocalDate.of(2014, 3, 7)));

        System.out.println("Repopulated list with Alice and Johanne");
        System.out.println("Memberlist size is: " + memberList.size());

        scanner.nextLine();

        memberList.remove(memberList.size() - 1);
        System.out.println("Removed last added member from list (Alice)");
        System.out.println("Memberlist size is: " + memberList.size());

        scanner.nextLine();

        try
        {
            data.saveMemberList(memberList);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        System.out.println("Overwritten file with only one member");

        scanner.nextLine();

        memberListToString(memberList);
        System.out.println("Printed memberList from local instance");

        scanner.nextLine();

        try
        {
            memberListToString(data.getMemberList());
            System.out.println("Printed entire list from file");
        }
        catch(ClassNotFoundException ex)
        {
        }
    }

    static void memberListToString(ArrayList<Member> memberList)
    {
        try
        {
            for(Member m : memberList)
            {
                System.out.println(m.toString());
            }
        }
        catch(NullPointerException e)
        {
            System.out.println("File does not contain any members");
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
}

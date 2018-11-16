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
 * @author Freiden
 */
public class DataAccessorTempTest
{

    public static void main(String[] args)
    {
        DataAccessorFile data = new DataAccessorFile();
        Scanner scanner = new Scanner(System.in);
        ArrayList<Member> memberList = new ArrayList();

        memberList.add(new Member(false, false, true, 2800, 010, 14548645,
                50000, 50000, "Johanne Jaeger", "Fiktiv Vej 23",
                "Kongens Lyngby", "Johanne.j@test.dk",
                LocalDate.of(1993, 04, 12), LocalDate.of(2009, 12, 10)));
        try
        {
            data.saveMemberList(memberList);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }

        scanner.nextLine();

        memberList.remove(0);

        scanner.nextLine();

        try
        {
            memberList = data.getMemberList();
            for(Member m : memberList)
            {
                System.out.println(m.toString());
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
}

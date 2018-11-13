/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.Member;

/**
 *
 * @author Freiden
 */
public class Controller

{

    private DataAccessor data;

    public Member registerNewMember(Member newMember)
    {
        data.saveMember(newMember);
    }
}

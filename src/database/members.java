/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author Nafis
 */
public class members {
    
     public String membersID;
     public String membersname;
     public String membersdesig;
     public String memberscontact;
     public String memberschedule;

    public members(String membersID, String membersname, String membersdesig, String memberscontact, String memberschedule) {
        this.membersID = membersID;
        this.membersname = membersname;
        this.membersdesig = membersdesig;
        this.memberscontact = memberscontact;
        this.memberschedule = memberschedule;
    }

    public String getMembersID() {
        return membersID;
    }

    public void setMembersID(String membersID) {
        this.membersID = membersID;
    }

    public String getMembersname() {
        return membersname;
    }

    public void setMembersname(String membersname) {
        this.membersname = membersname;
    }

    public String getMembersdesig() {
        return membersdesig;
    }

    public void setMembersdesig(String membersdesig) {
        this.membersdesig = membersdesig;
    }

    public String getMemberscontact() {
        return memberscontact;
    }

    public void setMemberscontact(String memberscontact) {
        this.memberscontact = memberscontact;
    }

    public String getMemberschedule() {
        return memberschedule;
    }

    public void setMemberschedule(String memberschedule) {
        this.memberschedule = memberschedule;
    }
    
}

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
public class mediList {
    
   public String mediname;
   public String  mediprice;

    public mediList(String mediname, String mediprice) {
        this.mediname = mediname;
        this.mediprice = mediprice;
    }

    public String getMediname() {
        return mediname;
    }

    public void setMediname(String mediname) {
        this.mediname = mediname;
    }

    public String getMediprice() {
        return mediprice;
    }

    public void setMediprice(String mediprice) {
        this.mediprice = mediprice;
    }
}

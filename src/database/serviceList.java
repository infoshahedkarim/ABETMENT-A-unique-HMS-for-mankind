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
public class serviceList {
    
    public String servicesname;
     public String netcost;

    public serviceList(String servicesname, String netcost) {
        this.servicesname = servicesname;
        this.netcost = netcost;
    }

    public String getServicesname() {
        return servicesname;
    }

    public void setServicesname(String servicesname) {
        this.servicesname = servicesname;
    }

    public String getNetcost() {
        return netcost;
    }

    public void setNetcost(String netcost) {
        this.netcost = netcost;
    }
    
}

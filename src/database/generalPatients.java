/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

/**
 *
 * @author Zannat
 */
public class generalPatients {

    public String doctorsName;
    public String patientsID;
    public String patientsName;
    public String patientsContact;
    public String syndrome;
    public String mediNtest;

    public generalPatients(String doctorsName, String patientsID, String patientsName, String patientsContact, String syndrome, String mediNtest) {
        this.doctorsName = doctorsName;
        this.patientsID = patientsID;
        this.patientsName = patientsName;
        this.patientsContact = patientsContact;
        this.syndrome = syndrome;
        this.mediNtest = mediNtest;
    }

    public String getDoctorsName() {
        return doctorsName;
    }

    public String getPatientsID() {
        return patientsID;
    }

    public String getPatientsName() {
        return patientsName;
    }

    public String getPatientsContact() {
        return patientsContact;
    }

    public String getSyndrome() {
        return syndrome;
    }

    public String getMediNtest() {
        return mediNtest;
    }

    public void setDoctorsName(String doctorsName) {
        this.doctorsName = doctorsName;
    }

    public void setPatientsID(String patientsID) {
        this.patientsID = patientsID;
    }

    public void setPatientsName(String patientsName) {
        this.patientsName = patientsName;
    }

    public void setPatientsContact(String patientsContact) {
        this.patientsContact = patientsContact;
    }

    public void setSyndrome(String syndrome) {
        this.syndrome = syndrome;
    }

    public void setMediNtest(String mediNtest) {
        this.mediNtest = mediNtest;
    }
}

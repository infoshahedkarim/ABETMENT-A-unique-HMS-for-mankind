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
public class appointment {
    public String patientsID;
    public String patientsName;
    public String patientsContact;
    public String doctorsName_patients;

    public appointment(String patientsID, String patientsName, String patientsContact, String doctorsName_patients) {
        this.patientsID = patientsID;
        this.patientsName = patientsName;
        this.patientsContact = patientsContact;
        this.doctorsName_patients = doctorsName_patients;
    }

    public String getDoctorsName_patients() {
        return doctorsName_patients;
    }

    public void setDoctorsName_patients(String doctorsName_patients) {
        this.doctorsName_patients = doctorsName_patients;
    }

    public String getPatientsID() {
        return patientsID;
    }

    public void setPatientsID(String patientsID) {
        this.patientsID = patientsID;
    }

    public String getPatientsName() {
        return patientsName;
    }

    public void setPatientsName(String patientsName) {
        this.patientsName = patientsName;
    }

    public String getPatientsContact() {
        return patientsContact;
    }

    public void setPatientsContact(String patientsContact) {
        this.patientsContact = patientsContact;
    }
}

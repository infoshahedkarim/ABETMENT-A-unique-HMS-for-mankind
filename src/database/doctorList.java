/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author Zannat
 */
public class doctorList {
    
    public String doctorsID;
    public String doctorsName;
    public String doctersDesig;
    public String doctorsContact;
    public String doctorSchedule;
   

    public doctorList(String doctorsID, String doctorsName, String doctersDesig, String doctorsContact, String doctorSchedule) {
        this.doctorsName = doctorsName;
        this.doctersDesig = doctersDesig;
        this.doctorsContact = doctorsContact;
        this.doctorSchedule = doctorSchedule;
        this.doctorsID = doctorsID;
    }

    public String getDoctorsID() {
        return doctorsID;
    }

    public void setDoctorsID(String doctorsID) {
        this.doctorsID = doctorsID;
    }

    public String getDoctorsName() {
        return doctorsName;
    }

    public void setDoctorsName(String doctorsName) {
        this.doctorsName = doctorsName;
    }

    public String getDoctersDesig() {
        return doctersDesig;
    }

    public void setDoctersDesig(String doctersDesig) {
        this.doctersDesig = doctersDesig;
    }

    public String getDoctorsContact() {
        return doctorsContact;
    }

    public void setDoctorsContact(String doctorsContact) {
        this.doctorsContact = doctorsContact;
    }

    public String getDoctorSchedule() {
        return doctorSchedule;
    }

    public void setDoctorSchedule(String doctorSchedule) {
        this.doctorSchedule = doctorSchedule;
    }
}

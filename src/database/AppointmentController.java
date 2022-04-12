/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import abetment.MainpageController;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Nafis
 */
public class AppointmentController implements Initializable {

    Connection co;
    @FXML
    private TextField patientsNameTF;
    @FXML
    private TextField patientsContactTF;
    @FXML
    private TextField doctorsName_patientsTF;
    @FXML
    private Button insert;
    @FXML
    private TableView<doctorList> doctorTable;
    @FXML
    private TableColumn<doctorList, String> doctorsID;
    @FXML
    private TableColumn<doctorList, String> doctorsName;
    @FXML
    private TableColumn<doctorList, String> doctersDesig;
    @FXML
    private TableColumn<doctorList, String> doctorsContact;
    @FXML
    private TableColumn<doctorList, String> doctorSchedule;
    @FXML
    private Button B2H;
    @FXML
    private Button exit;
    @FXML
    private TableView<appointment> appointment;
    @FXML
    private TableColumn<appointment, String> patientsID;
    @FXML
    private TableColumn<appointment, String> patientsName;
    @FXML
    private TableColumn<appointment, String> patientsContact;
    @FXML
    private TextField patientsIDTF;
    @FXML
    private TableColumn<appointment, String> doctorsName_patients;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            //System.out.println("Database connection");
          co = DriverManager.getConnection("jdbc:derby://localhost:1527/abetment", "shahed", "1234");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database is not connected", "Error", JOptionPane.ERROR_MESSAGE);
        }
        initCol();
        showAll();
        showAll2();
    }
    public void initCol(){

        doctorsID.setCellValueFactory(new PropertyValueFactory<>("doctorsID"));
        doctorsName.setCellValueFactory(new PropertyValueFactory<>("doctorsName"));
        doctersDesig.setCellValueFactory(new PropertyValueFactory<>("doctersDesig"));
        doctorsContact.setCellValueFactory(new PropertyValueFactory<>("doctorsContact"));
        doctorSchedule.setCellValueFactory(new PropertyValueFactory<>("doctorSchedule"));
        patientsID.setCellValueFactory(new PropertyValueFactory<>("patientsID"));
        patientsName.setCellValueFactory(new PropertyValueFactory<>("patientsName"));
        patientsContact.setCellValueFactory(new PropertyValueFactory<>("patientsContact"));
        
    }
    private void showAll() {

        String sql = "SELECT * FROM DOCTORLIST";
        try {
            Statement st = co.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //moon.setModel(DbUtils.resultSetToTableModel(rs));
           
            ObservableList<doctorList> results = FXCollections.observableArrayList();
           

            //iterating resultSet to add the values to ObservableList
            while (rs.next()) {
                String DoctorsID = rs.getString("doctorsID");
                String DoctorsName = rs.getString("doctorsName");
                String DoctersDesig = rs.getString("doctersDesig");
                String DoctorsContact = rs.getString("doctorsContact");
                String DoctorSchedule = rs.getString("doctorSchedule");
                
                
           
                
                doctorList obj = new doctorList(DoctorsID,DoctorsName,DoctersDesig,DoctorsContact,DoctorSchedule);
                results.add(obj);
                
            }
            
            doctorTable.getItems().setAll(results);
            

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data fetching failed", "Error", JOptionPane.ERROR_MESSAGE);
        }

    
    }    
    private void showAll2() {

        String sql = "SELECT * FROM APPOINTMENT";
        try {
            Statement st = co.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //moon.setModel(DbUtils.resultSetToTableModel(rs));
           
            ObservableList<appointment> results = FXCollections.observableArrayList();
           

            //iterating resultSet to add the values to ObservableList
            while (rs.next()) {
                String PatientsID = rs.getString("patientsID");
                String PatientsName = rs.getString("patientsName");
                String PatientsContact = rs.getString("patientsContact");
                String DoctorsName_patients = rs.getString("doctorsName_patients");
                
                
                
           
                
                appointment obj2 = new appointment( PatientsID,  PatientsName,  PatientsContact, DoctorsName_patients);
                results.add(obj2);
                
            }
            
            appointment.getItems().setAll(results);
            

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data fetching failed", "Error", JOptionPane.ERROR_MESSAGE);
        }

    
    }  
      

    @FXML
    private void insert(ActionEvent event) {
        int row = -1;
                String PatientsID = patientsIDTF.getText();
                String PatientsName = patientsNameTF.getText();
                String PatientsContact = patientsContactTF.getText();
                String DoctorsName_patients = doctorsName_patientsTF.getText();
                
                  
        
        String sql = "INSERT INTO APPOINTMENT (PatientsID, PatientsName, PatientsContact, DoctorsName_patients) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = co.prepareStatement(sql);

            ps.setString(1, PatientsID);
            ps.setString(2, PatientsName);
            ps.setString(3, PatientsContact);
            ps.setString(4, DoctorsName_patients);
          
            
            row = ps.executeUpdate();
            JOptionPane.showMessageDialog(null, row + " rows added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Insertion Failed", "Error", JOptionPane.ERROR_MESSAGE);
        }
        showAll2();
    
    }

    @FXML
    private void b2h(ActionEvent event) {
        
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/abetment/mainpage.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MainpageController.class.getName()).log(Level.SEVERE, null, ex);
        }
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            Image icon=new Image("/UI/icon.png");
            stage.getIcons().add(icon);
            stage.setTitle("Abetment : General Patients Information Form");
            stage.setScene(scene);
            stage.show();
    }

    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }
    
}

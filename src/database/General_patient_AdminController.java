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
 * @author Zannat
 */
public class General_patient_AdminController implements Initializable{

    Connection co;
    
    @FXML
    private TextField patientsNameTF;

    @FXML
    private TextField patientsContactTF;

    @FXML
    private TextField syndromeTF;

    @FXML
    private TextField doctorsNameTF;

    @FXML
    private TextField patientsIDTF;

    @FXML
    private TextField mediNtestTF;
    
    @FXML
    private TableView <generalPatients> generalTable;
    
    @FXML
    private TableColumn<generalPatients, String> doctorsName;

    @FXML
    private TableColumn<generalPatients, String> patientsID;

    @FXML
    private TableColumn<generalPatients, String> patientsName;

    @FXML
    private TableColumn<generalPatients, String> patientsContact;

    @FXML
    private TableColumn<generalPatients, String> syndrome;

    @FXML
    private TableColumn<generalPatients, String> mediNtest;
    
    

    @FXML
    private Button insert;


    @FXML
    private Button reset;
    @FXML
    private Button update;
    @FXML
    private Button delete;
    
     public void initialize(URL url, ResourceBundle rb) {

        try {
            //System.out.println("Database connection");
          co = DriverManager.getConnection("jdbc:derby://localhost:1527/abetment", "shahed", "1234");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database is not connected", "Error", JOptionPane.ERROR_MESSAGE);
        }
        initCol();
        showAll();
    }
    public void initCol(){

        doctorsName.setCellValueFactory(new PropertyValueFactory<>("doctorsName"));
        patientsID.setCellValueFactory(new PropertyValueFactory<>("patientsID"));
        patientsName.setCellValueFactory(new PropertyValueFactory<>("patientsName"));
        patientsContact.setCellValueFactory(new PropertyValueFactory<>("patientsContact"));
        syndrome.setCellValueFactory(new PropertyValueFactory<>("syndrome"));
        mediNtest.setCellValueFactory(new PropertyValueFactory<>("mediNtest"));
    }
     private void showAll() {

        String sql = "SELECT * FROM GENERALPATIENTS";
        try {
            Statement st = co.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //moon.setModel(DbUtils.resultSetToTableModel(rs));
           
            ObservableList<generalPatients> results = FXCollections.observableArrayList();

            //iterating resultSet to add the values to ObservableList
            while (rs.next()) {
                String DoctorsName = rs.getString("doctorsName");
                String PatientsID = rs.getString("patientsID");
                String PatientsName = rs.getString("patientsName");
                String PatientsContact = rs.getString("patientsContact");
                String Syndrome = rs.getString("syndrome");
                String MediNtest = rs.getString("mediNtest");
           
                
                generalPatients obj = new generalPatients(DoctorsName,PatientsID,PatientsName,PatientsContact,Syndrome,MediNtest);
                results.add(obj);
                
            }
            
            generalTable.getItems().setAll(results);
            

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data fetching failed", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    @FXML
    void b2h(ActionEvent event) {
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
    void delete(ActionEvent event) {
        
        int row = -1;
         String PatientsID = patientsIDTF.getText();

        String sql = "DELETE FROM GENERALPATIENTS WHERE PATIENTSID = ?";
        
        try {
            PreparedStatement ps = co.prepareStatement(sql);
            ps.setString(1, PatientsID);
            row = ps.executeUpdate();
            JOptionPane.showMessageDialog(null, row+" row deleted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            showAll();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Deletion Failed", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    void exit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void insert(ActionEvent event) {
        
          int row = -1;
                String DoctorsName = doctorsNameTF.getText();
                String PatientsID = patientsIDTF.getText();
                String PatientsName = patientsNameTF.getText();
                String PatientsContact = patientsContactTF.getText();
                String Syndrome = syndromeTF.getText();
                String MediNtest = mediNtestTF.getText();
                  
        
        String sql = "INSERT INTO GENERALPATIENTS (DoctorsName,PatientsID,PatientsName,PatientsContact,Syndrome,MediNtest) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = co.prepareStatement(sql);

            ps.setString(1, DoctorsName);
            ps.setString(2, PatientsID);
            ps.setString(3, PatientsName);
            ps.setString(4, PatientsContact);
            ps.setString(5, Syndrome);
            ps.setString(6, MediNtest);
            
            row = ps.executeUpdate();
            JOptionPane.showMessageDialog(null, row + " rows added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Insertion Failed", "Error", JOptionPane.ERROR_MESSAGE);
        }
        showAll();

    }

    @FXML
    void reset(ActionEvent event) {

    }

    @FXML
    void update(ActionEvent event) {
        int row = -1;
                String DoctorsName = doctorsNameTF.getText();
                String PatientsName = patientsNameTF.getText();
                String PatientsContact = patientsContactTF.getText();
                String Syndrome = syndromeTF.getText();
                String MediNtest = mediNtestTF.getText();
                String PatientsID = patientsIDTF.getText();

        
        String sql = "UPDATE GENERALPATIENTS SET DOCTORSNAME=?, PATIENTSNAME=? , PATIENTSCONTACT=?, SYNDROME=?, MEDINTEST=? WHERE PATIENTSID = ?";
        try {
            PreparedStatement ps = co.prepareStatement(sql);
            
            ps.setString(1, DoctorsName);
            ps.setString(2, PatientsName);
            ps.setString(3, PatientsContact);
            ps.setString(4, Syndrome);
            ps.setString(5, MediNtest);
            ps.setString(6, PatientsID);

            
            row = ps.executeUpdate();
            JOptionPane.showMessageDialog(null, row+" row updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            showAll();
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Update Failed", "Error", JOptionPane.ERROR_MESSAGE);
        }
         showAll();
    }

}

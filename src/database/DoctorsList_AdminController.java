/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Zannat
 */
public class DoctorsList_AdminController implements Initializable {
    Connection co;
    
    @FXML
    private TextField doctorsNameTF;
    @FXML
    private TextField doctorsDesigTF;
    @FXML
    private TextField doctorsContactTF;
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
    private TextField doctorsScheduleTF;
    @FXML
    private Button update;
    @FXML
    private Button delete;
   
    @FXML
    private TextField doctorsIDTF;

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
    }
    public void initCol(){

        doctorsID.setCellValueFactory(new PropertyValueFactory<>("doctorsID"));
        doctorsName.setCellValueFactory(new PropertyValueFactory<>("doctorsName"));
        doctersDesig.setCellValueFactory(new PropertyValueFactory<>("doctersDesig"));
        doctorsContact.setCellValueFactory(new PropertyValueFactory<>("doctorsContact"));
        doctorSchedule.setCellValueFactory(new PropertyValueFactory<>("doctorSchedule"));
        
        
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

    @FXML
    private void insert(ActionEvent event) {
        
        int row = -1;
                String DoctorsID = doctorsIDTF.getText();
                String DoctorsName = doctorsNameTF.getText();
                String DoctersDesig = doctorsDesigTF.getText();
                String DoctorsContact = doctorsContactTF.getText();
                String DoctorSchedule = doctorsScheduleTF.getText();
                  
        
        String sql = "INSERT INTO DOCTORLIST (doctorsID, doctorsName, doctersDesig, doctorsContact,doctorSchedule) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = co.prepareStatement(sql);

            ps.setString(1, DoctorsID);
            ps.setString(2, DoctorsName);
            ps.setString(3, DoctersDesig);
            ps.setString(4, DoctorsContact);
            ps.setString(5, DoctorSchedule);
           
            
            row = ps.executeUpdate();
            JOptionPane.showMessageDialog(null, row + " rows added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Insertion Failed", "Error", JOptionPane.ERROR_MESSAGE);
        }
        showAll();
    }

    @FXML
    private void b2h(ActionEvent event) {
    }

    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void update(ActionEvent event) {
        
        int row = -1;
             String DoctorsID = doctorsIDTF.getText();
                String DoctorsName = doctorsNameTF.getText();
                String DoctersDesig = doctorsDesigTF.getText();
                String DoctorsContact = doctorsContactTF.getText();
                String DoctorSchedule = doctorsScheduleTF.getText();   

        
        String sql = "UPDATE DOCTORLIST SET DOCTORSNAME=?, DoctersDesig=? , DoctorsContact=?, DoctorSchedule=? WHERE DoctorsID = ?";
        try {
            PreparedStatement ps = co.prepareStatement(sql);
            
            
            ps.setString(1, DoctorsName);
            ps.setString(2, DoctersDesig);
            ps.setString(3, DoctorsContact);
            ps.setString(4, DoctorSchedule);
            ps.setString(5, DoctorsID);
            

            
            row = ps.executeUpdate();
            JOptionPane.showMessageDialog(null, row+" row updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            showAll();
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Update Failed", "Error", JOptionPane.ERROR_MESSAGE);
        }
         showAll();
    }
    
    

    @FXML
    private void delete(ActionEvent event) {
        
        int row = -1;
         String DoctorsID = doctorsIDTF.getText();

        String sql = "DELETE FROM DOCTORLIST WHERE DoctorsID = ?";
        
        try {
            PreparedStatement ps = co.prepareStatement(sql);
            ps.setString(1, DoctorsID);
            row = ps.executeUpdate();
            JOptionPane.showMessageDialog(null, row+" row deleted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            showAll();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Deletion Failed", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}

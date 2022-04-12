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
public class ClassicControl_databaseController implements Initializable {

    Connection co;
    
    @FXML
    private TextField membersIDTF;
    @FXML
    private TextField membersnameTF;
    @FXML
    private TextField membersdesigTF;
    @FXML
    private Button insert;
    @FXML
    private Button update;
    @FXML
    private Button delete;
    @FXML
    private TableView<members> membersTable;
    @FXML
    private TableColumn<members, String> membersID;
    @FXML
    private TableColumn<members, String> membersname;
    @FXML
    private TableColumn<members, String> membersdesig;
    @FXML
    private TableColumn<members, String> memberscontact;
    @FXML
    private TableColumn<members, String> memberschedule;
    @FXML
    private TextField memberscontactTF;
    @FXML
    private TextField memberscheduleTF;
    

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

        membersID.setCellValueFactory(new PropertyValueFactory<>("membersID"));
        membersname.setCellValueFactory(new PropertyValueFactory<>("membersname"));
        membersdesig.setCellValueFactory(new PropertyValueFactory<>("membersdesig"));
        memberscontact.setCellValueFactory(new PropertyValueFactory<>("memberscontact"));
        memberschedule.setCellValueFactory(new PropertyValueFactory<>("memberschedule"));
        
        
    }  
     private void showAll() {

        String sql = "SELECT * FROM MEMBERSTABLE";
        try {
            Statement st = co.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //moon.setModel(DbUtils.resultSetToTableModel(rs));
           
            ObservableList<members> results = FXCollections.observableArrayList();

            //iterating resultSet to add the values to ObservableList
            while (rs.next()) {
                String MembersID = rs.getString("membersID");
                String Membersname = rs.getString("membersname");
                String Membersdesig = rs.getString("membersdesig");
                String Memberscontact = rs.getString("memberscontact");
                String Memberschedule = rs.getString("memberschedule");
                
                
           
                
                members obj = new members(MembersID,Membersname,Membersdesig,Memberscontact,Memberschedule);
                results.add(obj);
                
            }
            
            membersTable.getItems().setAll(results);
            

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data fetching failed", "Error", JOptionPane.ERROR_MESSAGE);
        }

    
    }
     

    @FXML
    private void insert(ActionEvent event) {
        
        int row = -1;
                String MembersID = membersIDTF.getText();
                String Membersname = membersnameTF.getText();
                String Membersdesig = membersdesigTF.getText();
                String Memberscontact = memberscontactTF.getText();
                String Memberschedule = memberscheduleTF.getText();
                  
        
        String sql = "INSERT INTO MEMBERSTABLE (MembersID, Membersname, Membersdesig, Memberscontact,Memberschedule) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = co.prepareStatement(sql);

            ps.setString(1, MembersID);
            ps.setString(2, Membersname);
            ps.setString(3, Membersdesig);
            ps.setString(4, Memberscontact);
            ps.setString(5, Memberschedule);
           
            
            row = ps.executeUpdate();
            JOptionPane.showMessageDialog(null, row + " rows added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Insertion Failed", "Error", JOptionPane.ERROR_MESSAGE);
        }
        showAll();
    }

    @FXML
    private void update(ActionEvent event) {
        
        int row = -1;
             String MembersID = membersIDTF.getText();
                String Membersname = membersnameTF.getText();
                String Membersdesig = membersdesigTF.getText();
                String Memberscontact = memberscontactTF.getText();
                String Memberschedule = memberscheduleTF.getText();   

        
        String sql = "UPDATE MEMBERSTABLE SET Membersname=?, Membersdesig=? , Memberscontact=?, Memberschedule=? WHERE MembersID = ?";
        try {
            PreparedStatement ps = co.prepareStatement(sql);
            
            
            
            ps.setString(1, Membersname);
            ps.setString(2, Membersdesig);
            ps.setString(3, Memberscontact);
            ps.setString(4, Memberschedule);
            ps.setString(5, MembersID);

            
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
        String MembersID = membersIDTF.getText();

        String sql = "DELETE FROM MEMBERSTABLE WHERE MembersID = ?";
        
        try {
            PreparedStatement ps = co.prepareStatement(sql);
            ps.setString(1, MembersID);
            row = ps.executeUpdate();
            JOptionPane.showMessageDialog(null, row+" row deleted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            showAll();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Deletion Failed", "Error", JOptionPane.ERROR_MESSAGE);
        }
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

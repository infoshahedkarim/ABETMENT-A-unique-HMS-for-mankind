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
public class InternalServicesController implements Initializable {

    Connection co;
    
    @FXML
    private TextField servicesnameTF;
    @FXML
    private TextField netcostTF;
    @FXML
    private Button insert;
    @FXML
    private Button update;
    @FXML
    private Button delete;
    @FXML
    private TableView<serviceList> serviceTable;
    @FXML
    private TableColumn<serviceList, String> servicesname;
    @FXML
    private TableColumn<serviceList, String> netcost;

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

        servicesname.setCellValueFactory(new PropertyValueFactory<>("servicesname"));
        netcost.setCellValueFactory(new PropertyValueFactory<>("netcost"));
     
    }  
    private void showAll() {

        String sql = "SELECT * FROM SERVICELIST";
        try {
            Statement st = co.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //moon.setModel(DbUtils.resultSetToTableModel(rs));
           
            ObservableList<serviceList> results = FXCollections.observableArrayList();

            //iterating resultSet to add the values to ObservableList
            while (rs.next()) {
                String Servicesname = rs.getString("servicesname");
                String Netcost = rs.getString("netcost");
         
                serviceList obj = new serviceList(Servicesname,Netcost);
                results.add(obj);
                
            }
            
            serviceTable.getItems().setAll(results);
            

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data fetching failed", "Error", JOptionPane.ERROR_MESSAGE);
        }

    
     
    }    

    @FXML
    private void insert(ActionEvent event) {
        
        int row = -1;
                String Servicesname = servicesnameTF.getText();
                String Netcost = netcostTF.getText();
               
                  
        
        String sql = "INSERT INTO SERVICELIST (Servicesname, Netcost) VALUES (?, ?)";
        try {
            PreparedStatement ps = co.prepareStatement(sql);

            ps.setString(1, Servicesname);
            ps.setString(2, Netcost);
            
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
       String Servicesname = servicesnameTF.getText();
                String Netcost = netcostTF.getText();
               
        String sql = "UPDATE SERVICELIST SET Netcost=? WHERE Servicesname = ?";
        try {
            PreparedStatement ps = co.prepareStatement(sql);
           
            ps.setString(1, Netcost);
             ps.setString(2, Servicesname);
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
        String Servicesname = servicesnameTF.getText();

        String sql = "DELETE FROM SERVICELIST WHERE Servicesname = ?";
        
        try {
            PreparedStatement ps = co.prepareStatement(sql);
            ps.setString(1, Servicesname);
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

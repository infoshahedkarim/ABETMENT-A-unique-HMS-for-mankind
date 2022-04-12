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
public class Medi_dbController implements Initializable {

    Connection co;
    @FXML
    private TextField medinameTF;
    @FXML
    private TextField medipriceTF;
    @FXML
    private Button insert;
    @FXML
    private Button update;
    @FXML
    private Button delete;
    @FXML
    private TableView<mediList> mediTable;
    @FXML
    private TableColumn<mediList, String> mediname;
    @FXML
    private TableColumn<mediList, String> mediprice;

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

        mediname.setCellValueFactory(new PropertyValueFactory<>("mediname"));
        mediprice.setCellValueFactory(new PropertyValueFactory<>("mediprice"));
     
    }  
    private void showAll() {

        String sql = "SELECT * FROM MEDILIST";
        try {
            Statement st = co.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //moon.setModel(DbUtils.resultSetToTableModel(rs));
           
            ObservableList<mediList> results = FXCollections.observableArrayList();

            //iterating resultSet to add the values to ObservableList
            while (rs.next()) {
                String Mediname = rs.getString("mediname");
                String Mediprice = rs.getString("mediprice");
         
                mediList obj = new mediList(Mediname,Mediprice);
                results.add(obj);
                
            }
            
            mediTable.getItems().setAll(results);
            

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data fetching failed", "Error", JOptionPane.ERROR_MESSAGE);
        }

    
    }    

    @FXML
    private void insert(ActionEvent event) {
        
        
        int row = -1;
                String Mediname = medinameTF.getText();
                String Mediprice = medipriceTF.getText();
               
                  
        
        String sql = "INSERT INTO MEDILIST (Mediname, Mediprice) VALUES (?, ?)";
        try {
            PreparedStatement ps = co.prepareStatement(sql);

            ps.setString(1, Mediname);
            ps.setString(2, Mediprice);
            
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
        String Mediname = medinameTF.getText();
                String Mediprice = medipriceTF.getText();
                
        String sql = "UPDATE MEDILIST SET Mediprice=? WHERE Mediname = ?";
        try {
            PreparedStatement ps = co.prepareStatement(sql);
            
            ps.setString(1, Mediprice);
            ps.setString(2, Mediname);
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
         String Mediname = medinameTF.getText();

        String sql = "DELETE FROM MEDILIST WHERE Mediname = ?";
        
        try {
            PreparedStatement ps = co.prepareStatement(sql);
            ps.setString(1, Mediname);
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

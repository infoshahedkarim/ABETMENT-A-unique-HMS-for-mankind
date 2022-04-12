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
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Nafis
 */
public class ForgetpassController implements Initializable {

    Connection co;
    @FXML
    private TextField usernameTF;
    @FXML
    private TextField idTF;
    @FXML
    private TextField passwordTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            
          co = DriverManager.getConnection("jdbc:derby://localhost:1527/abetment", "shahed", "1234");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database is not connected", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    @FXML
    private void update(ActionEvent event) {
         int row = -1;
         String ID = idTF.getText();
        String USERNAME = usernameTF.getText();
        String PASSWORD = passwordTF.getText();
        String sql = "UPDATE DATABASELOGIN SET USERNAME=?, PASSWORD=? WHERE ID = ?";
        try {
            PreparedStatement ps = co.prepareStatement(sql);
           
            
            ps.setString(1, USERNAME);
             ps.setString(2, PASSWORD);
              ps.setString(3, ID);
            
            row = ps.executeUpdate();
            JOptionPane.showMessageDialog(null, row+" password updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, " password Update Failed", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    private void b2h(ActionEvent event) {
        
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/abetment/DatabaseLogin.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MainpageController.class.getName()).log(Level.SEVERE, null, ex);
        }
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
           Image icon=new Image("/UI/icon.png");
            stage.getIcons().add(icon);
            stage.setTitle("Abetment : Database Login");
            stage.setScene(scene);
            stage.show();
    }
    
}

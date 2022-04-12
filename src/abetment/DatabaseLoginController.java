/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abetment;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Nafis
 */
public class DatabaseLoginController implements Initializable {

    Connection co;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

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
    }    
        
    @FXML
    private void signin(ActionEvent event) throws IOException {
        
         String pass = password.getText();
        String user = username.getText();

        try {
           // co = DriverManager.getConnection("jdbc:derby://localhost:1527/abetment", "shahed", "1234");

            String sql = "SELECT * FROM DATABASELOGIN";
            Statement st = co.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String User = rs.getString(2);
                String Pass = rs.getString(3);
                if (User.equals(user) && Pass.equals(pass)) {
                    //JOptionPane.showMessageDialog(null, "Login successful", "Success", JOptionPane.INFORMATION_MESSAGE);

                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("mainpage.fxml"));
                        Parent root;
                        root = loader.load();
                        Scene scene = new Scene(root);
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        stage.setScene(scene);
                        stage.setTitle("Abetment: Multiverse");
                        stage.show();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Insertion Failed", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                }

            }

        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Insertion Failed!!", "Error", JOptionPane.ERROR_MESSAGE);
            
        }

        password.clear();
        username.clear();
    }

//    
    

    @FXML
    private void forgetpass(ActionEvent event) {
        
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/database/forgetpass.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MainpageController.class.getName()).log(Level.SEVERE, null, ex);
        }
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
           Image icon=new Image("/UI/icon.png");
            stage.getIcons().add(icon);
            stage.setTitle("Abetment : Reset Password");
            stage.setScene(scene);
            stage.show();
        
    }

    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }
    
}

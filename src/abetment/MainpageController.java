/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abetment;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Al Throx
 */
public class MainpageController implements Initializable {

    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("mainpage.fxml"));
        Scene scene = new Scene(root);
        Image icon=new Image("/UI/icon.png");
        //img icon or favicon
        stage.getIcons().add(icon);
        stage.setTitle("Abetment : Multiverse");
        stage.setScene(scene);
        stage.show();
    }
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void rp(ActionEvent event) {
        
            Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("login.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MainpageController.class.getName()).log(Level.SEVERE, null, ex);
        }
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            Image icon=new Image("/UI/icon.png");
            stage.getIcons().add(icon);
            stage.setTitle("Abetment : Login");
            stage.setScene(scene);
            stage.show();
           
            
    }
    @FXML
    private void cc(ActionEvent event) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("login.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MainpageController.class.getName()).log(Level.SEVERE, null, ex);
        }
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
           Image icon=new Image("/UI/icon.png");
            stage.getIcons().add(icon);
            stage.setTitle("Abetment : Login");
            stage.setScene(scene);
            stage.show();
            
    }

    @FXML
    private void dp(ActionEvent event) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("login.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MainpageController.class.getName()).log(Level.SEVERE, null, ex);
        }
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
           Image icon=new Image("/UI/icon.png");
            stage.getIcons().add(icon);
            stage.setTitle("Abetment : Login");
            stage.setScene(scene);
            stage.show();
            
    }

    @FXML
    private void mm(ActionEvent event) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("login.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MainpageController.class.getName()).log(Level.SEVERE, null, ex);
        }
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            Image icon=new Image("/UI/icon.png");
            stage.getIcons().add(icon);
            stage.setTitle("Abetment : Login");
            stage.setScene(scene);
            stage.show();
            
    }

    @FXML
    private void bill(ActionEvent event) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("login.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MainpageController.class.getName()).log(Level.SEVERE, null, ex);
        }
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            Image icon=new Image("/UI/icon.png");
            stage.getIcons().add(icon);
            stage.setTitle("Abetment : Login ");
            stage.setScene(scene);
            stage.show();
            
    }

    @FXML
    private void admin(ActionEvent event) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("login.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MainpageController.class.getName()).log(Level.SEVERE, null, ex);
        }
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            Image icon=new Image("/UI/icon.png");
            stage.getIcons().add(icon);
            stage.setTitle("Abetment:Login Page");
            stage.setScene(scene);
            stage.show();
            
    }

    @FXML
    private void pharma(ActionEvent event) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("login.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MainpageController.class.getName()).log(Level.SEVERE, null, ex);
        }
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            Image icon=new Image("/UI/icon.png");
            stage.getIcons().add(icon);
            stage.setTitle("Abetment:Login Page");
            stage.setScene(scene);
            stage.show();
           
    }

    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }    
}

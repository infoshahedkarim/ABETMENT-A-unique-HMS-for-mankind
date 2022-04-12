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

/**
 * FXML Controller class
 *
 * @author Al Throx
 */
public class AdministrativeController implements Initializable {

    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Administrative.fxml"));
        Scene scene = new Scene(root);
        Image icon=new Image("/UI/icon.png");
        //img icon or favicon
        stage.getIcons().add(icon);
        stage.setTitle("Abetment : Admin");
        stage.setScene(scene);
        stage.show();
    }
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    void ClassicControl(ActionEvent event) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/database/ClassicControl_database.fxml"));
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
    void GeneralPatients(ActionEvent event) {
        
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/database/general_patient_Admin.fxml"));
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
    void InternalServices(ActionEvent event) {
        
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/database/InternalServices.fxml"));
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
    void dL(ActionEvent event) {
        
        
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/database/doctorList_Admin.fxml"));
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
    void medi_bd(ActionEvent event) {
        
         Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/database/medi_db.fxml"));
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
    private void logout(ActionEvent event) {
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
    private void b2h(ActionEvent event) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("mainpage.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MainpageController.class.getName()).log(Level.SEVERE, null, ex);
        }
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            Image icon=new Image("/UI/icon.png");
            stage.getIcons().add(icon);
            stage.setTitle("Abetment : Multiverse");
            stage.setScene(scene);
            stage.show();
    }

    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class Social_MediaController implements Initializable {

    @FXML
    private Button twitter;
    @FXML
    private Circle twitterimg;
    @FXML
    private Circle facebookimg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       
           Image Twitter_Img = new Image("/image/twitter.png");
   
           twitterimg.setFill(new ImagePattern(Twitter_Img));
            
         
           Image Facebook_Img = new Image("/image/facebook.png");
            facebookimg.setFill(new ImagePattern(Facebook_Img));

    }    

    @FXML
    private void Twitter_Account(MouseEvent event) {
        
           try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/pi_desktop_app/TwitterFxml.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {

        }
   
    }

    @FXML
    private void Facebook_Account(MouseEvent event) {
           try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/pi_desktop_app/Facebook.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {

        }
   
    }
    
}

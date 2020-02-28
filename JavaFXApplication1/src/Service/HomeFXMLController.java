/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class HomeFXMLController implements Initializable {

    @FXML
    private BorderPane BorderPane;
    @FXML
    private Button bot;
    @FXML
    private Button bot1;
    @FXML
    private Button bot2;
    @FXML
    private Button bot3;
    @FXML
    private Button bot4;
    @FXML
    private Button bot5;
    @FXML
    private Button bot6;
    @FXML
    private Text txt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       String type=null;
       String type1=null;
        String ad="Admin";
        String agf="AgentFinancier";
        String agt="AgentTransport";
        String agg="AgentGestion";
        type=FXMLIdentificationController.usr_type;
        type1=FXMLInscriptionController.usr_type;
        if(type.equals(ad) || type1==ad)
        {
            bot2.setVisible(false);
            bot3.setVisible(false);
            bot4.setVisible(false);
            bot5.setVisible(false);
        }
        if(type.equals(agf) || type1==agf)
        {
            bot.setVisible(false);
            bot1.setVisible(false);
            bot2.setVisible(false);
            bot3.setVisible(false);
            bot6.setVisible(false);
            bot5.setVisible(false);
        }
        if(type.equals(agt) || type1==agt)
        {
            bot.setVisible(false);
            bot1.setVisible(false);
            bot2.setVisible(false);
            bot3.setVisible(false);
            bot6.setVisible(false);
            bot4.setVisible(false);
        } 
        if(type.equals(agg) || type1==agg)
        {
            bot.setVisible(false);
            bot1.setVisible(false);
            bot5.setVisible(false);
            bot6.setVisible(false);
            bot4.setVisible(false);
        }   
        
        
        // TODO
    }    
@FXML
    private void User_Management(MouseEvent event) throws IOException {
        LoadUI("User_ManagementFXML");
    }

    @FXML
    private void Worker_management(MouseEvent event) throws IOException {
        LoadUI("Worker_ManagementFXML");
    }

    @FXML
    private void Stock_management(MouseEvent event) throws IOException {
        LoadUI("Stock_ManagementFXML");
    }

    @FXML
    private void Product_management(MouseEvent event) throws IOException {
        LoadUI("Product_ManagementFXML");
    }

    @FXML
    private void Financial_management(MouseEvent event) throws IOException {
        LoadUI("Financial_ManagementFXML");
    }

    @FXML
    private void Transport_management(MouseEvent event) throws IOException {
        LoadUI("Transport_ManagementFXML");
    }

    @FXML
    private void Complaint_management(MouseEvent event) throws IOException {
        LoadUI("Complaint_ManagementFXML");
    }
    
    private void LoadUI(String ui) throws IOException {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(ui + ".fxml"));
        } catch (IOException ex) {

            java.util.logging.Logger.getLogger(HomeFXMLController.class.getName()).log(Level.SEVERE, null, ex);

        }
        BorderPane.setCenter(root);
    }

    @FXML
    private void retour(MouseEvent event) {
    try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
                           Parent root1 = (Parent) fxmlLoader.load();
                           Stage stage = new Stage();
                           stage.initStyle(StageStyle.UNDECORATED);
                           stage.setScene(new Scene(root1));  
                           stage.show();
                           Stage stage1 = (Stage) txt.getScene().getWindow(); 
                           stage1.close();
                           } catch (IOException ex) {
                                Logger.getLogger(FXMLInscriptionController.class.getName()).log(Level.SEVERE, null, ex);
                            }
    }

}

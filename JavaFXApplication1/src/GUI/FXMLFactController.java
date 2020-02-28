/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.AWTException;
import java.awt.TrayIcon;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
//import static java.util.Collections.list;
//import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.controlsfx.control.Notifications;
import Service.AchatService;

/**
 * FXML Controller class
 *
 * @author bazinfo
 */
public class FXMLFactController implements Initializable {
     ObservableList list = FXCollections.observableArrayList();
    ObservableList filteredData = FXCollections.observableArrayList();
    @FXML
    private BorderPane BorderPane;
    
    @FXML
    private TableView<?> tableAchat;
    private TableColumn<?, ?> Tableid;
    @FXML
    private TableColumn<?, ?> Table_cname;
    @FXML
    private TableColumn<?, ?> Table_cadresse;
    @FXML
    private TableColumn<?, ?> Table_quantite;
    @FXML
    private TableColumn<?, ?> Table_etat;
    @FXML
    private Button bt1;
    @FXML
    private Button gest;
    @FXML
    private Button ft;
    @FXML
    private AnchorPane panee;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
   
      LoadData();
        //item.getSelectionModel().selectLast();
               AchatService   ms =  new AchatService();
               
               ArrayList Liste = (ArrayList) ms.displayAll();
              
               ObservableList obs =FXCollections.observableArrayList(Liste);
               tableAchat.setItems(obs);
                //Tableid.setCellValueFactory(new PropertyValueFactory<>("id_product"));
                Table_cname.setCellValueFactory(new PropertyValueFactory<>("client_name"));   
               Table_cadresse.setCellValueFactory(new PropertyValueFactory<>("client_address"));
                Table_quantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
                Table_etat.setCellValueFactory(new PropertyValueFactory<>("etat"));

              Notifications notificationBuilder =Notifications.create()
               .title("vous avez  demande de sponsoring ")
               .text("saved to home/downloads")
               .graphic(null)
               .hideAfter(javafx.util.Duration.seconds(8.0))
               .position(Pos.TOP_LEFT)
               .onAction(new EventHandler<ActionEvent>(){
               @Override
               public void handle(ActionEvent event){
               System.out.println("clicked on me :p");
               }
              }
               );
              
                 // Notification.sendNotification("you have "+5+" demande de sponsoring ","you can accept or not ",TrayIcon.MessageType.INFO);
    }    
    

        private void LoadData(){ 
        list.removeAll();
        String a = "id_product";
        String b = "client_name";
        String c = "client_adresse";
        String d= "quantite";
        String e= "etat";
        list.addAll(a,b,c,d,e);
       tableAchat.getItems().addAll(list);
        }
      
 

   

    @FXML
    private void factt(MouseEvent event) throws IOException {
        Parent root  ;
        try {
        root = FXMLLoader.load(getClass().getResource("FXMLAfficheFacture.fxml"));
        panee.getChildren().setAll(root);      
        }
        catch(Exception e)
        {
            System.out.println(e);
        }         
    }


    @FXML
    private void gestionn(MouseEvent event) throws IOException {
                
                try {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLGestionFacture.fxml"));
        panee.getChildren().setAll(root);      
        }
        catch(Exception e)
        {
            System.out.println(e);
        }         
         
    }

    @FXML
    private void facttransp(MouseEvent event) throws IOException {    
                try {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLFactTransport.fxml"));
        panee.getChildren().setAll(root);      
        }
        catch(Exception e)
        {
            System.out.println(e);
        }         
    }
    }

  

 


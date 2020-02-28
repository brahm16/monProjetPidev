/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

//import doryan.windowsnotificationapi.fr.Notification;
import Entity.Facture;
import java.awt.AWTException;
import java.awt.TrayIcon;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
//import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import Service.AchatService;
import Service.FactureService;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author bazinfo
 */
public class FXMLGestionFactureController implements Initializable {
    ObservableList list = FXCollections.observableArrayList();
    ObservableList filteredData = FXCollections.observableArrayList();
   
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
    private Button bot61;
    @FXML
    private Text txt;
    @FXML
    private TableView<?> tableAchat;
    @FXML
    private TableColumn<?, ?> ref;
    @FXML
    private TableColumn<?, ?> client_name;
    @FXML
    private TableColumn<?, ?> client_type;
    @FXML
    private TableColumn<?, ?> type_facture;
    @FXML
    private TableColumn<?, ?> statut_facture;
    @FXML
    private TableColumn<?, ?> totalHT;
    @FXML
    private TableColumn<?, ?> totalTTC;
    @FXML
    private TableColumn<?, ?> echeance;
    @FXML
    private TableColumn<?, ?> delivery;
    
    @FXML
    private Button modif;
    @FXML
    private TextField recherche;
    @FXML
    private Button affichier;
    @FXML
    private Button mood;
    @FXML
    private ChoiceBox<?> item;
    @FXML
    private Button bbbb;
    @FXML
    private Button trie_bt;
    @FXML
    private TableColumn<Facture, String> date;
    @FXML
    private DatePicker dater;
    @FXML
    private Button s1;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
               
        
   LoadData();
   item.getSelectionModel().selectLast();
        //item.getSelectionModel().selectLast();
               FactureService   ms =  new FactureService();
               
               ArrayList Liste = (ArrayList) ms.displayAll();
               ObservableList obs =FXCollections.observableArrayList(Liste);
               tableAchat.setItems(obs);
                ref.setCellValueFactory(new PropertyValueFactory<>("reference"));
                client_name.setCellValueFactory(new PropertyValueFactory<>("client_name"));   
               client_type.setCellValueFactory(new PropertyValueFactory<>("client_type"));
                type_facture.setCellValueFactory(new PropertyValueFactory<>("type_facture"));
                statut_facture.setCellValueFactory(new PropertyValueFactory<>("statut_facture"));
                totalHT.setCellValueFactory(new PropertyValueFactory<>("totalHT"));   
               totalTTC.setCellValueFactory(new PropertyValueFactory<>("totalTTC"));
                echeance.setCellValueFactory(new PropertyValueFactory<>("echeance"));
                delivery.setCellValueFactory(new PropertyValueFactory<>("delivery"));
                date.setCellValueFactory(new PropertyValueFactory<>("DateFact"));
                
                    System.out.print(date);
             FactureService   ms2 =  new FactureService();
         
        
 ArrayList Liste4 = (ArrayList) ms2.displayAll();
         //try {
          //  Notification.sendNotification("you have "+Liste4.size()+" demande de sponsoring ","you can accept or not ",TrayIcon.MessageType.INFO);
      //  } catch (Exception ex) {
      //      System.out.print("hhhh");
            //Logger.getLogger(GestionFactureController.class.getName()).log(Level.SEVERE, null, ex);
      ///  } catch (Exception ex) {
          //  System.out.print("khalil meet");
            //Logger.getLogger(GestionFactureController.class.getName()).log(Level.SEVERE, null, ex);
       // }
       /*  Notifications notificationBuilder =Notifications.create()
               .title("vous avez  demande de sponsoring ")
              .text("saved to home/downloads")
                 .graphic(null)
               .hideAfter(Duration.Seconds(8))
               .position(Pos.TOP_LEFT)
               .onAction(new EventHandler<ActionEvent>(){
               @Override
               public void handle(ActionEvent event){
               System.out.println("clicked on me :p");
               }
               }
               );
       notificationBuilder.darkStyle();
       notificationBuilder.showConfirm();
       */               
        // TODO
    }    
    

        private void LoadData(){ 
        list.removeAll();
        String a = "reference";
        String b = "client_name";
        String c= "type_facture";
        
        list.addAll(a,b,c);
        item.getItems().addAll(list);
        }
       

    @FXML
    private void modif(MouseEvent event) throws IOException {
       
        
        FactureService   ms =  new FactureService();
        Facture r = (Facture)(tableAchat.getSelectionModel().getSelectedItem());
                 System.out.println(r);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation du  suppression");
        alert.setHeaderText("Confirmation de supprission");
        alert.setContentText("étes-vous Sur ?"+r.getReference());
//System.out.print(r.getId_facture());
Optional<ButtonType> result = alert.showAndWait();
if (result.get() == ButtonType.OK){
    //ms.delete(r.getId_facture());
    ms.delete1(r.getReference());
     Parent page = FXMLLoader.load(getClass().getResource("FXMLGestionFacture.fxml"));
                Scene scene = new Scene(page);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
               stage.setTitle("Liste Achat");
                stage.setScene(scene);
                stage.show();
   
} else {
    // ... user chose CANCEL or closed the dialog
}
                 
    }

    @FXML
    private void retour(MouseEvent event) throws IOException {
              Parent page = FXMLLoader.load(getClass().getResource("FXMLFact.fxml"));
                Scene scene = new Scene(page);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
               stage.setTitle("facture");
                stage.setScene(scene);
                stage.show();
         
    
    }
 

    @FXML
    private void update(MouseEvent event) throws IOException {
         Facture r = (Facture)(tableAchat.getSelectionModel().getSelectedItem());
         Parent page = FXMLLoader.load(getClass().getResource("FXMLupdateFact.fxml"));
                Scene scene = new Scene(page);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
               stage.setTitle("Facture");
                stage.setScene(scene);
                stage.show();
    
      
    }
    
    
    @FXML
    private void affiche(MouseEvent event) throws IOException {
         Facture r = (Facture)(tableAchat.getSelectionModel().getSelectedItem());
         Parent page = FXMLLoader.load(getClass().getResource("FXMLAfficheFacture.fxml"));
                Scene scene = new Scene(page);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
               stage.setTitle("Liste Achat");
                stage.setScene(scene);
                stage.show();
    
    }   
   



    @FXML
    private void rechecher(MouseEvent event) {
         if ( item.getSelectionModel().getSelectedItem() == "reference"){
                             FactureService   ms =  new FactureService();
                             
             ArrayList filteredData = (ArrayList) ms.afficherByreference(recherche.getText());
               ObservableList obs =FXCollections.observableArrayList(filteredData);
               tableAchat.setItems(obs);
                 ref.setCellValueFactory(new PropertyValueFactory<>("reference"));
                client_name.setCellValueFactory(new PropertyValueFactory<>("client_name"));   
               client_type.setCellValueFactory(new PropertyValueFactory<>("client_type"));
                type_facture.setCellValueFactory(new PropertyValueFactory<>("type_facture"));
                statut_facture.setCellValueFactory(new PropertyValueFactory<>("statut_facture"));
                totalHT.setCellValueFactory(new PropertyValueFactory<>("totalHT"));   
               totalTTC.setCellValueFactory(new PropertyValueFactory<>("totalTTC"));
                echeance.setCellValueFactory(new PropertyValueFactory<>("echeance"));
                delivery.setCellValueFactory(new PropertyValueFactory<>("delivery"));
                
      }

      if ( item.getSelectionModel().getSelectedItem() == "client_name"){
                             FactureService   ms =  new FactureService();
               ArrayList filteredData = (ArrayList) ms.afficherByClient_name(recherche.getText());
             ObservableList obs =FXCollections.observableArrayList(filteredData);
               tableAchat.setItems(obs);
                 ref.setCellValueFactory(new PropertyValueFactory<>("reference"));
                client_name.setCellValueFactory(new PropertyValueFactory<>("client_name"));   
               client_type.setCellValueFactory(new PropertyValueFactory<>("client_type"));
                type_facture.setCellValueFactory(new PropertyValueFactory<>("type_facture"));
                statut_facture.setCellValueFactory(new PropertyValueFactory<>("statut_facture"));
                totalHT.setCellValueFactory(new PropertyValueFactory<>("totalHT"));   
               totalTTC.setCellValueFactory(new PropertyValueFactory<>("totalTTC"));
                echeance.setCellValueFactory(new PropertyValueFactory<>("echeance"));
                delivery.setCellValueFactory(new PropertyValueFactory<>("delivery"));
    }
    }

    @FXML
    private void trieParDate(MouseEvent event) {
         
        
         String a = dater.getValue().toString();
 FactureService   ms =  new FactureService();
               ArrayList Liste = (ArrayList) ms.afficherByDate(a);
               ObservableList obs =FXCollections.observableArrayList(Liste);
                 tableAchat.setItems(obs);
                 ref.setCellValueFactory(new PropertyValueFactory<>("reference"));
                client_name.setCellValueFactory(new PropertyValueFactory<>("client_name"));   
               client_type.setCellValueFactory(new PropertyValueFactory<>("client_type"));
                type_facture.setCellValueFactory(new PropertyValueFactory<>("type_facture"));
                statut_facture.setCellValueFactory(new PropertyValueFactory<>("statut_facture"));
                totalHT.setCellValueFactory(new PropertyValueFactory<>("totalHT"));   
               totalTTC.setCellValueFactory(new PropertyValueFactory<>("totalTTC"));
                echeance.setCellValueFactory(new PropertyValueFactory<>("echeance"));
                delivery.setCellValueFactory(new PropertyValueFactory<>("delivery"));
                date.setCellValueFactory(new PropertyValueFactory<>("DateFact"));
    }

    @FXML
    private void createe_fact(MouseEvent event) throws IOException {
             Parent page = FXMLLoader.load(getClass().getResource("FXMLCreateFact.fxml"));
                Scene scene = new Scene(page);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
               stage.setTitle("Liste Facture");
                stage.setScene(scene);
                stage.show();
    }
    }


  

 


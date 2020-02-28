/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Facture;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import Service.FactureService;

/**
 * FXML Controller class
 *
 * @author bazinfo
 */
public class FXMLupdateFactController implements Initializable {
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
    private Text retour;
    @FXML
    private Button update;
    @FXML
    private TextField ch2;
    @FXML
    private TextField ch3;
    @FXML
    private TextField ch4;
    @FXML
    private TextField ch5;
    @FXML
    private TextField ch6;
    @FXML
    private TextField ch7;
    @FXML
    private TextField ch8;
    @FXML
    private TextField ch9;
    @FXML
    private TextField ch1;
    @FXML
    private Label idd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         FactureService   ms =  new FactureService();
              Facture   E = (Facture) ms.AffichierFacture(3);
              System.out.print(E.toString());
              String d = String.valueOf (E.getId_facture());
              idd.setText(d);
              ch1.setText(E.getReference());
              ch2.setText(E.getClient_name());
              ch3.setText(E.getClient_type());
              ch4.setText(E.getType_facture()); 
              ch5.setText(E.getStatut_facture());
              String a = String.valueOf (E.getTotalHT());
              String b = String.valueOf (E.getTotalTTC());
              String c = String.valueOf (E.getDelivery());
              
              ch6.setText(a);
              ch7.setText(b);
              ch8.setText(E.getEcheance());
             ch9.setText(c);
    }    

    @FXML
    private void update(MouseEvent event) {
    String w=idd.getText().toString();  
    String z=ch1.getText().toString();
    String a=ch2.getText().toString();
    String b=ch3.getText().toString();
    String c=ch4.getText().toString();
    String d=ch5.getText().toString();
    String e=ch6.getText().toString();
    String f=ch7.getText().toString();
    String j=ch8.getText().toString();
    String h=ch9.getText().toString();
    int i = Integer.parseInt(w);
    int di = Integer.parseInt(h);
    
    float f1 = Float.parseFloat(e);
    float f2 = Float.parseFloat(f);
    
   int ee = 3 ;
    Facture F = new Facture (i,z,ee,a,b,c,d,f1,f2,j,di);
    System.out.print(F.toString());
    FactureService   ms =  new FactureService();
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation du  modification");
        alert.setHeaderText("Confirmation de modification");
        alert.setContentText("étes-vous Sur ?");

Optional<ButtonType> result = alert.showAndWait();
if (result.get() == ButtonType.OK){
    ms.update(F);
    System.out.print("Confirmation de modification");
   
} else {
    // ... user chose CANCEL or closed the dialog
}
    }

    @FXML
    private void retour(MouseEvent event) throws IOException {
    Parent page = FXMLLoader.load(getClass().getResource("FXMLGestionFacture.fxml"));
                Scene scene = new Scene(page);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
               stage.setTitle("Liste Achat");
                stage.setScene(scene);
                stage.show();
    }
    
}

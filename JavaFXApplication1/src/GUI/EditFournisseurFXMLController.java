/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import Entity.Fournisseur;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import Service.FournisseurService;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Ibrahim
 */
public class EditFournisseurFXMLController implements Initializable {
    
    @FXML
    private JFXTextField txtLastName;
    @FXML
    private JFXTextField txtFirstName;
    @FXML
    private JFXTextField txtPhoneNumber;
    @FXML
    private JFXComboBox cmbTypeProduct;
    @FXML
    private JFXTextField txtEmail;
    @FXML
    private JFXTextField txtAddress;
    @FXML
    private JFXButton btnEdit;
    
   public Fournisseur f=MainFournisseursController.fo;
    @FXML
    private AnchorPane AnchorPane;

    
    @FXML
    public void handleEdit(ActionEvent e){
         FournisseurService fournisseurService=new FournisseurService();
        if((verifEmail(txtEmail.getText()))&&(validatePhoneNumber(txtPhoneNumber.getText()))&&(txtFirstName.getText().length()>3)&&(txtLastName.getText().length()>3)&&(txtAddress.getText().length()>8)){
           Fournisseur f1=new Fournisseur(f.getId_fournisseur(),txtFirstName.getText(),txtLastName.getText(),txtPhoneNumber.getText(),cmbTypeProduct.getValue().toString(),txtAddress.getText(),txtEmail.getText());
        fournisseurService.update(f1);
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Fournisseur update avec success");
            a.show();
        }
        else{
           Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Cordonnes invalid");
            a.show();  
        }
        
    }
    public void getData(){
    }
     public boolean verifEmail(String email){
         try {
             InternetAddress internetAddress=new InternetAddress(email);
             internetAddress.validate();
             return true;
         } catch (AddressException ex) {
             System.out.println(ex.getMessage());
             return false;
         }
       

    }
    private static boolean validatePhoneNumber(String phoneNo) {
		//validate phone numbers of format "1234567890"
		if (phoneNo.matches("\\d{8}")) return true;
		//validating phone number with -, . or spaces
		else if(phoneNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) return true;
		//validating phone number with extension length from 3 to 5
		else if(phoneNo.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) return true;
		//validating phone number where area code is in braces ()
		else if(phoneNo.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) return true;
		//return false if nothing matches the input
		else return false;
		
	}

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                txtFirstName.setText(f.getFirstname());
        txtLastName.setText(f.getLastname());
        txtEmail.setText(f.getEmail());
        txtAddress.setText(f.getAddress());
        txtPhoneNumber.setText(f.getPhoneNumber());
        cmbTypeProduct.setValue(f.getType_product());         
//        txtLastName.setPromptText("Nom");
//        txtLastName.getParent().requestFocus();
//        txtFirstName.setPromptText("Prenom");
//        txtFirstName.getParent().requestFocus();
//        txtAddress.setPromptText("Address");
//        txtAddress.getParent().requestFocus();
//        txtEmail.setPromptText("Email");
//        txtEmail.getParent().requestFocus();
//        txtPhoneNumber.setPromptText("Numero Telephone");
        txtPhoneNumber.getParent().requestFocus();
        List<String> list = new ArrayList<String>();
        list.add("Produit laitiére");
        list.add("Parfum");
        list.add("Produit alimentaire");
        ObservableList obList = FXCollections.observableList(list);
        cmbTypeProduct.getItems().clear();
        cmbTypeProduct.setItems(obList);  
    }    
    
}

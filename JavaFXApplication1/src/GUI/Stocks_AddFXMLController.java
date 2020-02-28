/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Entrepot;
import Entity.Product;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import Connexion.DataSource;
import Service.EntrepotService;
import Service.ProductService;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class Stocks_AddFXMLController implements Initializable {

    @FXML
    private ComboBox<Product> combo_Product;
    @FXML
    private ComboBox<Entrepot> combo_Entrepot;
    @FXML
    private TextField quantity;
    @FXML
    private TextField Unity;
    @FXML
    private Button AddStock;
    private ObservableList<Product> oblistP = FXCollections.observableArrayList();
    private ObservableList<Entrepot> oblistE = FXCollections.observableArrayList();
    
    private Button Add_btn;
    private Connection cnx;
    private Statement stmt;
    private PreparedStatement pst;
    private ResultSet res;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       ProductService products=new ProductService();
        EntrepotService entrepots=new EntrepotService();
        oblistP.addAll(products.displayAll());
        oblistE.addAll(entrepots.displayAll());

        combo_Product.getItems().setAll(oblistP);
        combo_Entrepot.getItems().setAll(oblistE);
        
        
        
    }    

    @FXML
    private void Add_Product(MouseEvent event) {
        
        String Quantity = quantity.getText();
        String unity = Unity.getText();
        Entrepot entrepot=combo_Entrepot.getItems().get(combo_Entrepot.getSelectionModel().getSelectedIndex());
        Product product=combo_Product.getItems().get(combo_Product.getSelectionModel().getSelectedIndex());
        
         if((!Quantity.matches(".*\\d.*"))||(Quantity.isEmpty())){
             Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Quantity must contain only float or integer values");
            a.setHeaderText("Invalid Value");
            a.show();
        }
         
        else if ((!unity.matches(".*\\d.*"))||(unity.isEmpty())){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Unity must contain only float or integer values");
            a.setHeaderText("Invalid Value");
            a.show();
        }
                 
         else  if(combo_Entrepot.getSelectionModel().getSelectedItem()==null){
             
        Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Quantity must contain only float or integer values");
            a.setHeaderText("Invalid Value");
            a.show();
        }
         else  if(combo_Product.getSelectionModel().getSelectedItem()==null){
        Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Quantity must contain only float or integer values");
            a.setHeaderText("Invalid Value");
            a.show();
        }
         else{
        try {
            this.cnx = DataSource.getInstance().getCon();
            PreparedStatement stmt = cnx.
                    prepareStatement("INSERT INTO stocks (quantity,id_product,id_entrepot,unity)VALUES ('" +Quantity+"','"+product.getId_product()+"','"+entrepot.getId_entrepot()+"','"+ unity+"')");

            stmt.executeUpdate();
            System.out.println("Item Added successfully");

        } catch (Exception ex) {
            ex.printStackTrace();

        }
         try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/EntrepotFXML.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            
        } catch (IOException ex) {

        }
     
         }
    }
    
    
    private static boolean validateRangs(String phoneNo) {
		//validate phone numbers of format "1234567890"
		if (phoneNo.matches(".*\\d.*")) return true;
		
		//return false if nothing matches the input
		else return false;
		
	}
    
}

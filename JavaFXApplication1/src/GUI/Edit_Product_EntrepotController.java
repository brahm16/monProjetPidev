/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Stocks;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import Connexion.DataSource;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class Edit_Product_EntrepotController implements Initializable {

    @FXML
    private TextField Quantity;
    @FXML
    private TextField Unity;
    @FXML
    private Button edit;
    @FXML
    private TextField id;
    @FXML
    private Button delete;
    private Connection cnx;
    private Statement stmt;
    private PreparedStatement pst;
    private ResultSet res;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Edit_Product(MouseEvent event) {
        
           String quantity = Quantity.getText();
           String unity = Unity.getText();
           
            if(quantity.isEmpty()){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Quantity must contain only float or integer values");
            a.setHeaderText("Invalid Value");
            a.show();
        }
         
         else if (unity.isEmpty()){
        Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Unity must contain only float or integer values");
            a.setHeaderText("Invalid Value");
            a.show();
        }
         else{
           try {
            this.cnx = DataSource.getInstance().getCon();
            PreparedStatement stmt = cnx.
                    prepareStatement("UPDATE stocks  SET  Quantity='" + quantity + "', Unity='" +unity+ "' WHERE id_stocks='" + id.getText() + "'");

            stmt.executeUpdate();
            System.out.println("Updated Stocks successfully");

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
        }}
        
        
    

    @FXML
    private void Delete_Product(MouseEvent event) {
           String sql = "delete from stocks where id_stocks= '"+ id.getText()+"'";

        try {
            this.cnx = DataSource.getInstance().getCon();
            pst = cnx.prepareStatement(sql);
            pst.executeUpdate();
            System.out.println("Stock deleted");
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(e.toString());
          
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

    void SetItems(Stocks person) {
        Quantity.setText(String.valueOf(person.getQuantity()));
        Unity.setText(String.valueOf(person.getUnity()));
        id.setText(String.valueOf(person.getId_stocks()));
        id.setEditable(false);
        }
    
}

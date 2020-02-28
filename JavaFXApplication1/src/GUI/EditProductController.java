/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Product;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import Connexion.DataSource;
import Service.EntrepotService;
import Service.StockService;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class EditProductController implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private TextField type;
    @FXML
    private TextField reference;
    @FXML
    private TextField marque;
    @FXML
    private TextField priceHT;
    @FXML
    private TextField priceTTC;
    @FXML
    private TextField Weight;
    @FXML
    private TextField TVA;
    @FXML
    private Button edit;

    private Connection cnx;
    private Statement stmt;
    private PreparedStatement pst;
    private ResultSet res;
    private int ID;
    @FXML
    private TextField id;
    @FXML
    private Button delete;
    @FXML
    private Label entrepots;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        id.setVisible(false);

    }

    public void SetItems(Entity.Product p) {
        StockService stockService=new StockService();
        EntrepotService entrepotService=new EntrepotService();
        String ch="";
        for(Stocks s: stockService.displayByIdProduct(p.getId_product())){
            System.out.println(entrepotService.findById(s.getId_entrepot()));
            ch+=entrepotService.findById(s.getId_entrepot()).toString()+"\n";
            
        }
        entrepots.setText(ch);
        name.setText(p.getProduct_name());
        type.setText(p.getProduct_type());
        reference.setText(p.getReference());
        marque.setText(p.getMarque());
        priceHT.setText(String.valueOf(p.getPriceHT()));
        priceTTC.setText(String.valueOf(p.getPriceTTC()));
        Weight.setText(String.valueOf(p.getWeight()));
        TVA.setText(String.valueOf(p.getTVA()));
        id.setText(String.valueOf(p.getId_product()));
        id.setEditable(false);
    }

    @FXML
    private void Edit_Product(MouseEvent event) {
        
        
          if((name.getText().isEmpty())){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Name field is empty ");
            a.setHeaderText("Invalid Value");
            a.show();
            
 
        }
       else if((type.getText().isEmpty())){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Type field is empty");
            a.setHeaderText("Invalid Value");
            a.show();
            
 
        }
        else if((reference.getText().isEmpty())){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Reference field is empty");
            a.setHeaderText("Invalid Value");
            a.show();
            
 
        }
         else if((marque.getText().isEmpty())){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Marque field is empty");
            a.setHeaderText("Invalid Value");
            a.show();
            
 
        }
        
        else if((!priceHT.getText().matches("[-+]?[0-9]*\\.?[0-9]+"))&&(priceHT.getText().isEmpty())){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("PriceHT must contain only float or integer values");
            a.setHeaderText("Invalid Value");
            a.show();
            
 
        }
         
        else if((!priceTTC.getText().matches("[-+]?[0-9]*\\.?[0-9]+"))&&(priceTTC.getText().isEmpty())){
        Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("PriceTTC must contain only float or integer values");
             a.setHeaderText("Invalid Value");
            a.show();
 
        }
         else if((!Weight.getText().matches("[-+]?[0-9]*\\.?[0-9]+"))&&(Weight.getText().isEmpty())){
        Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Weight must contain only float or integer values");
             a.setHeaderText("Invalid Value");
            a.show();
 
        }
         else if((!TVA.getText().matches("[-+]?[0-9]*\\.?[0-9]+"))&&(TVA.getText().isEmpty())){
        Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("TVA must contain only float or integer values");
             a.setHeaderText("Invalid Value");
            a.show();
 
        }
         
         else{
    

        try {
            this.cnx = DataSource.getInstance().getCon();
            PreparedStatement stmt = cnx.
                    prepareStatement("UPDATE product SET  product_name='" + name.getText() + "', product_type='" + type.getText() + "', reference='" + reference.getText() + "', marque='" + marque.getText() + "', priceHT='" + priceHT.getText() + "', priceTTC='" + priceTTC.getText() + "', TVA='" + TVA.getText() + "', weight='" + Weight.getText() + "' WHERE id_product='" + id.getText() + "'");

            stmt.executeUpdate();
            System.out.println("Updated item successfully");

        } catch (Exception ex) {
            ex.printStackTrace();

        }
         try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/ProductFXML.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {

        }

    }
    }
    @FXML
    private void Delete_Product(MouseEvent event) {
        
        String sql = "delete from product where id_product= '"+ id.getText()+"'";

        try {
            this.cnx = DataSource.getInstance().getCon();
            pst = cnx.prepareStatement(sql);
            pst.executeUpdate();
            System.out.println("product deleted");
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(e.toString());
          
        }
        
         try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/ProductFXML.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {

        }
        
    }

}

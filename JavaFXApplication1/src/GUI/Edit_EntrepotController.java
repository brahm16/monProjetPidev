/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import Connexion.DataSource;
import Service.ProductService;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class Edit_EntrepotController implements Initializable {

    @FXML
    private TextField address;
    @FXML
    private TextField nbr;
    @FXML
    private TextField phone;
    @FXML
    private TextField phone_bis;
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
    private int ID;
    @FXML
    private Label address_test;
    @FXML
    private Label nbr_test;
    @FXML
    private Label phone_test;
    @FXML
    private Label phone_bis_test;
    @FXML
    private Button Product_List;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         id.setVisible(false);

    }    

    @FXML
    private void Edit_Entrepot(MouseEvent event) {
        String add = address.getText();
        String nbre = nbr.getText();
        String phones = phone.getText();
        String phone_b = phone_bis.getText();

         if ((!validateRangs(nbre))||(nbre.isEmpty())) {
           Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Nbr must contain only float or integer values");
            a.setHeaderText("Invalid Value");
            a.show();
 }

        else if ((!validatePhoneNumber(phones))||(phones.isEmpty())) {
           Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Phone must contain 8 numbers");
            a.setHeaderText("Invalid Value");
            a.show();
        }

        else if ((!validatePhoneNumber(phone_b))||(phone_b.isEmpty())) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Phone bis must contain 8 numbers");
            a.setHeaderText("Invalid Value");
            a.show();
 }
         else if (add.isEmpty()){
        Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Unity must contain only float or integer values");
            a.setHeaderText("Invalid Value");
            a.show();
        }
       else {
   try {
            this.cnx = DataSource.getInstance().getCon();
            PreparedStatement stmt = cnx.
                    prepareStatement("UPDATE entrepot SET  address='" + address.getText() + "', nbrRangs='" + nbr.getText() + "', phone='" + phone.getText() + "', phone_bis='" + phone_bis.getText() + "' WHERE id_entrepot='" + id.getText() + "'");

            stmt.executeUpdate();
            System.out.println("Updated item successfully");

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
     private static boolean validatePhoneNumber(String phoneNo) {
		//validate phone numbers of format "1234567890"
		if (phoneNo.matches("\\d{8}")) return true;
                if (phoneNo.matches("\\d")) return true;
		//validating phone number with -, . or spaces
		else if(phoneNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) return true;
		//validating phone number with extension length from 3 to 5
		else if(phoneNo.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) return true;
		//validating phone number where area code is in braces ()
		else if(phoneNo.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) return true;
		//return false if nothing matches the input
		else return false;
		
	}
 private static boolean validateRangs(String phoneNo) {
		//validate phone numbers of format "1234567890"
		if (phoneNo.matches(".*\\d.*")) return true;
		
		//return false if nothing matches the input
		else return false;
		
	}

    @FXML
    private void Delete_Entrepot(MouseEvent event) {
         String sql = "delete from entrepot where id_entrepot= '"+ id.getText()+"'";

        try {
            this.cnx = DataSource.getInstance().getCon();
            pst = cnx.prepareStatement(sql);
            pst.executeUpdate();
            System.out.println("Entrepot deleted");
            
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
    
    public void SetItems(Entity.Entrepot p) {

        address.setText(p.getAddress());
        nbr.setText(String.valueOf(p.getNbrRangs()));
        phone.setText(p.getPhone());
        phone_bis.setText(p.getPhone_bis());
        id.setText(String.valueOf(p.getId_entrepot()));
        id.setEditable(false);
    }

    @FXML
    private void Product_List(MouseEvent event) {
                String person = id.getText();

        
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/Stock_ProductFXML.fxml"));
            Parent root = loader.load();
            Stock_ProductFXMLController controller = (Stock_ProductFXMLController) loader.getController();
            controller.SetItems(person);
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);

        }
       
    }
    
}

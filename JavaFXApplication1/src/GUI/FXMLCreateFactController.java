/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Achat;
import Entity.Facture;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.controlsfx.control.textfield.TextFields;
import Service.AchatService;
import Connexion.DataSource;
import Service.FactureService;

/**
 * FXML Controller class
 *
 * @author bazinfo
 */
public class FXMLCreateFactController implements Initializable {
     ObservableList list = FXCollections.observableArrayList();
    ObservableList filteredData = FXCollections.observableArrayList();
    @FXML
    private BorderPane b1;
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
    private TextField bt1;
    
    @FXML
    private TextField bt3;
    @FXML
    private TextField bt4;
    @FXML
    private TextField bt5;
    @FXML
    private TextField bt6;
    @FXML
    private TextField bt7;
    @FXML
    private TextField bt8;
    @FXML
    private TextField bt9;
    @FXML
    private TextField bt10;
    @FXML
    private TextField bt11;
    @FXML
    private Button saisir;
     public boolean inscrivalide ;
  Connection cnx ;
    PreparedStatement pst ;
    ResultSet rs;
    Achat f ;
    final ObservableList<Achat> options= FXCollections.observableArrayList();
    @FXML
    private ComboBox<Achat> comboo;
    int id =0;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
             // TODO
             List<Achat> list1=new ArrayList<>();
            cnx=DataSource.getInstance().getCon();
            String query="select * from achat";
            
            pst=cnx.prepareStatement(query);
                  //  pst.setString(1, query);
            rs=pst.executeQuery();
            while(rs.next())
            {
//                int i=rs.getInt("id_vehicule");   
//                String st=Integer.toString(i);
//                System.out.println(st);
//                options.add(st);
                f =new Achat(rs.getInt(1),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getString(8));
                list.add(f);

            }
             System.out.println(list);
            options.addAll(list);
             comboo.getItems().setAll(options);
         } catch (SQLException ex) {
             Logger.getLogger(FXMLCreateFactController.class.getName()).log(Level.SEVERE, null, ex);
         }
             inscrivalide = true ;
        
        bt1.textProperty().addListener((observable, oldValue, newValue) -> {
            bt1.setStyle("-fx-background-color: "+"white");
             inscrivalide = true;
        });
        
       bt3.textProperty().addListener((observable, oldValue, newValue) -> {
            bt3.setStyle("-fx-background-color: "+"white");
             inscrivalide = true;
             
        });
       bt4.textProperty().addListener((observable, oldValue, newValue) -> {
            inscrivalide = true;
            bt4.setStyle("-fx-background-color: "+"white");
        });
       
        bt5.textProperty().addListener((observable, oldValue, newValue) -> {
             inscrivalide = true;
            bt5.setStyle("-fx-background-color: "+"white");
        });
        
        
         bt6.textProperty().addListener((observable, oldValue, newValue) -> {
             inscrivalide = true;
            bt6.setStyle("-fx-background-color: "+"white");
        });
         
         
          bt7.textProperty().addListener((observable, oldValue, newValue) -> {
            bt7.setStyle("-fx-background-color: "+"white");
             inscrivalide = true;
        });
           bt8.textProperty().addListener((observable, oldValue, newValue) -> {
            bt8.setStyle("-fx-background-color: "+"white");
             inscrivalide = true;
        });
                   
              bt9.textProperty().addListener((observable, oldValue, newValue) -> {
            bt9.setStyle("-fx-background-color: "+"white");
             inscrivalide = true;
        });
         bt10.textProperty().addListener((observable, oldValue, newValue) -> {
            bt10.setStyle("-fx-background-color: "+"white");
             inscrivalide = true;
        });
          bt11.textProperty().addListener((observable, oldValue, newValue) -> {
            bt11.setStyle("-fx-background-color: "+"white");
             inscrivalide = true;
        });
          String[] PossibleVille1 ={"facturation intermédiaire",
"facture de régularisation",
"facture de clôture",
"facture proforma ",
"facture véritable"};
          
  
        TextFields.bindAutoCompletion(bt5,PossibleVille1);
        
        String[] PossibleVille ={"Stock",
"En attente",
"traitée"
};
          
  
        TextFields.bindAutoCompletion(bt6,PossibleVille);
        
        
      
    } 
    


       
    
    
   

    @FXML
    private void retour(MouseEvent event) throws IOException {
        
          Parent page = FXMLLoader.load(getClass().getResource("FXMLGestionFacture.fxml"));
                Scene scene = new Scene(page);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
               stage.setTitle("Liste Facture");
                stage.setScene(scene);
                stage.show();
             }
 public void fillComboBox() throws SQLException
    {
       
            List<Achat> list1=new ArrayList<>();
            cnx=DataSource.getInstance().getCon();
            String query="select * from achat";
            
            pst=cnx.prepareStatement(query);
                  //  pst.setString(1, query);
            rs=pst.executeQuery();
            while(rs.next())
            {
//                int i=rs.getInt("id_vehicule");   
//                String st=Integer.toString(i);
//                System.out.println(st);
//                options.add(st);
                f =new Achat(rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getString(8));
                list.add(f);

                
            }
            options.addAll(list1);
             comboo.getItems().setAll(options);

            System.out.println("aaa");
            System.out.println(options);
        
        String query1="select id_achat from achat where id_achat=?";
            
            pst=cnx.prepareStatement(query1);
            pst.setInt(1,f.getId_achat());
            
            rs=pst.executeQuery();
             while(rs.next())
            {
                id=rs.getInt(1);
            }
    }
    @FXML
    private void create(MouseEvent event) {
      
        
        
        
        
        
    String z=bt1.getText().toString();
//    String a=bt2.getText().toString();
    String b=bt3.getText().toString();
    String c=bt4.getText().toString();
    String d=bt5.getText().toString();
    String e=bt6.getText().toString();
    String f=bt7.getText().toString();
    String g=bt8.getText().toString();
    String h=bt9.getText().toString();
    String i=bt10.getText().toString();
    String j=bt11.getText().toString();
  
    if(bt1.getText().isEmpty()){
            bt1.setStyle("-fx-background-color: #"+"ff7d9f");
            inscrivalide = false;
        }
       
        if(bt3.getText().isEmpty()){
            bt3.setStyle("-fx-background-color: #"+"ff7d9f");
            inscrivalide = false;
        }
        if(bt4.getText().isEmpty()){
            bt4.setStyle("-fx-background-color: #"+"ff7d9f");
            inscrivalide = false;
        }
        if(bt5.getText().isEmpty()){
            bt5.setStyle("-fx-background-color: #"+"ff7d9f");
            inscrivalide = false;
        }
        
        if(bt6.getText().isEmpty()){
           bt6.setStyle("-fx-background-color: #"+"ff7d9f");
           inscrivalide = false; 
        }
        if(bt7.getText().isEmpty()){
           bt7.setStyle("-fx-background-color: #"+"ff7d9f");
           inscrivalide = false; 
        }
        if(bt8.getText().isEmpty()){
           bt8.setStyle("-fx-background-color: #"+"ff7d9f");
           inscrivalide = false; 
        }
        if(bt9.getText().isEmpty()){
           bt9.setStyle("-fx-background-color: #"+"ff7d9f");
           inscrivalide = false; 
        }
         if(bt10.getText().isEmpty()){
           bt10.setStyle("-fx-background-color: #"+"ff7d9f");
           inscrivalide = false; 
        }
          if(bt11.getText().isEmpty()){
           bt11.setStyle("-fx-background-color: #"+"ff7d9f");
           inscrivalide = false; 
        }
       
 
 

        
        
              if ( inscrivalide == false ){
              JOptionPane.showMessageDialog(null, "Champ Invalide");}
              if(inscrivalide){
    
    
    int di = Integer.parseInt(i);
    
    float f1 = Float.parseFloat(f);
    float f2 = Float.parseFloat(g);

           
   int ee = 3 ;
   Achat v=comboo.getItems().get(comboo.getSelectionModel().getSelectedIndex());
   Facture F = new Facture (z,v.getId_achat(),b,c,d,e,f1,f2,h,di,j);
    System.out.print(F.toString());
    FactureService   ms =  new FactureService();
         ms.insert(F);
     
    System.out.print("facture ajouter");
   
} 
    
    
}

 
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfWriter;
import Entity.FactureTransport;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import Service.FactureService;
import Service.FactureTransportService;

/**
 * FXML Controller class
 *
 * @author bazinfo
 */
public class FXMLFactTransportController implements Initializable {
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
    private TableView<?> table1;
    @FXML
    private TableColumn<?, ?> idd;
    @FXML
    private TableColumn<?, ?> deliv_ref;
    @FXML
    private TableColumn<?, ?> fact_ref;
    @FXML
    private TableColumn<?, ?> etat;
    @FXML
    private TableColumn<?, ?> dated;
    @FXML
    private BorderPane b1;
    @FXML
    private Button env;
    @FXML
    private Button env1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         FactureTransportService   ms =  new FactureTransportService();
               
               ArrayList Liste = (ArrayList) ms.displayAll();
               ObservableList obs =FXCollections.observableArrayList(Liste);
               table1.setItems(obs);
                idd.setCellValueFactory(new PropertyValueFactory<>("id"));
                deliv_ref.setCellValueFactory(new PropertyValueFactory<>("delivery_reference"));   
               fact_ref.setCellValueFactory(new PropertyValueFactory<>("facture_reference"));
                etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
                dated.setCellValueFactory(new PropertyValueFactory<>("Datedelivery"));
        // TODO
    }    


    @FXML
    private void update(MouseEvent event) {
    }

    @FXML
    private void retour(MouseEvent event) throws IOException {
          Parent page = FXMLLoader.load(getClass().getResource("FXMLFact.fxml"));
                Scene scene = new Scene(page);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
               stage.setTitle("Liste Achat");
                stage.setScene(scene);
                stage.show();
    }

    @FXML
    private void envoyer(MouseEvent event) throws MessagingException {
        
        //api pdf + signature + mail 
         
                   
                    // String dest = "C:\\generare_pdf\\ticket.pdf";       
   //   PdfWriter writer = new PdfWriter(dest);              
     // PdfDocument pdf = new PdfDocusment(writer);                  
     // Document document = new Document(pdf);                   
//      String imFile = "C:\\Users\\Yassine\\Documents\\NetBeansProjects\\techeventsappv2\\src\\images\\TecheventPNG.png";       
//      ImageData data = ImageDataFactory.create(imFile);                    
      //              
      //String para1 = "nom mkjflj vlvbdlf lvhihv lfhoil ";
    // Paragraph paragraph1 = new Paragraph(para1);             
 //  document.add(paragraph1);
      // Closing the document       
      //document.close();              
      
     // System.out.println("Image added"); 
        FactureTransportService   ms =  new FactureTransportService();
               
               ArrayList Liste = (ArrayList) ms.SortAsc();
               ObservableList obs =FXCollections.observableArrayList(Liste);
               table1.setItems(obs);
                idd.setCellValueFactory(new PropertyValueFactory<>("id"));
                deliv_ref.setCellValueFactory(new PropertyValueFactory<>("delivery_reference"));   
               fact_ref.setCellValueFactory(new PropertyValueFactory<>("facture_reference"));
                etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
                dated.setCellValueFactory(new PropertyValueFactory<>("Datedelivery"));
        
    }

    @FXML
    private void sort2(MouseEvent event) {
         FactureTransportService   ms =  new FactureTransportService();
               
               ArrayList Liste = (ArrayList) ms.SortDesc();
               ObservableList obs =FXCollections.observableArrayList(Liste);
               table1.setItems(obs);
                idd.setCellValueFactory(new PropertyValueFactory<>("id"));
                deliv_ref.setCellValueFactory(new PropertyValueFactory<>("delivery_reference"));   
               fact_ref.setCellValueFactory(new PropertyValueFactory<>("facture_reference"));
                etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
                dated.setCellValueFactory(new PropertyValueFactory<>("Datedelivery"));
    }
    
}

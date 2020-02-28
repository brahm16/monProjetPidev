/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.restfb.BinaryAttachment;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.FacebookType;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import static GUI.Twitter_PostController.status;
import Service.ProductService;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class Facebook_PostController implements Initializable {

    @FXML
    private TextArea message_Post;
    private FileChooser filechooser;
    private File file;
    private Desktop desktop;
    Stage primaryStage;
    @FXML
    private AnchorPane anchorid;
    static String name_File;
    static String Path_File;
    @FXML
    private Button facebook;
    static String status;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        status = "vide";
    }

    private void browse(ActionEvent event) {
        final FileChooser dirchooser = new FileChooser();
        Stage stage = (Stage) anchorid.getScene().getWindow();
        File file = dirchooser.showOpenDialog(stage);
        if (file != null) {
            status = "nonvide";
            System.out.println(status);

            Path_File = file.getAbsolutePath();
            name_File = file.getName();

        } else {
            status = "vide";
            System.out.println(status);
        }

    }

    @FXML
    private void Post_To_Page(MouseEvent event) throws FileNotFoundException {

        String messsage = message_Post.getText();

        String AccessToken = "EAAC0ZCaxdF7oBALZCiUzhXZC22uwc7acdOZCA7YC8xRmV0Dgqbbi2KZAASZAyK9X6fGdJuTfWZB0kYqLLfzNruTjlT5IpvZAfExPErMvBLUpqgm5QQdtXdPZBkBn3Dg14ujZBxQEtorIwfQu8hGjAVvlais7KueTGHnB4s2F49gDanBKJPmHsVDTW40hTd4XrwmUyZB6YkGWhEUsgdivuEMCkpZB";
        FacebookClient fc = new DefaultFacebookClient(AccessToken, Version.UNVERSIONED);
        if (status.equals("vide")) {

            FacebookType rest = fc.publish("me/feed", FacebookType.class, Parameter.with("message", messsage));
            System.out.println("Message publiée");
        } else {

            FileInputStream f = new FileInputStream(new File(Path_File));
            FacebookType rest = fc.publish("me/photos", FacebookType.class, BinaryAttachment.with("icon.png", f), Parameter.with("message", messsage));
            System.out.println("Message publiée");

        }

        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setContentText("Post Published");
        a.setHeaderText("Successfully Posted ");
        a.show();

    }

    @FXML
    private void browseP(MouseEvent event) {

        final FileChooser dirchooser = new FileChooser();
        Stage stage = (Stage) anchorid.getScene().getWindow();
        File file = dirchooser.showOpenDialog(stage);
        if (file != null) {
            status = "nonvide";
            System.out.println(status);

            Path_File = file.getAbsolutePath();
            name_File = file.getName();

        } else {
            status = "vide";
            System.out.println(status);
        }

    }

}

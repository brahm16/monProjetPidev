/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import Connexion.DataSource;
import javafx.scene.control.Alert.AlertType; 
import Entity.Product;

import Entity.Stocks;
import GUI.EditProductController;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 *
 * @author Ibrahim
 */
public class ProductService implements IService<Product>, IServiceProduct<Product> {

    private Connection cnx;
    private Statement stmt;
    private PreparedStatement pst;
    private ResultSet res;
    @FXML
    private TableColumn<?, ?> name;
    @FXML
    private TableColumn<?, ?> type;
    @FXML
    private TableColumn<?, ?> reference;
    @FXML
    private TableColumn<?, ?> marque;
    @FXML
    private TableColumn<?, ?> priceht;
    @FXML
    private TableColumn<?, ?> pricettc;
    @FXML
    private TableColumn<?, ?> tva;
    @FXML
    private TableColumn<?, ?> weight;
    @FXML
    private Button add;
    @FXML
    private Button edit;
    @FXML
    private Button show;
    ObservableList<Product> oblist = FXCollections.observableArrayList();
    @FXML
    private TableView<Product> Table;

    public ProductService() {
        this.cnx = DataSource.getInstance().getCon();
    }

    @Override
    public boolean insert(Product p) {
        String sql = "insert into product (product_name,product_type,reference,marque,priceHT,priceTTC,TVA,weight) values (?,?,?,?,?,?,?,?)";
        try {
            pst = cnx.prepareCall(sql);
            pst.setString(1, p.getProduct_name());
            pst.setString(2, p.getProduct_type());
            pst.setString(3, p.getReference());
            pst.setString(4, p.getMarque());
            pst.setFloat(5, p.getPriceHT());
            pst.setFloat(6, p.getPriceTTC());
            pst.setFloat(7, p.getTVA());
            pst.setFloat(8, p.getWeight());
            pst.executeUpdate();
            System.out.println("product added successfully");

            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    @Override
    public boolean update(Product p) {
        String sql = "update product set product_name= ? , product_type= ? , reference= ? , marque = ? , priceHT= ? , TVA = ? , weight= ? where id_product= ?";
        try {
            pst = cnx.prepareCall(sql);
            pst.setString(1, p.getProduct_name());
            pst.setString(2, p.getProduct_type());
            pst.setString(3, p.getReference());
            pst.setString(4, p.getMarque());
            pst.setFloat(5, p.getPriceHT());
            pst.setFloat(6, p.getTVA());
            pst.setFloat(7, p.getWeight());
            pst.setInt(8, p.getId_product());
            pst.executeUpdate();
            System.out.println("product updated");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    
    public boolean delete(int id) {
        String sql = "delete from product where id_product= ? ";

        try {
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            System.out.println("product deleted");
            return true;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(e.toString());
            return false;
        }
    }

    @Override
    public List<Product> displayAll() {
        String sql = "Select * from product";
        List<Product> list = new ArrayList<>();
        try {
            stmt = cnx.createStatement();
            res = stmt.executeQuery(sql);
            while (res.next()) {
                list.add(new Product(res.getInt("id_product"), res.getString("product_name"), res.getString("product_type"), res.getString("reference"), res.getString("marque"), res.getFloat("priceHT"), res.getFloat("priceTTC"), res.getFloat("TVA"), res.getFloat("weight")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);

        }
        return list;
    }

    public void display() {
        String sql = "Select * from product";
        List<Product> list = new ArrayList<>();
        try {
            stmt = cnx.createStatement();
            res = stmt.executeQuery(sql);
            while (res.next()) {
                list.add(new Product(res.getInt("id_product"), res.getString("product_name"), res.getString("product_type"), res.getString("reference"), res.getString("marque"), res.getFloat("priceHT"), res.getFloat("priceTTC"), res.getFloat("TVA"), res.getFloat("weight")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    @Override
    public List<Product> findByName(String name) {
        String sql = "Select* from product where product_name='" + name + "'";
        List<Product> list = new ArrayList<>();
        try {
            stmt = cnx.createStatement();
            res = stmt.executeQuery(sql);
            while (res.next()) {
               list.add(new Product(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getFloat(6), res.getFloat(7), res.getFloat(8), res.getFloat(9)));
            }
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
            return null;

        }
    }

    @Override
    public Product findById(int id) {
        String sql = "Select* from product where id_product=" + id + ";";
        Product p = null;
        try {
            stmt = cnx.createStatement();
            res = stmt.executeQuery(sql);
            if (res.next()) {
               // p = new Product(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getFloat(6), res.getFloat(7), res.getFloat(8), res.getFloat(9));
            }
            return p;

        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<Product> findByMarque(String marque) {
        String sql = "Select* from product where marque='" + marque + "'";
        List<Product> list = new ArrayList<>();
        try {
            stmt = cnx.createStatement();
            res = stmt.executeQuery(sql);
            while (res.next()) {
               // list.add(new Product(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getFloat(6), res.getFloat(7), res.getFloat(8), res.getFloat(9)));
            }
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
            return null;

        }
    }

    public List<Product> TrieName() {
        String req = "select * from product order by product_name";
        List<Product> list = new ArrayList<>();

        try {
            stmt = cnx.createStatement();
            res = stmt.executeQuery(req);
            while (res.next()) {
              //  list.add(new Product(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getFloat(6), res.getFloat(7), res.getFloat(8), res.getFloat(9)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public boolean deleteAll() {
        int result = 0;
        try {
            pst = cnx.prepareStatement("delete from product;");
            result = pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);

        }
        if (result == 1) {
            return true;
        }
        return false;
    }

    @FXML
    private void ADD(MouseEvent event) throws IOException {
        
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/pi_desktop_app/Add_Product.fxml"));
                       Parent root = (Parent) fxmlLoader.load();
                       Stage stage = new Stage();
                       stage.setScene(new Scene(root));  
                       stage.show();
           } catch (IOException ex) {

            

        }
        
        
                     
    }

    @FXML
    private void Edit(MouseEvent event) {
    }

    @FXML
    private void Show(MouseEvent event) {
        try {
            this.cnx = DataSource.getInstance().getCon();
            String sql = "select * from product";
            stmt = cnx.createStatement();
            res = stmt.executeQuery(sql);

            while (res.next()) {

                oblist.add(new Product(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getFloat(6), res.getFloat(7), res.getFloat(8), res.getFloat(9)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);

        }
        name.setCellValueFactory(new PropertyValueFactory<>("product_name"));
        type.setCellValueFactory(new PropertyValueFactory<>("product_type"));
        reference.setCellValueFactory(new PropertyValueFactory<>("reference"));
        marque.setCellValueFactory(new PropertyValueFactory<>("marque"));
        priceht.setCellValueFactory(new PropertyValueFactory<>("priceHT"));
        pricettc.setCellValueFactory(new PropertyValueFactory<>("priceTTC"));
        tva.setCellValueFactory(new PropertyValueFactory<>("TVA"));
        weight.setCellValueFactory(new PropertyValueFactory<>("weight"));
        Table.setItems(oblist);
        
    }

    @FXML
    private void take(MouseEvent event) throws IOException {
        Product person = Table.getSelectionModel().getSelectedItem();
        if(person==null){
        JOptionPane.showMessageDialog(null,"No Selected Item" ,"message" ,JOptionPane.PLAIN_MESSAGE );
        return;
        }
        
        try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/pi_desktop_app/Edit_Product.fxml"));
        Parent root = loader.load();
        EditProductController controller=(EditProductController ) loader.getController();
        controller.SetItems(person);
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);  
        stage.show();
        
    }catch (IOException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @Override
    public boolean delete(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet display(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet display(int number) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet display(String pass, String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product findFirstOneByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product findFirstOneByType(String type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Product> findByType(String type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product findByReference(String reference) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product findFirstByMarque(String marque) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}


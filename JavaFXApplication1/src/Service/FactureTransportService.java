/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Connexion.DataSource;
import Entity.FactureTransport;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bazinfo
 */
public class FactureTransportService implements IService<FactureTransport> {
    private  Connection cnx;
    private Statement stmt;
    private PreparedStatement pst;
    private ResultSet res;
    
    public FactureTransportService() {
        this.cnx = DataSource.getInstance().getCon();
    }
    
     @Override
    public boolean insert(FactureTransport t) {
        {
        String sql ="insert into facture_transport (id,delivery_reference,facture_reference,etat,Datedelivery) values (?,?,?,?,?)";
        try {
            Date CreatedDate= new Date(System.currentTimeMillis());
            pst=cnx.prepareCall(sql);
         // PreparedStatement pst = con.prepareStatement(Sql query);
            pst.setDate(5, (java.sql.Date) CreatedDate);
            pst.setInt(1,t.getId());
            pst.setString(2,t.getDelivery_reference());
            pst.setString(3,t.getFacture_reference());
            pst.setString(4,t.getEtat());
          
            pst.executeUpdate();
            System.out.println("facture_transport added successfully");

            return true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
        }    }
    }
     @Override
    public boolean update(FactureTransport t) {
        String sql = "UPDATE facture_transport SET delivery_reference= ? , delivery_reference= ? , etat= ? , Datedelivery= ?   where id = ?";
        try {
             Date CreatedDate= new Date(System.currentTimeMillis());
            
         // PreparedStatement pst = con.prepareStatement(Sql query);
            pst.setDate(5, (java.sql.Date) CreatedDate);
            pst = cnx.prepareCall(sql);
            pst.setString(1, t.getDelivery_reference());
            pst.setString(3, t.getFacture_reference());
            pst.setString(4, t.getEtat());
           
            pst.executeUpdate();
            System.out.println("factureTransport updated");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    
    public boolean delete(int id) {
 String sql = "delete from facture_transport where id= ? ";

        try {
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            System.out.println("facture_transport deleted");
            return true;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(e.toString());
            return false;
        }    }

    @Override
    public List<FactureTransport> displayAll() {
          String sql="Select* from facture_transport";
        List<FactureTransport> list=new ArrayList<>();
        try {
            stmt=cnx.createStatement();
            res=stmt.executeQuery(sql);
            while(res.next()){
                list.add(new FactureTransport(res.getInt("id"),res.getString("delivery_reference"),res.getString("facture_reference"),res.getString("etat"),res.getDate("Datedelivery")));
            }
            return list;
        } catch (SQLException ex) {
                        Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);

        }
        return list;
        
    }
    public List<FactureTransport> SortAsc() {
          String sql="SELECT * FROM facture_transport ORDER BY Datedelivery ASC";
          
        List<FactureTransport> list=new ArrayList<>();
        try {
            stmt=cnx.createStatement();
            res=stmt.executeQuery(sql);
            while(res.next()){
                list.add(new FactureTransport(res.getInt("id"),res.getString("delivery_reference"),res.getString("facture_reference"),res.getString("etat"),res.getDate("Datedelivery")));
            }
            return list;
        } catch (SQLException ex) {
                        Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);

        }
        return list;
        
    }
    public List<FactureTransport> SortDesc() {
          String sql="SELECT * FROM facture_transport ORDER BY Datedelivery DESC";
          
        List<FactureTransport> list=new ArrayList<>();
        try {
            stmt=cnx.createStatement();
            res=stmt.executeQuery(sql);
            while(res.next()){
                list.add(new FactureTransport(res.getInt("id"),res.getString("delivery_reference"),res.getString("facture_reference"),res.getString("etat"),res.getDate("Datedelivery")));
            }
            return list;
        } catch (SQLException ex) {
                        Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);

        }
        return list;
        
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
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Connexion.DataSource;
import Entity.paiement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bazinfo
 */
public class PaiementService   implements IService<paiement>{
    
     private final Connection cnx;
    private Statement stmt;
    private PreparedStatement pst;
    private ResultSet res;
    
      public PaiementService () {
        this.cnx = DataSource.getInstance().getCon();
    
      }

    @Override
    public boolean insert(paiement t) {
        {
        String sql ="insert into paiement (reference,client_name,paiement_type,rib,num_cheque) values (?,?,?,?,?)";
        try {
            pst=cnx.prepareCall(sql);
            pst.setString(1,t.getReference());
            pst.setString(2,t.getClient_name());
            pst.setString(3,t.getPaiement_type());
            pst.setString(4,t.getRib());
            pst.setString(5,t.getNum_cheque());
            
            pst.executeUpdate();
            System.out.println("paiement added successfully");

            return true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
        }    }
    }

    @Override
    public boolean update(paiement t) {
        String sql = "update paiement set reference= ? , client_name= ? , paiement_type= ? , rib = ? , num_cheque= ? ";
        try {
            pst = cnx.prepareCall(sql);
            pst.setString(1, t.getReference());
            pst.setString(2, t.getClient_name());
            pst.setString(3, t.getPaiement_type());
            pst.setString(4, t.getRib());
            pst.setString(5, t.getNum_cheque());
         
            pst.executeUpdate();
            System.out.println("paiement updated");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean delete(int id) {
       String sql = "delete from paiement where id_paiement= ? ";

        try {
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            System.out.println("paiement deleted");
            return true;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(e.toString());
            return false;
        }   
    }

    @Override
    public List<paiement> displayAll() {
        String sql="Select* from paiement";
        List<paiement> list=new ArrayList<>();
        try {
            stmt=cnx.createStatement();
            res=stmt.executeQuery(sql);
            while(res.next()){
                list.add(new paiement(res.getInt("id_paiement"),res.getString("reference"),res.getString("client_name"),res.getString("paiement_type"),res.getString("rib"),res.getString("num_cheque")));
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

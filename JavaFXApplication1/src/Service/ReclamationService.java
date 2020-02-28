/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

/**
 *
 * @author Ahmed
 */
import Connexion.DataSource;
import Entity.Reclamation;
import Entity.Staff;
import static com.oracle.nio.BufferSecrets.instance;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.UIManager.getString;
import static jdk.nashorn.internal.objects.Global.instance;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ahmed
 */
public class ReclamationService {
     private Connection cnx;
        private PreparedStatement pst;
            private static ReclamationService instance;

        private ResultSet rs;
        private Statement st;
        
        public ReclamationService(){
         cnx = DataSource.getInstance().getCon();

        } 
        public static ReclamationService getInstance()
    {
        if (instance == null) {
            instance = new ReclamationService();
        }
        return instance; 
    }
         
         
         

    
    public boolean ajouteReclamation(Reclamation Reclamation) {

                    int verf = 0 ;
        try{
        String req ;
        
        req="INSERT INTO `reclamationproduct`(`id_user`,`id_product`,`contenu`,`etat`,`date`) VALUES (?,?,?,?,?)";
        pst =cnx.prepareStatement(req);
        
        pst.setInt(1,Reclamation.getId_user());
        pst.setInt(2, Reclamation.getId_product());
        pst.setString(3,Reclamation.getContenu());
        pst.setString(4, Reclamation.getEtat());
        pst.setDate(5,(Date) Reclamation.getDate_rec());  

        
        verf=pst.executeUpdate();
         
        
        }
        catch(SQLException e ){
        Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE,null,e);
        
        }
        if (verf==0)
        {return false;}
        else {return true;}
        
        
    }
    public int count() throws SQLException{
       try (Statement s = cnx.createStatement()) {
    final ResultSet rs = s.executeQuery("SELECT COUNT(*) FROM reclamationproduct");
    rs.next();
    int j=rs.getInt(1);
    return j;
  }
        
    }
    public List<Reclamation> affiche(int id) throws SQLDataException
    {

       List<Reclamation> list=new ArrayList<Reclamation>();
           try {
               String req="SELECT * FROM `reclamationproduct` where `id_reclamationp`='"+id+"'";
               Statement st;
                 st = cnx.createStatement();
                 ResultSet rs=st.executeQuery(req);
               
                while(rs.next())
                       {
                          Reclamation R = new Reclamation();
                R.setId_product(rs.getInt(3));
                R.setId_reclamation(rs.getInt(1));
                R.setId_user(rs.getInt(2));
                R.setContenu(rs.getString(4));
                R.setDate_rec(rs.getDate(6));
                R.setEtat(rs.getString(5));
               
                           list.add(R);
            
                       }    
           } catch (SQLException ex) {
               Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
           }
          return list;
    }

 public boolean  ModifierUser(Reclamation reclamation){
         int verf = 0 ;
        try{
        String req ;
        
        req="UPDATE reclamationproduct set contenu=?,etat=?, where id_reclamationp=?";
        PreparedStatement res=cnx.prepareStatement(req);
        
        res.setInt(1, reclamation.getId_user());
        res.setInt(2, reclamation.getId_product());
        res.setString(3, reclamation.getContenu());
        res.setString(4, reclamation.getEtat());
        res.setDate(5, reclamation.getDate_rec());

        
       
        
        verf=res.executeUpdate();
         
        
        }
        catch(SQLException e ){
        Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE,null,e);
        
        }
        if (verf==0)
        {return false;}
        else {return true;}
    }
 public boolean  ModifierUser2(Reclamation reclamation){
         int verf = 0 ;
        try{
        String req ;
        
        req="UPDATE reclamationproduct set contenu=? where id_reclamationp=?";
        PreparedStatement res=cnx.prepareStatement(req);
        
        res.setInt(2, reclamation.getId_reclamation());
        res.setString(1, reclamation.getContenu());

        
       
        
        verf=res.executeUpdate();
         
        
        }
        catch(SQLException e ){
        Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE,null,e);
        
        }
        if (verf==0)
        {return false;}
        else {return true;}
    }
    




    
    public List<Reclamation> DisplayAll(){
        
        List<Reclamation> list = new ArrayList<Reclamation>();
        int count =0;
        
        String req="select * from reclamationproduct";
         try{
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()){
                
                Reclamation R = new Reclamation();
                R.setId_product(rs.getInt(3));
                R.setId_reclamation(rs.getInt(1));
                R.setId_user(rs.getInt(2));
                R.setContenu(rs.getString(4));
                R.setDate_rec(rs.getDate(6));
                R.setEtat(rs.getString(5));


                list.add(R);
                
                count++;
            }
            if(count == 0){
                return null;
           }else{
               return list;
            
           
        
           
        }
         }
        catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
   
           
} 
    
    public List<Reclamation> DisplayAll1(int id){
        
        List<Reclamation> list = new ArrayList<Reclamation>();
        int count =0;
        
        String req="select * from reclamationproduct where id_user='"+id+"'";
         try{
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()){
                
                Reclamation R = new Reclamation();
                R.setId_product(rs.getInt(3));
                R.setId_reclamation(rs.getInt(1));
                R.setId_user(rs.getInt(2));
                R.setContenu(rs.getString(4));
                R.setDate_rec(rs.getDate(6));
                R.setEtat(rs.getString(5));


                list.add(R);
                
                count++;
            }
            if(count == 0){
                return null;
           }else{
               return list;
            
           
        
           
        }
         }
        catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
   
           
} 
    
    
    
  
   public boolean UpdateRec (Reclamation reclamation ){
        try{
            PreparedStatement pst = cnx.prepareStatement("update reclamationproduct set etat = 'Traiter' where id_reclamationp=?"); 
            pst.setInt(1,reclamation.getId_reclamation());
            pst.executeUpdate();
            return true ;

        }
        catch (SQLException ex)
        {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
            return false ;
        }
    }
   public boolean SupprimerReclamation(int a) 
   {
         try {
             String req= "DELETE FROM reclamationproduct WHERE id_reclamationp='"+a+"' ";
             st=cnx.createStatement();
            st.executeUpdate(req);
             System.out.println("supprimer avec succee");
             return true ;
         } catch (SQLException ex) {
             Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
                          return false;

         }
      
    }
 }

   
   

    
  


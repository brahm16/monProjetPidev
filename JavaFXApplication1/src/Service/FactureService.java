/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Connexion.DataSource;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import Entity.Facture;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
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
public class FactureService implements IService<Facture>{
  private Connection cnx;
    private Statement stmt;
    private PreparedStatement pst;
    private ResultSet res;
    
    public static final String QR_CODE_IMAGE_PATH = "./MyQRCode.png";
    
      public FactureService() {
        this.cnx = DataSource.getInstance().getCon();
    }

   @Override
    public boolean insert(Facture t) {
        {
        String sql ="insert into facture (reference,id_achat,client_name,client_type,type_facture,statut_facture,totalHT,totalTTC,echeance,delivery,DateFact) values (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            pst=cnx.prepareCall(sql);
            pst.setString(1,t.getReference());
            pst.setInt(2,t.getId_achat());
            pst.setString(3,t.getClient_name());
            pst.setString(4,t.getClient_type());
            pst.setString(5,t.getType_facture());
            pst.setString(6,t.getStatut_facture());
            pst.setFloat(7,t.getTotalHT());
            pst.setFloat(8,t.getTotalTTC());
            pst.setString(9,t.getEcheance());
            pst.setInt(10,t.getDelivery());
            pst.setString(11,t.getDateFact());
            pst.executeUpdate();
            System.out.println("facture added successfully");

            return true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
        }    }
    }

    /**
     *
     * @param t
     * @return
     */
    @Override
    public boolean update(Facture t) {
        String sql = "UPDATE facture SET reference= ? , id_achat= ? , client_name= ? , client_type = ? , type_facture= ? , statut_facture = ? ,totalHT = ?,totalTTC = ? ,echeance = ? ,delivery = ?  where id_facture = ?";
        try {
            pst = cnx.prepareCall(sql);
            pst.setString(1, t.getReference());
            pst.setInt(2, t.getId_achat());
            pst.setString(3, t.getClient_name());
            pst.setString(4, t.getClient_type());
            pst.setString(5, t.getType_facture());
            pst.setString(6, t.getStatut_facture());
            
            pst.setFloat(7, t.getTotalHT());
            pst.setFloat(8, t.getTotalTTC());
            pst.setString(9, t.getEcheance());
            pst.setInt(10, t.getDelivery());
            pst.setInt(11, t.getId_facture());
            pst.executeUpdate();
            System.out.println("facture updated");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    
    public boolean delete(int id) {
        cnx =DataSource.getInstance().getCon();
 String sql = "delete from facture where id_facture= ? ";

        try {
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            System.out.println("facture deleted");
            return true;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(e.toString());
            return false;
        }    }

    
    public boolean delete1(String id) {
        cnx =DataSource.getInstance().getCon();
 String sql = "delete from facture where reference= ? ";

        try {
            pst = cnx.prepareStatement(sql);
            pst.setString(1, id);
            pst.execute();
            System.out.println("facture deleted");
            return true;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(e.toString());
            return false;
        }    }
public Facture AffichierFacture(int id)  {
     
          Facture sp = new Facture (); 
     try 
        {
        Statement stm = DataSource.getInstance().getCon().createStatement();
         //String requete = "SELECT nom,email,address,tel,password,role,categorie,type,description,photo FROM `fos_user` WHERE id="+id+"";
         String requete= "SELECT id_facture,reference,id_achat,client_name,client_type,type_facture,statut_facture,totalHT,totalTTC,echeance,delivery,DateFact FROM `facture`WHERE id_facture="+id+"";
       ResultSet rest= stm.executeQuery(requete);
      
       
         
         while (rest.next()) 
        {
            
            System.out.println("le contenu de commentaire:"+rest.getString(1));
       sp.setId_facture(rest.getInt(1));
       sp.setReference(rest.getString(2));
       sp.setClient_name(rest.getString(4));
       sp.setClient_type(rest.getString(5));
       sp.setType_facture(rest.getString(6));
       sp.setStatut_facture(rest.getString(7));
       sp.setTotalHT (rest.getFloat(8));
       sp.setTotalTTC (rest.getFloat(9));
       sp.setEcheance(rest.getString(10));
       sp.setDelivery(rest.getInt(11));
       sp.setDateFact(rest.getString(12));

       

      
           //System.out.println("Date de comm:"+rest.getDate("dateCom"));
            
        } }
          catch (SQLException e)
                {
                    System.err.println("SQLException: "+e.getMessage());
                    System.err.println("SQLSTATE: "+e.getSQLState());
                    System.err.println("VnedorError: "+e.getErrorCode());
                }
       
       return sp;

}
public Facture AffichierFacture1(String id)  {
     
          Facture sp = new Facture (); 
     try 
        {
        Statement stm = DataSource.getInstance().getCon().createStatement();
         //String requete = "SELECT nom,email,address,tel,password,role,categorie,type,description,photo FROM `fos_user` WHERE id="+id+"";
         String requete= "SELECT id_facture,reference,id_achat,client_name,client_type,type_facture,statut_facture,totalHT,totalTTC,echeance,delivery,DateFact FROM `facture`WHERE reference="+id+"";
       ResultSet rest= stm.executeQuery(requete);
      
       
         
         while (rest.next()) 
        {
            
            System.out.println("le contenu de commentaire:"+rest.getString(1));
       sp.setId_facture(rest.getInt(1));
       sp.setReference(rest.getString(2));
       sp.setClient_name(rest.getString(4));
       sp.setClient_type(rest.getString(5));
       sp.setType_facture(rest.getString(6));
       sp.setStatut_facture(rest.getString(7));
       sp.setTotalHT (rest.getFloat(8));
       sp.setTotalTTC (rest.getFloat(9));
       sp.setEcheance(rest.getString(10));
       sp.setDelivery(rest.getInt(11));
       sp.setDateFact(rest.getString(12));

       

      
           //System.out.println("Date de comm:"+rest.getDate("dateCom"));
            
        } }
          catch (SQLException e)
                {
                    System.err.println("SQLException: "+e.getMessage());
                    System.err.println("SQLSTATE: "+e.getSQLState());
                    System.err.println("VnedorError: "+e.getErrorCode());
                }
       
       return sp;

}
    @Override
    public List<Facture> displayAll() {
        String sql="Select* from facture";
        List<Facture> list=new ArrayList<>();
        try {
            stmt=cnx.createStatement();
            res=stmt.executeQuery(sql);
            while(res.next()){
                list.add(new Facture(res.getString("reference"),res.getInt("id_achat"),res.getString("client_name"),res.getString("client_type"),res.getString("type_facture"),res.getString("statut_facture"),res.getFloat("totalHT"),res.getFloat("totalTTC"),res.getString("echeance"),res.getInt("delivery"),res.getString("DateFact")));
            }
            return list;
        } catch (SQLException ex) {
                        Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);

        }
        return list;    }
     public List<Facture> afficherByreference(String n) {
        List<Facture> myList = new ArrayList<Facture>();
        try {

            String requete2 = "SELECT * FROM facture WHERE reference LIKE '%" + n + "%'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete2);

            while (rs.next()) {
                Facture u = new Facture();
                u.setId_facture(rs.getInt(1));
                u.setReference(rs.getString(2));
                u.setId_achat(rs.getInt(3));
                u.setClient_name(rs.getString(4));
                u.setClient_type(rs.getString(5));
                u.setType_facture(rs.getString(6));
                u.setStatut_facture(rs.getString(7));
                u.setTotalHT(rs.getFloat(8));
                u.setTotalTTC(rs.getFloat(9));
                u.setEcheance(rs.getString(10));
                u.setDelivery(rs.getInt(11));
  

                myList.add(u);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }  
     
      public List<Facture> afficherByClient_name( String n) {
        List<Facture> myList = new ArrayList<Facture>();
        try {

            String requete2 = "SELECT * FROM facture WHERE client_name LIKE '%" + n + "%'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete2);

            while (rs.next()) {
                Facture u = new Facture();
                u.setId_facture(rs.getInt(1));
                u.setReference(rs.getString(2));
                u.setId_achat(rs.getInt(3));
                u.setClient_name(rs.getString(4));
                u.setClient_type(rs.getString(5));
                u.setType_facture(rs.getString(6));
                u.setStatut_facture(rs.getString(7));
                u.setTotalHT(rs.getFloat(8));
                u.setTotalTTC(rs.getFloat(9));
                u.setEcheance(rs.getString(10));
                u.setDelivery(rs.getInt(11));
  
                   myList.add(u);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }   
      
      
       public List<Facture> afficherByType_facture (String n) {
        List<Facture> myList = new ArrayList<Facture>();
        try {

            String requete2 = "SELECT * FROM facture WHERE type type_facture '%" + n + "%'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete2);

            while (rs.next()) {
                Facture u = new Facture();
                u.setId_facture(rs.getInt(1));
                u.setReference(rs.getString(2));
                u.setId_achat(rs.getInt(3));
                u.setClient_name(rs.getString(4));
                u.setClient_type(rs.getString(5));
                u.setType_facture(rs.getString(6));
                u.setStatut_facture(rs.getString(7));
                u.setTotalHT(rs.getFloat(8));
                u.setTotalTTC(rs.getFloat(9));
                u.setEcheance(rs.getString(10));
                u.setDelivery(rs.getInt(11));
                myList.add(u);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }   
    public List<Facture> afficherByDate(String a) {
        List<Facture> myList = new ArrayList<Facture>();
        try {

            String requete2 = "SELECT * FROM facture WHERE DateFact LIKE '%" + a + "%'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete2);

            while (rs.next()) {
                Facture u = new Facture();
                u.setId_facture(rs.getInt(1));
                u.setReference(rs.getString(2));
                u.setId_achat(rs.getInt(3));
                u.setClient_name(rs.getString(4));
                u.setClient_type(rs.getString(5));
                u.setType_facture(rs.getString(6));
                u.setStatut_facture(rs.getString(7));
                u.setTotalHT(rs.getFloat(8));
                u.setTotalTTC(rs.getFloat(9));
                u.setEcheance(rs.getString(10));
                u.setDelivery(rs.getInt(11));
                u.setDateFact(rs.getString(12));
                myList.add(u);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }
    /* public void download(Facture f,String file) {
        Document document = new Document(PageSize.A4);
        document.addAuthor("bazinfo");
        document.addTitle("Facture");
        
        
        try {
            PdfWriter.getInstance(document, new FileOutputStream(file+".pdf"));
            document.open();
            generateQRCodeImage( 150, 150, QR_CODE_IMAGE_PATH,f);
            System.out.println("aaaa");
            Paragraph para = new Paragraph(f.toString());
            Image img = Image.getInstance(QR_CODE_IMAGE_PATH);

            document.add(para);
            document.add(para);
            document.add(para);
            document.add(para);
            document.add(para);
            document.add(para);
            document.add(para);
            document.add(img);
            document.close();
            System.out.println("Document generated");

        } catch (DocumentException ex) {
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FournisseurService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WriterException | IOException ex) {
            Logger.getLogger(FournisseurService.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    private static void generateQRCodeImage(int width, int height, String filePath,Facture f) throws WriterException, IOException
             {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(f.getClient_name(), BarcodeFormat.QR_CODE, width, height);

        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }*/

    public void create(Facture F) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String maill(String id) throws SQLException  {
     
          Facture sp = new Facture (); 
          String a="aymenhergli10@gmail.com";
          //String a="";
     
           Statement stm = DataSource.getInstance().getCon().createStatement();
         //String requete = "SELECT nom,email,address,tel,password,role,categorie,type,description,photo FROM `fos_user` WHERE id="+id+"";
         String requete= "SELECT Email FROM user WHERE FirstName_U="+id+"";
       ResultSet rest= stm.executeQuery(requete);
       a =  rest.getString(1);
       
       
         
        
                
       System.out.print(a);
       return a ;

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


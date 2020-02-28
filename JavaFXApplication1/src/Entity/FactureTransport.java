/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author bazinfo
 */
public class FactureTransport {
    
    private int id;	
    private String delivery_reference;	
    private String  facture_reference;
    private String etat;
    Date Datedelivery;
    
   private String getDateTime() {
    DateFormat Datedelivery = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();
    return Datedelivery.format(date);
}
   

    @Override
    public String toString() {
        return "FactureTransport{" + "id=" + id + ", delivery_reference=" + delivery_reference + ", facture_reference=" + facture_reference + ", etat=" + etat + '}';
    }

    public FactureTransport(String delivery_reference, String facture_reference, String etat) {
        this.delivery_reference = delivery_reference;
        this.facture_reference = facture_reference;
        this.etat = etat;
    }

    public FactureTransport(int id, String delivery_reference, String facture_reference, String etat) {
        this.id = id;
        this.delivery_reference = delivery_reference;
        this.facture_reference = facture_reference;
        this.etat = etat;
    }

    public FactureTransport(int id, String delivery_reference, String facture_reference, String etat, Date Datedelivery) {
        this.id = id;
        this.delivery_reference = delivery_reference;
        this.facture_reference = facture_reference;
        this.etat = etat;
        this.Datedelivery = Datedelivery;
    }

    public String getDelivery_reference() {
        return delivery_reference;
    }

    public void setDelivery_reference(String delivery_reference) {
        this.delivery_reference = delivery_reference;
    }

    public String getFacture_reference() {
        return facture_reference;
    }

    public void setFacture_reference(String facture_reference) {
        this.facture_reference = facture_reference;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatedelivery() {
        return Datedelivery;
    }

    public void setDatedelivery(Date Datedelivery) {
        this.Datedelivery = Datedelivery;
    }
    
}

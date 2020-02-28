/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author aymen
 */
public class Facture {
     private int id_facture;	
    private String reference;	
    private int  id_achat;
    private String client_name;
    private String client_type;
    private String type_facture;
    private String statut_facture;
    private float totalHT;
    private float totalTTC;
    private String echeance;
    private int delivery;
    private String DateFact;

    public Facture(String reference, int id_achat, String client_name, String client_type, String type_facture, String statut_facture, float totalHT, float totalTTC, String echeance, int delivery) {
        this.reference = reference;
        this.id_achat = id_achat;
        this.client_name = client_name;
        this.client_type = client_type;
        this.type_facture = type_facture;
        this.statut_facture = statut_facture;
        this.totalHT = totalHT;
        this.totalTTC = totalTTC;
        this.echeance = echeance;
        this.delivery = delivery;
    }

    public Facture(String reference, int id_achat, String client_name, String client_type, String type_facture, String statut_facture, float totalHT, float totalTTC, String echeance, int delivery, String DateFact) {
        this.reference = reference;
        this.id_achat = id_achat;
        this.client_name = client_name;
        this.client_type = client_type;
        this.type_facture = type_facture;
        this.statut_facture = statut_facture;
        this.totalHT = totalHT;
        this.totalTTC = totalTTC;
        this.echeance = echeance;
        this.delivery = delivery;
        this.DateFact = DateFact;
    }
  

    public int getId_facture() {
        return id_facture;
    }

    public String getReference() {
        return reference;
    }

    public int getId_achat() {
        return id_achat;
    }

    public String getClient_name() {
        return client_name;
    }

    public String getClient_type() {
        return client_type;
    }

    public String getType_facture() {
        return type_facture;
    }

    public String getStatut_facture() {
        return statut_facture;
    }

    public float getTotalHT() {
        return totalHT;
    }

    public float getTotalTTC() {
        return totalTTC;
    }

    public String getEcheance() {
        return echeance;
    }

    public int getDelivery() {
        return delivery;
    }

    public void setId_facture(int id_facture) {
        this.id_facture = id_facture;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setId_achat(int id_achat) {
        this.id_achat = id_achat;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public void setClient_type(String client_type) {
        this.client_type = client_type;
    }

    public void setType_facture(String type_facture) {
        this.type_facture = type_facture;
    }

    public void setDateFact(String DateFact) {
        this.DateFact = DateFact;
    }

    public String getDateFact() {
        return DateFact;
    }

    public void setStatut_facture(String statut_facture) {
        this.statut_facture = statut_facture;
    }

    public void setTotalHT(float totalHT) {
        this.totalHT = totalHT;
    }

    public void setTotalTTC(float totalTTC) {
        this.totalTTC = totalTTC;
    }

    public void setEcheance(String echeance) {
        this.echeance = echeance;
    }

    public void setDelivery(int delivery) {
        this.delivery = delivery;
    }

    public Facture() {
    }

    public Facture(int id_facture,String reference, int id_achat, String client_name, String client_type, String type_facture, String statut_facture, float totalHT, float totalTTC, String echeance, int delivery) {
        this.id_facture = id_facture;
        this.reference = reference;
        this.id_achat = id_achat;
        this.client_name = client_name;
        this.client_type = client_type;
        this.type_facture = type_facture;
        this.statut_facture = statut_facture;
        this.totalHT = totalHT;
        this.totalTTC = totalTTC;
        this.echeance = echeance;
        this.delivery = delivery;
    }

    @Override
    public String toString() {
        return "Facture{" + "id_facture=" + id_facture + ", reference=" + reference + ", id_achat=" + id_achat + ", client_name=" + client_name + ", client_type=" + client_type + ", type_facture=" + type_facture + ", statut_facture=" + statut_facture + ", totalHT=" + totalHT + ", totalTTC=" + totalTTC + ", echeance=" + echeance + ", delivery=" + delivery + '}';
    }

  
    
}

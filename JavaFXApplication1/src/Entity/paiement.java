/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;



/**
 *
 * @author aymen
 */
public class paiement {
    
   private int id_paiement;
   private String reference ;
   private String client_name;
   private String paiement_type;
   private String rib;
   private String num_cheque;

    public paiement(String reference, String client_name, String paiement_type, String rib, String num_cheque) {
        this.reference = reference;
        this.client_name = client_name;
        this.paiement_type = paiement_type;
        this.rib = rib;
        this.num_cheque = num_cheque;
    }

    public int getId_paiement() {
        return id_paiement;
    }

    public void setId_paiement(int id_paiement) {
        this.id_paiement = id_paiement;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getPaiement_type() {
        return paiement_type;
    }

    public void setPaiement_type(String paiement_type) {
        this.paiement_type = paiement_type;
    }

    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }

    public String getNum_cheque() {
        return num_cheque;
    }

    public void setNum_cheque(String num_cheque) {
        this.num_cheque = num_cheque;
    }

    public paiement(int id_paiement, String reference, String client_name, String paiement_type, String rib, String num_cheque) {
        this.id_paiement = id_paiement;
        this.reference = reference;
        this.client_name = client_name;
        this.paiement_type = paiement_type;
        this.rib = rib;
        this.num_cheque = num_cheque;
    }

    @Override
    public String toString() {
        return "paiement{" + "id_paiement=" + id_paiement + ", reference=" + reference + ", client_name=" + client_name + ", paiement_type=" + paiement_type + ", rib=" + rib + ", num_cheque=" + num_cheque + '}';
    }
  
   
   
}

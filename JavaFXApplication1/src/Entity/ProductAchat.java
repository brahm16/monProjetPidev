/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Ibrahim
 */
public class ProductAchat {
    private int id_product_achat;
    private float quantite;
    private String unite;
    private float prixTTC;
    private float prixHT;
    private int id_product;
    private int id_achat;

    public ProductAchat(int id_product_achat, float quantite, String unite, float prixTTC, float prixHT, int product, int achat) {
        this.id_product_achat = id_product_achat;
        this.quantite = quantite;
        this.unite = unite;
        this.prixTTC = prixTTC;
        this.prixHT = prixHT;
        this.id_product = product;
        this.id_achat = achat;
    }

    public ProductAchat(float quantite, int id_product) {
        this.quantite = quantite;
        this.id_product = id_product;
    }

    public ProductAchat(float quantite, String unite, float prixTTC, float prixHT, int product, int achat) {
        this.quantite = quantite;
        this.unite = unite;
        this.prixTTC = prixTTC;
        this.prixHT = prixHT;
        this.id_product = product;
        this.id_achat= achat;
    }

    public ProductAchat(int id_product_achat, float quantite, String unite, float prixTTC, float prixHT) {
        this.id_product_achat = id_product_achat;
        this.quantite = quantite;
        this.unite = unite;
        this.prixTTC = prixTTC;
        this.prixHT = prixHT;
    }
    
    public int getId_product_achat() {
        return id_product_achat;
    }

    public void setId_product_achat(int id_product_achat) {
        this.id_product_achat = id_product_achat;
    }

    public float getQuantite() {
        return quantite;
    }

    public void setQuantite(float quantite) {
        this.quantite = quantite;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public float getPrixTTC() {
        return prixTTC;
    }

    public void setPrixTTC(float prixTTC) {
        this.prixTTC = prixTTC;
    }

    public float getPrixHT() {
        return prixHT;
    }

    public void setPrixHT(float prixHT) {
        this.prixHT = prixHT;
    }

    public int getProduct() {
        return id_product;
    }

    public void setProduct(int product) {
        this.id_product = product;
    }

    public int getAchat() {
        return id_achat;
    }

    public void setAchat(int achat) {
        this.id_achat = achat;
    }

    @Override
    public String toString() {
        return "ProductAchat{" + "id_product_achat=" + id_product_achat + ", quantite=" + quantite + ", unite=" + unite + ", prixTTC=" + prixTTC + ", prixHT=" + prixHT + ", id_product=" + id_product + ", id_achat=" + id_achat + '}';
    }

   

    
}

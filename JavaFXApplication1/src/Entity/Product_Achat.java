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
public class Product_Achat {
    private int id_product_achat;
    private float quantite;
    private Product product;
    private Achat achat;

    public Product_Achat(int id_product_achat, float quantite, Product product, Achat achat) {
        this.id_product_achat = id_product_achat;
        this.quantite = quantite;
        this.product = product;
        this.achat = achat;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Achat getAchat() {
        return achat;
    }

    public void setAchat(Achat achat) {
        this.achat = achat;
    }



    
}

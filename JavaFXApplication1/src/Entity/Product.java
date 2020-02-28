/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;


import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 *
 * @author Ibrahim
 */
public class Product {
    public SimpleIntegerProperty id_product;
    public SimpleStringProperty product_name;
    public SimpleStringProperty product_type;	
    public SimpleStringProperty reference;	
    public SimpleStringProperty marque;	
    public SimpleFloatProperty priceHT;	
    public SimpleFloatProperty priceTTC;	
    public SimpleFloatProperty TVA;	
    public SimpleFloatProperty weight;
    

    public Product() {
    }

    

   

   

    public Product(String product_name, String product_type, String reference, String marque, float priceHT, float TVA, float weight,String photo) {
        this.product_name = new SimpleStringProperty (product_name);
        this.product_type = new SimpleStringProperty(product_type);
        this.reference = new SimpleStringProperty(reference);
        this.marque = new SimpleStringProperty(marque);
        this.priceHT = new SimpleFloatProperty(priceHT);
        this.TVA = new SimpleFloatProperty(TVA);
        this.weight =new SimpleFloatProperty(weight);
        

        
    }

  
     public Product(String product_name, String product_type, String reference, String marque, float priceHT, float TVA, float weight) {
        this.product_name = new SimpleStringProperty (product_name);
        this.product_type = new SimpleStringProperty(product_type);
        this.reference = new SimpleStringProperty(reference);
        this.marque = new SimpleStringProperty(marque);
        this.priceHT = new SimpleFloatProperty(priceHT);
        this.TVA = new SimpleFloatProperty(TVA);
        this.weight =new SimpleFloatProperty(weight);
      

        
    }


    public Product(int id_product, String product_name, String product_type, String reference, String marque, float priceHT, float priceTTC, float TVA, float weight,String photo) {
        this.id_product = new SimpleIntegerProperty (id_product);
        this.product_name = new SimpleStringProperty (product_name);
        this.product_type = new SimpleStringProperty(product_type);
        this.reference = new SimpleStringProperty(reference);
        this.marque = new SimpleStringProperty(marque);
        this.priceHT = new SimpleFloatProperty(priceHT);
        this.TVA = new SimpleFloatProperty(TVA);
        this.weight =new SimpleFloatProperty(weight);
        this.priceTTC = new SimpleFloatProperty (priceTTC);
        //this.photo = new SimpleStringProperty (photo);



    }
     public Product(int id_product, String product_name, String product_type, String reference, String marque, float priceHT, float priceTTC, float TVA, float weight) {
        this.id_product = new SimpleIntegerProperty (id_product);
        this.product_name = new SimpleStringProperty (product_name);
        this.product_type = new SimpleStringProperty(product_type);
        this.reference = new SimpleStringProperty(reference);
        this.marque = new SimpleStringProperty(marque);
        this.priceHT = new SimpleFloatProperty(priceHT);
        this.TVA = new SimpleFloatProperty(TVA);
        this.weight =new SimpleFloatProperty(weight);
        this.priceTTC = new SimpleFloatProperty (priceTTC);
       // this.photo = new SimpleObjectProperty (photo);



    }
    public Product(String product_name, String product_type, String reference, String marque, float priceHT, float priceTTC, float TVA, float weight) {
        
        this.product_name = new SimpleStringProperty (product_name);
        this.product_type = new SimpleStringProperty(product_type);
        this.reference = new SimpleStringProperty(reference);
        this.marque = new SimpleStringProperty(marque);
        this.priceHT = new SimpleFloatProperty(priceHT);
        this.priceTTC = new SimpleFloatProperty(priceTTC);
        this.TVA = new SimpleFloatProperty(TVA);
        this.weight =new SimpleFloatProperty(weight);
    }
  
  
    public int getId_product() {
        return id_product.get();
    }

    public String getProduct_name() {
        return product_name.get();
    }

    public String getProduct_type() {
        return product_type.get();
    }

    public String getReference() {
        return reference.get();
    }

    public String getMarque() {
        return marque.get();
    }

    public float getPriceHT() {
        return priceHT.get();
    }

    public float getPriceTTC() {
        return priceTTC.get();
    }

    public float getTVA() {
        return TVA.get();
    }

    public float getWeight() {
        return weight.get();
    }

    public void setId_product(int id_product) {
        this.id_product.set(id_product);
    }

    public void setProduct_name(String product_name) {
        this.product_name.set(product_name);
    }

    public void setProduct_type(String product_type) {
        this.product_type.set(product_type);
    }

    public void setReference(String reference) {
       this.reference.set(reference);
    }

    public void setMarque(String marque) {
        this.marque.set(marque);
    }

    public void setPriceHT(float priceHT) {
        this.priceHT.set(priceHT);
    }

    public void setPriceTTC(float priceTTC) {
       this.priceTTC .set(priceTTC);
    }

    public void setTVA(float TVA) {
        this.TVA.set(TVA);
    }

    public void setWeight(float weight) {
        this.weight.set(weight);
    }

    @Override
    public String toString() {
       return product_name.get();  

    }


    public String toPdf() {
          
        return "Product" + " "+"id_product=" + id_product.get() +"\n"+"\n"+ "product_name=" + product_name.get() + ", product_type=" + product_type.get() + ", reference=" + reference.get() + ", marque=" + marque.get() + ", priceHT=" + priceHT.get() + ", priceTTC=" + priceTTC.get() + ", TVA=" + TVA.get() + ", weight=" + weight.get() +"\n"+"\n";
    }
    
    
}

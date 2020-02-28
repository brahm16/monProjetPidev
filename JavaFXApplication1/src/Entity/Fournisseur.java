/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Ibrahim
 */
public class Fournisseur {
    private SimpleIntegerProperty id_fournisseur;
    private SimpleStringProperty firstname;
    private SimpleStringProperty lastname;
    private SimpleStringProperty phoneNumber;
    private SimpleStringProperty type_product;
    private SimpleStringProperty address;
    private SimpleStringProperty email;
    

    public Fournisseur(String firstname, String lastname, String phoneNumber, String type_product, String address, String email) {
        this.firstname = new SimpleStringProperty(firstname);
        this.lastname = new SimpleStringProperty(lastname);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.type_product = new SimpleStringProperty(type_product);
        this.address = new SimpleStringProperty(address);
        this.email = new SimpleStringProperty(email);
    }

    public Fournisseur(int id_fournisseur, String firstname, String lastname, String phoneNumber, String type_product, String address, String email) {
        this.id_fournisseur = new SimpleIntegerProperty(id_fournisseur);
         this.firstname = new SimpleStringProperty(firstname);
        this.lastname = new SimpleStringProperty(lastname);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.type_product = new SimpleStringProperty(type_product);
        this.address = new SimpleStringProperty(address);
        this.email = new SimpleStringProperty(email);
    }

    public int getId_fournisseur() {
        return id_fournisseur.get();
    }

    public void setId_fournisseur(int id_fournisseur) {
        this.id_fournisseur.set(id_fournisseur);
    }

    public String getFirstname() {
        return firstname.get();
    }

    public void setFirstname(String firstname) {
        this.firstname.set(firstname);
    }

    public String getLastname() {
        return lastname.get();
    }

    public void setLastname(String lastname) {
        this.lastname.set(lastname);
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public String getType_product() {
        return type_product.get();
    }

    public void setType_product(String type_product) {
        this.type_product.set(type_product);
    }

    public String getAddress() {
        return address.get();
    }

    public void setAddress(String address) {
        this.address.set(address); 
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    @Override
    public String toString() {
        return "Fournisseur{" + "id_fournisseur=" + id_fournisseur.get() + ", firstname=" + firstname.get() + ", lastname=" + lastname.get() + ", phoneNumber=" + phoneNumber.get() + ", type_product=" + type_product.get() + ", address=" + address.get() + ", email=" + email.get() + '}';
    }
    
    
}

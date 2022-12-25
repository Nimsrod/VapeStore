package VapeStore;

import java.util.Objects;
import java.util.Scanner;

public class Product {
    private String idProd, nameProd, prodDrescription, brand;
    private double price;
    private Category category;

    public Product() {
        Scanner sc = new Scanner(System.in);
        String price1;

        System.out.println("Saisir le numéro d'identification du produit : ");
        this.idProd = saisie("[A-Z]{2}[0-9]{4}", "Format d'identification : AZ1234 > Deux lettre majuscule et 4 chiffres\nSaisir le numéro d'identification du produit : ");
        System.out.println("Saisir le nom du produit : ");
        this.nameProd = sc.nextLine();
        System.out.println("Saisir la description du produit : ");
        this.prodDrescription = sc.nextLine();
        System.out.println("Saisir la marque du produit : ");
        this.brand = sc.nextLine();
        System.out.println("Saisir le prix : ");
        do {

            price1 = saisie("[0-9]{0,10}[.][0-9]{0,2}|[0-9]{0,10}", "Erreur de saisie, veuillez saisir un nombre réel (séparée d'un point) supérieur à 0\nSaisir le tarif horaire : ");
            this.price = Double.parseDouble(price1);
            if (this.price <= 0) {
                System.out.println("Erreur, Le prix doit être supérieur à 0");
            }
        } while (this.price <= 0);
        //set Category with setter in Gestion when Category has been created.
        //have to create cat 1st => Then add when addProd in Gestion
        this.category = null;
    }

    public Product(String idProd){
        this.idProd = idProd;
        this.nameProd ="";
        this.prodDrescription = "";
        this.brand ="";
        this.price = 0;
        this.category = null;
    }

    public Product (String idProd, String nameProd, String prodDrescription, String brand, double price, Category cat){
        this.idProd = idProd;
        this.nameProd = nameProd;
        this.prodDrescription = prodDrescription;
        this.brand = brand;
        this.price = price;
        this.category = cat;
    }

    public void setIdProd(String idProd) {
        this.idProd = idProd;
    }

    public void setNameProd(String nameProd) {
        this.nameProd = nameProd;
    }

    public void setProdDrescription(String prodDrescription) {
        this.prodDrescription = prodDrescription;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getIdProd() {
        return idProd;
    }

    public String getNameProd() {
        return nameProd;
    }

    public String getProdDrescription() {
        return prodDrescription;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }


    public Category getCategory() {
        return category;
    }

    //equals on idProd , Name and Brand
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(idProd, product.idProd) || Objects.equals(nameProd, product.nameProd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProd, nameProd);
    }

    @Override
    public String toString() {
        return "\nclé du Produit : " + idProd +
                "\t\tNom du produit : " + nameProd +
                "\nDescription : " + prodDrescription +
                "\nMarque : " + brand +
                "\nPrix : " + price + "€\n";
    }

    public String saisie(String regex, String message) {
        Scanner sc = new Scanner(System.in);
        boolean check = false;
        String phrase;
        do {
            phrase = sc.nextLine();
            if (phrase.matches(regex)) {
                check = true;
            } else {
                System.out.println(message);
            }
        } while (!check);
        return phrase;
    }


}

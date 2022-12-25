package VapeStore;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Order {
    private int idOrder;
    private String dateOrder;
    private double priceTot;
    private HashMap<Product, Integer> ProdDetails;
    //https://www.geeksforgeeks.org/java-util-hashmap-in-java-with-examples/
    private static int orderNbrAtm = 1;

    public Order() {
        //idOrder start from 1 then increment each object created from static orderNbrAtm
        //https://stackoverflow.com/questions/15866028/auto-generate-id
        this.idOrder = orderNbrAtm;
        orderNbrAtm++;
        //https://stackoverflow.com/questions/25963720/how-to-compare-two-string-dates-in-java
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDateTime localDateTime = LocalDateTime.now();
        String data = dateTimeFormatter.format(localDateTime);
        this.dateOrder = data;
        this.priceTot = 0;
        ProdDetails = new HashMap<>();
    }

    //TODO delete after testing
    //to test all methods inside gestion => insert != orders
    public Order(String date, int idOrder, HashMap<Product,Integer> ProdDetails){
        this.dateOrder = date;
        this.idOrder = idOrder;
        this.ProdDetails = ProdDetails;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public String getDateOrder() {
        return dateOrder;
    }

    public double getPriceTot() {
        return priceTot;
    }

    public void setPriceTot() {
        double priceTot = 0;
        for(Map.Entry<Product, Integer> o : ProdDetails.entrySet() ){
            //System.out.println("Produit : " + o.getKey().getNameProd() + "\n" + "Quantité : " + o.getValue());
            priceTot+= (o.getKey().getPrice()) * o.getValue();
        }

        //round number to avoid super long decimal
        this.priceTot = Math.round(priceTot * 100.0) / 100.0;
    }

    public void setProdDetails(HashMap<Product, Integer> prodDetails) {
        ProdDetails = prodDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return idOrder == order.idOrder && Objects.equals(dateOrder, order.dateOrder) && Objects.equals(ProdDetails, order.ProdDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrder, dateOrder, ProdDetails);
    }

    @Override
    public String toString() {
        String det = "\n\nDétails de la commande :\n\n";
        for(Map.Entry<Product,Integer> d:ProdDetails.entrySet()){
            det += "Id produit : " + d.getKey().getIdProd() + "\t Nom : " + d.getKey().getNameProd() + "\t" + "Quantité : " + d.getValue();
            det += "\nPrix unitaire : " + d.getKey().getPrice() + "€ \tMarque : "  + d.getKey().getBrand()+ "\n" + "\t\tSous-total : " + d.getKey().getPrice() * d.getValue() + "€\n\n";
        }

        return "\nN° de commande :" + idOrder +
                "\t\tDate de la commande : " + dateOrder +
                "\nPrix total : " + priceTot + "€" +
                det;
    }

}

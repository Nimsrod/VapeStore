package VapeStore;

import java.util.Objects;
import java.util.Scanner;

public class Category {

    private String catName, catDescription;
    private Category catParent;

    public Category() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Saisir le nom de la catégorie : ");
        this.catName = sc.nextLine();
        System.out.println("Saisir la description de la catégorie : ");
        this.catDescription = sc.nextLine();
        this.catParent = null;
    }

    public Category(String catName, String catDescription, Category parentCat) {
        this.catName = catName;
        this.catDescription = catDescription;
        this.catParent = parentCat;
    }

    //deep cloning
    public Category(Category catCopy) {
        this.catName = catCopy.catName;
        this.catDescription = catCopy.catDescription;
        this.catParent = catCopy.catParent;
    }

    public String getCatName() {
        return catName;
    }

    public String getCatDescription() {
        return catDescription;
    }

    public Category getCatParent() {
        return catParent;
    }

    public void setCatParent(Category catParent) {
        this.catParent = catParent;
    }

    //check on category name only
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(catName, category.catName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(catName);
    }

    @Override
    public String toString() {

        return "Nom de la catégorie : " + catName + "\nDescription : " + catDescription;
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

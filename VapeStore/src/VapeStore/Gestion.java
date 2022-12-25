package VapeStore;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Gestion {
    private List<Product> allProducts;
    private List<Category> allCategories;
    private List<Order> allOrders;
    private Scanner sc = new Scanner(System.in);

    public Gestion() {

        allProducts = new ArrayList<>();
        allCategories = new ArrayList<>();
        allOrders = new ArrayList<>();
        //TODO delete those 3 methods below after testing
        addCatsEasyTest();
        addProdsEasyTest();
        addOrderEaseTest();
        menu();
    }

    public void menu() {
        String choice1;
        String option = "\n1.Gestion des catégories\n2.Ajouter un produit\n3.Supprimer un produit\n4.Consulter et modifier les produits\n5.Encoder une vente\n6.Consulter les ventes\n7.Quitter";
        int choice;
        System.out.println("\n--- Vape Store ---");

        do {
            do {
                System.out.println(option);
                System.out.print("\nVotre choix : ");
                choice1 = saisie("[1-7]{1}", "Veuillez Saisir un nombre compris entre 1 et 7.\nVotre choix : ");
                choice = Integer.parseInt(choice1);
            } while (choice < 1 || choice > 7);

            switch (choice) {
                case 1 -> menuCategories(); //categorie add
                case 2 -> addProduct();
                case 3 -> deleteProd();
                case 4 -> menuConsultProd();
                case 5 -> encodeOrder();
                case 6 -> menuOrders();
                case 7 -> System.out.println("\nAu revoir.\n");
                default -> System.out.println("\nErreur de saisie");
            }
        } while (choice != 7);
    }

    public String saisie(String regex, String message) {
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

    //insert categories
    public void addCatsEasyTest() {
        Category c1 = new Category("Cigarettes électroniques", "Cigarettes électroniques de marques diverses", null);
        allCategories.add(c1);
        Category c1_1 = new Category("Pack complet", "Cigarettes électroniques - pack complet", c1);
        allCategories.add(c1_1);
        Category c1_2 = new Category("Accessoires", "Accessoire pour cigarettes électroniques", c1);
        allCategories.add(c1_2);
        Category c2 = new Category("Liquides", "Liquides pour cigarettes électroniques", null);
        allCategories.add(c2);
        Category c2_1 = new Category("Base", "Liquides \"Do it yourself\" sans arômes, sans nicotine", c2);
        allCategories.add(c2_1);
        Category c2_2 = new Category("Nicotine Boost", "Boost de nicotine à ajouter au liquide de base", c2);
        allCategories.add(c2_2);
        Category c2_3 = new Category("Arômes", "Arômes à ajouter au liquide de base", c2);
        allCategories.add(c2_3);
        Category c2_4 = new Category("Liquides prêt à l'emploi", "Liquides avec ou sans nicotines, prêt à l'emploi", c2);
        allCategories.add(c2_4);
    }

    //insert products
    public void addProdsEasyTest() {
        Product p1 = new Product("CG0001", "Cigarettes électronique Pico 1000", "Pack complet comprenant\n\tUne cigarette électronique\n\t1 batterie\n\t3 résistances\n\t1 Manuel\n\t1 chargeur usb", "Eleaf", 59.99, allCategories.get(1));
        allProducts.add(p1);
        Product p2 = new Product("CG0002", "Cigarette électronique Pico 2000", "Pack complet comprenant\n\tUne cigarette électronique\n\t2 batteries\n\t3 résistances\n\t1 Manuel\n\t1 chargeur usb", "Eleaf", 89.99, allCategories.get(1));
        allProducts.add(p2);
        Product p3 = new Product("CG0003", "Cigarette électronique Whirl X1000", "Pack complet comprenant\n\tUne cigarette électronique\n\t2 batteries\n\t1 Manuel\n\t1 chargeur usb", "Storm", 70, allCategories.get(1));
        allProducts.add(p3);
        Product p4 = new Product("AC0001", "Pyrex 32mm", "Pyrex 32mm (contenance 3ml).\nCompatible : PICO 1000, PICO 2000, PICO XTREME", "Eleaf", 3, allCategories.get(2));
        allProducts.add(p4);
        Product p5 = new Product("AC0002", "Pyrex 50mm", "Pyrex 32mm (contenance 6ml).\nCompatible : PICO 1000, PICO 2000, PICO XTREME", "Eleaf", 4, allCategories.get(2));
        allProducts.add(p5);
        Product p6 = new Product("AC003", "Pyrex 40mm", "Pyrex 40mm (contenance 4ml) compatible Whirl 1000, X1000 , Marbles", "Storm", 3.5, allCategories.get(2));
        allProducts.add(p6);
        Product p7 = new Product("LB0001", "Liquide de base 250ml", "Liquide PG50/VG50 sans arômes, sans nicotine\n\tFormat 250ml", "Belgi'Ohm", 8.99, allCategories.get(4));
        allProducts.add(p7);
        Product p8 = new Product("LB0002", "Liquide de base 500ml", "Liquide PG50/VG50 sans arômes, sans nicotine\n\tFormat 500ml", "Belgi'Ohm", 16.99, allCategories.get(4));
        allProducts.add(p8);
        Product p9 = new Product("LB0003", "Liquide de base 1L", "Liquide PG50/VG50 sans arômes, sans nicotine\n\tFormat 1L", "Belgi'Ohm", 20, allCategories.get(4));
        allProducts.add(p9);
        Product p10 = new Product("NB0001", "Boost Nicotine 12mg", "Liquide PG50/VG50 sans arômes, 12mg de nicotine\n\tFormat 10ml", "Belgi'Ohm", 2.99, allCategories.get(5));
        allProducts.add(p10);
        Product p11 = new Product("NB0002", "Boost Nicotine 24mg", "Liquide PG50/VG50 sans arômes, 24mg de nicotine\n\tFormat 10ml", "Belgi'Ohm", 2.99, allCategories.get(5));
        allProducts.add(p11);
        Product p12 = new Product("NB0003", "Boost Nicotine 36mg", "Liquide PG50/VG50 sans arômes, 36mg de nicotine\n\tFormat 10ml", "Belgi'Ohm", 2.99, allCategories.get(5));
        allProducts.add(p12);
        Product p13 = new Product("AR0001", "Arômes Marlboro 10ml", "Liquide PG50/VG50 arôme Marlboro, sans nicotine  à mélanger sois-même\n\tFormat 25ml", "Tasty", 9.99, allCategories.get(6));
        allProducts.add(p13);
        Product p14 = new Product("AR0002", "Arômes Bubble gum 10ml", "Liquide PG50/VG50 arôme Bubble gum, sans nicotine  à mélanger sois-même\n\tFormat 25ml", "Tasty", 9.99, allCategories.get(6));
        allProducts.add(p14);
        Product p15 = new Product("AR0003", "Arômes Cookies 10ml", "Liquide PG50/VG50 arôme Cookie, sans nicotine à mélanger sois-même\n\tFormat 25ml", "Tasty", 9.99, allCategories.get(6));
        allProducts.add(p15);
        Product p16 = new Product("LP0001", "Liquide Cookies 150ml", "Liquide PG50/VG50 arôme Cookie, sans nicotine\n\tFormat 150ml", "Tasty", 19.99, allCategories.get(7));
        allProducts.add(p16);
        Product p17 = new Product("LP0002", "Liquide Bubble gum 150ml", "Liquide PG50/VG50 arôme bubble gum, sans nicotine\n\tFormat 150ml", "Tasty", 19.99, allCategories.get(7));
        allProducts.add(p17);
        Product p18 = new Product("LP0003", "Liquide Menthol 150ml", "Liquide PG50/VG50 arôme menthol, sans nicotine\n\tFormat 150ml", "Tasty", 19.99, allCategories.get(7));
        allProducts.add(p18);
    }


    public void addOrderEaseTest(){
        HashMap<Product,Integer> or1 = new HashMap<>();
        or1.put(allProducts.get(0),2);
        or1.put(allProducts.get(2),1);
        //999 to make sure it doesn't bother the encoded order which start at 1
        Order o1 = new Order("11.12.1989",999,or1);
        o1.setPriceTot();
        allOrders.add(o1);
        HashMap<Product,Integer> or2 = new HashMap<>();
        or2.put(allProducts.get(4),2);
        or2.put(allProducts.get(2),1);
        Order o2 = new Order("11.11.1989",998,or2);
        o2.setPriceTot();
        allOrders.add(o2);
        HashMap<Product,Integer> or3 = new HashMap<>();
        or3.put(allProducts.get(16),2);
        or3.put(allProducts.get(12),1);
        Order o3 = new Order("17.07.2009",997,or3);
        o3.setPriceTot();
        allOrders.add(o3);
        HashMap<Product,Integer> or4 = new HashMap<>();
        or4.put(allProducts.get(8),2);
        or4.put(allProducts.get(5),1);
        Order o4 = new Order("01.01.2022",996,or4);
        o4.setPriceTot();
        allOrders.add(o4);
    }

    //all methods about category
    public void menuCategories() {
        String choiceCat1;
        String optionCat = "1.Nouvelle catégorie\n2.Nouvelle sous-catégorie\n3.Voir l'arborescence de catégories\n4.Retour au menu principal\n\nVotre choix : ";
        int choiceCat;

        do {
            System.out.println(optionCat);
            choiceCat1 = saisie("[1-4]{1}", "Veuillez saisir un nombre compris entre 1 et 4\nVotre choix : ");
            choiceCat = Integer.parseInt(choiceCat1);
            switch (choiceCat) {
                case 1 -> addMainCat();
                case 2 -> addSubCat();
                case 3 -> printCategTree();
                case 4 -> System.out.println("");
            }
        } while (choiceCat != 4);
    }

    //add category where catParent is NULL => MainCategory
    public void addMainCat() {
        Category catTmp = new Category();

        if (!isCatExist(catTmp)) {
            allCategories.add(catTmp);
        } else {
            System.out.println("La catégorie existe déja");
        }
    }

    public void addSubCat() {
        String choiceMainCat1;
        int choiMainCat;
        ArrayList<Category> mainCateg = new ArrayList<>();
        mainCateg = getAllMainCat();
        int sizeMainCat = mainCateg.size();
        String msgChoice = "Veuillez saisir un chiffre entre 1 et " + sizeMainCat + "\nVotre choix : ";

        do {
            printArrCat(mainCateg);
            System.out.println("Votre choix : ");
            choiceMainCat1 = saisie("[1-9]{1,3}", msgChoice);
            choiMainCat = Integer.parseInt(choiceMainCat1);
        } while (choiMainCat < 1 || choiMainCat > mainCateg.size());

        //choice of main cat => mainCateg.get(choiMainCat-1);
        Category subCat = new Category();
        subCat.setCatParent(mainCateg.get(choiMainCat - 1));

        if (!isCatExist(subCat)) {
            allCategories.add(subCat);
        } else {
            System.out.println("Cette catégorie existe déja.");
        }

    }

    //create and return an array list of all category without a catParent;
    public ArrayList<Category> getAllMainCat() {
        ArrayList<Category> mainCats = new ArrayList<>();

        for (Category mc : allCategories) {
            if (mc.getCatParent() == null) {
                mainCats.add(mc);
            }
        }
        Collections.sort(mainCats, new SortCatByName());

        return mainCats;
    }

    //return Array of all subCategory of Category passed in (mainCat)
    public ArrayList<Category> getAllSubCat(Category mainCat) {
        ArrayList<Category> subCatOf = new ArrayList<>();

        for (Category c : allCategories) {
            if (mainCat.equals(c.getCatParent())) {
                subCatOf.add(c);
            }
        }
        return subCatOf;
    }

    //print any ArrayList of Category , with a number, starting from 1
    public void printArrCat(ArrayList<Category> cats) {
        int i = 1;

        for (Category c : cats) {
            System.out.println(i + " - " + c + " \n");
            i++;
        }
    }

    //check if newly created Category is in allCategory ArrayList<Category>
    //return false if not in array || return true if found in array (EQUALS => based on catName)
    public boolean isCatExist(Category catToVerif) {
        boolean checkCat = false;

        for (Category c : allCategories) {
            if (catToVerif.equals(c)) {
                checkCat = true;
            }
        }
        return checkCat;
    }

    public void printCategTree() {
        ArrayList<Category> mainCateg = new ArrayList<>();
        ArrayList<Category> subCateg = new ArrayList<>();
        int i = 1, j;

        mainCateg = getAllMainCat();

        //sort category by name (alphabetical order)
        Collections.sort(mainCateg, new SortCatByName());

        for (Category ct : mainCateg) {
            System.out.println(i + " - " + ct + "\n");
            subCateg = getAllSubCat(ct);
            Collections.sort(subCateg, new SortCatByName());
            j = 1;
            for (Category s : subCateg) {

                System.out.println("\t\t" + i + " ~ " + j + " - " + s);
                j++;
            }
            System.out.println("\n\n");
            i++;
        }
    }

    //all methods about Product ----------------------------------------

    public void addProduct() {
        String choiceMain1, choiceSub1;
        int choiceMain, choiceSub;
        boolean checkProdExist;
        ArrayList<Category> mainCats = new ArrayList<>();
        ArrayList<Category> subCats = new ArrayList<>();

        mainCats = getAllMainCat();
        String msgMain = "Veuillez choisir un nombre compris entre 1 et " + mainCats.size() + ".\nVotre choix : ";

        do {
            System.out.println("--- Choix de la catégorie principale du produit --- \n");
            printArrCat(mainCats);
            System.out.println("Votre choix : ");
            choiceMain1 = saisie("[0-9]{1,3}", msgMain);
            choiceMain = Integer.parseInt(choiceMain1);
            if (choiceMain < 1 || choiceMain > mainCats.size()) {
                System.out.println(msgMain);
            }
        } while (choiceMain < 1 || choiceMain > mainCats.size());

        //choose main cat => get all subcategory of chosen main category
        subCats = getAllSubCat(mainCats.get(choiceMain - 1));
        String msgSub = "Veuillez saisir un nombre compris entre 1 et " + subCats.size() + ".\nVotre choix : ";

        do {
            System.out.println("\n\n--- Choix de la sous-catégorie du produit ---");
            printArrCat(subCats);
            System.out.println("Votre choix : ");
            choiceSub1 = saisie("[0-9]{1,4}", msgSub);
            choiceSub = Integer.parseInt(choiceSub1);
            if (choiceSub < 1 || choiceSub > subCats.size()) {
                System.out.println(msgSub);
            }
        } while (choiceSub < 1 || choiceSub > subCats.size());

        //chosen cat for product is subCats.get(choiceSub-1);
        Product prodTmp = new Product();
        prodTmp.setCategory(subCats.get(choiceSub - 1));
        checkProdExist = isProdExist(prodTmp);
        if (!checkProdExist) {
            allProducts.add(prodTmp);
            System.out.println("\nLe produit " + prodTmp.getNameProd() + "(id : " + prodTmp.getIdProd() + ") a été enregistré.");
        } else {
            System.out.println("Le produit existe déjà");
        }

    }

    //return true if object passed is in allProducts Array
    //equals based on idProd OR nameProd
    public boolean isProdExist(Product prod) {
        boolean checkProd = false;

        for (Product p : allProducts) {
            if (prod.equals(p)) {
                checkProd = true;
            }
        }
        return checkProd;
    }

    public void deleteProd() {
        String choiceProd1;
        int choiceProd, i = 1;
        String msgPr = "Veuillez saisir un nombre entre 1 et " + allProducts.size() + "\nVotre choix : ";

        for (Product p : allProducts) {
            System.out.println(i + " - " + "\tn°produit : " + p.getIdProd() + "\nNom produit : " + p.getNameProd() + "\nCategorie : " + p.getCategory().getCatName() + "\n");
            i++;
        }

        if (!allProducts.isEmpty()) {
            System.out.println("Votre choix : ");
            do {

                choiceProd1 = saisie("[0-9]*", msgPr);
                choiceProd = Integer.parseInt(choiceProd1);
                if (choiceProd < 1 || choiceProd > allProducts.size()) {
                    System.out.println(msgPr);
                }
            } while (choiceProd < 1 || choiceProd > allProducts.size());
            System.out.println(allProducts.get(choiceProd - 1) + "\nProduit effacé");
            allProducts.remove(choiceProd - 1);
        } else {
            System.out.println("Aucun produit enregistré");
        }

    }

    public ArrayList<Product> seeProdsPerCat() {
        String choiceMain1, choiceSub1;
        int choiceMain, choiceSub;
        ArrayList<Category> mainCats = new ArrayList<>();
        ArrayList<Category> subCats = new ArrayList<>();
        ArrayList<Product> prodPerCat = new ArrayList<>();

        mainCats = getAllMainCat();
        String msgM = "Veuillez saisir un nombre compris entre 1 et " + mainCats.size() + "\nVotre choix : ";
        do {
            printArrCat(mainCats);
            System.out.println("Votre choix : ");
            choiceMain1 = saisie("[0-9]{1,3}", msgM);
            choiceMain = Integer.parseInt(choiceMain1);
            if (choiceMain < 1 || choiceMain > mainCats.size()) {
                System.out.println(msgM);
            }
        } while (choiceMain < 1 || choiceMain > mainCats.size());

        // choice main cat = mainCats.get(choiceMain-1)
        subCats = getAllSubCat(mainCats.get(choiceMain - 1));
        String msgS = "Veuillez saisir un nombre compris entre 1 et " + subCats.size() + "\nVotre choix : ";

        do {
            printArrCat(subCats);
            System.out.println("votre choix : ");
            choiceSub1 = saisie("[0-9]{1,3}", msgS);
            choiceSub = Integer.parseInt(choiceSub1);
            if (choiceSub < 1 || choiceSub > subCats.size()) {
                System.out.println(msgS);
            }
        } while (choiceSub < 1 || choiceSub > subCats.size());

        //making a shallow copy of all prods of chosen subCat
        prodPerCat = getProdsPerCateg(subCats.get(choiceSub - 1));
        printArrProd(prodPerCat);

        return prodPerCat;
    }

    //Return an arraylist of prod per category
    public ArrayList<Product> getProdsPerCateg(Category categ) {
        Product shallowCopyOf;
        ArrayList<Product> prodPerCat = new ArrayList<>();

        for (Product p : allProducts) {
            if (p.getCategory().equals(categ)) {
                prodPerCat.add(p);
            }
        }

        return prodPerCat;
    }

    public void getProdsPerBrand() {
        String choiceBrd1;
        int choiceBrd;
        ArrayList<String> allBrands = new ArrayList<>();

        if (allProducts.isEmpty()) {
            System.out.println("Aucun produit enregistré");
        } else {
            for (Product p : allProducts) {
                //check if String isn't already in allBrands
                if (!allBrands.contains(p.getBrand())) {
                    allBrands.add(p.getBrand());
                }
            }
        }

        int i = 1;
        for (String b : allBrands) {
            System.out.println(i + " - " + b + "\n");
            i++;
        }

        String msgBrd = "Veuillez saisir un nombre compris entre 1 et " + allBrands.size() + "\nVotre choix :";

        do {
            System.out.println("Votre choix : ");
            choiceBrd1 = saisie("[0-9]", msgBrd);
            choiceBrd = Integer.parseInt(choiceBrd1);
            if (choiceBrd < 1 || choiceBrd > allBrands.size()) {
                System.out.println(msgBrd);
            }
        } while (choiceBrd < 1 || choiceBrd > allBrands.size());

        //brand chose = allBrands.get(choiceBrd-1)
        int j = 1;
        for (Product p : allProducts) {
            if (p.getBrand().equalsIgnoreCase(allBrands.get(choiceBrd - 1))) {
                System.out.println(j + " - " + p + "\n");
                j++;
            }
        }
    }


    public void printArrProd(ArrayList<Product> prodArray) {
        int i = 1;

        for (Product p : prodArray) {
            System.out.println(i + " - " + p + "\n");
            i++;
        }

    }

    public void menuConsultProd() {
        int choiceM;
        String choiceM1;
        String option = "\n1.Voir tous les produits\n2.Produits par catégorie\n3.Produits par marques\n4.Modifier un produit\n5.Retour au menu principal\nVotre choix : ";

        do {
            System.out.println(option);
            choiceM1 = saisie("[1-5]", "Veuillez saisir un nombre compris entre 1 et 5\nVotre choix : ");
            choiceM = Integer.parseInt(choiceM1);

            if (!allProducts.isEmpty()) {
                switch (choiceM) {
                    case 1 -> printArrProd((ArrayList<Product>) allProducts);
                    case 2 -> seeProdsPerCat();
                    case 3 -> getProdsPerBrand();
                    case 4 -> modifProd();
                }
            } else {
                System.out.println("Aucun produit enregistré");
            }

        } while (choiceM != 5);
    }

    public void modifProd() {
        String choice1, choiceOpt1;
        String msgProd = "Veuillez saisir un numéro entre 1 et " + allProducts.size() + "\nVotre choix : ";
        int choice, choiceOpt;

        //order by alphabetical order ASC
        Collections.sort(allProducts, new SortProdByName());
        printArrProd((ArrayList<Product>) allProducts);

        do {
            System.out.println("Votre choix : ");
            choice1 = saisie("[0-9]*", msgProd);
            choice = Integer.parseInt(choice1);
            if (choice < 1 || choice > allProducts.size()) {
                System.out.println(msgProd);
            }
        } while (choice < 1 || choice > allProducts.size());

        String optionModif = "\n1.Modifier l'id produit\n2.Modifier le nom du produit\n3.Modifier la description du produit\n4.Modifier le prix.\n5.Retour au menu principal";

        do {
            System.out.println("Produit choisi : \n" + allProducts.get(choice - 1) + "\n");
            System.out.println(optionModif);
            System.out.println("Votre choix : ");
            choiceOpt1 = saisie("[1-5]", "Veuillez saisir un numéro compris entre 1 et 5\nVotre choix ");
            choiceOpt = Integer.parseInt(choiceOpt1);
            switch (choiceOpt) {
                case 1:
                    String newId;
                    boolean checkId;

                    System.out.println("Ancien Id : " + allProducts.get(choice - 1).getIdProd());
                    System.out.println("Saisir le nouveau numéro d'identification du produit : ");
                    newId = saisie("[A-Z]{2}[0-9]{4}", "Format d'identification : AZ1234 > Deux lettre majuscule et 4 chiffres\nSaisir le numéro d'identification du produit : ");
                    Product tmp1 = new Product(newId);
                    checkId = isProdExist(tmp1);

                    if (!checkId) {
                        allProducts.get(choice - 1).setIdProd(newId);
                    } else {
                        System.out.println("Erreur cet Id produit existe déjà");
                    }
                    //don't need tmp  no more , was just created to check if ID existed b4
                    tmp1 = null;
                    break;

                case 2:
                    String newName;
                    boolean check2;

                    System.out.println("Ancien nom : " + allProducts.get(choice - 1).getNameProd());
                    System.out.println("Entrer un nouveau nom : ");
                    newName = sc.nextLine();
                    Product tmp2 = new Product("TP");
                    tmp2.setNameProd(newName);
                    check2 = isProdExist(tmp2);

                    if (!check2) {
                        allProducts.get(choice - 1).setNameProd(newName);
                    } else {
                        System.out.println("Le nouveau nom du produit existe déjà");
                    }
                    break;

                case 3:
                    String newDescrip;

                    System.out.println("Ancienne description : " + allProducts.get(choice - 1).getProdDrescription());
                    System.out.println("Saisir la nouvelle description : ");
                    newDescrip = sc.nextLine();
                    allProducts.get(choice - 1).setProdDrescription(newDescrip);

                    System.out.println("\n\n" + allProducts.get(choice - 1));
                    break;

                case 4:
                    String newPrice1;
                    double newPrice;

                    System.out.println("Ancien prix : " + allProducts.get(choice - 1).getPrice() + "€");
                    System.out.println("Saisir le nouveau prix : ");
                    do {
                        newPrice1 = saisie("[0-9]{0,10}[.][0-9]{0,2}|[0-9]{0,10}", "Veuillez saisir un nombre décimal (séparée d'un point) supérieur à 0\nSaisir le nouveau prix : ");
                        newPrice = Double.parseDouble(newPrice1);
                    } while (newPrice <= 0);

                    allProducts.get(choice - 1).setPrice(newPrice);
                    System.out.println("\n\n" + allProducts.get(choice - 1));

                    break;
            }
        } while (choiceOpt != 5);

    }

    //methods about the orders

    public void encodeOrder() {
        ArrayList<Product> prodsPerCat;
        Map<Product, Integer> orderDetails = new HashMap<>();
        Order o1 = new Order();
        int keepOn, choiceProd, qtityProd;
        String keepsOn, choiceProd1, qtityProd1, msgKeep = "Ajouter un autre produit à la commande ?\n1.Oui\n2.Non\nVotre choix :";
        double priceOrderTot = 0;
        boolean checkDetails;

        System.out.println("N° de commande  :" + o1.getIdOrder() + "\t\tDate de commande : " + o1.getDateOrder() + "\n");
        do {
            System.out.println("Choisir la catégorie du produit à ajouter : ");
            // pick a category, pick a product, add it to the basket (HashMap inside Order Object)
            prodsPerCat = seeProdsPerCat();
            if (!prodsPerCat.isEmpty()) {
                printArrProd(prodsPerCat);
                String msgProd = "Veuillez saisir un nombre entre 1 et " + prodsPerCat.size() + "\nVotre choix : ";
                System.out.println("Votre choix : ");

                do {
                    choiceProd1 = saisie("[0-9]", msgProd);
                    choiceProd = Integer.parseInt(choiceProd1);
                    if (choiceProd < 1 || choiceProd > prodsPerCat.size()) {
                        System.out.println(msgProd);
                    }
                } while (choiceProd < 1 || choiceProd > prodsPerCat.size());

                do {
                    System.out.println("Quelle quantité du produit : ");
                    qtityProd1 = saisie("[0-9]", "Veuillez saisir un nombre supérieur à 0");
                    qtityProd = Integer.parseInt(qtityProd1);
                } while (qtityProd < 1);


                //check if product isn't already in map
                if (!orderDetails.containsKey(prodsPerCat.get(choiceProd - 1))) {
                    orderDetails.put(prodsPerCat.get(choiceProd - 1), qtityProd);
                } else {
                    System.out.println("Le produit est déja dans le panier");
                }
            } else {
                System.out.println("Pas de produit dans cette catégorie");
            }

            System.out.println(msgKeep);
            keepsOn = saisie("[1-2]{1}", msgKeep);
            keepOn = Integer.parseInt(keepsOn);
        } while (keepOn != 2);

        //Once done, add the products and quantities to the order (HashMap)
        o1.setProdDetails((HashMap<Product, Integer>) orderDetails);
        System.out.println("n° de commande : " + o1.getIdOrder() + "\t\tDate : " + o1.getDateOrder());

        //set price ,calculate the total once the HashMap has been added to order
        o1.setPriceTot();

        System.out.println("\nPrix total de la commande : " + o1.getPriceTot() + " € ");
        allOrders.add(o1);
        System.out.println("\nRécapitulatif : \n");
        System.out.println(o1);
        o1 = null;
    }

    //orders' menu
    public void menuOrders() {
        int choiceMenu;
        String choiceMenu1, msgMenu = "Veuillez saisir un nombre compris entre 1 et 4.\nVotre choix : ";
        String option = "1.Voir les ventes du jour\n2.Voir les vente à partir d'une date saisie\n3.Voir toutes les ventes\n4.Retour au menu principal\n";

        do {
            System.out.println(option);
            System.out.println("Votre choix : ");
            do {
                choiceMenu1 = saisie("[1-4]{1}", msgMenu);
                choiceMenu = Integer.parseInt(choiceMenu1);
            } while (choiceMenu < 1 || choiceMenu > 4);

            switch (choiceMenu) {
                case 1 -> seeTodayOrdr();
                case 2 -> seeOrderFrom();
                case 3 -> seeAllOrdr();
            }
        } while (choiceMenu != 4);
    }

    public void seeTodayOrdr() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDateTime localDateTime = LocalDateTime.now();
        String today = dateTimeFormatter.format(localDateTime);
        int i = 1;

        System.out.println("Date du jour : " + today);
        for (Order o : allOrders) {
            if (o.getDateOrder().equals(today)) {
                System.out.println(i + " - " + o);
                i++;
            }
        }
    }

    //will be the same as seeTodayOrdr => can't save the orders atm , will be != with SQL
    public void seeAllOrdr() {
        int i = 1;

        for (Order o : allOrders) {
            System.out.println(i + " - " + o);
            i++;
        }

    }

    public void seeOrderFrom() {
        String choiceDate;
        boolean checkDate;
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        //interface DateValidator check if the date is a correct calendar date
        //  https://www.baeldung.com/java-string-valid-date
        //  https://www.baeldung.com/java-comparing-dates
        do {
            System.out.println("Entre une date : ");
            choiceDate = saisie("[0-9]{2}[.][0-9]{2}[.][0-9]{4}", "Veuillez saisir une date au format dd.MM.yyyy");
            DateValidator verif = new DateValidatorUsingDateTimeFormatter();
            checkDate = verif.isValid(choiceDate);

            if (!checkDate) {
                System.out.println("Erreur, la date entrée n'est pas valide.");
            }
        } while (!checkDate);

        LocalDate pickDate = LocalDate.parse(choiceDate, format);
        int i = 1;
        for (Order o : allOrders) {
            String dateOrd = o.getDateOrder();
            LocalDate ordDate = LocalDate.parse(o.getDateOrder(), format);
            if (ordDate.isAfter(pickDate)) {
                System.out.println(i + " - " + o);
                i++;
            }
        }

    }


}

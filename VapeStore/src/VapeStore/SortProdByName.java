package VapeStore;

import java.util.Comparator;

public class SortProdByName implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o1.getNameProd().compareTo(o2.getNameProd());
    }
}

package VapeStore;

import java.util.Comparator;

public class SortCatByName implements Comparator<Category> {

    @Override
    public int compare(Category o1, Category o2) {
        return o1.getCatName().compareTo(o2.getCatName());
    }
}

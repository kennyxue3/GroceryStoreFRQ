import java.util.ArrayList;

public class GroceryStore {
    /**
     * An array of products normally stocked at the grocery store
     * Guaranteed not to be null and to contain only non-null entries
     */
    private Product[] productsStocked;

    public GroceryStore(Product[] initialInventory) {
        productsStocked = initialInventory;
    }

    /**
     * Returns an ArrayList of indices for Product elements in the
     * productsStocked array that need to be reordered, as described in part (a)
     * Precondition: min > 0
     */
    public ArrayList<Integer> getReorderList(int min) {
        ArrayList<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < productsStocked.length; i++) {
            if (productsStocked[i].getQuantity() <= min) {
                indexes.add(i);
            }
        }
        return indexes;
    }

    /**
     * Returns true if all products named in shoppingList are available for purchase
     * and returns false otherwise, as described in part (b)
     * Precondition: The products named in shoppingList are found exactly once
     * in the productsStocked array.
     */
    public boolean checkAvailability(ArrayList<String> shoppingList) {
        for (String item : shoppingList) {
            for (Product product : productsStocked) {
                if (item.equals(product.getName())) {
                    if (product.getQuantity() < 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Returns an ArrayList containing all Products from productStocked that
     * have a weight that exceeds the “weight” value provided in the parameter
     */
    public ArrayList<Product> oversized(double weight) {
        ArrayList<Product> oversizedProducts = new ArrayList<>();
        for (Product product : productsStocked) {
            if (product.getWeight() > weight) {
                oversizedProducts.add(product);
            }
        }
        return oversizedProducts;
    }

}
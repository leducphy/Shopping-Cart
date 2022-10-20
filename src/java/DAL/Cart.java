package DAL;

import java.util.*;

/**
 *
 * @author leducphi
 */
public class Cart {

    private List<Item> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public Cart(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    private Item getItemByID(int ID) {
        for (Item i : items) {
            if (i.getProduct().getProductID() == ID) {
                return i;
            }
        }
        return null;
    }

    // tra ve so luong khi biet id
    public int getQuantityByID(int ID) {
        return getItemByID(ID).getQuantity();
    }

    // them vao gio 
    public void addItem(Item t) {
        //TH1: co o trong gio hang roi
        if (getItemByID(t.getProduct().getProductID()) != null) {
            Item i = getItemByID(t.getProduct().getProductID());
            i.setQuantity(i.getQuantity() + t.getQuantity());
        } else {
            //TH2: chua co 
            items.add(t);
        }
    }

    public void removeItem(int ID) {
        if (getItemByID(ID) != null) {
            items.remove(getItemByID(ID));
        }
    }

    public double getTotalMoney() {
        double total = 0;
        for (Item x : items) {
            total += x.getQuantity() * x.getProduct().getUnitPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Cart{" + "items=" + items + '}';
    }
    

}

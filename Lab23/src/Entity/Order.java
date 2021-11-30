
package Entity;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Order {
    private ArrayList<Fruit> lo = new ArrayList<>();
    
    private String customer;
         
    public Order() {
    }

    public ArrayList<Fruit> listFruitInOrder(){
        return lo;
    }
     //add fruit customer buy in list order
     public void addFruitInOrder( Fruit fruit, int quantity){
            //check item exist or not
            Fruit t = checkItemExist(fruit.getFruitId());
            if (t!=null) {
                 t.setQuantity(t.getQuantity()+quantity);
            }
            //if item not exist add this in list of order
            else{
                lo.add(new Fruit(fruit.getFruitId(), fruit.getFruitName(), fruit.getPrice(), quantity, fruit.getOrigin()));
            }      
    }
     //total of all amount in list order
     public double total(){
        double total = 0;
        for (Fruit l : lo) {
            total += l.amount();
        }
        return total;
    }
   
      //check item exist or not
     public Fruit checkItemExist( String id){
         if (lo.isEmpty()) {
             return null;
         }
         for (Fruit l : lo) {
             //return false if user input a same id 
             if (l.getFruitId().equalsIgnoreCase(id)) {
                 return l;
             }
         }
         return null;
     }
    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
}

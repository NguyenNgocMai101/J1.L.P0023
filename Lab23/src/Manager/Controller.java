/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Entity.Fruit;
import Entity.Order;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

/**
 *
 * @author Admin
 */
public class Controller {
    private ArrayList<Fruit> ls = new ArrayList<>();
    private Hashtable<String, ArrayList<Fruit>> ht = new Hashtable<>();
       // create original shop
    public Controller() {
        ls.add(new Fruit("f32", "Apple", 5, 160, "Thailand"));
        ls.add(new Fruit("f11", "Coconut", 2, 100, "Laos"));
        ls.add(new Fruit("f20", "Orange", 3, 200, "US"));
    }
    // add fruit in list
    public void addFruit(String fruitId, String fruitName, double price, int quantity, String origin ){
         ls.add(new Fruit(fruitId, fruitName, price, quantity, origin));
    }
    
    public Hashtable<String, ArrayList<Fruit>> hashTable(){
        return ht;
    }
    public ArrayList<Fruit> list(){
        return ls;
    }

     //get fruit for buyer want to by
    public Fruit getFruitByItem( String item){
        for (Fruit l : ls) {
            if (l.getFruitId().equalsIgnoreCase(item)) {
                return l;
            }
        }
        return null;
    }
    //set new quantity of Fruit buyer choose
    public void setQuantityOfFruit(Fruit t, int s){
        t.setQuantity(t.getQuantity()-s);
        if (t.getQuantity()==0) {
            ls.remove(t);
        }
    }
    //add order in hashtable
    public void addOrder(Order order){
        ht.put(order.getCustomer() + "|" + new Date().toString(), order.listFruitInOrder());
    }
     //check id exist
     public  boolean checkIdExist(String id){
         for (Fruit l : ls) {
             //return false if user input a same id 
             if (id.equalsIgnoreCase(l.getFruitId())) {
                 return false;
             }        
         }
          return true;
     }  
}


package Manager;

import Entity.Fruit;
import Entity.Order;

public class View {
   Controller c = new Controller();
 
    //show menu
    public static int menu(){
        //loop until user want to exist
        System.out.println("FRUIT SHOP SYSTEM\n"
                + "1. Create Fruit\n"
                + "2. View orders\n"
                + "3. Shopping (for buyer)\n"
                + "4. Exit\n");
        System.out.print("Please input your choice: ");
        int choice = Validation.checkInputIntLimit(1, 4);
        return choice;
    }
    
    //allow users create fruit
    public void creatFruit(){
        //loop until user don't want to creat fruit
        while (true) {    
            System.out.println();
            System.out.print("Fruit id: ");
            String fruitId = Validation.checkInputString();
            //check id exist
            if (!c.checkIdExist(fruitId)) {
                System.err.println("Id exist!!!");
                continue;
            }
            System.out.print("Fruit name: ");
            String fruitName = Validation.checkInputString();
            System.out.print("Price: ");
            double price = Validation.checkInputDouble();
            System.out.print("Quantity: ");
            int quantity = Validation.checkInputInt();
            System.out.print("Origin: ");
            String origin = Validation.checkInputString();
            //add fruit in list of fruit
            c.addFruit(fruitId, fruitName, price, quantity, origin);
            //check user want to continue or not
            if (!Validation.checkInputYN()) {
                return;
            }
        }
    }
    
    //allow user show view order
    public void viewOrder(){
        for (String key : c.hashTable().keySet()) {
            System.out.println();
            double total = 0;
            System.out.println("Customer: "+key.substring(0, key.indexOf("|")));
              System.out.println("Product | Quantity | Price | Amount");
            for (Fruit f : c.hashTable().get(key)) {
                total+=f.amount();
                f.printFruitOrder();
            }
        System.out.println("Total: " + total);
        }
    }
    
    //allow user buy items
    public void shopping(){
        //check list fruit empty
        if (c.list().isEmpty()) {
            System.err.println("Don't have item");
            return;
        }
        Order order = new Order();     
        while (true) {  
             //check list fruit empty
            if (c.list().isEmpty()) {
                System.err.println("Don't have item");
                break;
            }
            //display list of fruit for buyer easy choice
             System.out.println("List of fruit:");
             System.out.println(" ++Item++ | ++Fruit Name++ | ++Origin++ | ++Price++ |");
           
            for(int i=0; i < c.list().size();i++) {
               c.list().get(i).print();
            }
            System.out.print("Items: ");
            String item = Validation.checkInputString();
            //get fruit by item input
            Fruit t = c.getFruitByItem(item);
            if (t==null) {
                System.err.println("Items not exist");
                continue;            
            }
            System.out.println("You selected: "+t.getFruitName());
            System.out.print("Please input quantity: ");
          
            int s = Validation.checkInputIntLimit(0, t.getQuantity());
            if (s==0) continue;  
            c.setQuantityOfFruit(t, s);
            order.addFruitInOrder(t,s);
            //check buyer want to continue or not
            if (!Validation.checkInputYN()) {
                break;
            }
        }
        System.out.println("Product | Quantity | Price | Amount");       
        for (Fruit l : order.listFruitInOrder()) {
            l.printFruitOrder();
        }      
        System.out.println("Total: " + order.total());
        //put name of customer in table of order
        System.out.print("Input your name: ");
        String name = Validation.checkInputString();
        order.setCustomer(name);
        c.addOrder(order);
        System.err.println("Add customer successfull");       
    }
}


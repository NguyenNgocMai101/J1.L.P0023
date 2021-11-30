
package Manager;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        View view = new View();
        
        //loop until user want to exit
        while (true) {
            //show menu
            int choice = View.menu();
            switch(choice){
                //allow user creat fruit
                case 1:
                    view.creatFruit();
                    break;
                //allow user view order
                case 2:
                    view.viewOrder();
                    break;
                //allow buyer shopping
                case 3:
                    view.shopping();
                    break;
                //allow user exit
                case 4:
                    return;
            }
        }       
    }
}

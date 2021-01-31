/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbcoffeeshopclient;

import Products.Beverage;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javax.ejb.EJB;
import server.remote.CoffeeShopRemote;
/**
 *
 * @author User
 */
public class Main {

    static Scanner scanner;

    @EJB
    private static server.remote.CoffeeShopRemote coffeeShopRemote;

    static {
        scanner = new Scanner(System.in);
    }
    
    public Main(){
        
    }

    public void displayCoffees() {
        List<Beverage> coffees = this.coffeeShopRemote.getCoffeeMenu();
        System.out.println("\n------------------");
        System.out.println(" AVAILABLE COFFEE");
        System.out.println("--------------------\n");
        System.out.println("----------------------------------------------------------------");
        System.out.println("No.\t\tITEM\t\t\tPRICE");
        System.out.println("----------------------------------------------------------------\n");
        int coffeeIndex = 0;
        Iterator iterator = coffees.iterator();

        while(iterator.hasNext()) {
            Beverage coffee = (Beverage)iterator.next();
            ++coffeeIndex;
            System.out.printf("%1$d.\t\t%2$s\t\t$%3$,.2f\n", coffeeIndex, coffee.getDescription(), coffee.getPrice());
        }
    }

    public void displayCondiments() {
        List<Beverage> condiments = this.coffeeShopRemote.getCondimentsMenu();
        System.out.println("\n------------------");
        System.out.println(" AVAILABLE CONDIMENTS");
        System.out.println("--------------------\n");
        System.out.println("----------------------------------------------------------------");
        System.out.println("No.\t\tITEM\t\t\tPRICE");
        System.out.println("----------------------------------------------------------------\n");
        int condimentIndex = 0;
        Iterator iterator = condiments.iterator();

        while(iterator.hasNext()) {
            Beverage condiment = (Beverage)iterator.next();
            ++condimentIndex;
            System.out.printf("%1$d.\t\t%2$s\t\t$%3$,.2f\n", condimentIndex, condiment.getDescription(), condiment.getPrice());
        }
    }



    public Beverage selectCoffeeToBuy() {
        List<Beverage> coffees = this.coffeeShopRemote.getCoffeeMenu();
        System.out.println("\n------------------");
        System.out.println(" AVAILABLE COFFEE");
        System.out.println("--------------------\n");
        System.out.println("----------------------------------------------------------------");
        System.out.println("No.\t\tITEM\t\t\tPRICE");
        System.out.println("----------------------------------------------------------------\n");
        int coffeeIndex = 0;
        Iterator iterator = coffees.iterator();

        while(iterator.hasNext()) {
            Beverage coffee = (Beverage)iterator.next();
            ++coffeeIndex;
            System.out.printf("%1$d.\t\t%2$s\t\t$%3$,.2f\n", coffeeIndex, coffee.getDescription(), coffee.getPrice());
        }

        System.out.println("\nPlease select item no. to buy:");
        int selectedIndex = scanner.nextInt();
        if (selectedIndex > 0 && selectedIndex <= coffees.size()) {
            Beverage selectedBeverage = (Beverage)coffees.get(selectedIndex - 1);
            return  selectCondimentsToAdd(selectedBeverage);
        } else {
            System.out.println("ERROR - Invalid product selection");
            return null;
        }
    }

    public Beverage selectCondimentsToAdd(Beverage coffee){
        List<Beverage> condiments = this.coffeeShopRemote.getCondimentsMenu();
        System.out.println("\n------------------");
        System.out.println(" AVAILABLE CONDIMENTS");
        System.out.println("--------------------\n");
        System.out.println("----------------------------------------------------------------");
        System.out.println("No.\t\tITEM\t\t\tPRICE");
        System.out.println("----------------------------------------------------------------\n");
        int condimentIndex = 0;
        Iterator iterator = condiments.iterator();
        Boolean running = true;
        while(iterator.hasNext()) {
            Beverage condiment = (Beverage)iterator.next();
            ++condimentIndex;
            System.out.printf("%1$d.\t\t%2$s\t\t$%3$,.2f\n", condimentIndex, condiment.getDescription(), condiment.getPrice());
        }

        while(running){
            System.out.println("\nPlease select condiment no. to add (Press 0 to confirm):");
            int selectedIndex = scanner.nextInt();
            if (selectedIndex > 0 && selectedIndex <= condiments.size()) {
                coffee = coffeeShopRemote.addCondiment(selectedIndex, coffee);
                System.out.println("Added on: " + condiments.get(selectedIndex - 1).getDescription());
                System.out.println("Current beverage: " + coffee.getDescription());
            } else if(selectedIndex == 0) {
                running = false;
            } else {
                System.out.println("ERROR - Invalid product selection");
            }
        }
        return coffee;
    }

    public void purchaseSuccess(Beverage coffee) {
        System.out.println("SUCCESS - " + " quantities of " + coffee.getDescription() + " added to oder list!");
        this.displayOrderList();
    }

    public Beverage[] displayOrderList() {
        List<Beverage> shoppedBeverages = this.coffeeShopRemote.getOrderedBeverages();
        System.out.println("\n---------------------------------");
        System.out.println(" DISPLAYING ITEMS IN SHOPPING CART");
        System.out.println("-----------------------------------\n");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("No.    ITEM                     UNIT-PRICE");
        System.out.println("--------------------------------------------------------------------------------\n");
        int itemIndex = 0;
        double totalPrice = 0.0D;
        Beverage[] beverages = new Beverage[shoppedBeverages.size()];
        Iterator iterator = shoppedBeverages.iterator();

        while(iterator.hasNext()) {
            Beverage beverage = (Beverage)iterator.next();
            beverages[itemIndex] = beverage;
            ++itemIndex;
            totalPrice += beverage.getPrice();
            System.out.printf("%1$2d%2$-5s%3$-25s$%4$,-17.2f\n", itemIndex, ".", beverage.getDescription(), beverage.getPrice());
        }

        System.out.println("                                                -----------------------------");
        System.out.printf("                                                 TOTAL PRICE:   $%1$,-8.2f\n", totalPrice);
        System.out.println("                                                -----------------------------\n");
        return beverages;
    }

    public Beverage selectBeverageToRemove() {
        Beverage[] products = this.displayOrderList();
        System.out.println("\nPlease select item no. to remove (Press 0 to cancel):");
        int selectedIndex = scanner.nextInt();

        if(selectedIndex == 0){
            System.out.println("Back to server.Menu\n");
            return null;
        }else if (selectedIndex > 0 && selectedIndex <= products.length) {
            Beverage beverage = products[selectedIndex - 1];
            return beverage;
        } else {
            System.out.println("ERROR - Invalid item specification\n");
            return null;
        }
    }

    public void removalSuccess(Beverage beverage) {
        System.out.println("SUCCESS - " + beverage.getDescription() + " removed from order list!");
        displayOrderList();
    }

    public void displayCheckOut() {
        double totalPrice = this.coffeeShopRemote.getOrderedBeveragesTotalPrice();
        System.out.printf("Please Pay $%1$,-8.2f\n", totalPrice);
        System.out.println("Thank you for your patronage! Please visit again!");
    }




    public int mainMenu() {
        System.out.println("\n----------------------------");
        System.out.println("WELCOME TO CBSE Coffee Shop!");
        System.out.println("----------------------------\n");
        System.out.println("1. View server.Menu");
        System.out.println("2. Order coffee");
        System.out.println("3. View or remove coffee from order list");
        System.out.println("4. Pay bill");
        System.out.println("5. Exit");
        System.out.println("\nChoose an option:");
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        Main ui = new Main();

        for(int userChoice = ui.mainMenu(); userChoice > 0 && userChoice <= 4; userChoice = ui.mainMenu()) {
            switch(userChoice) {
                case 1:
                    ui.displayCoffees();
                    ui.displayCondiments();
                    break;
                case 2:
                    Beverage beverage = ui.selectCoffeeToBuy();
                    if (beverage != null) {
                        coffeeShopRemote.addBeverageIntoOrderList(beverage);
                    }
                    break;
                case 3:
                    beverage = ui.selectBeverageToRemove();
                    if(beverage != null){
                        coffeeShopRemote.removeBeverageFromOrderList(beverage);
                        ui.displayOrderList();
                    }
                    break;
                case 4:
                    ui.displayCheckOut();
                    coffeeShopRemote.checkOut();
            }
        }

    }
}

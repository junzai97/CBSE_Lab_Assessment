package virtualCoffeeShop.coffeeShop.osgi.client;

import virtualCoffeeShop.coffeeMaker.osgi.ifce.Beverage;

import java.util.ArrayList;

public class Menu {
    private ArrayList<Beverage> coffeeMenu = new ArrayList<>();
    private ArrayList<Beverage> condimentsMenu = new ArrayList<>();

    //Add coffee into coffees ArrayList
    public void addCoffee(ArrayList<Beverage> coffees){
        coffeeMenu.addAll(coffees);
    };

    //Get coffees ArrayList
    public ArrayList<Beverage> getCoffeeMenu(){
        return coffeeMenu;
    };

    //Add condiment into condiments ArrayList
    public void addCondiments(ArrayList<Beverage> condiments){
        condimentsMenu.addAll(condiments);
    };

    //Get condiments ArrayList
    public ArrayList<Beverage> getCondimentsMenu(){
        return condimentsMenu;
    };

}

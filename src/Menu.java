import Products.Beverage;

import java.util.ArrayList;

public class Menu {
    private ArrayList<Beverage> coffeeMenu = new ArrayList<>();
    private ArrayList<Beverage> condimentsMenu = new ArrayList<>();

    //Add coffee into coffees ArrayList
    public void addCoffee(Beverage coffee){
        coffeeMenu.add(coffee);
    };

    //Get coffees ArrayList
    public ArrayList<Beverage> getCoffeeMenu(){
        return coffeeMenu;
    };

    //Add condiment into condiments ArrayList
    public void addCondiments(Beverage condiment){
        condimentsMenu.add(condiment);
    };

    //Get condiments ArrayList
    public ArrayList<Beverage> getCondimentsMenu(){
        return condimentsMenu;
    };

}

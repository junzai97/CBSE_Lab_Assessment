import Products.Beverage;
import Products.Beverages.*;
import Products.Condiments.Milk;
import Products.Condiments.Mocha;
import Products.Condiments.Soy;
import Products.Condiments.Whip;

import java.util.List;


public class CoffeeShop {
    private OrderList orderList = new OrderList();
    private CoffeeMaker coffeeMaker = new CoffeeMaker();
    private Menu menu = new Menu();
    private UI ui;

    public CoffeeShop(UI ui) {
        this.ui = ui;
        this.init();
    }

    /**
     * @Description: Set up coffee and condiments into the Menu
     */
    public void init() {
        menu.addCoffee(coffeeMaker.getBlackCoffee());
        menu.addCoffee(coffeeMaker.getDecaf());
        menu.addCoffee(coffeeMaker.getEspresso());
        menu.addCoffee(coffeeMaker.getHouseBlend());
        menu.addCondiments(coffeeMaker.addMilk(new NoBeverage()));
        menu.addCondiments(coffeeMaker.addMocha(new NoBeverage()));
        menu.addCondiments(coffeeMaker.addSoy(new NoBeverage()));
        menu.addCondiments(coffeeMaker.addWhip(new NoBeverage()));
    }


    /**
     * @Description: Get coffee menu
     * @Dependencies: menu
     */
    public List<Beverage> getCoffeeMenu(){
        return menu.getCoffeeMenu();
    }

    /**
     * @Description: Get condiments menu
     * @Dependencies: menu
     */
    public List<Beverage> getCondimentsMenu(){
        return menu.getCondimentsMenu();
    }


    /**
     * @Description: Get coffee from OrderList
     * Dependencies: orderList
     */
    public List<Beverage> getOrderedBeverages(){
        return orderList.getOrderList();
    }

    /**
     * @Description: Add coffee into OrderList
     * @Dependencies: orderList
     */
    public void addBeverageIntoOrderList(Beverage beverage){
        if(beverage != null){
            orderList.addBeverage(beverage);
        }
    }

    /**
     * @Description: Remove coffee from OrderList
     * Dependencies: orderList
     */
    public void removeBeverageFromOrderList(Beverage beverage){
        if(beverage != null){
            orderList.removeBeverage(beverage);
        }
    }

    /**
     * @Description: Get total price
     * Dependencies: orderList
     */
    public double getOrderedBeveragesTotalPrice(){
        return orderList.getPrice();
    }

    /**
     * @Description: CheckOut the OrderList
     * Dependencies: orderList
     */
    public void checkOut(){
        orderList.empty();
    }

    /**
     * @Description: Add condiment to the selected coffee
     * Dependencies: CoffeeMaker
     */
    public Beverage addCondiment(int condimentNumber, Beverage coffee){
        switch (condimentNumber){
            case 1:
                coffee = coffeeMaker.addMilk(coffee);
                break;
            case 2:
                coffee = coffeeMaker.addMocha(coffee);
                break;
            case 3:
                coffee = coffeeMaker.addSoy(coffee);
                break;
            default:
                coffee = coffeeMaker.addWhip(coffee);
        }
        return coffee;
    }


}

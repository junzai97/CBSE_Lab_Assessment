package server;

import Products.Beverage;
import Products.Beverages.*;
import client.UI;
import server.remote.CoffeeShopRemote;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import java.util.List;

@Stateful
public class CoffeeShop implements CoffeeShopRemote {

    @EJB
    private OrderList orderList;

    @EJB
    private CoffeeMaker coffeeMaker;

    @EJB
    private Menu menu;

    private UI ui;

    public CoffeeShop(UI ui) {
        this.ui = ui;
        this.init();
    }

    /**
     * @Description: Set up coffee and condiments into the server.Menu
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
     * @Description: Get coffee from server.OrderList
     * Dependencies: orderList
     */
    public List<Beverage> getOrderedBeverages(){
        return orderList.getOrderList();
    }

    /**
     * @Description: Add coffee into server.OrderList
     * @Dependencies: orderList
     */
    public void addBeverageIntoOrderList(Beverage beverage){
        if(beverage != null){
            orderList.addBeverage(beverage);
        }
    }

    /**
     * @Description: Remove coffee from server.OrderList
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
     * @Description: CheckOut the server.OrderList
     * Dependencies: orderList
     */
    public void checkOut(){
        orderList.empty();
    }

    /**
     * @Description: Add condiment to the selected coffee
     * Dependencies: server.CoffeeMaker
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

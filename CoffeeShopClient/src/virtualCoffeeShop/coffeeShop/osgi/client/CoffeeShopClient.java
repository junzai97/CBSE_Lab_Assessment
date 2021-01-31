package virtualCoffeeShop.coffeeShop.osgi.client;

import org.osgi.framework.ServiceReference;
import org.osgi.service.component.ComponentContext;
import virtualCoffeeShop.coffeeMaker.osgi.ifce.Beverage;
import virtualCoffeeShop.OralList.osgi.ifce.IOrderList;
import virtualCoffeeShop.coffeeMaker.osgi.ifce.CoffeeMakerApi;

import java.util.List;

public class CoffeeShopClient {
    ComponentContext context;
    IOrderList orderList;
    CoffeeMakerApi coffeeMaker;
    Menu menu = new Menu();
    UI ui;

    public CoffeeShopClient(UI ui, ComponentContext context, ServiceReference reference) {

        if (reference != null) {
            orderList = (IOrderList) context.locateService("IOrderList", reference);
            coffeeMaker = (CoffeeMakerApi) context.locateService("CoffeeMakerApi", reference);
        }
        this.context = context;
        this.ui = ui;
        this.init();
    }

    /**
     * @Description: Set up coffee and condiments into the Menu
     */
    public void init() {
        menu.addCoffee(coffeeMaker.getAllAvailableBeverage());
        menu.addCondiments(coffeeMaker.getAllAvailableCondiments());
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

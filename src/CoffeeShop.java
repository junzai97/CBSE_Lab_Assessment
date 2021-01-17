public class CoffeeShop {
    private OrderList orderList;
    private CoffeeMaker coffeeMaker;
    private Menu menu;
    private UI ui;

    public CoffeeShop(OrderList orderList, CoffeeMaker coffeeMaker, Menu menu, UI ui) {
        this.orderList = orderList;
        this.coffeeMaker = coffeeMaker;
        this.menu = menu;
        this.ui = ui;
    }

    /**
     * @Description: Set up coffee and condiments into the Menu
     */
    public void init() {

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
     * @Description: Select a coffee to brew
     * Dependencies: CoffeeMaker
     */
    public void selectCoffee(){

    }

    /**
     * @Description: Add condiment to the selected coffee
     * Dependencies: CoffeeMaker
     */
    public void addCondiment(){

    }


}

public class Mocha extends CondimentDecorator{
    Beverage beverage;

    public Mocha(Beverage beverage){
        this.beverage = beverage;
    }

    public String getDescription(){
        return beverage.description + ", Mocha";
    }

    public double cost(){
        return beverage.cost() + 0.20;
    }
}

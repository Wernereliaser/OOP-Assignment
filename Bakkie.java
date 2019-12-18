package realestates;

import realestates.ConditionInterface.condition;

public class Bakkie extends Vehicle{
    private String model;

    public Bakkie(int propertyID, boolean status, int yearsOwned, double sellingPrice, double buyingPrice, String Model, String colour, condition condition, String model) {
        super(propertyID, status, yearsOwned, sellingPrice, buyingPrice, Model, colour, condition);
        this.model = model;
    }

    public Bakkie(String model, String Model, String colour, condition condition) {
        super(Model, colour, condition);
        this.model = model;
    }

    public Bakkie(String model) {
        this.model = model;
    }
    
    public Bakkie() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public static void setCounter(int counter) {
        Asset.counter = counter;
    }

    @Override
    public String toString() {
        return "▀▀▀▀▀▀▀▀▀▀▀▀▀ BAKKIE ▀▀▀▀▀▀▀▀▀▀▀▀▀▀" + 
               super.toString() +
               "\nModel             : " + model +
               "\n▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀";
    }

    @Override
    public double checkProfitOrLoss() {
        return (this.getSellingPrice() - this.getBuyingPrice());
    }

    
    @Override
    public String print() {
        return (super.getAssetID() + " " + 
                "Bakkie" + " " +
                super.isStatus() + " " + 
                super.getYearsOwned() + " " + 
                super.getSellingPrice() + " " +
                super.getBuyingPrice() + " " +
                super.getModel() + " " +
                super.getColour() + " " +
                super.getCondition() + " " + 
                this.getModel());
    }
}

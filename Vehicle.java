package realestates;

import realestates.ConditionInterface.condition;

public class Vehicle extends Asset{
    private String Model;
    private String colour;
    private condition vehicle_condition;
    
    //Parametized constructor

    public Vehicle(int propertyID, boolean status, int yearsOwned, double sellingPrice, double buyingPrice, String Model, String colour, condition condition) {
        super(propertyID, status, yearsOwned, sellingPrice, buyingPrice);
        this.Model = Model;
        this.colour = colour;
        this.vehicle_condition = condition;
    }

    public Vehicle(String Model, String colour, condition condition) {
        this.Model = Model;
        this.colour = colour;
        this.vehicle_condition = condition;
    }

    //Default Constructor
    public Vehicle() {
        this.Model = "Unknown";
        this.colour = "Unknnown";
    }
    //Setters and Getters
    public String getModel() {
        return Model;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }


    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public condition getCondition() {
        return vehicle_condition;
    }

    public void setCondition(condition condition) {
        this.vehicle_condition = condition;
    }
        
    //toString for outputing details of car objects
    @Override
    public String toString() {
        return "\nModel  : " + Model + 
               "\nColour : " + colour +
               "\nCondition" + vehicle_condition;
    }

    @Override
    public double checkProfitOrLoss() {
        return (this.getSellingPrice() - this.getBuyingPrice());
    }

    @Override
    public String print() {
        return (super.getAssetID() + " " + 
                "Vehicle" + " " +
                super.isStatus() + " " + 
                super.getYearsOwned() + " " + 
                super.getSellingPrice() + " " +
                super.getBuyingPrice() + " " +
                this.getModel() + " " +
                this.getColour() + " " +
                this.getCondition());
    }
    
    @Override
    public void enterDetails() {
        super.enterDetails();
        System.out.println("ENTER MODEL           : ");
        this.setModel(input.next());
        System.out.println("ENTER COLOUR          : ");
        this.setColour(input.next());
        System.out.println("ENTER CONDITION       : (Bad/Fair/Bad)");
        String condition_string = input.next();
        
        if("Bad".equalsIgnoreCase(condition_string)){
            this.setCondition(condition.Bad);
            
        }else if ("Fair".equalsIgnoreCase(condition_string)){
            this.setCondition(condition.Fair);
            
        }else if ("Good".equalsIgnoreCase(condition_string)){
            this.setCondition(condition.Good);
        } 
    }
}

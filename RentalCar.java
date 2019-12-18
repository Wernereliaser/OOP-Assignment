package realestates;

import realestates.ConditionInterface.condition;

public class RentalCar extends Vehicle{
    private Date bookedFor;

    public RentalCar(int propertyID, boolean status, int yearsOwned, double sellingPrice, double buyingPrice, String Model, String colour, condition condition, Date bookedFor) {
        super(propertyID, status, yearsOwned, sellingPrice, buyingPrice, Model, colour, condition);
        this.bookedFor = bookedFor;
    }

    public RentalCar(String Manufacturer, Date bookedFor, String Model, String colour, condition condition) {
        super(Model, colour, condition);
        this.bookedFor = bookedFor;
    }

    public RentalCar(String Manufacturer, Date bookedFor) {
        this.bookedFor = bookedFor;
    }

    public RentalCar() {
    }

    public Date getBookedFor() {
        return bookedFor;
    }

    public void setBookedFor(Date bookedFor) {
        this.bookedFor = bookedFor;
    }

    @Override
    public String toString() {
        return  "▀▀▀▀▀▀▀▀▀▀▀ RENTAL CAR ▀▀▀▀▀▀▀▀▀▀▀▀▀" +
                super.toString() +
               "\nBookedFor          : " + getBookedFor()+ 
                "\n▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀";
    }

    @Override
    public double checkProfitOrLoss() {
        return (this.getSellingPrice() - this.getBuyingPrice());
    }
    
    @Override
    public String print() {
        return (super.getAssetID() + " " + 
                "RentalCar" + " " +
                super.isStatus() + " " + 
                super.getYearsOwned() + " " + 
                super.getSellingPrice() + " " +
                super.getBuyingPrice() + " " +
                super.getModel() + " " +
                super.getColour() + " " +
                super.getCondition() + " " +    
                this.bookedFor.getDay() + " " +
                this.bookedFor.getMonth() + " " +
                this.bookedFor.getYear());
    }
    
    @Override
    public void enterDetails() {
        System.out.println("----------------------------------------------------");
        super.enterDetails();
        System.out.println("ENTER BOOKED DAY     : ");
        int day = input.nextInt();
        System.out.println("ENTER BOOKED MONTH   : ");
        String month = input.next();        
        System.out.println("ENTER BOOKED YEAR    : ");
        int year = input.nextInt();
        this.setBookedFor(new Date(day, month, year));
        System.out.println("----------------------------------------------------");
    }
}

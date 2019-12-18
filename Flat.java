package realestates;

public class Flat extends Asset{
    private int noOfRooms;
    private boolean balcony;

    public Flat(int assetID, boolean status, int yearsOwned, double sellingPrice, double buyingPrice,int noOfRooms, boolean balcony) {
        super(assetID, status, yearsOwned, sellingPrice, buyingPrice);
        this.noOfRooms = noOfRooms;
        this.balcony = balcony;
    }

    public Flat(int noOfRooms, boolean balcony) {
        this.noOfRooms = noOfRooms;
        this.balcony = balcony;
    }
    
    public Flat() {
    }

    public int getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(int noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public boolean isBalcony() {
        return balcony;
    }

    public void setBalcony(boolean balcony) {
        this.balcony = balcony;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Asset.counter = counter;
    }

    @Override
    public String toString() {
        return "▀▀▀▀▀▀▀▀▀▀▀▀ FLAT ▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀" + 
               super.toString() + 
               "\nNoOfRooms               : " + noOfRooms + 
               "\nBalcony                 : " + balcony +
               "\n▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀";
    }
   
    @Override
    public double checkProfitOrLoss() {
        return (this.getSellingPrice() - this.getBuyingPrice());
    }

    @Override
    public String print() {
        return (super.getAssetID() + " " + 
                "Flat" + " " +
                super.isStatus() + " " + 
                super.getYearsOwned() + " " + 
                super.getSellingPrice() + " " +
                super.getBuyingPrice() + " " +
                this.getNoOfRooms() + " " + 
                this.isBalcony());
    }
    
    @Override
    public void enterDetails() {
        System.out.println("----------------------------------------------------");
        super.enterDetails();
        System.out.println("ENTER NUMBER OF ROOMS : ");
        this.setNoOfRooms(input.nextInt());        
        System.out.println("HAS A BALCONY : (true/false)");
        String balcony_String = input.next();
        
        if("true".equalsIgnoreCase(balcony_String)){
            this.setBalcony(true);
        }else if ("false".equalsIgnoreCase(balcony_String)){
            this.setBalcony(false);
        }        
        System.out.println("----------------------------------------------------");
    }
}

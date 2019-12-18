package realestates;

import static realestates.Farm.input;

public class House extends Asset{
    private Address address;
    private int noOfRooms;
    
    //Parametized Constructor

    public House(int assetID, boolean status,int yearsOwned, double sellingPrice, double buyingPrice, int erfNo, String Street, String Town, int noOfRooms) {
        super(assetID, status, yearsOwned, sellingPrice, buyingPrice);
        this.address = new Address(erfNo, Street, Town);
        this.noOfRooms = noOfRooms;
    }
    
    public House() {
        super();
    }
    
    //Getters   
    public int getNoOfRooms() {
        return noOfRooms;
    }

    public Address getAddress() {
        return address;
    }
    
    
    //Setters
    public void setNoOfRooms(int noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public void setAddress(int erfNo, String Street, String Town) {
        this.address = new Address(erfNo, Street, Town);
    }
    
    @Override
    public String toString() {
        return "▀▀▀▀▀▀▀▀▀▀▀▀ HOUSE ▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀" + 
               super.toString()+
               "\nAddress                 : " + this.getAddress() +
               "\nNumber of Rooms         : " + this.getNoOfRooms() + 
               "\n▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀";
    }

    @Override
    public double checkProfitOrLoss() {
        return (this.getSellingPrice() - this.getBuyingPrice());
    }

    @Override
    public String print() {
        return (super.getAssetID() + " " + 
                (this.getClass()).toString().replaceAll("class realestates.", "") + " " +
                super.isStatus() + " " + 
                super.getYearsOwned() + " " + 
                super.getSellingPrice() + " " +
                super.getBuyingPrice() + " " +
                this.address.getErfNo() + " " + 
                this.address.getStreet() + " " + 
                this.address.getTown() + " " + 
                this.getNoOfRooms());
    }
    
    @Override
    public void enterDetails() {
        System.out.println("----------------------------------------------------");
        super.enterDetails();
        System.out.println("ENTER ERF NUMBER      : ");
        int erfNo = input.nextInt();
        System.out.println("ENTER STREET          : ");
        String Street = input.next();
        System.out.println("ENTER TOWN            : ");
        String Town = input.next();
        
        this.setAddress(erfNo, Street, Town);
        
        System.out.println("ENTER NUMBER OF ROOMS : ");
        this.setNoOfRooms(input.nextInt());
        System.out.println("----------------------------------------------------");
    }
}

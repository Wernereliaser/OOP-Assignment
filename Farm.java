package realestates;

import java.util.Scanner;

public class Farm extends Asset{
    static Scanner input = new Scanner(System.in);//For user input
    private String name;
    private double hectares;

    public Farm(int assetID, boolean status, int yearsOwned, double sellingPrice, double buyingPrice, String name, double hectares) {
        super(assetID, status, yearsOwned, sellingPrice, buyingPrice);
        this.name = name;
        this.hectares = hectares;
    }

    public Farm(String name, String location, double hectares) {
        this.name = name;
        this.hectares = hectares;
    }
    
    public Farm() {
    }    

    public String getName() {
        return name;
    }

    public double getHectares() {
        return hectares;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHectares(double hectares) {
        this.hectares = hectares;
    }

    @Override
    public String toString() {
        return "▀▀▀▀▀▀▀▀▀▀▀▀ FARM ▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀" +
               super.toString() +
               "\nName                   : " + name + 
               "\nHectares               : " + hectares +
               "\n▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀";
    }

    @Override
    public double checkProfitOrLoss() {
        return (this.getSellingPrice() - this.getBuyingPrice());
    }

    @Override
    public String print() {
        return (super.getAssetID() + " " + 
                "Farm" + " " +
                super.isStatus() + " " + 
                super.getYearsOwned() + " " + 
                super.getSellingPrice() + " " +
                super.getBuyingPrice() + " " +
                this.getName() + " " + 
                this.getHectares());
    }

    @Override
    public void enterDetails() {
        System.out.println("----------------------------------------------------");
        super.enterDetails();
        System.out.println("ENTER NAME     : ");
        this.setName(input.next());
        System.out.println("ENTER HECTARES : ");
        this.setHectares(input.nextDouble());
        System.out.println("----------------------------------------------------");
    }
}

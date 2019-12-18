package realestates;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import realestates.ConditionInterface.condition;

//Polymorphism achieved through : Method overloading 
//Method overloading supports polymorphism because it is one way that Java implements the “one interface, multiple methods” paradigm
public class AssetManager {
    static Scanner input = new Scanner(System.in);//For user input
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        Login();//To allow only authenticated users to use the syste,
        
    }
    
    public static void Login() throws IOException{       
        System.out.println((char)27 + "[31m▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀"+(char)27 + "[0m");
        System.out.print("ENTER USERNAME : ");
        String username = input.next();//prompt user to enter username
        System.out.print("ENTER PASSWORD : ");
        String password = input.next();//prompt user to enter password
        System.out.println((char)27 + "[31m▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀"+(char)27 + "[0m");
                
        if("admin".equals(username) && "admin".equals(password)){
            Menu();//Menu  for easy navigation of the system
        }else{
            System.err.println("LOG IN UNSUCCESSFULL");
            System.out.println("ATTEMPT AGAIN : (Y/N)");
            String reply = input.next();
            if("Y".equalsIgnoreCase(reply)){                
                Login();
            }else if("N".equalsIgnoreCase(reply)){
                System.exit(0);
            }
        }        
    }
    
    public static void Menu() throws IOException{
        System.out.println((char)27 + "[31m▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀"+(char)27 + "[0m");
        System.out.println("             PROPERTIES - VEHICLE                   ");
        System.out.println("                  INVESTMENTS                       ");
        System.out.println((char)27 + "[31m▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀"+(char)27 + "[0m");
        System.out.println(" 1. ADD ASSETS ");
        System.out.println(" 2. ALL ASSETS ");
        System.out.println(" 3. SOLD ASSETS ");
        System.out.println(" 4. AVAILABLE ASSETS ");
        System.out.println(" 5. SELL ASSET ");
        System.out.println(" 6. SEARCH & CHANGES");
        System.out.println(" 7. EXIT");
        System.out.println((char)27 + "[31m▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀"+(char)27 + "[0m");
        int choice = 0;
        System.out.print("ENTER OPTION :");
        try {
            choice = Integer.parseInt(br.readLine());
        } catch (NumberFormatException e) {
            System.out.println("\tInvalid input.");
            Menu();
        }
        switch (choice) {
            case 1:
                assetList.clear();
                populateAssets();
                addAsset();
                Menu();
                assetList.clear();
                break;
            case 2:
                assetList.clear();
                populateAssets();
                Display("all");
                Menu();
                assetList.clear();
                break;
            case 3:
                assetList.clear();
                populateAssets();
                Display("sold");
                Menu();
                assetList.clear();
                break;
            case 4:
                assetList.clear();
                populateAssets();
                Display("available");
                Menu();
                assetList.clear();
                break;
            case 5:
                assetList.clear();
                populateAssets();
                sellAssets();
                Menu();
                assetList.clear();
                break;
            case 6:
                assetList.clear();
                populateAssets();
                Search();
                Menu();
                assetList.clear();
                break;
            case 7:
                System.exit(0);
            default:
                break;
        }
    }
    
    private static void addAsset() throws IOException {
        System.out.println("------ ASSET TYPE ------");
        System.out.println("1. HOUSE");
        System.out.println("2. FLAT");
        System.out.println("3. FARM");
        System.out.println("4. RENTAL CAR");
        System.out.println("5. BAKKIE");
        System.out.println("-------------------------");
        int choice = 0;
        System.out.print("ENTER OPTION :");
        try {
            choice = Integer.parseInt(br.readLine());
        } catch (NumberFormatException e) {
            System.out.println("\tInvalid input.");
            Menu();
        }
        
        switch (choice) {
            case 1:
                Asset house = new House();
                house.enterDetails();
                assetList.add(house);
                save(assetList);
                break;
            case 2:
                Asset flat = new Flat();
                flat.enterDetails();
                assetList.add(flat);
                save(assetList);
                break;
            case 3:
                Asset farm = new Farm();
                farm.enterDetails();
                assetList.add(farm);
                save(assetList);
                break;
            case 4:
                Asset rentalCar = new RentalCar();
                rentalCar.enterDetails();
                assetList.add(rentalCar);
                save(assetList);
                break;
            case 5:
                Asset bakkie = new Bakkie();
                bakkie.enterDetails();
                assetList.add(bakkie);
                save(assetList);
                break;
            default:
                break;
        }
    }
    

    private static void sellAssets() throws IOException {
        Display("available");
        
        int available = 0;
        for (int i = 0; i < assetList.size(); i++) {
            if(assetList.get(i).isStatus() == false){
                available ++;
            }
        }
        
        if(available>0){ 
            int choice = 0;
            System.out.print("ENTER ASSET ID :");
            try {
                choice = Integer.parseInt(br.readLine());
            } catch (NumberFormatException e) {
                System.err.println("Invalid input.");
                sellAssets();
            }

            int index = 0;
            boolean found = false;
            for(int i = 0; i < assetList.size(); i++){
                if(assetList.get(i).getAssetID() == choice){
                    found = true;
                    index = i;
                }
            }
            System.out.println("--------------------------------");
            System.out.println("ENTER BUYER NAME : ");
            String buyer = input.next();
            System.out.println("ENTER BUYER AMOUNT :");
            double amount = input.nextDouble();

            while(amount < assetList.get(index).getSellingPrice()){
                System.err.println("AMOUNT IS NOT SUFFICIENT");
                System.out.printf("\nASSETS' PRICE IS N$%.2f", assetList.get(index).getSellingPrice());
                System.out.println("END TRANSACTION : (Y/N)");
                String reply = input.next();
                if("y".equalsIgnoreCase(reply)){
                    Menu();
                }else if("n".equalsIgnoreCase(reply)){
                    System.out.println("ENTER BUYER AMOUNT :");
                    amount = input.nextDouble();
                }            
            }

            if(found == true && amount >= assetList.get(index).getSellingPrice()){
                System.out.println(assetList.get(index).toString());
                System.out.println("------------------------------------");
                System.out.printf("\nSELLING PRICE N$%.2f",assetList.get(index).getSellingPrice());
                System.out.printf("\nBUYING PRICE  N$%.2f",assetList.get(index).getBuyingPrice());
                System.out.println("\n------------------------------------");
                System.out.printf("PROFIT        N$%.2f",assetList.get(index).checkProfitOrLoss());
                System.out.println("\n             ======================");

                assetList.get(index).setStatus(true);//The asset is sold now
                save(assetList);//update the list
                receipt(buyer, amount,assetList.get(index));
            }else{
                System.out.println("SORRY PROPERTY IS NOT FOUND");
            }
            
        }else{
            System.err.println("NO ITEMS AVAILABLE");
        }        
        assetList.clear();
    }
    
    private static void Search() throws IOException {        
        Display("all");
        int choice = 0;
        System.out.print("ENTER ASSET ID :");
        try {
            choice = Integer.parseInt(br.readLine());
        } catch (NumberFormatException e) {
            System.err.println("Invalid input.");
            Search();
        }
        
        int index = 0;
        boolean found = false;
        for(int i = 0; i < assetList.size(); i++){
            if(assetList.get(i).getAssetID() == choice){
                found = true;
                index = i;
            }
        }
        
        if(found == true){
            System.out.println(assetList.get(index).toString());
            System.out.print("MAKE CHANGES : (Y?N)");
            String reply = input.next();
            if("Y".equalsIgnoreCase(reply) || "YES".equalsIgnoreCase(reply)){
                makeChanges(assetList.get(index));    
            }else{               
                Menu();
            }
            
        }else{
            System.err.println("SORRY PROPERTY IS NOT FOUND");
        }
        assetList.clear();
    }
    
    public static void Display(String condition){
        System.out.println((char)27 + "[31m▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀"+(char)27 + "[0m");
        System.out.println("ASSET ID |   TYPE     |  STATUS    |   NO YEARS OWNED   | SELLING PRICE | BUYING PRICE   ");
        System.out.print((char)27 + "[31m▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀"+(char)27 + "[0m");
            
        if("all".equals(condition)){            
            for(int i = 0; i < assetList.size(); i++) { 
                String type = (assetList.get(i).getClass()).toString().replaceAll("class realestates.", "");
                System.out.format("\n %-7s | %-10s | %-11s | %-13s \t| N$%.2f \t| N$%.2f", 
                        assetList.get(i).getAssetID(),type, 
                        assetList.get(i).isStatus(), 
                        assetList.get(i).getYearsOwned(), 
                        assetList.get(i).getSellingPrice(), 
                        assetList.get(i).getBuyingPrice());
            }  
            
        }else if ("sold".equals(condition)){
            for(int i = 0; i < assetList.size(); i++) { 
                if(assetList.get(i).isStatus() == true){//if status is true then asset has been sold
                    String type = (assetList.get(i).getClass()).toString().replaceAll("class realestates.", "");
                    System.out.format("\n %-7s | %-10s | %-11s | %-13s \t| N$%.2f \t| N$%.2f", 
                        assetList.get(i).getAssetID(),type, 
                        assetList.get(i).isStatus(), 
                        assetList.get(i).getYearsOwned(), 
                        assetList.get(i).getSellingPrice(), 
                        assetList.get(i).getBuyingPrice());
                }
            } 
        }else if ("available".equals(condition)){
            for(int i = 0; i < assetList.size(); i++) { 
                if(assetList.get(i).isStatus() == false){//if status is false then asset has not been sold yet
                    String type = (assetList.get(i).getClass()).toString().replaceAll("class realestates.", "");
                    System.out.format("\n %-7s | %-10s | %-11s | %-13s \t| N$%.2f \t| N$%.2f", 
                        assetList.get(i).getAssetID(),type, 
                        assetList.get(i).isStatus(), 
                        assetList.get(i).getYearsOwned(), 
                        assetList.get(i).getSellingPrice(), 
                        assetList.get(i).getBuyingPrice());
                }
            } 
        }
        
        System.out.println((char)27 + "[31m\n▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀"+(char)27 + "[0m");

    
    }
    
    static ArrayList<Asset> assetList= new ArrayList<>();
        
    static void populateAssets() {
    String fileName = "src/realestates/Assets.txt";                 
        File file = new File(fileName);
        try {
            Scanner read = new Scanner(file);
            while(read.hasNext()) {
                int pid = read.nextInt();
                String type = read.next();
                String s = read.next();
                boolean status = false;
                if("true".equals(s)){
                    status = true;
                }else if ("false".equals(s)){
                    status = false;
                } 

                int yearsOwned = read.nextInt();
                double sellingPrice = read.nextDouble();
                double buyingPrice = read.nextDouble();
                
                if("House".equals(type)){
                    int erfNo = read.nextInt(); 
                    String location = read.next();
                    String town = read.next();
                    int noOfRooms = read.nextInt();

                    Asset house = new House(pid, status, yearsOwned, sellingPrice, buyingPrice, erfNo, location,  town, noOfRooms);
                    assetList.add(house);
                }else if("Farm".equals(type)){
                    String name = read.next();
                    double hectares = read.nextDouble();

                    Asset house = new Farm(pid, status,yearsOwned, sellingPrice, buyingPrice, name, hectares);
                    assetList.add(house);
                    
                }else if("Flat".equals(type)){
                    Asset flat = new Flat();
                    int noOfRoom = read.nextInt();
                    String balcony = read.next();
                    
                    if("true".equalsIgnoreCase(balcony)){                        
                        flat = new Flat(pid, status,yearsOwned, sellingPrice, buyingPrice, noOfRoom, true);
                    }else if("false".equalsIgnoreCase(balcony)){
                        flat = new Flat(pid, status,yearsOwned, sellingPrice, buyingPrice, noOfRoom, false);
                    }
                    
                    assetList.add(flat);
                    
                }else if("Bakkie".equals(type)){
                    Asset bakkie = new Bakkie();
                    String model = read.next();
                    String Colour = read.next();
                    String condition_String = read.next();
                    
                    if("Bad".equals(condition_String)){
                        bakkie = new Bakkie(pid, status, yearsOwned, sellingPrice, buyingPrice, model, Colour, condition.Bad, model);
                    }else if("Fair".equals(condition_String)){
                        bakkie = new Bakkie(pid, status, yearsOwned, sellingPrice, buyingPrice, model, Colour, condition.Fair, model);
                    }else if("Good".equals(condition_String)){
                        bakkie = new Bakkie(pid, status, yearsOwned, sellingPrice, buyingPrice, model, Colour, condition.Good, model);
                    }
                     
                    assetList.add(bakkie);
                    
                }else if("RentalCar".equals(type)){                    
                    Asset rentalCar = new RentalCar();
                    String model = read.next();
                    String colour = read.next();
                    String condition_String = read.next();
                    int day = read.nextInt();
                    String month = read.next();
                    int year = read.nextInt();
                                     
                    if("Low".equals(condition_String)){
                        rentalCar = new RentalCar(pid, status, yearsOwned, sellingPrice, buyingPrice, model, colour, condition.Bad, new Date(day, month, year));
                    }else if("Fair".equals(condition_String)){
                        rentalCar = new RentalCar(pid, status, yearsOwned, sellingPrice, buyingPrice, model, colour, condition.Fair, new Date(day, month, year));
                    }else if("Good".equals(condition_String)){
                        rentalCar = new RentalCar(pid, status, yearsOwned, sellingPrice, buyingPrice, model, colour, condition.Good, new Date(day, month, year));
                    }
                    
                    assetList.add(rentalCar);
                }
                       
            }            
        } catch (FileNotFoundException ex) {                //If the file could not be found
            Logger.getLogger(AssetManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR: Properties data file not found!");
        } 
    }

    private static void makeChanges(Asset property) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("----------------- MAKE CHANGES TO ------------------");
        System.out.println("1. SELLING PRICE");
        System.out.println("2. BUYING PRICE");
        
        int choice = 0;
        System.out.print("ENTER OPTION :");
        try {
            choice = Integer.parseInt(br.readLine());
        } catch (NumberFormatException e) {
            System.err.println("Invalid input.");
            Search();
        }
        
        if(choice == 1){
            System.out.println("ENTER THE NEW SELLING PRICE : ");
            double newSellingPrice = input.nextDouble();
            property.setSellingPrice(newSellingPrice);
            save(assetList);
        }else if(choice == 2){
            System.out.println("ENTER THE NEW BUYING PRICE : ");
            double newBuyingPrice = input.nextDouble();
            property.setBuyingPrice(newBuyingPrice);
            save(assetList);
        }
        
    }
    
    public static void save(ArrayList<Asset> assetList) throws IOException {
        File file = new File("src/realestates/Assets.txt");
        try (FileWriter w = new FileWriter(file.getAbsoluteFile(),false);//the "true" part lets you continue writing in the file
            BufferedWriter buw = new BufferedWriter(w);                 //....instead of overwriting everything
            PrintWriter out = new PrintWriter(buw))
        {
            if (!file.exists()) {//if the "Properties.txt" doesnt exist it automatically creates it
                file.createNewFile();
            }
            
            for(int i = 0;i < assetList.size(); i++){                 
                String output = assetList.get(i).print();
                out.println(output); 
            }
                        
            buw.close();//closes the BufferedWriter
        } catch (IOException e) {
        }
    }

    private static void receipt(String buyer, double amount ,Asset sold) {
        File file = new File("src/realestates/Receipt.txt");
        try (FileWriter w = new FileWriter(file.getAbsoluteFile(),false);//the "false" part overwrites the whole file
            BufferedWriter buw = new BufferedWriter(w);                 
            PrintWriter out = new PrintWriter(buw))
        {
            if (!file.exists()) {//if the "Receipt.txt" doesnt exist it automatically creates it
                file.createNewFile();
            }
            
            out.println("----------------------------------------");
            out.println("--------------RECEIPT--------------------"); 
            out.println("SOLD TO        : " + buyer);
            out.printf("PAID            : N$%.2f",amount);
            out.printf("BUYING PRICE    : N$%.2f",sold.getBuyingPrice());
            out.printf("\nSELLING PRICE : N$%.2f",sold.getSellingPrice());
            out.printf("\nPROFIT/LOSS   : N$%.2f",sold.checkProfitOrLoss());
            out.println("\n----------------------------------------");
            out.printf("\nCHANGE N$%.2f",(amount - sold.getSellingPrice()));
            out.println("\n----------------------------------------");
            out.println();
                        
            buw.close();//closes the BufferedWriter
        } catch (IOException e) {
        }
    }    
}

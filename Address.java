package realestates;

public class Address {
    private int erfNo;
    private String street;
    private String town;

    public Address(int erfNo, String street, String town) {
        this.erfNo = erfNo;
        this.street = street;
        this.town = town;
    }

    public Address() {
    }

    public int getErfNo() {
        return erfNo;
    }

    public void setErfNo(int erfNo) {
        this.erfNo = erfNo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Override
    public String toString() {
        return "ErfNo " + erfNo + ", Street " + street + ", Town=" + town;
    }     
}


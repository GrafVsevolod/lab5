package models;

public class Address {
    private String street;

    private String zipCode;

    public Address(String street, String zipCode){
        this.street = street;
        this.zipCode = zipCode;
    }

    public String getStreet(){
        return street;
    }

    public String getZipCode(){
        return zipCode;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}

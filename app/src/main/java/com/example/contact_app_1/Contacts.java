package com.example.contact_app_1;

public class Contacts extends ContactParent {
    private int id;
    private String name;
    private String sirName;
    private String phoneNumber;
    private String address;
    private String email;

    public Contacts() {

    }

    public Contacts(String fullName,String address , String mobile)
    {
        super(ContactParent.WITH_TEXT);
        setName(fullName);
        setAddress(address);
        setMobileNumber(mobile);
    }

    public Contacts(int id, String name, String sirName,
                    String phoneNumber, String address,
                    String email) {
        super(ContactParent.WITH_TEXT);
        setId(id);
        setName(name);
        setSirName(sirName);
        setMobileNumber(phoneNumber);
        setAddress(address);
        setEmail(email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSirName() {
        return sirName;
    }

    public void setSirName(String sirName) {
        this.sirName = sirName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.phoneNumber = mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

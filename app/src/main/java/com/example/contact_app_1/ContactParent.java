package com.example.contact_app_1;


public class ContactParent
{
    public static final int WITH_TEXT = 648 ;
    //public static final int WITH_IMAGE = 464 ;

    private int currentType;

    public ContactParent(int currentType)
    {
        this.setCurrentType(currentType);
    }

    public ContactParent() {
    }

    public int getCurrentType() {
        return currentType;
    }

    public void setCurrentType(int currentType) {
        this.currentType = currentType;
    }
}

package com.example.contact_app_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.Surface;

import java.util.ArrayList;
import java.util.List;

public class DataBase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "ContactData";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "INFO_TABLE";
    public static final String COL_ID = "Id";
    public static final String COL_Name = "Name";
    public static final String COL_SIRNAME = "SirName";
    public static final String COL_PH_NUM = "PhoneNumber";
    public static final String COL_ADDRESS = "Address";
    public static final String COL_Email = "Email";

    private Context myContext;


    public DataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.myContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE INFO_TABLE ("
                + "Id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "Name TEXT, "
                + "SirName TEXT, "
                + "PhoneNumber TEXT, "
                + "Address TEXT ,"
                + "Email TEXT "
                + ");");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }



    public void addContact(Contacts contacts) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_Name, contacts.getName());
        values.put(COL_SIRNAME, contacts.getSirName());
        values.put(COL_PH_NUM, contacts.getPhoneNumber());
        values.put(COL_ADDRESS, contacts.getAddress());
        values.put(COL_Email, contacts.getEmail());

        db.insert(TABLE_NAME, null, values);
        db.close();

    }

//    public List<Contacts> getAllContacts() throws SQLiteException {
//
//        //Fields
//        Cursor cursor = null;
//        SQLiteDatabase db = this.getReadableDatabase();
//        //QUery - Raw
//        String rawQuery = "select * from INFO_TABLE";
//        cursor = db.rawQuery(rawQuery, null);
//        //Creating Array list
//        List<Contacts> listContact = new ArrayList<>();
//        //loop for reading
//        while (cursor.moveToNext()) {
//            Contacts contacts1 = new Contacts(
//                    cursor.getString(cursor.getColumnIndex("Name")),
//                    cursor.getString(cursor.getColumnIndex("SirName")),
//                    cursor.getString(cursor.getColumnIndex("PhoneNumber")),
//                    cursor.getString(cursor.getColumnIndex("Address")),
//                    cursor.getString(cursor.getColumnIndex("Email")));
//            contacts1.setId(cursor.getInt(cursor.getColumnIndexOrThrow("Id")));
//            listContact.add(contacts1);
//        }
//        //closing cursor and return
//        cursor.close();
//        return listContact;
//    }


    //============================= <<<< Show All Contact >>>> =============================
    public List<Contacts> getAllContactsCopy()
    {
        List<Contacts> contactList = new ArrayList<Contacts>();
        //Select All query
        String selectQuery = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);

        //looking through all rows and adding to list
        if (cursor.moveToFirst())
        {
            do {
                Contacts contact = new Contacts();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setSirName(cursor.getString(2));
                contact.setMobileNumber(cursor.getString(3));
                contact.setAddress(cursor.getString(4));
                contact.setEmail(cursor.getString(5));

                //Adding contact to list
                contactList.add(contact);
            }while(cursor.moveToNext());
        }
        return contactList;
    }

    //============================= <<<< Search for Contact >>>> =============================
    Contacts getContact(int id) throws SQLiteException
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor =
                db.query(TABLE_NAME,
                        new String[]{COL_ID,COL_Name,COL_SIRNAME,COL_PH_NUM,COL_ADDRESS,COL_Email},
                        "=?",
                        new String[]{String.valueOf(id)},
                        null,null,null,null);
        Contacts contact = null;
        if (cursor!=null)
        {
            cursor.moveToFirst();

            contact =
                    new Contacts(
                            (Integer.parseInt(cursor.getString(0))),
                                              cursor.getString(1),
                                              cursor.getString(2),
                                              cursor.getString(3),
                                              cursor.getString(4),
                                              cursor.getString(5));
        }
        return contact;
    }


    //============================= <<<< Update Contact >>>> =============================
    public int editContact(Contacts contacts)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_Name,contacts.getName());
        values.put(COL_PH_NUM,contacts.getPhoneNumber());

        //updating new
        return db.update(TABLE_NAME , values , COL_ID + "=?",
                new String[]{String.valueOf(contacts.getId())});
    }

}

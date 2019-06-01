package com.example.contact_app_1;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class Write_Contact extends AppCompatActivity implements Serializable {

    TextView txtFullName, txtName, txtSirName, txtPhone, txtAddress, txtEmail;

    EditText edtName, edtSirName, edtEmail, edtAddress, edtMobileNumber;

    String name, sirName, email, address, mobileNumber , fullName;

    Button btnSaveInfo;

    DataBase db;
    public static Contacts myContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write__contact);
        findViews();

        edtName = findViewById(R.id.edt_name_id);
        edtSirName = findViewById(R.id.edt_sir_name_id);
        edtEmail = findViewById(R.id.edt_email_id);
        edtAddress = findViewById(R.id.edt_address_id);
        edtMobileNumber = findViewById(R.id.edt_phone_number_id);

//        name = edtName.getText().toString();
//        sirName = edtName.getText().toString();
//        email = edtName.getText().toString();
//        address = edtName.getText().toString();
//        mobileNumber = edtName.getText().toString();


        myContacts = new Contacts();
        db = new DataBase(this);

        btnSaveInfo = findViewById(R.id.btn_save_info_id);

        btnSaveInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myContacts.setName(edtName.getText().toString());
                myContacts.setSirName(edtSirName.getText().toString());
                myContacts.setEmail(edtEmail.getText().toString());
                myContacts.setAddress(edtAddress.getText().toString());
                myContacts.setMobileNumber(edtMobileNumber.getText().toString());

                Log.d("CREATING CONTACT ---", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
                db.addContact(myContacts);

                Log.d("CONTACT CREATED---", "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");

                name = myContacts.getName();
                sirName = myContacts.getSirName();
                mobileNumber = myContacts.getPhoneNumber();
                address = myContacts.getAddress();
                email = myContacts.getEmail();

                Log.d("SETTING CONTACT---", "SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");

                Toast.makeText(Write_Contact.this, "Contact saved", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Write_Contact.this, Show_Single_Contact.class);
                i.putExtra("name",name);
                i.putExtra("sirname",sirName);
                i.putExtra("mobile",mobileNumber);
                i.putExtra("address",address);
                i.putExtra("email",email);

                fullName = name +" "+sirName;
                MainActivity.myContactsList_MAIN_ACTV.add(new Contacts(fullName,address,mobileNumber));

                startActivity(i);
            }
        });

    }

    public void findViews() {
        txtFullName = findViewById(R.id.act_show_single_contact_full_name_id);
        txtName = findViewById(R.id.act_show_single_contact_first_name_id);
        txtSirName = findViewById(R.id.act_show_single_contact_last_name_id);
        txtPhone = findViewById(R.id.act_show_single_contact_phone_id);
        txtAddress = findViewById(R.id.act_show_single_contact_address_id);
        txtEmail = findViewById(R.id.act_show_single_contact_email_id);
    }

//    public void setContact(Contacts myContacts) {
//
//        txtFullName.setText("New Contact");
//        txtName.setText(myContacts.getName());
//        txtSirName.setText(myContacts.getSirName());
//        txtPhone.setText(myContacts.getPhoneNumber());
//        txtAddress.setText(myContacts.getAddress());
//        txtEmail.setText(myContacts.getEmail());
//
//    }

}

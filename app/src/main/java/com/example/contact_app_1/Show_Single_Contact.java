package com.example.contact_app_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.Serializable;

public class Show_Single_Contact extends AppCompatActivity implements Serializable {

    TextView txtFullName,txtName,txtSirName,txtPhone,txtAddress,txtEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show__single__contact);
        findViews();


        Intent i = getIntent();
        String name = i.getStringExtra("name");
        txtName.setText(name);
        String lastName = i.getStringExtra("sirname");
        txtSirName.setText(lastName);
        String phone = i.getStringExtra("mobile");
        txtPhone.setText(phone);
        String address = i.getStringExtra("address");
        txtAddress.setText(address);
        String email = i.getStringExtra("email");
        txtEmail.setText(email);

        txtFullName.setText(name+" "+lastName);


    }

    @Override
    public void onBackPressed()
    {
        Intent i = new Intent(Show_Single_Contact.this,MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
        finish();
    }

//    @Override
//    protected void onDestroy()
//    {
//        Runtime.getRuntime().gc();
//        super.onDestroy();
//    }

    public void findViews()
    {
        txtFullName = findViewById(R.id.act_show_single_contact_full_name_id);
        txtName = findViewById(R.id.act_show_single_contact_first_name_id);
        txtSirName = findViewById(R.id.act_show_single_contact_last_name_id);
        txtPhone = findViewById(R.id.act_show_single_contact_phone_id);
        txtAddress = findViewById(R.id.act_show_single_contact_address_id);
        txtEmail = findViewById(R.id.act_show_single_contact_email_id);
    }
//
//    public void setContact(Contacts myContacts)
//    {
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

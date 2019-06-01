package com.example.contact_app_1;

import android.content.Intent;
import android.net.wifi.aware.PublishConfig;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    Button btnCreateContact;
    EditText edtSearch;
    Animation animation;

    public static List<Contacts> myContactsList_MAIN_ACTV = new ArrayList<>();
    public static RecyclerView recyclerView ;
    public static ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animation = AnimationUtils.loadAnimation(this,R.anim.anim5);
        btnCreateContact = findViewById(R.id.btn_add_contact_id);
        btnCreateContact.startAnimation(animation);
        edtSearch = findViewById(R.id.editText_actv_id);
        edtSearch.setSelected(false);
        recyclerView = findViewById(R.id.recycler_view_contact_list_id);
        adapter = new ContactAdapter(myContactsList_MAIN_ACTV,MainActivity.this);

        recyclerView.setLayoutManager
                (new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);


        btnCreateContact.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Write_Contact.class);
                startActivity(i);
            }
        });


    }



    //===============  <<<<   AsyncTask   >>>>  ===============
    public class showContacts_AsyncTast extends AsyncTask<String,Integer,String>
    {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }
}

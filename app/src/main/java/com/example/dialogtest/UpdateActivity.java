package com.example.dialogtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class UpdateActivity extends AppCompatActivity {
    EditText update_name,update_age,update_address;
    Button update_btn;
    List<DialogModel> list = new ArrayList<>();
    String update_name_= "";
    String update_age_= "";
    String update_address_= "";
    String type= "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        update_name=findViewById(R.id.edt_updname);
        update_age=findViewById(R.id.edt_updage);
        update_address=findViewById(R.id.edt_updaddress);
        update_btn=findViewById(R.id.upd_btn);

        Intent intent = getIntent();
         update_name_= intent.getStringExtra("updatename");
         update_age_ = intent.getStringExtra("updateage");
         update_address_ = intent.getStringExtra("updateaddress");
         type  =intent.getStringExtra("type");

        update_name.setText(update_name_);
        update_age.setText(update_age_);
        update_address.setText(update_address_);



        update_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String name=  update_name.getText().toString();
                String age=update_age.getText().toString();
                String address=update_address.getText().toString();
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("updatename",name);
                intent.putExtra("updateage",age);
                intent.putExtra("updateaddress",address);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(intent);
           
            }
        });

    }
}
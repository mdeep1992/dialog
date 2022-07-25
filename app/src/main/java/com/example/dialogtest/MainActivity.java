package com.example.dialogtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.icu.text.Transliterator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements updateInterface{
    RecyclerView recyclerView;
    FloatingActionButton fab_button;
    List<DialogModel> list = new ArrayList<>();
    DialogAdapter my_dialog_adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);
        DoInitRecyclerview();
        fab_button = findViewById(R.id.fab_btn);
        fab_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialogbox);
                EditText edt_name = dialog.findViewById(R.id.edt_name);
                EditText edt_age = dialog.findViewById(R.id.edt_age);
                EditText edt_address = dialog.findViewById(R.id.edt_address);
                Button save_btn = dialog.findViewById(R.id.save_btn);
                save_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name = "", age = "", address = "";
                        if (!edt_name.getText().toString().equals("")) {
                            name = edt_name.getText().toString();
                        } else {
                            Toast.makeText(MainActivity.this, "pls enter the name", Toast.LENGTH_SHORT).show();
                        }
                        if (!edt_age.getText().toString().equals("")) {
                            age = edt_age.getText().toString();
                        } else {
                            Toast.makeText(MainActivity.this, "pls enter the age", Toast.LENGTH_SHORT).show();
                        }
                        if (!edt_address.getText().toString().equals("")) {

                            address = edt_address.getText().toString();
                        } else {
                            Toast.makeText(MainActivity.this, "pls enter the address", Toast.LENGTH_SHORT).show();
                        }


                        if (edt_name.getText().toString().equals("") && edt_age.getText().toString().equals("") && edt_address.getText().toString().equals("")) {
                            Toast.makeText(MainActivity.this, "pls enter the details", Toast.LENGTH_SHORT).show();
                        } else {

                            DialogModel modelDialog = new DialogModel();
                            modelDialog.setName(name);
                            modelDialog.setAge(age);
                            modelDialog.setAddress(address);
                            list.add(modelDialog);
                            dialog.dismiss();
                        }


                    }

                });
                dialog.show();
            }
        });


    }

    private void DoInitRecyclerview() {
        my_dialog_adapter = new DialogAdapter(this, list,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(my_dialog_adapter);

    }
    Runnable runnable = new Runnable()
    {
        @Override
        public void run()
        {

        }
    };


    @Override
    public void onItemClick(DialogModel dialogModel , int position) {

        try{
        Dialog dialog_ = new Dialog(MainActivity.this);
            dialog_.setContentView(R.layout.dialogbox);
        EditText edt_name = dialog_.findViewById(R.id.edt_name);
        EditText edt_age = dialog_.findViewById(R.id.edt_age);
        EditText edt_address = dialog_.findViewById(R.id.edt_address);
        Button save_btn = dialog_.findViewById(R.id.save_btn);
        save_btn.setText("UPDATE");
        edt_name.setText(list.get(position).name);
        edt_age.setText(list.get(position).age);
        edt_address.setText(list.get(position).address);
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = "", age = "", address = "";
                if (!edt_name.getText().toString().equals("")) {
                    name = edt_name.getText().toString();
                } else {
                    Toast.makeText(MainActivity.this,"ps enter the name", Toast.LENGTH_SHORT).show();
                }
                if (!edt_age.getText().toString().equals("")) {
                    age = edt_age.getText().toString();
                } else  {
                    Toast.makeText(getApplicationContext(), "pls enter the age", Toast.LENGTH_SHORT).show();
                }
                if (!edt_address.getText().toString().equals("")) {

                    address = edt_address.getText().toString();
                } else {
                    Toast.makeText(getApplicationContext(), "pls enter the address", Toast.LENGTH_SHORT).show();
                }


                if (edt_name.getText().toString().equals("") && edt_age.getText().toString().equals("") && edt_address.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "pls enter the details", Toast.LENGTH_SHORT).show();
                } else {

                    DialogModel modelDialog = new DialogModel();
                    modelDialog.setName(name);
                    modelDialog.setAge(age);
                    modelDialog.setAddress(address);
                    list.add(modelDialog);
                    dialog_.dismiss();
                }
                list.set(position, new DialogModel(name, age, address));
                //notifyItemChanged(position);

            }

        });


            dialog_.show();

    }catch (Exception e){
           // System.out.println("Error " + e.getMessage());
            Log.i("Error>>>" , e.toString());

        }
    }
}
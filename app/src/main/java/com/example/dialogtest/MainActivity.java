package com.example.dialogtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FloatingActionButton fab_button;
    ArrayList<DialogModel> list = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);
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
                        if (!edt_name.getText().toString().equals("")) {
                            String name = edt_name.getText().toString();
                        } else {
                            Toast.makeText(MainActivity.this, "pls enter the name", Toast.LENGTH_SHORT).show();
                        }
                        if (!edt_age.getText().toString().equals("")) {
                            String age = edt_age.getText().toString();
                        } else {
                            Toast.makeText(MainActivity.this, "pls enter the age", Toast.LENGTH_SHORT).show();
                        }
                        if (!edt_address.getText().toString().equals("")) {

                            String address = edt_address.getText().toString();
                        } else {
                            Toast.makeText(MainActivity.this, "pls enter the address", Toast.LENGTH_SHORT).show();
                        }
                        dialog.dismiss();

                    }

                });
                dialog.show();
            }
        });

    }
}
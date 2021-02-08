package com.example.sqliteoperations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Name,Score;
    Button bt1,bt2;
    myDbManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name = (EditText) findViewById(R.id.editText);
        Score = (EditText) findViewById(R.id.editText2);
        bt1 = (Button)findViewById(R.id.button);
        bt2 = (Button)findViewById(R.id.button2);
        manager = new myDbManager(this);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUser();

            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewData();
            }
        });
    }
    public void addUser(){
//get value from EditText
        String t1 = Name.getText().toString();
        String t2 = Score.getText().toString();
//check if empty?
        if(t1.isEmpty() || t2.isEmpty()) {
            Toast.makeText(this, "Enter Both Name and Score",

                    Toast.LENGTH_LONG).show();
        }
        else {
            long id = manager.insert(t1,t2);
            if(id<=0) {
                Toast.makeText(this, "Insertion Unsuccessful", Toast.LENGTH_LONG).show();
                Name.setText("");
                Score.setText("");
            } else {
                Toast.makeText(this, "Insertion Successful", Toast.LENGTH_LONG).show();
                Name.setText("");
                Score.setText("");
            }
//add data to database
        }
    }
    public void viewData() {
        String data = manager.getData();
        Toast.makeText(this, data, Toast.LENGTH_LONG).show();
    }
}
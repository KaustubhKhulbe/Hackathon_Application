package com.example.hackathon_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Driver extends AppCompatActivity {

    int[] chosen;
    TextView display;
    String name;
    Button h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver);
       // Bundle myBundle = getIntent().getExtras();
       // chosen = myBundle.getIntArray("chosen");
        h = (Button)findViewById(R.id.leave);
        h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent temp = new Intent(Driver.this, MainActivity.class);
                startActivity(temp);
            }
        });
        Intent intent = getIntent();
        name = intent.getExtras().getString("name");
        display = (TextView)findViewById(R.id.DISPLAY);
        findDrivers();

    }

    public void findDrivers(){
        for(int i = 0; i < DriverManager.drivers.length;i++){

            if(DriverManager.drivers[i] != null&&DriverManager.drivers[i].isSelected){
                System.out.println("CHECK");
                if(DriverManager.drivers[i].getName().equals(name)){
                    System.out.println("CHECK");
                    display.setText(DriverManager.drivers[i].getName() + " , you been selected and are scheduled to deliver between " + DriverManager.drivers[i].getStart() + " and " + DriverManager.drivers[i].getEnd() + " from hospital A to hospital B. Estimated time: 22 minutes");
                    break;
                }

            }
        }
    }




}

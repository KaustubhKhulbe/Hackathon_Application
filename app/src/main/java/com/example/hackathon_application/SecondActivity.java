package com.example.hackathon_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


public class SecondActivity extends AppCompatActivity {

    Button home;
    int[] chosen;
    TextView success;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle myBundle = getIntent().getExtras();
        chosen = myBundle.getIntArray("chosen");

        success = (TextView)findViewById(R.id.SUCCESS);
        setText();
        home = (Button) findViewById(R.id.Home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle myBundle = new Bundle();
                myBundle.putIntArray("chosen", chosen);
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                intent.putExtra("chosen", chosen);
                startActivity(intent);
            }
        });

    }
    public void setText(){
        boolean temp = false;
        for(int i = 0; i < DriverManager.drivers.length;i++){
            if(DriverManager.drivers[i] != null && DriverManager.drivers[i].isSelected){
                temp = true;

            }
        }

        if(temp){
            success.setText("Success! Your order has been placed");
        }
        else{
            success.setText("Sorry, no drivers are available ... we will notify you as soon as they are");
        }

    }




}

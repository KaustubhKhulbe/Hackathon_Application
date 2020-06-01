package com.example.hackathon_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int errorCount = 5;
    private TextView registration;
    int[] chosen;

    //GIT UPDATE TEST

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // Bundle myBundle = getIntent().getExtras();
//        chosen = myBundle.getIntArray("chosen");
        Name = (EditText)findViewById(R.id.etName);
        Password = (EditText)findViewById(R.id.etPassword);
        Info = (TextView)findViewById(R.id.tvInfo);
        Login = (Button) findViewById(R.id.btLogin);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateInfo(Name.getText().toString(), Password.getText().toString());
            }
        });

    }

    private void validateInfo(String userName, String userPassword){

        if(userName.equals("Hospital1") && userPassword.equals("Hospital1")){
            Intent intent = new Intent(MainActivity.this, Hospitals.class);
            startActivity(intent);
        }
        else if (userName.equals("Hannah") && userPassword.equals("Hannah")){
            //Bundle bundle = new Bundle();
            //bundle.putIntArray("chosen", chosen);
            Intent intent = new Intent(MainActivity.this, Driver.class);
            intent.putExtra("name", "Hannah");
            startActivity(intent);
        }
        else if (userName.equals("Jeff") && userPassword.equals("Jeff")){
            //Bundle bundle = new Bundle();
            //bundle.putIntArray("chosen", chosen);
            Intent intent = new Intent(MainActivity.this, Driver.class);
            intent.putExtra("name", "Jeff");
            startActivity(intent);
        }
        else if (userName.equals("Bob") && userPassword.equals("Bob")){
            //Bundle bundle = new Bundle();
            //bundle.putIntArray("chosen", chosen);
            Intent intent = new Intent(MainActivity.this, Driver.class);
            intent.putExtra("name", "Bob");
            startActivity(intent);
        }
        else if (userName.equals("James") && userPassword.equals("James")){
            //Bundle bundle = new Bundle();
            //bundle.putIntArray("chosen", chosen);
            Intent intent = new Intent(MainActivity.this, Driver.class);
            intent.putExtra("name", "James");
            startActivity(intent);
        }
        else if (userName.equals("Jimmy") && userPassword.equals("Jimmy")){
            //Bundle bundle = new Bundle();
            //bundle.putIntArray("chosen", chosen);
            Intent intent = new Intent(MainActivity.this, Driver.class);
            intent.putExtra("name", "Jimmy");
            startActivity(intent);
        }
        else if (userName.equals("Chandler") && userPassword.equals("Chandler")){
            //Bundle bundle = new Bundle();
            //bundle.putIntArray("chosen", chosen);
            Intent intent = new Intent(MainActivity.this, Driver.class);
            intent.putExtra("name", "Chandler");
            startActivity(intent);
        }
        else if (userName.equals("Cathy") && userPassword.equals("Cathy")){
            //Bundle bundle = new Bundle();
            //bundle.putIntArray("chosen", chosen);
            Intent intent = new Intent(MainActivity.this, Driver.class);
            intent.putExtra("name", "Cathy");
            startActivity(intent);
        }

        else{
            errorCount--;
            if(errorCount == 0){
                Login.setEnabled(false);
            }
            Info.setText("Number of attempts left: " + String.valueOf(errorCount));
        }
    }
}

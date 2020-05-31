package com.example.hackathon_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {


    private EditText userName, userPin;
    private Button Register;
    private TextView logIn;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setUpUI();

        firebaseAuth = FirebaseAuth.getInstance();

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkAllInput()){
                    String userEmail = userName.getText().toString().trim();
                    String userPassword = userPin.getText().toString().trim();
                    firebaseAuth.createUserWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(Register.this,"Registration succesful",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Register.this, MainActivity.class));
                            }
                            else{
                                Toast.makeText(Register.this,"Registration failed",Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }
            }
        });
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register.this, MainActivity.class));
            }
        });
    }

    private boolean checkAllInput() {

        boolean result = false;
        String name = userName.getText().toString();
        String password = userPin.getText().toString();

        if(name.isEmpty() && password.isEmpty()){
            Toast.makeText(this, "Please enter all info!", Toast.LENGTH_SHORT).show();
        } else{
            result = true;
        }

        return result;

    }

    private void setUpUI(){
        userName = (EditText)findViewById(R.id.etName);
        userPin = (EditText)findViewById(R.id.etPassword);
        Register = (Button)findViewById(R.id.btLogin);
        logIn = (TextView)findViewById(R.id.tvSignIn);
    }
}

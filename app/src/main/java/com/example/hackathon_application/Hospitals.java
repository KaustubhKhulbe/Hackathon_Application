package com.example.hackathon_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ComponentInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Hospitals extends AppCompatActivity {

    Button cont;
    Button[] buttons = new Button[6];
    TextView[] views = new TextView[6];
    TextView[] selectedViews = new TextView[6];
    final int[] amounts1 = {2,5,8,5,3,11};
    int[] amounts = {2,5,8,5,3,11};
    int[] chosen = {0,0,0,0,0,0};
    Button[] addButtons = new Button[6];
    Button signOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitals);
        intializeButtons();
        initializeAddButtons();
        initializeText();
        initializeSelectedView();
        initializeAmounts();
        initializeChosen();

        signOut = (Button) findViewById(R.id.exit);
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Hospitals.this, MainActivity.class);
                startActivity(i);
            }
        });

        cont = (Button)findViewById(R.id.btnCont);
        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle myBundle = new Bundle();
                myBundle.putIntArray("chosen", chosen);
                Intent intent = new Intent(Hospitals.this, HospitalStage2.class);
                intent.putExtra("chosen", chosen);
                startActivity(intent);
            }
        });

    }

    private void initializeAddButtons(){
        addButtons[0] = (Button)findViewById(R.id.button6);
        addButtons[1] = (Button)findViewById(R.id.button7);
        addButtons[2] = (Button)findViewById(R.id.button8);
        addButtons[3] = (Button)findViewById(R.id.button9);
        addButtons[4] = (Button)findViewById(R.id.button10);
        addButtons[5] = (Button)findViewById(R.id.button11);
        onCreateAddButtons();
    }

    private void intializeButtons(){
        buttons[0] = (Button)findViewById(R.id.button0);
        buttons[1] = (Button)findViewById(R.id.button1);
        buttons[2] = (Button)findViewById(R.id.button2);
        buttons[3] = (Button)findViewById(R.id.button3);
        buttons[4] = (Button)findViewById(R.id.button4);
        buttons[5] = (Button)findViewById(R.id.button5);
        SetOnCreateForButtons();
    }

    private void initializeText(){
        views[0] = (TextView)findViewById(R.id.textView0);
        views[1] = (TextView)findViewById(R.id.textView1);
        views[2] = (TextView)findViewById(R.id.textView2);
        views[3] = (TextView)findViewById(R.id.textView3);
        views[4] = (TextView)findViewById(R.id.textView4);
        views[5] = (TextView)findViewById(R.id.textView5);
    }

    private void initializeSelectedView(){
        selectedViews[0] = (TextView)findViewById(R.id.textView6);
        selectedViews[1] = (TextView)findViewById(R.id.textView7);
        selectedViews[2] = (TextView)findViewById(R.id.textView8);
        selectedViews[3] = (TextView)findViewById(R.id.textView9);
        selectedViews[4] = (TextView)findViewById(R.id.textView10);
        selectedViews[5] = (TextView)findViewById(R.id.textView11);
    }

    private void onCreateAddButtons(){
        for(int i = 0; i < addButtons.length;i++){
            final int finalI = i;
            addButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateCount( finalI);
                    initializeAmounts();
                    updateButton(finalI);
                    //setText();
                }
            });
        }
    }

    private void SetOnCreateForButtons(){
        for(int i = 0; i < buttons.length;i++){
            final int finalI = i;
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addCount(finalI);
                    //setText();
                }
            });
        }

    }

    private void updateCount(int i){
        amounts[i] ++;
        amounts1[i] ++;
        //chosen[i] ++;

    }

    private void addCount(int i){
        if(amounts[i] == 0){
            buttons[i].setEnabled(false);
            return;
        }
        chosen[i] ++;
        amounts[i] --;
        initializeAmounts();
        updateText();
    }

    private void initializeAmounts(){
        for(int i = 0; i < views.length; i++){
            views[i].setText(Integer.toString(amounts[i]));
        }
    }
    private void initializeChosen(){
        for(int i = 0; i < chosen.length;i++){
            chosen[i] = 0;
        }

    }
    private void updateText(){
        for(int i = 0; i < selectedViews.length; i++){

            selectedViews[i].setText(Integer.toString(chosen[i]));

        }
    }
    private void updateButton(int i){


            selectedViews[i].setText(Integer.toString(chosen[i]));


    }
}

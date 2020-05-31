package com.example.hackathon_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HospitalStage2 extends AppCompatActivity {

    TextView textView;
    int[] chosen = {0, 0, 0, 0, 0, 0};
    DriverClass[] available;
    TextView[] DriverViews = new TextView[10];
    Button[] checkBoxes = new Button[10];
    Button Continue;
    Button choose;
    EditText time;
    Button submit;
    int val;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_stage2);
        time = (EditText)findViewById(R.id.editText) ;

        Bundle myBundle = getIntent().getExtras();
        chosen = myBundle.getIntArray("chosen");
        System.out.println(chosen);
        //textView = (TextView)findViewById(R.id.textView12);

        DriverManager.add(new DriverClass("Bob", 5, 7)); //TODO fix Bob button
        DriverManager.add(new DriverClass("James", 7, 8));
        DriverManager.add(new DriverClass("Jeff", 4, 11));
        DriverManager.add(new DriverClass("Hannah", 3, 6));
        DriverManager.add(new DriverClass("Jimmy", 2, 3));
        DriverManager.add(new DriverClass("Chandler", 10, 12));
        DriverManager.add(new DriverClass("Cathy", 8, 9));

        submit = (Button) findViewById(R.id.continue1);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val = Integer.parseInt(time.getText().toString());
                available = DriverManager.listAvailableDrivers(val);
                int l = available.length;
                listDrivers();
                setUpNewScreen();
            }
        });





        /*initializeText();
        intitialzeCheckBoxes(l);*/ //TODO uncomment



    }

    public void setUpNewScreen(){
        Bundle bundle = new Bundle();
        bundle.putIntArray("chosen", chosen);
        Intent intent = new Intent(HospitalStage2.this, SecondActivity.class);
        intent.putExtra("chosen", chosen);
        startActivity(intent);
    }


    public void listDrivers() {
        for (int i = 0, c = 0; i < available.length; i++) {  //TODO change back
            if(available[i] != null){
                DriverClass[] available = DriverManager.listAvailableDrivers(val); //TODO remove
                System.out.println("DRIVER "+available[i].getName());
                int t = DriverManager.findDrivers(available[i]);
                DriverManager.selectDriver(t);
            /*if (available[i] != null) { //TODO uncomment
                DriverViews[c].setText(available[i].getName());
                c++;
            }*/
                break;
            }


        }
    }

    public void initializeText() {
        /*DriverViews[0] = (TextView) findViewById(R.id.d1);
        DriverViews[1] = (TextView) findViewById(R.id.d2);
        DriverViews[2] = (TextView) findViewById(R.id.d3);
        DriverViews[3] = (TextView) findViewById(R.id.d4);
        DriverViews[4] = (TextView) findViewById(R.id.d5);
        DriverViews[5] = (TextView) findViewById(R.id.d6);
        DriverViews[6] = (TextView) findViewById(R.id.d7);
        DriverViews[7] = (TextView) findViewById(R.id.d8);
        DriverViews[8] = (TextView) findViewById(R.id.d9);
        DriverViews[9] = (TextView) findViewById(R.id.d10);*/

    }

    public void intitialzeCheckBoxes(int l){

            /*checkBoxes[0] = (Button) findViewById(R.id.checkBox);
            checkBoxes[1] = (Button) findViewById(R.id.checkBox2);
            checkBoxes[2] = (Button) findViewById(R.id.checkBox3);
            checkBoxes[3] = (Button) findViewById(R.id.checkBox4);
            checkBoxes[4] = (Button) findViewById(R.id.checkBox5);
            checkBoxes[5] = (Button) findViewById(R.id.checkBox6);
            checkBoxes[6] = (Button) findViewById(R.id.checkBox7);
            checkBoxes[7] = (Button) findViewById(R.id.checkBox8);
            checkBoxes[8] = (Button) findViewById(R.id.checkBox9);
            checkBoxes[9] = (Button) findViewById(R.id.checkBox10);

        for(int i = 0; i < checkBoxes.length;i++){
            final int finalI = i;

            checkBoxes[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //int t = DriverManager.findDrivers(available[finalI]);
                    DriverManager.selectDriver(finalI);
                    return;

                }
            });
        }*/
    }

}




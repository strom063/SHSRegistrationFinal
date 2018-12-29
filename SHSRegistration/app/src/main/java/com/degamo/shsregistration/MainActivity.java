package com.degamo.shsregistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {


    Spinner Tracks;
    EditText LastName, FirstName, MiddleName;
    RadioButton rbMale, rbFemale;
    CheckBox cb4, cb3, cb2, cb1;
    Button btn;


    String academicProgram, LN, FN, MN, G, RQTS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Tracks = findViewById(R.id.spn);
        LastName = findViewById(R.id.LName);
        FirstName = findViewById(R.id.FName);
        MiddleName = findViewById(R.id.MName);
        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
        cb1 = findViewById(R.id.cbx1);
        cb2 = findViewById(R.id.cbx2);
        cb3 = findViewById(R.id.cbx3);
        cb4 = findViewById(R.id.cbx4);
    }

    public void ST(View view) {

        academicProgram = Tracks.getSelectedItem().toString();
        LN= LastName.getText().toString();
        FN = FirstName.getText().toString();
        MN = MiddleName.getText().toString();

        if(rbMale.isChecked()) {
            G = "Male";
        }
        else {
            G = "Female";
        }

        RQTS = "";
        if(cb1.isChecked()) {
            RQTS = cb1.getText().toString() + "\n";
        }
        if(cb2.isChecked()) {
            RQTS =  RQTS + cb2.getText().toString() + "\n";
        }
        if(cb3.isChecked()) {
            RQTS =  RQTS + cb3.getText().toString() + "\n";
        }
        if(cb4.isChecked()) {
            RQTS = RQTS+ cb4.getText().toString() + "\n";

        }


        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.putExtra("academicProgram", academicProgram);
        intent.putExtra("lastname", LN);
        intent.putExtra("firstname", FN);
        intent.putExtra("middlename", MN);
        intent.putExtra("gender", G);
        intent.putExtra("requirements",  RQTS);
        startActivity(intent);



    }
}
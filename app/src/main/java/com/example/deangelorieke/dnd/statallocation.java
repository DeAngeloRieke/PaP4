package com.example.deangelorieke.dnd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class statallocation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statallocation);

        Button back = findViewById(R.id.statsBackButton);
        Button rollAll = findViewById(R.id.statsRollAll);
        Button rollSelected = findViewById(R.id.statsRollSel);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ccBack = new Intent(statallocation.this, NewCharacter.class);
                startActivityForResult(ccBack, 1);
            }
        });
        rollAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rand1 = new Random();
                Random rand2 = new Random();
                Random rand3 = new Random();
                Random rand4 = new Random();
                Random rand5 = new Random();
                Random rand6 = new Random();
                int str = rand1.nextInt(20) + 1;
                int dex = rand2.nextInt(20) + 1;
                int con = rand3.nextInt(20)+1;
                int intel = rand4.nextInt(20) + 1;
                int wis = rand5.nextInt(20) + 1;
                int cha = rand6.nextInt(20) + 1;
                EditText editText = (EditText)findViewById(R.id.strNum);
                editText.setText(Integer.toString(str), TextView.BufferType.EDITABLE);
                EditText editText1 = (EditText)findViewById(R.id.dexNum);
                editText1.setText(Integer.toString(dex), TextView.BufferType.EDITABLE);
                EditText editText2 = (EditText)findViewById(R.id.conNum);
                editText2.setText(Integer.toString(con), TextView.BufferType.EDITABLE);
                EditText editText3 = (EditText)findViewById(R.id.intNum);
                editText3.setText(Integer.toString(intel), TextView.BufferType.EDITABLE);
                EditText editText4 = (EditText)findViewById(R.id.wisNum);
                editText4.setText(Integer.toString(wis), TextView.BufferType.EDITABLE);
                EditText editText5 = (EditText)findViewById(R.id.charNum);
                editText5.setText(Integer.toString(cha), TextView.BufferType.EDITABLE);
            }
        });
    }
}

package com.example.deangelorieke.dnd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class statallocation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statallocation);

        Button back = findViewById(R.id.statsBackButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ccBack = new Intent(statallocation.this, CharacterCreation.class);
                startActivityForResult(ccBack, 1);
            }
        });
    }
}

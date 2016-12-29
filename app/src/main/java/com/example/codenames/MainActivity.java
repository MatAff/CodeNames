package com.example.codenames;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import fieldgenerator.FieldGenerator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Context c;

        c = this;

        // Initialize UI elements
        final GridView gridview = (GridView) findViewById(R.id.gridView);
        final Button newFieldbutton = (Button) findViewById(R.id.newFieldButton);

        // Link UI element to actions in code
        newFieldbutton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Declare variables
                int[] field;
                Integer[] mThumbIds;

                // Generate field
                FieldGenerator FG = new FieldGenerator();
                FG.generate();
                field = FG.getField();

                mThumbIds = new Integer[25];
                for(int i =0; i < 25; i++) {
                    if (field[i]==1) mThumbIds[i] = R.drawable.blue;
                    if (field[i]==-1) mThumbIds[i] = R.drawable.red;
                    if (field[i]==0) mThumbIds[i] = R.drawable.grey_light;
                    if (field[i]==9) mThumbIds[i] = R.drawable.grey_dark;
                }

                /*Integer[] mThumbIds = {
                        R.drawable.blue, R.drawable.red, R.drawable.grey_light, R.drawable.grey_dark
                };*/

                gridview.setAdapter(new ImageAdapter(c, mThumbIds));


            }

        });

    }

}

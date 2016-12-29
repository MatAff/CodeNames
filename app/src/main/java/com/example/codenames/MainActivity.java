package com.example.codenames;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import fieldgenerator.FieldGenerator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Context c;

        // Field related variables

        //final Integer[] mThumbIds;

        c = this;

        // Initialize UI elements
        final ImageView startColorView = (ImageView) findViewById(R.id.startColor);
        final GridView gridview = (GridView) findViewById(R.id.gridView);
        final Button newFieldbutton = (Button) findViewById(R.id.newFieldButton);
        final Button showButton = (Button) findViewById(R.id.showButton);

        // Link UI element to actions in code
        showButton.setOnTouchListener(new Button.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    //gridview.setAdapter(new ImageAdapter(c, mThumbIds));
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    //gridview.setAdapter(null);
                }
                return false;
            }

        });


        newFieldbutton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Declare variables
                int[] field;
                String startColor;
                int plusColor;
                int minusColor;
                Integer[] mThumbIds;

                // Generate field
                FieldGenerator FG = new FieldGenerator();
                FG.generate();
                field = FG.getField();
                startColor = FG.getStartColor();

                // Set colors
                if (startColor == "blue") {
                    plusColor = R.drawable.blue;
                    minusColor = R.drawable.red;
                } else {
                    minusColor = R.drawable.blue;
                    plusColor = R.drawable.red;
                }

                mThumbIds = new Integer[25];
                for(int i =0; i < 25; i++) {
                    if (field[i]==1) mThumbIds[i] = plusColor;
                    if (field[i]==-1) mThumbIds[i] = minusColor;
                    if (field[i]==0) mThumbIds[i] = R.drawable.grey_light;
                    if (field[i]==9) mThumbIds[i] = R.drawable.black;
                }

                /*Integer[] mThumbIds = {
                        R.drawable.blue, R.drawable.red, R.drawable.grey_light, R.drawable.grey_dark
                };*/

                if (startColor=="blue")
                    startColorView.setImageResource(R.drawable.blue);
                else
                    startColorView.setImageResource(R.drawable.red);

                // Show grid
                gridview.setAdapter(new ImageAdapter(c, mThumbIds));


            }

        });

    }

}

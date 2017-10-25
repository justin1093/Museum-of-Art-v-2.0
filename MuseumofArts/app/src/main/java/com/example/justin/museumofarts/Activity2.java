package com.example.justin.museumofarts;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static com.example.justin.museumofarts.R.layout.activity_guide;


public class Activity2 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museum_details);


        FloatingActionButton btn = (FloatingActionButton) findViewById(R.id.GuideButton);
        btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
//                setContentView(activity_guide);
                Intent intent = new Intent(Activity2.this, Activity3.class);
                startActivity(intent);
            }
        });


    }


}





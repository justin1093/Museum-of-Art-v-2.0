package com.example.justin.museumofarts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Justin on 10/24/2017.
 */

public class Activity3 extends AppCompatActivity {
@Override
protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        // content start
        ImageView museum;
        museum=(ImageView)findViewById(R.id.image1);
        museum.setOnClickListener(new View.OnClickListener(){

public void onClick(View v){
        // setContentView(activity_museum);
        Intent i=new Intent(Activity3.this, Activity4.class);
        startActivity(i);
        }
        });
        }
        }





//public class Activity3 extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_guide);
//    }
//
//
//
//    public void b(View v) {
//        Intent intent = new Intent(Activity3.this, Activity4.class);
//        startActivity(intent);
//
//    }
//}
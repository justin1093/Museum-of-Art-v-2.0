package com.example.justin.museumofarts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museum_list);


    }
    public void b(View v){
        Intent intent=new Intent(Activity1.this,Activity2.class);
        startActivity(intent);

    }
}

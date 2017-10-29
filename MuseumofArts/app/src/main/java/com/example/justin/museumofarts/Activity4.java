package com.example.justin.museumofarts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/****************************************
 * Created by Justin on 10/24/2017.
 * **************************************
 */

public class Activity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explain);
    }


    public void b(View v) {
        Intent intent = new Intent(Activity4.this, Activity5.class);
        startActivity(intent);

    }
}
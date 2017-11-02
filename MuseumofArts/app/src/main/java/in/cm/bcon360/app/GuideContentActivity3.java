package in.cm.bcon360.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.justin.museumofarts.R;

/**
 * Created by Justin on 10/24/2017.
 */

public class GuideContentActivity3 extends AppCompatActivity {
@Override
protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        //  Initializing the bottomNavigationView
        BottomNavigationView bottomNavigationView;
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.navigation);


        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                                switch (item.getItemId()) {
                                        case R.id.navigation_home:
                                                Intent i = new Intent(GuideContentActivity3.this, MainActivity.class);
                                                startActivity(i);
                                                break;
                                }
                                return false;
                        }
                });

        // content start
        ImageView museum;
        museum=(ImageView)findViewById(R.id.image1);
        museum.setOnClickListener(new View.OnClickListener(){

public void onClick(View v){
        // setContentView(activity_museum);
        Intent i=new Intent(GuideContentActivity3.this, GuideContentExplainActivity4.class);
        startActivity(i);
        }
        });
        }
        }





//public class GuideContentActivity3 extends AppCompatActivity {
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
//        Intent intent = new Intent(GuideContentActivity3.this, GuideContentExplainActivity4.class);
//        startActivity(intent);
//
//    }
//}
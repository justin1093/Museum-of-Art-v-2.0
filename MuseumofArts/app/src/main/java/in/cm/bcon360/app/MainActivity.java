package in.cm.bcon360.app;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.justin.museumofarts.R;



public class MainActivity extends AppCompatActivity {



//    private TextView mTextMessage;
//
//   private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
//            = new BottomNavigationView.OnNavigationItemSelectedListener() {
//
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            switch (item.getItemId()) {
//                case R.id.navigation_home:
//                    mTextMessage.setText(R.string.title_home);
//                    return true;
//                case R.id.naviation_search:
//                    mTextMessage.setText(R.string.title_search);
//                    return true;
//                case R.id.navigation_offer:
//                    mTextMessage.setText(R.string.title_offer);
//                    return true;
//                case R.id.navigation_around:
//                    mTextMessage.setText(R.string.title_around);
//                    return true;
//            }
//            return false;
//        }
//
//    };



/////////////////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museum_main);

        //  Initializing the bottomNavigationView
        BottomNavigationView bottomNavigationView;
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.navigation);


        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.navigation_home:

                                break;
                            case R.id.naviation_search:
                                Intent i = new Intent(MainActivity.this, GMapActivity5.class);
                                startActivity(i);
                                break;
                            case R.id.navigation_offer:

                                break;
                        }
                        return false;
                    }
                });


        // OnMuseumClick
        ImageView museum;
        museum = (ImageView) findViewById(R.id.imageMuseum);
        museum.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // setContentView(activity_museum);
                Intent i = new Intent(MainActivity.this, MuseumListActivity1.class);
                startActivity(i);
            }
        });


        //OnClickLocation
        ImageView location;
        location = (ImageView) findViewById(R.id.imageLocation);
        location.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // setContentView(activity_museum);
                Intent i = new Intent(MainActivity.this, GMapActivity5.class);
                startActivity(i);
            }
        });


        //OnClickMore
        ImageView more;
        more = (ImageView) findViewById(R.id.imageMore);
        more.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //setContentView(activity_more);
                Intent i = new Intent(MainActivity.this, MoreListActivity6.class);
                startActivity(i);

            }});



}

}






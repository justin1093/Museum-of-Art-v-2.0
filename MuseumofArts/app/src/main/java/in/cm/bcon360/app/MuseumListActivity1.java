package in.cm.bcon360.app;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.justin.museumofarts.R;

public class MuseumListActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museum_list);

        //  Initializing the bottomNavigationView
        BottomNavigationView bottomNavigationView;
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.navigation);


        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.navigation_home:
                                Intent i = new Intent(MuseumListActivity1.this, MainActivity.class);
                                startActivity(i);
                                break;
                        }
                        return false;
                    }
                });


    }
    public void b(View v){
        Intent intent=new Intent(MuseumListActivity1.this,MuseumDetailsActivity2.class);
        startActivity(intent);

    }
}

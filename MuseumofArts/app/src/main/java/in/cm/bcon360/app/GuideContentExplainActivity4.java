package in.cm.bcon360.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.justin.museumofarts.R;

/****************************************
 * Created by Justin on 10/24/2017.
 * **************************************
 */

public class GuideContentExplainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explain);
    }


    public void b(View v) {
        Intent intent = new Intent(GuideContentExplainActivity4.this, GMapActivity5.class);
        startActivity(intent);

    }
}
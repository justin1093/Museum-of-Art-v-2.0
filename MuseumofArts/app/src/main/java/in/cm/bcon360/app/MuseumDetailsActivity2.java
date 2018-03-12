package in.cm.bcon360.app;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import com.example.justin.museumofarts.R;
import in.cm.bcon360.app.actions.BeaconActionsLogsStore;
import in.cm.bcon360.app.config.BeaconControlConfiguration;
import in.cm.bcon360.app.s2s.http.BeaconControlManager;
import in.cm.bcon360.app.s2s.http.HttpListener;
import in.cm.bcon360.app.s2s.http.mediator.GetApplicationsMediator;
import in.cm.bcon360.app.s2s.http.mediator.LoginCallMediator;
import in.cm.bcon360.app.s2s.http.model.ErrorCode;
import in.cm.bcon360.app.s2s.http.response.BeaconControlApplication;
import in.cm.bcon360.app.s2s.http.response.GetApplicationsResponse;
import in.cm.bcon360.app.s2s.http.response.TokenResponse;
import in.cm.bcon360.sdk.*;
import java.util.*;



public class MuseumDetailsActivity2 extends AppCompatActivity {

    private static final String TAG = "MainContentActivity";
    private static final String MAIN_ERROR_DIALOG_TAG = "MainContentActivity Error";

    private static final String CREATE_ACCOUNT_DIALOG_TAG = "CREATE_ACCOUNT_DIALOG_TAG";
    private static final String LOGIN_ERROR_DIALOG_TAG = "LOGIN_ERROR_DIALOG_TAG";
    private static final int VIEWPAGER_OFFSCREEN_PAGE_LIMIT = 2;
    private static final String LOCATION_REQUIREMENT_EXPLANATION_DIALOG_TAG = "LOCATION_REQUIREMENT_EXPLANATION_DIALOG_TAG";
    private static final int PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION = 1;

    private BeaconControlManager beaconControlManager;
    private LoginCallMediator loginCallMediator;
    private GetApplicationsMediator getApplicationsMediator;
    private BeaconControlConfiguration beaconControlConfiguration;

    private boolean locationAccessPermissionDenied = false;

    private BeaconActionsLogsStore logsStore;
    //private BeaconsFragment beaconsFragment;
    private BeaconControl beaconControl;
    //Expansion
    TextView descText1, descText2, descText3, descText4, descText5, descText6, descText7, down1, down2, down3, down4, down5, down6, down7;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.justin.museumofarts.R.layout.activity_museum_details);

        descText1 = (TextView) findViewById(R.id.textView6);
        descText2 = (TextView) findViewById(R.id.textView9);
        descText3 = (TextView) findViewById(R.id.textView13);
        descText4 = (TextView) findViewById(R.id.textView23);
        descText5 = (TextView) findViewById(R.id.textView25);
        descText6 = (TextView) findViewById(R.id.textView27);
        descText7 = (TextView) findViewById(R.id.textView29);
        down1 = (TextView) findViewById(R.id.eda);
        down2 = (TextView) findViewById(R.id.textView8);
        down3 = (TextView) findViewById(R.id.textView12);
        down4 = (TextView) findViewById(R.id.textView22);
        down5 = (TextView) findViewById(R.id.textView24);
        down6 = (TextView) findViewById(R.id.textView26);
        down7 = (TextView) findViewById(R.id.textView28);



        down1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                descText1.setMaxLines(Integer.MAX_VALUE);
            }
        });

        down2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                descText2.setMaxLines(Integer.MAX_VALUE);
            }
        });

        down3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                descText3.setMaxLines(Integer.MAX_VALUE);
            }
        });

        down4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                descText4.setMaxLines(Integer.MAX_VALUE);
            }
        });

        down5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                descText5.setMaxLines(Integer.MAX_VALUE);
            }
        });

        down6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                descText6.setMaxLines(Integer.MAX_VALUE);
            }
        });

        down7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                descText7.setMaxLines(Integer.MAX_VALUE);
            }
        });






        //  Initializing the bottomNavigationView
        BottomNavigationView bottomNavigationView;
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);


        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.navigation_home:
                                Intent i = new Intent(MuseumDetailsActivity2.this, MainActivity.class);
                                startActivity(i);
                                break;
                            case R.id.naviation_search:
                                //
                                break;
                            case R.id.navigation_offer:

                                break;
                        }
                        return false;
                    }
                });


        FloatingActionButton btn = (FloatingActionButton) findViewById(R.id.GuideButton);
        btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
//                setContentView(activity_guide);

                    Log.d(TAG, "Hello Login BeaconControl");

//12.08.2018                logIn();
                startBeaconControl();

                Toast.makeText(MuseumDetailsActivity2.this, "Scanning. . .", Toast.LENGTH_SHORT).show();


//Navigate to museum items offline mode

                 Intent intent = new Intent(MuseumDetailsActivity2.this, GuideContentActivity3.class);
                 startActivity(intent);


            }
        });


    }

//    void logIn() {
//
//        String email = "connectedmach@gmail.com";
//        String password = "connmach123";
//        beaconControlConfiguration = new BeaconControlConfiguration(MuseumDetailsActivity2.this);
//
//        Toast.makeText(this, "Connecting with id and pwd", Toast.LENGTH_SHORT).show();
//
//
//        beaconControlManager = new BeaconControlManager(email, password);
//        loginCallMediator = new LoginCallMediator(MuseumDetailsActivity2.this, beaconControlManager, new HttpListener<TokenResponse>() {
//            @Override
//            public void onStart() {
//                //showBusy();
//            }
//
//            @Override
//            public void onSuccess(TokenResponse response) {
//                if (response == null || response.accessToken == null || response.tokenType == null) {
//                    // showIdle();
//                    // showLoginErrorDialog();
//                    Log.e(TAG, "corrupted token returned by oauth endpoint.");
//                } else {
//                    beaconControlManager.setToken(response);
//                    getClientInfoFromTestApplication();
//                }
//            }
//
//            @Override
//            public void onError(ErrorCode errorCode) {
//                // showIdle();
//                // showLoginErrorDialog();
//                Log.e(TAG, "error occurred during login: " + errorCode);
//            }
//
//            @Override
//            public void onEnd() {
//                // ignore
//            }
//        });
//        loginCallMediator.logIn();
//    }
//
//    private void getClientInfoFromTestApplication() {
//        getApplicationsMediator = new GetApplicationsMediator(this, beaconControlManager, new HttpListener<GetApplicationsResponse>() {
//
//            @Override
//            public void onStart() {
//                // ignore
//            }
//
//            @Override
//            public void onSuccess(GetApplicationsResponse response) {
//                for (BeaconControlApplication application : response.applications) {
//                    if (application.test) {
//                        beaconControlConfiguration.setClientId(application.uid);
//                        beaconControlConfiguration.setClientSecret(application.secret);
//                        break;
//                    }
//                }
//
//                Log.d(TAG, "startBeaconControl");
//
//
//                //         beaconControlConfiguration = new BeaconControlConfiguration( MainScreen_Activity.this);
//                if (isLocationPermissionGranted()) {
//                    startBeaconControl();
//                }
//                //startActivity(MainActivity.getIntent(MainScreen_Activity.this));
//            }
//
//            @Override
//            public void onError(ErrorCode errorCode) {
//                //  showLoginErrorDialog();
//                Log.e(TAG, "error occurred during getApplications request: " + errorCode);
//            }
//
//            @Override
//            public void onEnd() {
//                //showIdle();
//            }
//        });
//        getApplicationsMediator.getApplications();
//    }
//
//
//    /*private void showLoginErrorDialog() {
//        DialogFragment dialogFragment = LoginErrorDialogFragment.newInstance();
//        dialogFragment.show(getSupportFragmentManager(), LOGIN_ERROR_DIALOG_TAG);
//    }
//*/
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//
//        if (loginCallMediator != null) {
//            loginCallMediator.cancel();
//        }
//        if (getApplicationsMediator != null) {
//            getApplicationsMediator.cancel();
//        }
//    }
//    private void startBeaconControl() {
//        Log.d(TAG, "startBeaconControl");
//        //  beaconControlConfiguration = new BeaconControlConfiguration(this);
//        beaconControl = BeaconControl.getInstance(
//                this,
//                beaconControlConfiguration.getClientId(),
//                beaconControlConfiguration.getClientSecret(),
//                beaconControlConfiguration.getUserId()
//        );
//
//        //.configurations;
//       /// Log.d(TAG, "beaconservicehelper configurations "+ beaconControl.beaconServiceHelper.configurations);
//        beaconControl.enableLogging(true);
//        beaconControl.setBeaconDelegate(new BeaconDelegate() {
//            @Override
//            public boolean shouldPerformActionAutomatically() {
//                return true;
//            }
//
//            @Override
//            public void onActionStart(Action action) {
//                Log.d(TAG, "onActionStart");
//                //     logsStore.logActionStart(action);
//            }
//
//            @Override
//            public void onActionEnd(Action action) {
//                Log.d(TAG, "onActionEnd");
//            }
//
//            @Override
//            public void onBeaconsConfigurationLoaded(List<Beacon> list) {
//                Log.d(TAG, "onActionEnd");
//            }
//
//            @Override
//            public void onBeaconProximityChanged(Beacon beacon) {
//                Log.d(TAG, "beacon change" + beacon);
//            }
//        });
//        beaconControl.setBeaconErrorListener(new BeaconErrorListener() {
//            @Override
//            public void onError(in.cm.bcon360.sdk.ErrorCode errorCode) {
//                Log.e(TAG, "onError " + errorCode);
//                // logsStore.logError(errorCode);
//            }
//        });
//        beaconControl.startScan();
//    }
//
///*
//    @Override
//    public void logout() {
//        Log.d(TAG, "Logging out");
//        beaconControl.stopScan();
//        beaconControlConfiguration.clear();
//        logsStore.clear();
//        // startActivity(StartupActivity.getIntent(this));
//        finish();
//    }
//
//*/
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
//        switch (requestCode) {
//            case PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION: {
//                if (grantResults.length == 0 || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
//                    locationAccessPermissionDenied = true;
//                } else {
//                    startBeaconControl();
//                }
//            }
//        }
//    }
//
//    private void requestLocationPermissionIfNotGranted() {
//        if (!isLocationPermissionGranted()) {
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION);
//        }
//    }
//
//    private boolean isLocationPermissionGranted() {
//        return ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED;
//    }
//
///*    private void showLocationPermissionRequiredDialog() {
//        DialogFragment dialogFragment = LocationPermissionExplainingDialogFragment.newInstance();
//        dialogFragment.show(getSupportFragmentManager(), LOCATION_REQUIREMENT_EXPLANATION_DIALOG_TAG);
//    }*/
//
//}


    void logIn() {
        String email = "connectedmach@gmail.com";
        String password = "connmach123";
        beaconControlConfiguration = new BeaconControlConfiguration(MuseumDetailsActivity2.this);



        beaconControlManager = new BeaconControlManager(email, password);
        loginCallMediator = new LoginCallMediator(MuseumDetailsActivity2.this, beaconControlManager, new HttpListener<TokenResponse>() {
            @Override
            public void onStart() {
                //showBusy();
            }

            @Override
            public void onSuccess(TokenResponse response) {
                if (response == null || response.accessToken == null || response.tokenType == null) {
                    // showIdle();
                    // showLoginErrorDialog();
                    Log.e(TAG, "corrupted token returned by oauth endpoint.");
                } else {
                    beaconControlManager.setToken(response);
                    getClientInfoFromTestApplication();
                }
            }

            @Override
            public void onError(ErrorCode errorCode) {
                // showIdle();
                // showLoginErrorDialog();
                Log.e(TAG, "error occurred during login: " + errorCode);
            }

            @Override
            public void onEnd() {
                // ignore
            }
        });
        loginCallMediator.logIn();
    }

    private void getClientInfoFromTestApplication() {
        getApplicationsMediator = new GetApplicationsMediator(this, beaconControlManager, new HttpListener<GetApplicationsResponse>() {

            @Override
            public void onStart() {
                // ignore
            }

            @Override
            public void onSuccess(GetApplicationsResponse response) {
                for (BeaconControlApplication application : response.applications) {
                    if (application.test) {
                        beaconControlConfiguration.setClientId(application.uid);
                        beaconControlConfiguration.setClientSecret(application.secret);
                        break;
                    }
                }

                Log.d(TAG, "startBeaconControl");


                //         beaconControlConfiguration = new BeaconControlConfiguration( MainScreen_Activity.this);
                if (isLocationPermissionGranted()) {
                    startBeaconControl();
                }
                //startActivity(MainActivity.getIntent(MainScreen_Activity.this));
            }

            @Override
            public void onError(ErrorCode errorCode) {
                //  showLoginErrorDialog();
                Log.e(TAG, "error occurred during getApplications request: " + errorCode);
            }

            @Override
            public void onEnd() {
                //showIdle();
            }
        });
        getApplicationsMediator.getApplications();
    }


//    private void showLoginErrorDialog() {
//        DialogFragment dialogFragment = LoginErrorDialogFragment.newInstance();
//        dialogFragment.show(getSupportFragmentManager(), LOGIN_ERROR_DIALOG_TAG);
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (loginCallMediator != null) {
            loginCallMediator.cancel();
        }
        if (getApplicationsMediator != null) {
            getApplicationsMediator.cancel();
        }
    }
    private void startBeaconControl() {
        Log.d(TAG, "startBeaconControl");
        //  beaconControlConfiguration = new BeaconControlConfiguration(this);
/*12.08.2018
            beaconControl = BeaconControl.getInstance(
                this,
                beaconControlConfiguration.getClientId(),
                beaconControlConfiguration.getClientSecret(),
                beaconControlConfiguration.getUserId()
        );
*/



// added in 12.08.2018

        beaconControl = BeaconControl.getInstance(

                this,
                "test",
                "test",
                "teste"
        );





        //.configurations;
       // Log.d(TAG, "beaconservicehelper configurations "+ beaconControl.beaconServiceHelper.configurations);
        beaconControl.enableLogging(true);
        beaconControl.setBeaconDelegate(new BeaconDelegate() {
            @Override
            public boolean shouldPerformActionAutomatically() {
                return true;
            }

            @Override
            public void onActionStart(Action action) {
                Log.d(TAG, "onActionStart");
                //     logsStore.logActionStart(action);
            }

            @Override
            public void onActionEnd(Action action) {
                Log.d(TAG, "onActionEnd");
            }

            @Override
            public void onBeaconsConfigurationLoaded(List<Beacon> list) {
                Log.d(TAG, "onActionEnd");
            }

            @Override
            public void onBeaconProximityChanged(Beacon beacon) {
                Log.d(TAG, "beacon change" + beacon);
            }
        });
        beaconControl.setBeaconErrorListener(new BeaconErrorListener() {
            @Override
            public void onError(in.cm.bcon360.sdk.ErrorCode errorCode) {
                Log.e(TAG, "onError " + errorCode);
                // logsStore.logError(errorCode);
            }
        });
        beaconControl.startScan();
    }

//
//    @Override
//    public void logout() {
//        Log.d(TAG, "Logging out");
//        beaconControl.stopScan();
//        beaconControlConfiguration.clear();
//        logsStore.clear();
//        // startActivity(StartupActivity.getIntent(this));
//        finish();
//    }
    @Override
    protected void onResume() {
        super.onResume();
        if (locationAccessPermissionDenied) {
            //the user could have granted the permission from the application settings
            if (!isLocationPermissionGranted()) {
//                showLocationPermissionRequiredDialog();
            }
        } else {
            requestLocationPermissionIfNotGranted();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION: {
                if (grantResults.length == 0 || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    locationAccessPermissionDenied = true;
                } else {
                    startBeaconControl();
                }
            }
        }
    }

    private void requestLocationPermissionIfNotGranted() {
        if (!isLocationPermissionGranted()) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION);
        }
    }

    private boolean isLocationPermissionGranted() {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED;
    }

//    private void showLocationPermissionRequiredDialog() {
//        DialogFragment dialogFragment = LocationPermissionExplainingDialogFragment.newInstance();
//        dialogFragment.show(getSupportFragmentManager(), LOCATION_REQUIREMENT_EXPLANATION_DIALOG_TAG);
//    }

}












package com.example.admin.week5test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG ="MainActivityTAG" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a();
    }

    public void a() {


       // Log.d(TAG, "a: ");
        //final retrofit2.Call<List<com.example.admin.week5test.model.Response>> callRepos = RetrofitHelper.createCallWeather();
        final retrofit2.Call<List<com.example.admin.week5test.model.Response>> callRepos =
      RetrofitHelper.createCallWeather();
      //  final retrofit2.Call<Response> callRepos = RetrofitHelper.createCallWeather("atlanta",WEATHER_KEY);
      //  Log.d(TAG, "a: "+ callRepos.toString());
        // Log.d(TAG, "a2: " + callRepos.toString());
        //create a thread to make the rest call on a separate thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "runnable start: ");

                try {
                    Log.d(TAG, "runnable try: ");
                    final List<com.example.admin.week5test.model.Response> repoName =  callRepos.execute().body();
                   // final Response repoName = callRepos.execute().body();
                   // java.util.List<List> weatherData = repoName.getList();
              //      final List<com.example.admin.week5test.model.Response> repoName =  callRepos.execute().body();
               //     Log.d(TAG, "size: "+repoName.size());
                //    Log.d(TAG, "runnableShow: "+ repoName.get(1).getTitle());
/*
                    Log.d(TAG, "run: "+ ink().toString());
                    for (int i = 0; i < 5; i++) {
                        Log.d(TAG, "run: TEST");
                        Log.d(TAG, "run: "+ repoName.getLink().toString());
                    //    Log.d(TAG, "runnableShow: "+ repoName.getLink().toString());
                }

                */
/*
                    AmazonFragment amazoneFragment  = AmazonFragment.newInstance(repoName);
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.flFragHolderCarOptions, amazoneFragment, CAR_OPTIONS_FRAGMENT_TAG)
                            .addToBackStack(CAR_OPTIONS_FRAGMENT_TAG)

                            .commit();

*/

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();


    }
    /*
    public void b(){
        // Log.d(TAG, "a: ");
        final retrofit2.Call<List<com.example.admin.week5test.model.Response> >callRepos = RetrofitHelper.createCallWeather();
        //  final retrofit2.Call<Response> callRepos = RetrofitHelper.createCallWeather("atlanta",WEATHER_KEY);

        // Log.d(TAG, "a2: " + callRepos.toString());
        //create a thread to make the rest call on a separate thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "runnable start: ");

                try {
                    Log.d(TAG, "runnable try: ");
                    // final Response repoName = callRepos.execute().body();
                    final List<com.example.admin.week5test.model.Response> repoName = (List<com.example.admin.week5test.model.Response>)callRepos.execute().body();
                    //     Log.d(TAG, "size: "+repoName.size());
                    //    Log.d(TAG, "runnableShow: "+ repoName.get(1).getTitle());

                    for (int i = 0; i < 5; i++) {
                        Log.d(TAG, "run: TEST");
                        Log.d(TAG, "runnableShow: "+ repoName.get(i).getTitle());
                    }

                    AmazonFragment amazoneFragment  = AmazonFragment.newInstance(repoName);
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.flFragHolderCarOptions, amazoneFragment, CAR_OPTIONS_FRAGMENT_TAG)
                            .addToBackStack(CAR_OPTIONS_FRAGMENT_TAG)

                            .commit();



                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();


    }
*/
}

package com.rohitksingh.woof;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment fragment = DogListFragment.getInstance();
        Log.d("IMAGELIST", "Acticity");
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragmentHolder, fragment, "DOGLIST")
                .commit();
    }
}
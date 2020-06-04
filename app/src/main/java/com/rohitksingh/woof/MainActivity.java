package com.rohitksingh.woof;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements ItemClickCallBack, BackButtonCallback{

    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currentFragment = DogListFragment.getInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragmentHolder, currentFragment, "DOGLIST")
                .addToBackStack("DOGLIST")
                .commit();
    }

    @Override
    public void onItemClicked(Object object) {
        DogModel dogModel = (DogModel)object;
        currentFragment = DogDetailFragment.getInstance(dogModel);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentHolder, currentFragment)
                .commit();
    }

    @Override
    public void backButtonClicked() {
        currentFragment = getSupportFragmentManager().findFragmentByTag("DOGLIST");
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentHolder, currentFragment, "DOGLIST")
                .commit();
    }
}
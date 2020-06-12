package com.rohitksingh.woof;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.rohitksingh.woof.callbacks.BackButtonCallback;
import com.rohitksingh.woof.callbacks.ItemClickCallBack;
import com.rohitksingh.woof.fragments.DogDetailFragment;
import com.rohitksingh.woof.fragments.DogListFragment;

/**
 *   //This contains following key points to learn
 *   1) Fragment communication via interface
 *   2) Reusing fragment by getSupportFragmentManager().findFragmentByTag(TAG)
 *   3) Whicb lifecycle method should have API call so that it is called just once
 *   4) How to save RecylcerView instance in Fragment -> Scroll position is saved by default, you are responsible for content
 *   5) Pagination in RecyclerView
 */
public class MainActivity extends AppCompatActivity implements ItemClickCallBack, BackButtonCallback {

    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
              This null check condition make sure that the fragment instance is not created
              and added again. Because Activity itself recreates instance of fragment and all
              views when the screen is rotated by default.
         */
        if(savedInstanceState==null){
            currentFragment = DogListFragment.getInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentHolder, currentFragment, "DOGLIST")
                    .commit();
        }

    }

    @Override
    public void onItemClicked(Object object) {
        DogModel dogModel = (DogModel)object;
        currentFragment = DogDetailFragment.getInstance(dogModel);
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.slide_in_bottom, R.anim.slide_out_top, R.anim.slide_in_top, R.anim.slide_out_bottom)
                .replace(R.id.fragmentHolder, currentFragment, "DOGDETAIL")
                .addToBackStack("DOGDETAIL")
                .commit();
    }

    @Override
    public void backButtonClicked() {
        getSupportFragmentManager().popBackStack();
    }

}
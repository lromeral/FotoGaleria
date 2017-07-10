package com.foromtb.luroga.fotogaleria;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;


/**
 * Created by LuisR on 10/07/2017.
 */

public abstract class SingleFragmentLoader extends AppCompatActivity {
    protected abstract Fragment createFragment();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_fragment_loader);
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fg = fragmentManager.findFragmentById(R.id.fragment_container);
        if (fg == null){
            fg = createFragment();
            fragmentManager.beginTransaction().add(R.id.fragment_container,fg).commit();
        }

    }
}

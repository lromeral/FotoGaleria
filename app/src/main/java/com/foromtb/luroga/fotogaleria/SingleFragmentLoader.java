package com.foromtb.luroga.fotogaleria;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;


/**
 * Created by LuisR on 10/07/2017.
 */

public abstract class SingleFragmentLoader extends Fragment {
    protected abstract Fragment createFragment();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager fragmentManager = getFragmentManager();
        Fragment fg = createFragment();
        if (fg == null){
            fragmentManager.beginTransaction().add(R.id.fragment_container,fg).commit();
        }

    }
}

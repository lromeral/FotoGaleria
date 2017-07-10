package com.foromtb.luroga.fotogaleria;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FotoGaleriaActivity extends SingleFragmentLoader {


    @Override
    protected Fragment createFragment() {
        return new FotoGaleriaFragment();
    }
}

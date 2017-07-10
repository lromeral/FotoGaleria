package com.foromtb.luroga.fotogaleria;

import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;

/**
 * Created by LuisR on 10/07/2017.
 */

public class FotoGaleriaFragment extends Fragment {

    private RecyclerView mRecyclerView;


    public static FotoGaleriaFragment newInstance() {
        
        Bundle args = new Bundle();
        
        FotoGaleriaFragment fragment = new FotoGaleriaFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.foto_galeria_fragment,container,false);
        mRecyclerView = (RecyclerView)v.findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));

        new FetchItemTask().execute();

        return v;
    }

    private class FetchItemTask extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... params) {
           /* try{
                String result = new FlickrFetchr().getUrlString("https://www.foromtb.com");
                Log.d("Resultado",result);
            }catch (IOException e){
                Log.d("Error", e.toString());
            }
            */
           new FlickrFetchr().fetchItems();
            return null;

        }
    }
}

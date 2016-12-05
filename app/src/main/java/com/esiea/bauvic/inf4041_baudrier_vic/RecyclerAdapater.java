package com.esiea.bauvic.inf4041_baudrier_vic;

import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Dearth on 05/12/2016.
 */

public class RecyclerAdapater extends RecyclerView.Adapter<RecyclerAdapater.PhotoHolder> {

    private ArrayList<Photo> photos;

    @Override
    public RecyclerView. onCreateViewHolder(ViewGroup parent, int viewType) {
        //return null;
    }


    public RecyclerAdapater(ArrayList<Photo> photos)
    {
        this.photos = photos;
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }
}

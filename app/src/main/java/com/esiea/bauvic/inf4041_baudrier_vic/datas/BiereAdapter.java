package com.esiea.bauvic.inf4041_baudrier_vic.datas;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.esiea.bauvic.inf4041_baudrier_vic.R;

import java.util.List;

/**
 * Created by Dearth on 29/12/2016.
 */

public class BiereAdapter extends RecyclerView.Adapter<BiereAdapter.BiereViewHolder>{

    private List<Biere> biereList;

    public BiereAdapter(List<Biere> biereList) {
        this.biereList = biereList;
    }


    @Override
    public int getItemCount() {
        return biereList.size();
    }

    @Override
    public void onBindViewHolder(BiereViewHolder biereViewHolder, int i) {
        Biere b = biereList.get(i);
        biereViewHolder.name.setText(b.getName());
        biereViewHolder.category.setText(b.getCategory());
        biereViewHolder.country.setText(b.getCountry());
        biereViewHolder.dateCreation.setText(b.getDateCreation());
        biereViewHolder.description.setText(b.getDescription());
        //biereViewHolder.note.setText( b.getNote());
        //biereViewHolder.photoPath.setText(b.getPhotoPath());
    }

    @Override
    public BiereViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.card_layout, viewGroup, false);

        return new BiereViewHolder(itemView);
    }

    public static class BiereViewHolder extends RecyclerView.ViewHolder {

        protected TextView category;
        protected TextView country;
        protected TextView dateCreation;
        protected TextView description;
        protected TextView name;
        protected TextView note;
        protected TextView photoPath;

        public BiereViewHolder(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.name);
            category =  (TextView) v.findViewById(R.id.category);
            country = (TextView)  v.findViewById(R.id.country);
            dateCreation = (TextView)  v.findViewById(R.id.date);
            description = (TextView) v.findViewById(R.id.description);
            note = (TextView) v.findViewById(R.id.note);
            photoPath = (TextView) v.findViewById(R.id.photo);
        }
    }
}

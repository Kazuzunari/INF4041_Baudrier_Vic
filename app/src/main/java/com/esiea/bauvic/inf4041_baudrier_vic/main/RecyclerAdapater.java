package com.esiea.bauvic.inf4041_baudrier_vic.main;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.esiea.bauvic.inf4041_baudrier_vic.R;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;


/**
 * Created by Dearth on 05/12/2016.
 */

public class RecyclerAdapater extends RecyclerView.Adapter<RecyclerAdapater.PhotoHolder> {

    private ArrayList<Photo> mPhotos;

    @Override
    public PhotoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item_row, parent, false);
        return new PhotoHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(PhotoHolder holder, int position) {
        Photo itemPhoto = mPhotos.get(position);
        holder.bindPhoto(itemPhoto);
    }

    public RecyclerAdapater(ArrayList<Photo> photos)
    {
        this.mPhotos = photos;
    }

    @Override
    public int getItemCount() {
        return mPhotos.size();
    }


    public static class PhotoHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView mItemImage;
        private TextView mItemDate;
        private TextView mItemDescription;
        private Photo mPhoto;

        //3
        private static final String PHOTO_KEY = "PHOTO";

        //4
        public PhotoHolder(View v) {
            super(v);

            mItemImage = (ImageView) v.findViewById(R.id.item_image);
            mItemDate = (TextView) v.findViewById(R.id.item_date);
            mItemDescription = (TextView) v.findViewById(R.id.item_description);
            v.setOnClickListener(this);
        }

        //5
        @Override
        public void onClick(View v) {
            Context context = itemView.getContext();
            Intent showPhotoIntent = new Intent(context, PhotoActivity.class);
            showPhotoIntent.putExtra(PHOTO_KEY, mPhoto);
            context.startActivity(showPhotoIntent);
        }

        public void bindPhoto(Photo photo) {
            mPhoto = photo;
            Picasso.with(mItemImage.getContext()).load(photo.getUrl()).into(mItemImage);
            mItemDate.setText(photo.getHumanDate());
            mItemDescription.setText(photo.getExplanation());
        }
    }
}


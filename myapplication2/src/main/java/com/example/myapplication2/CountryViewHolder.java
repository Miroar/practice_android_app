package com.example.myapplication2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CountryViewHolder extends   RecyclerView.ViewHolder{

    ImageView flagView;
    TextView countryNameView;
    TextView descriptionView;

    public CountryViewHolder(@NonNull View itemView) {
        super(itemView);

        this.flagView = (ImageView) itemView.findViewById(R.id.imageView_flag);
        this.countryNameView = (TextView) itemView.findViewById(R.id.textView_countryName);
        this.descriptionView = (TextView) itemView.findViewById(R.id.textView_description);

    }

}

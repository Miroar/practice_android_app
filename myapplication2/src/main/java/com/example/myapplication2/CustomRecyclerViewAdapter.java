package com.example.myapplication2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CountryViewHolder> {


    private List<Country> countries;
    private Context context;
    private LayoutInflater mLayoutInflater;
    private String description;



    public CustomRecyclerViewAdapter(Context context, List<Country> datas ) {
        this.context = context;
        this.countries = datas;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public CountryViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View recyclerViewItem = mLayoutInflater.inflate(R.layout.recycler_item, parent, false);
        recyclerViewItem.setOnClickListener(v -> handleRecyclerItemClick( (RecyclerView)parent, v));
        return new CountryViewHolder(recyclerViewItem);
    }


    @Override
    public void onBindViewHolder(CountryViewHolder holder, int position) {
        Country country = this.countries.get(position);

        int imageResId = this.getDrawableResIdByName(country.getFlagName());
        try {
            this.description = this.getDescriptionByName(country.getFlagName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        holder.flagView.setImageResource(imageResId);
        holder.countryNameView.setText(country.getCountryName() );
        holder.descriptionView.setText(this.description);
    }

    @Override
    public int getItemCount() {
        return this.countries.size();
    }

    public int getDrawableResIdByName(String resName)  {
        String pkgName = context.getPackageName();
        int resID = context.getResources().getIdentifier(resName , "drawable", pkgName);
        return resID;
    }
    public int getRawResIdByName(String resName)  {
        String pkgName = context.getPackageName();
        int resID = context.getResources().getIdentifier(resName , "raw", pkgName);
        return resID;
    }

    public String getDescriptionByName(String name) throws IOException {
        int resId = getRawResIdByName(name);
        InputStream stream = context.getResources().openRawResource(resId);
        InputStreamReader inputStreamReader = new InputStreamReader(stream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line = bufferedReader.readLine();
        line = line.substring(0, Math.min(line.length(), 50));
        bufferedReader.close();
        return line;
    }

    private void handleRecyclerItemClick(RecyclerView recyclerView, View itemView) {
        int itemPosition = recyclerView.getChildLayoutPosition(itemView);
        Country country  = this.countries.get(itemPosition);
        int resIdDrawble = getDrawableResIdByName(country.getFlagName());
        int resIdRaw = getRawResIdByName(country.getFlagName());
        String countryName = country.getCountryName();
        Context context =itemView.getContext();
        Intent intent = new Intent(context, MainActivity2.class);
        intent.putExtra("country", countryName);
        intent.putExtra("IdDrawble", resIdDrawble);
        intent.putExtra("IdRaw", resIdRaw);
        context.startActivity(intent);
    }
}

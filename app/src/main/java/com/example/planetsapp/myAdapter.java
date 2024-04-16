package com.example.planetsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class myAdapter extends ArrayAdapter<Planet> {

    private ArrayList<Planet> planetsList;
    private Context context;

    public myAdapter(ArrayList<Planet> planetsList, Context context) {
        super(context, R.layout.list_item, planetsList);
        this.planetsList = planetsList;
        this.context = context;
    }

    private static class MyViewHolder{
        TextView planetName;
        TextView moons;
        ImageView picture;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Planet planet = getItem(position);
        //return super.getView(position, convertView, parent);
        MyViewHolder myViewHolder;
        final View result;

        if (convertView == null) {
            myViewHolder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(
                    R.layout.list_item,
                    parent,
                    false
            );


        myViewHolder.planetName = (TextView) convertView.findViewById(R.id.name);
        myViewHolder.moons = (TextView) convertView.findViewById(R.id.moons);
        myViewHolder.picture = (ImageView) convertView.findViewById(R.id.planet_picture);

        result = convertView;

        convertView.setTag(myViewHolder);
        }else{
            myViewHolder = (MyViewHolder) convertView.getTag();
            result = convertView;
        }

        //get data from model
        myViewHolder.planetName.setText(planet.getName());
        myViewHolder.moons.setText(planet.getMoons());
        myViewHolder.picture.setImageResource(planet.getImageID());

        return result;
    }
}

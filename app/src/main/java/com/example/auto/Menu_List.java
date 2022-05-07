package com.example.auto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ListAdapter;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Menu_List extends ArrayAdapter<String> {

    private LayoutInflater inflater;
    private int layout;
    private List<Car_Object> cars;

    public Menu_List(Context context, int resource, List<Car_Object> states) {
        super(context, resource);
        this.cars = states;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = inflater.inflate(this.layout, parent, false);
        ImageView car_image = view.findViewById(R.id.car_image_1);
        TextView car_name = view.findViewById(R.id.main_text_1);

        Car_Object car = cars.get(position);

        car_image.setImageResource(car.getImage());
        car_name.setText(car.getName());


        return view;
    }
}

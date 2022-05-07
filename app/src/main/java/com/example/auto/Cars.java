package com.example.auto;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Cars extends Fragment {

    ListView listView;
    ArrayList<Car_Object> car_items;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cars, container, false);

        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


//        listView = view.findViewById(R.id.cars_list);
//        car_items = new ArrayList<>();
//        getContext().deleteDatabase("CAR_SHOP");
//
//        try {
//            SQLiteOpenHelper helper = new Cars_Datebase(getActivity(), "CAR_SHOP", null, 2);
//            SQLiteDatabase database = helper.getReadableDatabase();
//            Log.i("TAG", "Connection success");
//            Cursor cursor = database.query("CARS1", new String[]{"NAME", "IMAGE_RESOURCE", "INFO"}, null, null, null, null, null, null);
//
//            if (cursor.moveToNext()) {
//                car_items.add(new Car_Object(cursor.getString(0), cursor.getInt(1), cursor.getString(2)));
//                Log.i("TAG", " " + cursor.getString(0) + " " + cursor.getString(2));
//            }
//            cursor.close();
//            Menu_List car_list = new Menu_List(getActivity(), R.layout.list_view, car_items);
////            ArrayAdapter cars_list = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_activated_1, car_items);
//
//            listView.setAdapter(car_list);
//
//        } catch (SQLException ex) {
//            Log.i("TAG", "connection error");
//
//        }


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
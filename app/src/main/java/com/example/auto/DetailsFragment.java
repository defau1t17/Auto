package com.example.auto;

import android.database.Cursor;
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
import android.widget.CheckBox;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsFragment extends Fragment {

    private Integer item_id;
    Cursor cursor;
    SQLiteDatabase database;
    TextView item_name;
    RatingBar ratingBar;
    ImageView imageView;
    CheckBox checkBox;
    public int column_1;
    public int column_2;
    public int column_3;
    public int column_4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_details2, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            item_id = getArguments().getInt("id");
        } else Toast.makeText(getContext(), "Error", Toast.LENGTH_LONG).show();
        SQLiteOpenHelper helper = new Cars_Datebase(getActivity(), "CAR_SHOP", null, 6);
        database = helper.getReadableDatabase();
        cursor = database.query("CARS1", null, "_id = ?", new String[]{Integer.toString(item_id)}, null, null, null, null);
        database.close();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView = view.findViewById(R.id.car_image_1);
        item_name = view.findViewById(R.id.main_text_1);
        ratingBar = view.findViewById(R.id.rating_bar);
        checkBox = view.findViewById(R.id.checkbox);

        column_1 = cursor.getColumnIndex("NAME");
        column_2 = cursor.getColumnIndex("RATING");
        column_3 = cursor.getColumnIndex("IMAGE_RESOURCE");
        column_4 = cursor.getColumnIndex("FAVOURITE");

        item_name.setText(cursor.getString(column_1));
        ratingBar.setRating(cursor.getFloat(column_2));
        imageView.setImageResource(cursor.getInt(column_3));
        checkBox.setChecked(cursor.getInt(column_4) == 1);

    }
}
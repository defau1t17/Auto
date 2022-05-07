package com.example.auto;

import android.content.Context;
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
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;


public class HomeFragment extends Fragment {

    changer changer;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        changer = (changer) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);


    }

    Cursor cursor;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        SQLiteOpenHelper helper = new Cars_Datebase(getActivity(), "CAR_SHOP", null, 6);
        SQLiteDatabase database = helper.getReadableDatabase();
        cursor = database.query("CARS1", null, null, null, null, null, null, null);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        CursorAdapter simpleCursorAdapter = new List_Adapter(getContext(), cursor, 0);
//        SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(getActivity(), R.layout.list_view, cursor, new String[]{"NAME", "IMAGE_RESOURCE"}, new int[]{R.id.main_text_1, R.id.car_image_1});
        ListView listView = view.findViewById(R.id.list_of_items);
        listView.setAdapter(simpleCursorAdapter);
        super.onViewCreated(view, savedInstanceState);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                changer.moveToDetailFragment(position + 1);
            }
        });
    }

    @Override
    public void onDestroy() {

        super.onDestroy();
    }

}
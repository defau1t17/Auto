package com.example.auto;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class List_Adapter extends CursorAdapter {
    LayoutInflater layoutInflater;


    public List_Adapter(Context context, Cursor c, int flags) {
        super(context, c, flags);

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return layoutInflater.inflate(R.layout.list_view, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        if (viewHolder == null) {
            viewHolder = new ViewHolder();
            viewHolder.imageView = view.findViewById(R.id.car_image_1);
            viewHolder.item_name = view.findViewById(R.id.main_text_1);
            viewHolder.ratingBar = view.findViewById(R.id.rating_bar);

            viewHolder.column_1 = cursor.getColumnIndex("NAME");
            viewHolder.column_2 = cursor.getColumnIndex("RATING");
            viewHolder.column_3 = cursor.getColumnIndex("IMAGE_RESOURCE");


            view.setTag(viewHolder);
        }
        viewHolder.item_name.setText(cursor.getString(viewHolder.column_1));
        viewHolder.ratingBar.setRating(cursor.getFloat(viewHolder.column_2));
        viewHolder.imageView.setImageResource(cursor.getInt(viewHolder.column_3));


    }

    static class ViewHolder {
        TextView item_name;
        RatingBar ratingBar;
        ImageView imageView;
        public int column_1;
        public int column_2;
        public int column_3;

    }
}


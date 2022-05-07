package com.example.auto;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class My_Details_Adapter extends CursorAdapter {
    LayoutInflater layoutInflater;


    public My_Details_Adapter(Context context, Cursor c, int flags) {
        super(context, c, flags);

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return layoutInflater.inflate(R.layout.list_view, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder_1 viewHolder = (ViewHolder_1) view.getTag();
        if (viewHolder == null) {
            viewHolder = new ViewHolder_1();
            viewHolder.imageView = view.findViewById(R.id.car_image_1);
            viewHolder.item_name = view.findViewById(R.id.main_text_1);
            viewHolder.ratingBar = view.findViewById(R.id.rating_bar);
            viewHolder.checkBox = view.findViewById(R.id.checkbox);

            viewHolder.column_1 = cursor.getColumnIndex("NAME");
            viewHolder.column_2 = cursor.getColumnIndex("RATING");
            viewHolder.column_3 = cursor.getColumnIndex("IMAGE_RESOURCE");
            viewHolder.column_4 = cursor.getColumnIndex("FAVOURITE");


            view.setTag(viewHolder);
        }
        viewHolder.item_name.setText(cursor.getString(viewHolder.column_1));
        viewHolder.ratingBar.setRating(cursor.getFloat(viewHolder.column_2));
        viewHolder.imageView.setImageResource(cursor.getInt(viewHolder.column_3));
        viewHolder.checkBox.setChecked(cursor.getInt(viewHolder.column_4) == 1);

    }

    static class ViewHolder_1 {
        TextView item_name;
        RatingBar ratingBar;
        ImageView imageView;
        CheckBox checkBox;
        public int column_1;
        public int column_2;
        public int column_3;
        public int column_4;

    }

}
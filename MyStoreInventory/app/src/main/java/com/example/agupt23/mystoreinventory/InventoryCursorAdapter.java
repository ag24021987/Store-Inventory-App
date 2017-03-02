package com.example.agupt23.mystoreinventory;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.agupt23.mystoreinventory.data.InventoryContract.InventoryEntry;

/**
 * Created by agupt23 on 2/28/17.
 */

public class InventoryCursorAdapter extends CursorAdapter {

    public InventoryCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        ImageView imageView = (ImageView) view.findViewById(R.id.product_image);
        imageView.setImageBitmap(convertByteArrayToBitmap(cursor.getBlob(cursor.getColumnIndex(InventoryEntry.COLUMN_PICTURE))));
        TextView nameTextview = (TextView) view.findViewById(R.id.product_name);
        nameTextview.setText(cursor.getString(cursor.getColumnIndex(InventoryEntry.COLUMN_NAME)));
        TextView priceTextview = (TextView) view.findViewById(R.id.product_price);
        priceTextview.setText("Price: $" + Integer.toString(cursor.getInt(cursor.getColumnIndex(InventoryEntry.COLUMN_PRICE))));
        TextView quantityTextView = (TextView) view.findViewById(R.id.product_quantity);
        quantityTextView.setText("Quantity: " + Integer.toString(cursor.getInt(cursor.getColumnIndex(InventoryEntry.COLUMN_QUANTITY))));

    }

    private Bitmap convertByteArrayToBitmap(byte[] bytes) {
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }
}

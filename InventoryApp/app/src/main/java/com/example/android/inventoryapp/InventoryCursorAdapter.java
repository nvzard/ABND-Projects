package com.example.android.inventoryapp;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.android.inventoryapp.Data.StoreContract.StoreEntry;

public class InventoryCursorAdapter extends CursorAdapter {

    public InventoryCursorAdapter(Context context, Cursor c) {
        super(context, c, 0 /* flags */);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    @Override
    public void bindView(View view, final Context context, Cursor cursor) {

        TextView nameTextView = (TextView) view.findViewById(R.id.name);
        TextView qtyTextView = (TextView) view.findViewById(R.id.quantity);
        TextView priceTextView = (TextView) view.findViewById(R.id.price);
        ImageButton saleButton = (ImageButton) view.findViewById(R.id.sale);

        final String productID = cursor.getString(cursor.getColumnIndex(StoreEntry.COLUMN_ID));
        String name = cursor.getString(cursor.getColumnIndex(StoreEntry.COLUMN_PRODUCT_NAME));
        int price = cursor.getInt(cursor.getColumnIndex(StoreEntry.COLUMN_PRICE));
        final int qty = cursor.getInt(cursor.getColumnIndex(StoreEntry.COLUMN_QUANTITY));

        saleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CatalogActivity Activity = (CatalogActivity) context;
                Activity.productSaleCount(Integer.valueOf(productID), Integer.valueOf(qty));
            }
        });

        String displayPrice = "at " + price + " " + view.getResources().getString(R.string.unit_price);
        String displayQty = "(" + qty + " " + view.getResources().getString(R.string.unit_item) + ")";

        if (TextUtils.isEmpty(name)) {
            name = context.getString(R.string.unknown_name);
        }

        nameTextView.setText(name);
        qtyTextView.setText(displayQty);
        priceTextView.setText(displayPrice);
    }
}

package com.example.android.inventoryapp.Data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

import com.example.android.inventoryapp.Data.StoreContract.StoreEntry;

public class StoreProvider extends ContentProvider {

    public static final String LOG_TAG = StoreProvider.class.getSimpleName();

    private StoreDbHelper mDbHelper;

    private static final int INVENTORY = 100;
    private static final int INVENTORY_ID = 101;

    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        sUriMatcher.addURI(StoreContract.CONTENT_AUTHORITY, StoreContract.PATH_INVENTORY, INVENTORY);
        sUriMatcher.addURI(StoreContract.CONTENT_AUTHORITY, StoreContract.PATH_INVENTORY + "/#", INVENTORY_ID);
    }

    @Override
    public boolean onCreate() {
        mDbHelper = new StoreDbHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        int match = sUriMatcher.match(uri);

        Cursor cursor;

        switch (match) {
            case INVENTORY:
                cursor = db.query(StoreEntry.TABLE_NAME, projection, selection,
                        selectionArgs, null, null, sortOrder);
                break;
            case INVENTORY_ID:
                selection = StoreEntry.COLUMN_ID + "=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                cursor = db.query(StoreEntry.TABLE_NAME, projection, selection,
                        selectionArgs, null, null, sortOrder);
                break;
            default:
                throw new IllegalArgumentException("Cannot query unknown URI " + uri);
        }

        cursor.setNotificationUri(getContext().getContentResolver(), uri);

        return cursor;
    }

    @Override
    public String getType(Uri uri) {
        final int match = sUriMatcher.match(uri);
        switch (match) {
            case INVENTORY:
                return StoreEntry.CONTENT_LIST_TYPE;
            case INVENTORY_ID:
                return StoreEntry.CONTENT_ITEM_TYPE;
            default:
                throw new IllegalStateException("Unknown URI " + uri + " with match " + match);
        }
    }

    private Uri insertItem(Uri uri, ContentValues values) {

        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        long id = db.insert(StoreEntry.TABLE_NAME, null, values);

        if (id == -1) {
            Log.e(LOG_TAG, "Failed to insert row for " + uri);
            return null;
        }

        getContext().getContentResolver().notifyChange(uri, null);
        return ContentUris.withAppendedId(uri, id);
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {

        // Sanity Checks
        String name = values.getAsString(StoreEntry.COLUMN_PRODUCT_NAME);
        if (name == null) {
            throw new IllegalArgumentException("Item requires a name");
        }

        Integer price = values.getAsInteger(StoreEntry.COLUMN_PRICE);
        if (price < 0 || price == null) {
            throw new IllegalArgumentException("Price requires a valid input.");
        }

        Integer qty = values.getAsInteger(StoreEntry.COLUMN_QUANTITY);
        if (qty < 0 || qty == null) {
            throw new IllegalArgumentException("Quantity requires a valid input.");
        }

        String supplierName = values.getAsString(StoreEntry.COLUMN_SUPPLIER_NAME);
        if (supplierName == null) {
            throw new IllegalArgumentException("Supplier requires a name");
        }

        String supplierNumber = values.getAsString(StoreEntry.COLUMN_SUPPLIER_PHONE);
        if (supplierNumber == null) {
            throw new IllegalArgumentException("Supplier requires a number");
        }

        final int match = sUriMatcher.match(uri);
        switch (match) {
            case INVENTORY:
                return insertItem(uri, values);
            default:
                throw new IllegalArgumentException("Cannot query unknown URI " + uri);
        }
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Get writeable database
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        final int match = sUriMatcher.match(uri);

        int rowsDeleted;
        switch (match) {
            case INVENTORY:
                // Delete all rows that match the selection and selection args
                rowsDeleted = db.delete(StoreEntry.TABLE_NAME, selection, selectionArgs);
                if (rowsDeleted != 0) {
                    getContext().getContentResolver().notifyChange(uri, null);
                }
                return rowsDeleted;
            case INVENTORY_ID:
                // Delete a single row given by the ID in the URI
                selection = StoreEntry._ID + "=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                rowsDeleted = db.delete(StoreEntry.TABLE_NAME, selection, selectionArgs);
                if (rowsDeleted != 0) {
                    getContext().getContentResolver().notifyChange(uri, null);
                }
                return rowsDeleted;
            default:
                throw new IllegalArgumentException("Deletion is not supported for " + uri);
        }
    }

    private int updateItem(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        // Sanity Checks
        if (values.size() == 0) {
            return 0;
        }

        if (values.containsKey(StoreEntry.COLUMN_PRODUCT_NAME)) {
            String name = values.getAsString(StoreEntry.COLUMN_PRODUCT_NAME);
            if (name == null) {
                throw new IllegalArgumentException("Item requires a name");
            }
        }

        if (values.containsKey(StoreEntry.COLUMN_PRICE)) {
            Integer price = values.getAsInteger(StoreEntry.COLUMN_PRICE);
            if (price != null && price < 0) {
                throw new IllegalArgumentException("Price requires a valid input.");
            }
        }

        if (values.containsKey(StoreEntry.COLUMN_QUANTITY)) {
            Integer qty = values.getAsInteger(StoreEntry.COLUMN_QUANTITY);
            if (qty != null && qty < 0) {
                throw new IllegalArgumentException("Quantity requires a valid input.");
            }
        }

        if (values.containsKey(StoreEntry.COLUMN_SUPPLIER_PHONE)) {
            String supplierName = values.getAsString(StoreEntry.COLUMN_SUPPLIER_NAME);
            if (supplierName == null) {
                throw new IllegalArgumentException("Supplier requires a name");
            }
        }

        if (values.containsKey(StoreEntry.COLUMN_SUPPLIER_PHONE)) {
            String supplierNumber = values.getAsString(StoreEntry.COLUMN_SUPPLIER_PHONE);
            if (supplierNumber == null) {
                throw new IllegalArgumentException("Supplier requires a number");
            }
        }

        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        getContext().getContentResolver().notifyChange(uri, null);

        int rowsUpdated = db.update(StoreEntry.TABLE_NAME, values, selection, selectionArgs);
        if (rowsUpdated != 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }

        return rowsUpdated;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {

        final int match = sUriMatcher.match(uri);
        switch (match) {
            case INVENTORY:
                return updateItem(uri, values, selection, selectionArgs);
            case INVENTORY_ID:
                selection = StoreEntry.COLUMN_ID + "=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                return updateItem(uri, values, selection, selectionArgs);
            default:
                throw new IllegalArgumentException("Cannot query unknown URI " + uri);
        }
    }
}

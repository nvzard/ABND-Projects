package com.example.android.pets.data;

import android.provider.BaseColumns;


public final class PetContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private PetContract() {}

    /**
     * Inner class that defines constant values for the pets database table.
     * Each entry in the table represents a single pet.
     */
    public static final class PetEntry implements BaseColumns {

        /** Name of database table for pets */

        public final static String TABLE_NAME = "pets";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_PET_NAME ="name";
        public final static String COLUMN_PET_BREED = "breed";
        public final static String COLUMN_PET_GENDER = "gender";
        public final static String COLUMN_PET_WEIGHT = "weight";

        public static final int GENDER_UNKNOWN = 0;
        public static final int GENDER_MALE = 1;
        public static final int GENDER_FEMALE = 2;
    }

}

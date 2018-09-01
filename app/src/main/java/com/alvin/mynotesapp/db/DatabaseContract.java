package com.alvin.mynotesapp.db;

import android.provider.BaseColumns;

/**
 * Created by Alvin Tandiardi on 23/08/2018.
 */

public class DatabaseContract {

    static String TABLE_NOTE = "note";

    static final class NoteColumns implements BaseColumns {

        // Note Title
        static String TITLE = "title";
        // Note Descripiton
        static String DESCRIPTION = "description";
        // Note date
        static String DATE = "date";
    }

}

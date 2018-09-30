package com.alvin.dicodingnotesapp.db;

import android.database.Cursor;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Alvin Tandiardi on 02/09/2018.
 */

public class DatabaseContract {

    public static String TABLE_NOTE = "note";

    public static final class NoteColumns implements BaseColumns {

        // Note Title
        public static String TITLE = "title";
        // Note Descripiton
        public static String DESCRIPTION = "description";
        // Note date
        public static String DATE = "date";
    }

    public static final String AUTHORITY = "com.alvin.mynotesapp";

    public static final Uri CONTENT_URI = new Uri.Builder().scheme("content")
            .authority(AUTHORITY)
            .appendPath(TABLE_NOTE)
            .build();

    public static String getColumnString(Cursor cursor, String columnName) {
        return cursor.getString(cursor.getColumnIndex(columnName));
    }

    public static int getColumnInt(Cursor cursor, String columnName) {
        return cursor.getInt(cursor.getColumnIndex(columnName));
    }

    public static long getColumnLong(Cursor cursor, String columnName) {
        return cursor.getLong(cursor.getColumnIndex(columnName));
    }

}

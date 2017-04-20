package com.proofconcept.uploadfile.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * @author everardo.salazar on 4/19/17.
 */

public class UploadFileOpenHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "UploadFile.db";

    public UploadFileOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(FileUploadsContract.SQL_CREATE_FILE_UPLOADS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(FileUploadsContract.SQL_DELETE_FILE_UPLOADS);
        onCreate(db);
    }

    public static final class FileUploadsContract {
        private FileUploadsContract() {
        }

        public static final String SQL_CREATE_FILE_UPLOADS =
                "CREATE TABLE " + UploadFileEntry.TABLE_NAME + " (" +
                        UploadFileEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        UploadFileEntry.COLUMN_URL + " TEXT," +
                        UploadFileEntry.COLUMN_STATUS + " TEXT)";

        public static final String SQL_DELETE_FILE_UPLOADS =
                "DROP TABLE IF EXISTS " + UploadFileEntry.TABLE_NAME;

        public static class UploadFileEntry implements BaseColumns {
            public static final String TABLE_NAME = "FileUploads";
            public static final String COLUMN_URL = "Url";
            public static final String COLUMN_STATUS = "Status";
        }
    }
}

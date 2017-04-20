package com.proofconcept.uploadfile.service;

import android.app.IntentService;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;
import android.util.Log;

import com.proofconcept.uploadfile.db.UploadFileOpenHelper;

/**
 * @author everardo.salazar on 4/18/17.
 */

public class FileStatusService extends IntentService {

    public static final String FILE_URL_EXTRA = "com.proofconcept.uploadfile.service.fileUrlExtra";

    public FileStatusService() {
        super("FileStatusService");
        setIntentRedelivery(true);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.i(FileStatusService.class.getName(), "onHandleIntent");

        UploadFileOpenHelper dbHelper = new UploadFileOpenHelper(this);

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UploadFileOpenHelper.FileUploadsContract.UploadFileEntry.COLUMN_URL, intent.getStringExtra(FILE_URL_EXTRA));
        values.put(UploadFileOpenHelper.FileUploadsContract.UploadFileEntry.COLUMN_STATUS, "notStarted");

        long newRowId = db.insert(UploadFileOpenHelper.FileUploadsContract.UploadFileEntry.TABLE_NAME, null, values);

        dbHelper.close();

        Log.i(FileStatusService.class.getName(), "new row inserted " + newRowId);


    }
}

package com.proofconcept.uploadfile.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.proofconcept.uploadfile.service.FileStatusService;

import static com.proofconcept.uploadfile.service.FileStatusService.FILE_URL_EXTRA;

public class PhotoTakenReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Log.i(PhotoTakenReceiver.class.getName(), intent.getAction());
        Log.i(PhotoTakenReceiver.class.getName(), intent.getData().toString());

        Intent serviceIntent = new Intent(context, FileStatusService.class);
        serviceIntent.putExtra(FILE_URL_EXTRA, intent.getData().toString());
        context.startService(serviceIntent);
    }
}

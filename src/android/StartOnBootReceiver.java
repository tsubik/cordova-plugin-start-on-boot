package com.tsubik.cordova.start_on_boot;

import android.content.Intent;
import android.content.BroadcastReceiver;
import android.util.Log;
import android.content.Context;

public class StartOnBootReceiver extends BroadcastReceiver {
    public static final String TAG = "StartOnBootPlugin";

    @Override
    public void onReceive(Context context, Intent intent) {
        try {
            String mainActivityName = context.getPackageName() + ".MainActivity";
            Intent serviceIntent = new Intent(context, Class.forName(mainActivityName));
            serviceIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Log.d(TAG, "Starting " + mainActivityName + " on boot");
            context.startActivity(serviceIntent);
        } catch(Exception ex) {
            Log.d(TAG, "Cannot start app on boot. Exception" + ex.toString());
        }
    }
}

package com.tsubik.cordova.start_on_boot;

import android.content.Intent;
import android.content.BroadcastReceiver;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import android.content.Context;

import java.util.List;

public class StartOnBootReceiver extends BroadcastReceiver {
    public static final String TAG = "StartOnBootPlugin";

    @Override
    public void onReceive(Context context, Intent intent) {
        try {
            String mainActivityName = getMainActivityName(context);
            Intent serviceIntent = new Intent(context, Class.forName(mainActivityName));
            serviceIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Log.d(TAG, "Starting " + mainActivityName + " on boot");
            context.startActivity(serviceIntent);
        } catch(Exception ex) {
            Log.d(TAG, "Cannot start app on boot. Exception" + ex.toString());
        }
    }

    private String getMainActivityName (Context context) {
        try {
            PackageManager pm = context.getPackageManager();

            ActivityInfo[] activities = pm.getPackageInfo(context.getPackageName(), PackageManager.GET_ACTIVITIES).activities;
            if (activities.length > 0) {
                return activities[0].name;
            }
        } catch (PackageManager.NameNotFoundException e) {}
        //return default name
        return context.getPackageName() + ".MainActivity";
    }
}

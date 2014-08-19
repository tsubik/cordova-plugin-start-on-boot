package com.tsubik.cordova.plugin;
 
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.content.BroadcastReceiver;
import android.content.Context;
 
public class StartAppAtBootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
            Intent serviceIntent = new Intent(context, YOURPACKAGENAME.EnterYourMainActivityName.class);
            serviceIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(serviceIntent);
    }
}
package com.banasiak.android.migrate;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by variable on 6/30/14.
 */
public class InstallReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // verify we received a ACTION_PACKAGE_ADDED intent (which is all we subscribed to in the manifest)
        if (intent.getAction().equals(Intent.ACTION_PACKAGE_ADDED)) {
            // verify the package that was installed is the package that replacing this one
            if (intent.getData() != null && intent.getDataString()
                    .equals("package:" + MainActivity.NEW_PACKAGE)) {
                // launch our main activity, since the new package has been installed,
                // it should prompt us to delete this package
                Intent newIntent = new Intent(context, MainActivity.class);
                newIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(newIntent);
            }
        }
    }

}

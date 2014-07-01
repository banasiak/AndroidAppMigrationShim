package com.banasiak.android.migrate;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by variable on 6/30/14.
 */
public class MainActivity extends ActionBarActivity {

    // the name of the new package in the Google Play store
    public static final String NEW_PACKAGE = "com.banasiak.coinflip";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        TextView header = (TextView) findViewById(R.id.header);
        TextView body = (TextView) findViewById(R.id.body);

        ImageView upgradeButton = (ImageView) findViewById(R.id.upgradeButton);
        Button uninstallButton = (Button) findViewById(R.id.uninstallButton);

        upgradeButton.setVisibility(View.GONE);
        uninstallButton.setVisibility(View.GONE);

        if (!isPackageInstalled(NEW_PACKAGE)) {
            // if the new package is not installed, prompt the user to install it
            header.setText(R.string.upgradeHeaderText);
            body.setText(R.string.upgradeBodyText);
            upgradeButton.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    Intent upgradeIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("market://details?id=" + NEW_PACKAGE));
                    startActivity(upgradeIntent);
                }
            });
            upgradeButton.setVisibility(View.VISIBLE);
        } else {
            // but, if the new package is already installed, prompt the user to install this app
            header.setText(R.string.uninstallHeaderText);
            body.setText(R.string.uninstallBodyText);
            uninstallButton.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    Intent uninstallIntent = new Intent(Intent.ACTION_DELETE,
                            Uri.parse("package:" + getPackageName()));
                    startActivity(uninstallIntent);
                }
            });
            uninstallButton.setVisibility(View.VISIBLE);
        }
    }

    private boolean isPackageInstalled(String packagename) {
        PackageManager pm = this.getPackageManager();
        try {
            pm.getPackageInfo(packagename, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}

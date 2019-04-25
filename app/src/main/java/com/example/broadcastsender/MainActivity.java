package com.example.broadcastsender;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    /**
     * From here we delete our onStart(), onStop() and our
     * private Broadcast Receiver
     * and also remove the Intent.putExtra and instead of
     * defining an action string in our Intent we use another
     * constructor that takes Context and our ExampleBroadcast2.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
    }

    public void sendBroadcast(View view) {
        Intent intent = new Intent("com.example.EXAMPLE_ACTION");
        //intent.setClass(this, ExampleBroadcast2.class);

        /**
         * With ComponentName we can also specify a Broadcast
         * receiver that is not in this app but in another one
         */

       /* ComponentName cn = new ComponentName("com.example.broadcastexample",
                "com.example.broadcastexample.ExampleBroadcast");
        intent.setComponent(cn);*/

      /* intent.setClassName("com.example.broadcastexample",
               "com.example.broadcastexample.ExampleBroadcast");
       */

        //intent.setPackage("com.example.broadcastexample");

        PackageManager packageManager = getPackageManager();

        /**
         *  Below we check which all apps of the phone
         *  has a BroadcastReceiver that has an intent filter
         *  for the intent we defined("com.example.EXAMPLE_ACTION")
         *  and pass it to packageManager.queryBroadcastReceivers(intent, 0);
         *
         *
         */

        List<ResolveInfo> infos = packageManager.queryBroadcastReceivers(intent, 0);

        for (ResolveInfo info : infos) {
            ComponentName cn = new ComponentName(info.activityInfo.packageName,
                    info.activityInfo.name);
            intent.setComponent(cn);
            sendBroadcast(intent);
        }
        //sendBroadcast(intent);
        //After this register this receiver in Manifest file
    }
}

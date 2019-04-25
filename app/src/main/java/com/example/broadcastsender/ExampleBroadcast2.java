package com.example.broadcastsender;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ExampleBroadcast2 extends BroadcastReceiver {
    /**
     * Implicit broadcasts means that an app or the Android
     * system itself sends a Broadcast from an Action String
     * and any Broadcast Receivers that want to receive
     * this broadcast has to register for this particular
     * action string("com.example.EXAMPLE_ACTION")
     * with an IntentFilter.
     * From Android O most of these implicit broadcasts
     * only runs when we implement them in any of the
     * Activities lifecycle, which means that to receive these
     * broadcasts our app has to be already running.
     * Earlier we had the privilege of adding these
     * Broadcasts in the Manifest as well, where even if our
     * app wasn't running, it would start the app just to receive
     * the broadcast. But now it's not the case, since it consumes
     * a lot of resources (RAM) memory space.
     *
     * These restrictions are not applicable to Explicit
     * Broadcasts.
     * Explicit broadcasts means we don't just define
     * an action we specify the Broadcast receiver
     * that we want to trigger directly. This can be a broadcast
     * receiver in our own app but also in an another app.
     *
     */

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "EBR2 Triggered", Toast.LENGTH_SHORT).show();
    }
}

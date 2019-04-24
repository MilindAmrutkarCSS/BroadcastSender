package com.example.broadcastsender;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
    }

    public void sendBroadcast(View view) {
        /**
         * For sending a broadcast we create an intent
         * and define an action
         */

        Intent intent = new Intent("com.example.EXAMPLE_ACTION");

        /**
         * We add an extra to this action, where we define the
         * name and value. If everything works perfectly the
         * BroadcastExample app shows Broadcast received as a
         * Toast.
         */
        intent.putExtra("com.example.EXTRA_TEXT", "Broadcast received");
        sendBroadcast(intent);


    }

    /**
     * We'll also put an another Broadcast receiver to this
     * app which will update the UI.
     * Until now we always created our Broadcast receiver as a
     * top level class but if we want to update the UI of our
     * activity we can also put it into this activity, as an
     * inner class, bcoz then we can access the activity variables
     * like TextView directly.
     *
     * One way to do this is by creating an
     * anonymous inner class
     */

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        /**
         * After sending the broadcast message, it is received
         * here in onReceive and text of TextView is changed.
         */

        @Override
        public void onReceive(Context context, Intent intent) {
            String receivedText = intent.getStringExtra("com.example.EXTRA_TEXT");
            textView.setText(receivedText);
        }
    };

    /**
     * We register this broadcast in onStart(),
     * bcoz in order to send this broadcasts we have to click
     * our button which also means that our app has to be in
     * the foreground, so we don't need this Broadcast receiver
     * when the app is in the background.
     */

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter("com.example.EXAMPLE_ACTION");
        registerReceiver(broadcastReceiver, filter);

    }

    /**
     * Then we unregister it
     */

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadcastReceiver);
    }


}

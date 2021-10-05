package com.example.ugdpn_a_10181;

import android.app.RemoteInput;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class DirectReplyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle remoteInput= RemoteInput.getResultsFromIntent(intent);

        if(remoteInput!=null) {
            CharSequence replyText = remoteInput.getCharSequence("key_text_reply");
            Message answer = new Message(replyText,null);
            MainActivity.MESSAGES.add(answer);

            MainActivity.sendChannel4Notification(context);
        }
    }
}

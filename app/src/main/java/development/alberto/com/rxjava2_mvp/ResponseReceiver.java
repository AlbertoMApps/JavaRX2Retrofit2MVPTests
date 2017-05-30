package development.alberto.com.rxjava2_mvp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ResponseReceiver extends BroadcastReceiver {
    public static final String ACTION_RESP =
            "development.alberto.com.rxjava2_mvp.MESSAGE_PROCESSED";

    @Override
    public void onReceive(Context context, Intent intent) {
        String text = intent.getStringExtra(DownloadInfoIntentService.PARAM_OUT_MSG);
        //Update the view with some text when calling the BR to inform about the background work done
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }
}
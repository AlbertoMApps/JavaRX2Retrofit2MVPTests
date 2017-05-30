package development.alberto.com.rxjava2_mvp;


import android.app.IntentService;
import android.content.Intent;
import android.os.SystemClock;
import android.text.format.DateFormat;

public class DownloadInfoIntentService  extends IntentService {

    public static final String PARAM_IN_MSG = "imsg";
    public static final String PARAM_OUT_MSG = "omsg";

    public DownloadInfoIntentService() {
        super("DownloadInfoIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //Do some off work here
        String msg = intent.getStringExtra(PARAM_IN_MSG);
        SystemClock.sleep(30000); // 30 seconds
        String resultTxt = msg + " "
                + DateFormat.format("MM/dd/yy h:mmaa", System.currentTimeMillis());

        // processing done here….
        Intent broadcastIntent = new Intent();
        broadcastIntent.setAction(ResponseReceiver.ACTION_RESP);
        broadcastIntent.addCategory(Intent.CATEGORY_DEFAULT);
        broadcastIntent.putExtra(PARAM_OUT_MSG, resultTxt);
        sendBroadcast(broadcastIntent);
    }
}

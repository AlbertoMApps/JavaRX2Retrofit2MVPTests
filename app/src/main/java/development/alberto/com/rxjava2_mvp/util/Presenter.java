package development.alberto.com.rxjava2_mvp.util;

/**
 * Base class with lifecycle methods
 */
public abstract class Presenter {

    protected Presenter() {}

    protected abstract void onCreate();

    protected abstract void onResume();

    protected abstract void onPause();

    protected abstract void onDestroy();
}

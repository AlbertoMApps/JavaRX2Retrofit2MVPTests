package development.alberto.com.rxjava2_mvp.util;

/**
 * Created by alber on 24/05/2017.
 */

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Default subscriber base class to be used whenever you want default error handling.
 */
public class DefaultObserver<T> implements Observer<T> {
    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}

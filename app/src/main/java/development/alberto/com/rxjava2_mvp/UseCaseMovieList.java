package development.alberto.com.rxjava2_mvp;


import java.util.List;

import development.alberto.com.rxjava2_mvp.api.ServerInstance;
import development.alberto.com.rxjava2_mvp.api.models.api_model.Movie;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by alber on 23/05/2017.
 */

public class UseCaseMovieList {

    private Disposable disposableObserver;

    public UseCaseMovieList() {
    }

    /**
     * Executes the current use case
     */
    @SuppressWarnings("unchecked")
    public void execute(Observer<List<Movie>> movieObserver) {
        ServerInstance.createMoviesAPI().getMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(movieObserver);
    }


    /**
     * Unsubscribes from current {@link rx.Subscription}.
     */
    public void unsubscribe() {
        ServerInstance.createMoviesAPI().getMovies().unsubscribeOn(Schedulers.io());
    }
}

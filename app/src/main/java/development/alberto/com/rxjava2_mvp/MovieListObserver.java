package development.alberto.com.rxjava2_mvp;

import android.util.Log;

import java.util.List;

import development.alberto.com.rxjava2_mvp.api.models.api_model.Movie;
import development.alberto.com.rxjava2_mvp.case1.ScreenCase1;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by alber on 24/05/2017.
 */

public class MovieListObserver implements Observer<List<Movie>> {

    private ScreenCase1.View mView;

    public MovieListObserver(ScreenCase1.View view) {
        mView = view;
    }

    @Override
    public void onError(Throwable e) {
        //Show errors on the view
//        mView.showErrorSnackBar(e.getMessage());
        Log.e("TAG", e.getMessage());
    }

    @Override
    public void onComplete() {
        //TODO
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(List<Movie> movieList) {
        //Update the view from the list
        mView.updateMovieList(movieList);
    }
}

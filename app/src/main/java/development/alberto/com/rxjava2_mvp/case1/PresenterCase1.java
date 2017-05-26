package development.alberto.com.rxjava2_mvp.case1;

import development.alberto.com.rxjava2_mvp.MovieListObserver;
import development.alberto.com.rxjava2_mvp.UseCaseMovieList;
import development.alberto.com.rxjava2_mvp.util.Presenter;

/**
 * Created by alber on 24/05/2017.
 */

public class PresenterCase1 extends Presenter implements  ScreenCase1.UserActionsListener {

    private UseCaseMovieList movieList;
    private ScreenCase1.View mView;

    public PresenterCase1( ScreenCase1.View view) {
        mView = view;
        movieList = new UseCaseMovieList();
    }

    @Override
    protected void onCreate() {
        movieList.execute(new MovieListObserver(mView));
    }

    @Override
    protected void onResume() {

    }

    @Override
    protected void onPause() {

    }

    @Override
    protected void onDestroy() {
        movieList.unsubscribe();
        movieList = null;
    }

}

package development.alberto.com.rxjava2_mvp;

import org.junit.Test;

import java.util.List;

import development.alberto.com.rxjava2_mvp.api.ServerInstance;
import development.alberto.com.rxjava2_mvp.api.models.api_model.Movie;
import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;

public class ObservableObserverMovieListUnitTest {

    //Unit test for observable MovieList working
    @Test public void testShouldBeSubscribedWithUseCaseMovieList(){
        Observable<List<Movie>> todoObservable = ServerInstance.createMoviesAPI().getMovies();
        TestObserver<Object> testObserver = new TestObserver<>();
        todoObservable.subscribeWith(testObserver);
        testObserver.assertSubscribed();
    }
}
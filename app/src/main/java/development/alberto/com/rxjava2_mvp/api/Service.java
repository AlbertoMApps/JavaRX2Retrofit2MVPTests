package development.alberto.com.rxjava2_mvp.api;

import java.util.List;

import development.alberto.com.rxjava2_mvp.api.constant.Constant;
import development.alberto.com.rxjava2_mvp.api.models.api_model.Movie;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by alber on 23/05/2017.
 */

public class Service {

    public interface IMoviesAPI {
        @GET(Constant.GET_MOVIES_URL)
        Observable<List<Movie>> getMovies();
    }
}

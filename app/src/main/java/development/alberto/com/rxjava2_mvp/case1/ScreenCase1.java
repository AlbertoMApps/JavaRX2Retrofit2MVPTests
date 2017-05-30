package development.alberto.com.rxjava2_mvp.case1;

import java.util.List;

import development.alberto.com.rxjava2_mvp.api.models.api_model.Movie;

/**
 * Created by alber on 24/05/2017.
 */

public interface ScreenCase1 {
    interface View {

        void updateMovieList(List<Movie> movieList);

        void showErrorSnackBar(String error);

    }

    interface UserActionsListener {

    }

}

package development.alberto.com.rxjava2_mvp.api;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import development.alberto.com.rxjava2_mvp.api.constant.Constant;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by alber on 23/05/2017.
 */

public class ServerInstance {

    //This can be added to dependency injections in the future
    public static Service.IMoviesAPI createMoviesAPI () {
        Retrofit retrofit = new Retrofit.Builder()
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constant.BASE_URL)
                .build();

        return retrofit.create(Service.IMoviesAPI.class);
    }
}

package development.alberto.com.rxjava2_mvp.case1;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import development.alberto.com.rxjava2_mvp.DownloadInfoIntentService;
import development.alberto.com.rxjava2_mvp.R;
import development.alberto.com.rxjava2_mvp.ResponseReceiver;
import development.alberto.com.rxjava2_mvp.adapter.MovieListAdapter;
import development.alberto.com.rxjava2_mvp.adapter.PositionAdapterToMainActivity;
import development.alberto.com.rxjava2_mvp.api.models.api_model.Movie;


public class MainActivity extends AppCompatActivity implements ScreenCase1.View, PositionAdapterToMainActivity {

    private PresenterCase1 presenter;
    @BindView(R.id.list)
    RecyclerView mRecyclerView;
    private MovieListAdapter mAdapter;
    @BindView(R.id.ll) LinearLayoutCompat mLinearLayout;
    private Unbinder unbinder;
    private ResponseReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        presenter = new PresenterCase1(this);
        presenter.onCreate();
        registrationBR();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void updateMovieList(List<Movie> movieList) {
        initRecyclerView();
        setmAdapter(movieList);
    }

    @Override
    public void showErrorSnackBar(String error) {
        Snackbar.make(mLinearLayout, error, Snackbar.LENGTH_SHORT).show();
    }


    private void initRecyclerView(){
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void setmAdapter(List<Movie> movieList) {
        mAdapter = new MovieListAdapter(movieList, R.layout.row_video, getApplicationContext(), this);
        mRecyclerView.setAdapter(mAdapter);
    }
    private void registrationBR(){
        //Registration BR
        IntentFilter filter = new IntentFilter(ResponseReceiver.ACTION_RESP);
        filter.addCategory(Intent.CATEGORY_DEFAULT);
        receiver = new ResponseReceiver();
        registerReceiver(receiver, filter);
    }

    @Override
    public void sendPositionRecyclerView(int position) {
//        Toast.makeText(getApplicationContext(), "Position clicked: "+position, Toast.LENGTH_SHORT).show();
        //Call for the DownloadIntent service to operate some work on the bacground thread
        Intent msgIntent = new Intent(this, DownloadInfoIntentService.class);
        msgIntent.putExtra(DownloadInfoIntentService.PARAM_IN_MSG, "download work in: " + position);
        startService(msgIntent);
    }
}

package development.alberto.com.rxjava2_mvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import development.alberto.com.rxjava2_mvp.R;
import development.alberto.com.rxjava2_mvp.api.models.api_model.Movie;
import development.alberto.com.rxjava2_mvp.case1.MainActivity;

/**
 * Created by alber on 25/05/2017.
 */

public class MovieListAdapter extends  RecyclerView.Adapter<MovieListAdapter.ViewHolder> {

    private Context context;
    private int mLayout;
    private List<Movie> movieList;
    private PositionAdapterToMainActivity positionAdapterToMainActivity;


    public MovieListAdapter(List<Movie> movieList, int row_video, Context applicationContext, MainActivity mainActivity) {
        this.movieList = movieList;
        this.mLayout = row_video;
        this.context = applicationContext;
        positionAdapterToMainActivity = mainActivity;
    }

    @Override
    public MovieListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(mLayout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        Picasso.with(context)
                .load(movie.getImage())
                .resize(350, 350)
                .into(holder.movieImage);
        holder.title.setText(movie.getTitle().toString());
        holder.rating.setText(movie.getRating().toString());
        holder.release.setText(movie.getReleaseYear().toString());
        holder.genre.setText(movie.getGenre().toString());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                positionAdapterToMainActivity.sendPositionRecyclerView(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.movieList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.movieImage)
        ImageView movieImage;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.rating)
        TextView rating;
        @BindView(R.id.release)
        TextView release;
        @BindView(R.id.genre)
        TextView genre;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
}

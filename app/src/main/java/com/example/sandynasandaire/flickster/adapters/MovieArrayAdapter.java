package com.example.sandynasandaire.flickster.adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sandynasandaire.flickster.R;
import com.example.sandynasandaire.flickster.models.Movie;
//import com.squareup.picasso.Picasso;

import java.security.DomainLoadStoreParameter;
import java.util.List;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

/**
 * Created by Sandyna Sandaire on 08/07/2018.
 */

public class MovieArrayAdapter extends ArrayAdapter<Movie> {
    private DomainLoadStoreParameter resources;

    public DomainLoadStoreParameter getResources() {
        return resources;
    }
    // View lookup cache

    private static class ViewHolder {

        TextView title;

        TextView overview;

    }


    public MovieArrayAdapter(Context context, List<Movie> movies)
    {
       super(context, android.R.layout.simple_list_item_1, movies);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position

        Movie movie = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view

        ViewHolder viewHolder; // view lookup cache stored in tag

        if (convertView == null) {

            // If there's no view to re-use, inflate a brand new view for row

            viewHolder = new ViewHolder();

            LayoutInflater inflater = LayoutInflater.from(getContext());

            convertView = inflater.inflate(R.layout.item_movie, parent, false);

            viewHolder.title = (TextView) convertView.findViewById(R.id.tvTitle);

            viewHolder.overview = (TextView) convertView.findViewById(R.id.tvOverview);

            // Cache the viewHolder object inside the fresh view

            convertView.setTag(viewHolder);

        } else {

            // View is being recycled, retrieve the viewHolder object from tag

            viewHolder = (ViewHolder) convertView.getTag();

        }

        // Populate the data from the data object via the viewHolder object

        // into the template view.

        viewHolder.title.setText(movie.getOriginalTitle());

        viewHolder.overview.setText(movie.getOverview());

        // Return the completed view to render on screen


        // find the image view
        ImageView ivImage = (ImageView) convertView.findViewById(R.id.ivMovieImage);
        // clear out image from convertView
        ivImage.setImageResource(0);

        int orientation = getContext().getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT){
           // Picasso.with(getContext()).load(movie.getPosterPath())
                //    .placeholder(R.drawable.hold)
                //    .transform(new RoundedCornersTransformation(10, 10))
                //    .into(ivImage);

        } else if (orientation == Configuration.ORIENTATION_LANDSCAPE){
           // Picasso.with(getContext()).load(movie.getBackdropPath())
             //       .placeholder(R.drawable.hold)
             //       .transform(new RoundedCornersTransformation(10, 10))
             //       .into(ivImage);
        }


        return convertView;

    }


}
